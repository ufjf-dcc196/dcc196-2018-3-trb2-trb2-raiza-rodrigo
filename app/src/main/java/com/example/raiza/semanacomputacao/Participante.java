package com.example.raiza.semanacomputacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Participante implements Serializable {
    private String usuario;
    private String email;
    private String cpf;
    private List<Evento> evento;

    public Participante(String usuario, String email, String cpf) {
        this.usuario = usuario;
        this.email = email;
        this.cpf = cpf;
        this.evento = new ArrayList<>();
    }

    public Participante() {
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
}
