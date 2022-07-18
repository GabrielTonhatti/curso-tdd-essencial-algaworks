package com.algaworks.service;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrecoPassagemServiceTest {

    private PrecoPassagemService precoPassagemService;

    @Before
    public void setup() {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_comValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);

        assertValorPassagem(passageiro, voo, 90.0);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_comValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);

        assertValorPassagem(passageiro, voo, 510.0);
    }
    
    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_comValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);

        assertValorPassagem(passageiro, voo, 94.0);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_comValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);

        assertValorPassagem(passageiro, voo, 720.0);
    }

    private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
        double valor = precoPassagemService.calcular(passageiro, voo);

        assertEquals(esperado, valor, 0.0001);
    }

}
