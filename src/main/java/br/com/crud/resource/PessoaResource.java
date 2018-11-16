package br.com.crud.resource;

import br.com.crud.error.ValidacaoException;
import br.com.crud.models.Pessoa;
import br.com.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("pesquisar")
        public ResponseEntity<?> listarPorNomeOuCpf(@RequestBody Pessoa pessoa) {
        List<Pessoa> pessoas = pessoaService.listarPorNomeOuCpf(pessoa.getNome(), pessoa.getCpf());
        if(!pessoas.isEmpty())
            return ResponseEntity.ok(pessoas);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<Pessoa> pessoas = pessoaService.listarTodos();
        if(!pessoas.isEmpty())
            return ResponseEntity.ok(pessoas);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa) {
        try {
            return ResponseEntity.ok(pessoaService.cadastrar(pessoa));
        } catch (ValidacaoException erro) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro.getErroDTO());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> alterar(@RequestBody Pessoa pessoa, @PathVariable("id") Long id) throws ValidacaoException {
       try{
           return ResponseEntity.ok(pessoaService.alterar(pessoa, id));
       }catch (ValidacaoException erro) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro.getErroDTO());
       }

    }


}
