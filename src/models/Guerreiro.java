package models;

import interfaces.Interface;
import utils.Roll;

public class Guerreiro extends Personagem implements Interface {
    private int vidaMaxima;

    public Guerreiro(String nome, int idade, String raca, int forca, int constituicao, int destreza, int inteligencia, int carisma, int sabedoria) {
        super(nome, idade, raca, forca, destreza, inteligencia, constituicao, carisma, sabedoria);
        this.PV = 10 + this.constituicao;
        this.CA = 15 + this.destreza;
        this.vidaMaxima = this.PV;
    }

    @Override
    public int atacar(int defesa) {
        int dado = Roll.d20();
        int ataque = dado + this.força + 2;

        System.out.printf("%s ataca com rolagem %d (Total: %d)\n", nome, dado, ataque);

        if(dado == 20) {
            System.out.println("Acerto crítico!");
            int danoCritico = (Roll.d8() + this.força) * 2;
            System.out.printf("Dano crítico causado: %d\n", danoCritico);
            return danoCritico;

        } else if (ataque >= defesa){
            int dano = Roll.d8() + this.força;
            System.out.printf("Acerto! Dano causado: %d\n", dano);
            return dano;

        } else {
            System.out.println("O ataque errou!");
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
        int cura = Roll.d10() + this.constituicao;
        System.out.printf("%s usa a habilidade retomar fôlego, restaurando %d pontos de vida.\n", nome, cura);

        this.PV = curar(cura);
    }
}