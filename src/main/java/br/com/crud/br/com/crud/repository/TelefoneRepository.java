package br.com.crud.br.com.crud.repository;

import br.com.crud.br.com.crud.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
