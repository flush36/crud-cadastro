package br.com.crud.service;

import br.com.crud.error.ErroDTO;
import br.com.crud.error.ValidacaoException;
import br.com.crud.models.Telefone;
import br.com.crud.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    public Telefone cadastrar(Telefone telefone) throws ValidacaoException {
        if(validarTelefone(telefone) == null) {
            throw  new ValidacaoException(new ErroDTO("Dados invalidos"));
        }
        return repository.save(telefone);
    }

    private Telefone validarTelefone(Telefone telefone) {
        if(telefone.getDdd() != null && telefone.getNumero() != null) {
            return telefone;
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

