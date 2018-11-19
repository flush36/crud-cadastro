package br.com.crud.service;

import br.com.crud.dto.PessoaDTO;
import br.com.crud.error.ErroDTO;
import br.com.crud.error.ValidacaoException;
import br.com.crud.models.Pessoa;
import br.com.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaDTO> listarPorNomeOuCpf(String nome, String cpf) {
        List<Pessoa> pessoas = repository.findByNameAndCpfIgnoreCase(validarNull(nome), validarNull(cpf));
        return convertoToPessoaDTO(pessoas);
    }

    private String validarNull(String param) {
        if(param == null )
           return "";
        return param;
    }

    private List<PessoaDTO> convertoToPessoaDTO(List<Pessoa> pessoas) {

        List<PessoaDTO> dtoList = new ArrayList<>();
        pessoas.forEach(pessoa -> {
            PessoaDTO dto = new PessoaDTO();
            dto.setId(pessoa.getId());
            dto.setNome(pessoa.getNome());
            dto.setEmail(pessoa.getEmail());
            dto.setCpf(pessoa.getCpf());
            dto.setIdade(calcularIdade(pessoa.getDataNascimento()));
            dto.setQtdTelefones(pessoa.getTelefones().size());
            dto.setTelefones(pessoa.getTelefones());
            dtoList.add(dto);
        });
        return dtoList;
    }


    private Integer calcularIdade(Date dataNascimento) {
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String[] anoAtual = sdf.format(dataAtual).split("/");
        String[] anoNascimento = sdf.format(dataNascimento).split("/");
        int idade = Integer.parseInt(anoAtual[0]) - Integer.parseInt(anoNascimento[0]);
        return  idade < 0 ? 0 : idade;
    }

    public List<PessoaDTO> listarTodos() {
        return convertoToPessoaDTO(repository.findAll());
    }

    public Pessoa cadastrar(Pessoa pessoa) throws ValidacaoException {
        if(validarPessoa(pessoa) == null) {
            throw  new ValidacaoException(new ErroDTO("Dados invalidos"));
        }
        return repository.save(pessoa);
    }

    private Pessoa validarPessoa(Pessoa pessoa) {
        if(pessoa.getNome() != null && pessoa.getCpf() != null && pessoa.getDataNascimento() != null) {
            return pessoa;
        }
        return null;
    }

    public Optional<Object> alterar(Pessoa pessoa, Long id) throws ValidacaoException {
        if(validarPessoa(pessoa) == null) {
            throw  new ValidacaoException(new ErroDTO("Não foi possivel alterar os dados."));
        }
        Optional<Object> pessoaAtualizada = repository.findById(id).map(pessoaFind -> {
            pessoaFind.setCpf(pessoa.getCpf());
            pessoaFind.setDataNascimento(pessoa.getDataNascimento());
            pessoaFind.setEmail(pessoa.getEmail());
            pessoaFind.setNome(pessoa.getNome());
            pessoaFind.setTelefones(pessoa.getTelefones());
            return repository.save(pessoaFind);
        });
        return pessoaAtualizada;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }
}
