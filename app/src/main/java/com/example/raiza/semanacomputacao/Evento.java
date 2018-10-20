package com.example.raiza.semanacomputacao;

public class Evento {
    private String titulo;
    private String data;
    private String hora;
    private String facilitador;
    private String descricao;

    public Evento(String titulo, String data, String hora, String facilitador, String descricao) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.facilitador = facilitador;
        this.descricao = descricao;
    }

    public Evento() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
