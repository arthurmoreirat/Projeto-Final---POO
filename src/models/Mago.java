package models;

import interfaces.Interface;
import utils.Roll;

public class Mago extends Personagem implements Interface {
    private int vidaMaxima;

    public Mago(String nome, int idade, String raca, int forca, int constituicao, int destreza, int inteligencia, int carisma, int sabedoria) {
        super(nome, idade, raca, forca, destreza, inteligencia, constituicao, carisma, sabedoria);
        this.PV = 6 + this.constituicao;
        this.CA = 12 + this.destreza;
        this.vidaMaxima = this.PV;
    }

    @Override
    public int atacar(int defesa) {
        int dado = Roll.d20();
        int ataque = dado + this.inteligencia + 2;

        System.out.printf("%s lança uma magia! Rolagem: %d (Total: %d)\n", nome, dado, ataque);

        if(dado == 20) {
            System.out.println("Acerto crítico!");
            int danoCritico = (Roll.d10() + this.inteligencia) * 2;
            System.out.printf("Dano crítico causado: %d\n", danoCritico);
            return danoCritico;

        } else if (ataque >= defesa){ 
            int dano = Roll.d10() + this.inteligencia;
            System.out.printf("A magia acerta! Dano causado: %d\n", dano);
            return dano;

        } else {
            System.out.println("A magia falhou!");
            return 0;
        }
    }

    @Override
    public int curar(int cura) {
        this.PV += cura;
        if (this.PV > vidaMaxima) {
            this.PV = vidaMaxima;
        }
        System.out.printf("%s curou %d pontos de vida. PV atual: %d\n", nome, cura, PV);
        return this.PV;
    }

    @Override
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    @Override
    public void usarHabilidade() {
        System.out.printf("%s usa a habilidade Bola de Fogo!\n", nome);
        int dano = Roll.d10() + this.inteligencia;
        System.out.printf("A Bola de Fogo causa %d de dano mágico em área!\n", dano);
    }
}

