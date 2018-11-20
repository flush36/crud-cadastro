package br.com.crud.dto;

import br.com.crud.models.Telefone;

import java.util.List;

public class PessoaDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private Integer idade;

    private Integer qtdTelefones;

    private List<Telefone> telefones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getQtdTelefones() {
        return qtdTelefones;
    }

    public void setQtdTelefones(Integer qtdTelefones) {
        this.qtdTelefones = qtdTelefones;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}

