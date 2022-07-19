package com.algaworks.model;

public class Passageiro {

    private String nome;
    private TipoPassageiro tipo;

    public Passageiro(String nome, TipoPassageiro tipoPassageiro) {
        this.nome = nome;
        this.tipo = tipoPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPassageiro getTipo() {
        return tipo;
    }

    public void setTipo(TipoPassageiro tipo) {
        this.tipo = tipo;
    }

}
