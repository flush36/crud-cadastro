package br.com.crud.br.com.crud.repository;

import br.com.crud.br.com.crud.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
