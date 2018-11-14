package br.com.crud.br.com.crud.resource;

import br.com.crud.br.com.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("pesquisar")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(pessoaService.listarTodos());
    }
}
