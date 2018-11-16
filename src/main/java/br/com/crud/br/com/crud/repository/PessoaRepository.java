package br.com.crud.br.com.crud.repository;

import br.com.crud.br.com.crud.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select u from pessoa u where u.nome like %:nome% and u.cpf like %:cpf%")
    List<Pessoa> findByNameAndCpfIgnoreCase(@Param("nome") String nome, @Param("cpf") String cpf);

}
