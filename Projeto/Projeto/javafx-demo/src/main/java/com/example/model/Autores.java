package com.example.model;

public class Autores {

    private Long id;
    private String nomeDoAutor;
    private int idadeDoAutor;

    public Autores(Long id, String nomeDoAutor, int idadeDoAutor) {
        this.id = id;
        this.nomeDoAutor = nomeDoAutor;
        this.idadeDoAutor = idadeDoAutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoAutor() {
        return nomeDoAutor;
    }

    public void setNomeDoAutor(String nomeDoAutor) {
        this.nomeDoAutor = nomeDoAutor;
    }

    public int getIdadeDoAutor() {
        return idadeDoAutor;
    }

    public void setIdadeDoAutor(int idadeDoAutor) {
        this.idadeDoAutor = idadeDoAutor;
    }

    

    
    
}
