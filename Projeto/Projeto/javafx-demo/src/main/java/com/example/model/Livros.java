package com.example.model;

import java.math.BigDecimal;

public class Livros {

    private Long id;
    private String nomeDoLivro;
    private String autorDoLivro;
    private int anoDePublicacao;
    private String genero;
    private BigDecimal valor;

    public Livros(Long id, String nomeDoLivro, String autorDoLivro, int anoDePublicacao, String genero,
        BigDecimal valor) {
        this.id = id;
        this.nomeDoLivro = nomeDoLivro;
        this.autorDoLivro = autorDoLivro;
        this.anoDePublicacao = anoDePublicacao;
        this.genero = genero;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }

    public String getAutorDoLivro() {
        return autorDoLivro;
    }

    public void setAutorDoLivro(String autorDoLivro) {
        this.autorDoLivro = autorDoLivro;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
