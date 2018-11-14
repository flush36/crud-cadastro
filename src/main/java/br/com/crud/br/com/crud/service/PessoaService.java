package br.com.crud.br.com.crud.service;

import br.com.crud.br.com.crud.models.Pessoa;
import br.com.crud.br.com.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }
}
