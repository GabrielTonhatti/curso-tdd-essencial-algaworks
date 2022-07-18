package com.algaworks.service;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;

public class PrecoPassagemService {
    public double calcular(Passageiro passageiro, Voo voo) {
        if (passageiro.getTipoPassageiro() == TipoPassageiro.GOLD) {

            if (voo.getPreco() > 500) {
                return voo.getPreco() * 0.85;
            }

            return voo.getPreco() * 0.9;
        } else if (passageiro.getTipoPassageiro() == TipoPassageiro.SILVER) {
            if (voo.getPreco() > 700) {
                return voo.getPreco() * 0.9;
            }

            return voo.getPreco() * 0.94;
        }

        throw new TipoPassageiroInvalidoException();
    }

}
