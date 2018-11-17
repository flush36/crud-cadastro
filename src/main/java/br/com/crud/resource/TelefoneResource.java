package br.com.crud.resource;

import br.com.crud.error.ValidacaoException;
import br.com.crud.models.Telefone;
import br.com.crud.repository.TelefoneRepository;
import br.com.crud.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("telefone")
public class TelefoneResource {

    @Autowired
    private TelefoneService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Telefone telefone) {
        try {
            return ResponseEntity.ok(service.cadastrar(telefone));
        } catch (ValidacaoException e) {
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErroDTO());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        try{
            service.deletar(id);
            return  ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
