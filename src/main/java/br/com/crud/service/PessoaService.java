package br.com.crud.service;

import br.com.crud.error.ErroDTO;
import br.com.crud.error.ValidacaoException;
import br.com.crud.models.Pessoa;
import br.com.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listarPorNomeOuCpf(String nome, String cpf) {
        return repository.findByNameAndCpfIgnoreCase(nome, cpf);
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
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
}
