package com.sindify.condominio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_morador")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ddd;
    private String telefone;
    @Email
    private String email;
    private Boolean proprietario;
    private String unidade;
    @CPF
    private String cpf;
    private LocalDate dataNascimento;

    public Morador() {}

    public Morador(Long id,
                   String nome,
                   String ddd,
                   String telefone,
                   String email,
                   Boolean proprietario,
                   String unidade,
                   String cpf,
                   LocalDate dataNascimento
                   ) {
        this.id = id;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.unidade = unidade;
        this.email = email;
        this.proprietario = proprietario;
        this.telefone = telefone;
        this.ddd = ddd;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public Boolean getProprietario() {
        return proprietario;
    }

    public void setProprietario(Boolean proprietario) {
        this.proprietario = proprietario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return Objects.equals(id, morador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
