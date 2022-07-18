package com.algaworks.model;

public class Passageiro {

    private String nome;
    private TipoPassageiro tipoPassageiro;

    public Passageiro(String nome, TipoPassageiro tipoPassageiro) {
        this.nome = nome;
        this.tipoPassageiro = tipoPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public void setTipoPassageiro(TipoPassageiro tipoPassageiro) {
        this.tipoPassageiro = tipoPassageiro;
    }

}
