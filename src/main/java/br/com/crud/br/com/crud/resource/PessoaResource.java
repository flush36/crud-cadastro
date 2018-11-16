package br.com.crud.br.com.crud.resource;

import br.com.crud.br.com.crud.dto.PessoaDTO;
import br.com.crud.br.com.crud.models.Pessoa;
import br.com.crud.br.com.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> listarTodos(@RequestBody PessoaDTO dto) {
        List<Pessoa> pessoas = pessoaService.listarTodos(dto.getNome(), dto.getCpf());
        if(!pessoas.isEmpty())
            return ResponseEntity.ok(pessoas);
        return ResponseEntity.noContent().build();
    }
}
