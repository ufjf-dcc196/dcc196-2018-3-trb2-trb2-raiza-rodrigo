package com.example.raiza.semanacomputacao;

import java.io.Serializable;
import java.util.ArrayList;

public class Evento implements Serializable {
    private String titulo;
    private String data;
    private String hora;
    private String facilitador;
    private String descricao;
    private ArrayList<Participante> participante;

    public Evento(String titulo, String data, String hora, String facilitador, String descricao) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.facilitador = facilitador;
        this.descricao = descricao;
        this.participante = new ArrayList<>();
    }

    public Evento() {
        this.participante = new ArrayList<>();
    }

    public ArrayList<Participante> getParticipante() {
        return participante;
    }

    public void setParticipante(ArrayList<Participante> participante) {
        this.participante = participante;
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
