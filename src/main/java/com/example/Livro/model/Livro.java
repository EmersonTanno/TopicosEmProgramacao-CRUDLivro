package com.example.Livro.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int quantidadePaginas;
    private int anoPublicacao;

    public Livro() {}

    public Livro(String titulo, String autor, int quantidadePaginas,int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setQuantidadePaginas(int quantidadePaginas){
        this.quantidadePaginas = quantidadePaginas;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
