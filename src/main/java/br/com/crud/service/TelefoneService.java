package br.com.crud.service;

import br.com.crud.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

