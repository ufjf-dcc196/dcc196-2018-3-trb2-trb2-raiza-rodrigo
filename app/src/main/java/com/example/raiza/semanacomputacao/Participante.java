package com.example.raiza.semanacomputacao;

public class Participante {
    private String usuario;
    private String email;
    private String cpf;

    public Participante(String usuario, String email, String cpf) {
        this.usuario = usuario;
        this.email = email;
        this.cpf = cpf;
    }

    public Participante() {
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
