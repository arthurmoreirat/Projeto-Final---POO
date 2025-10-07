package models;

import interfaces.Interface;
import utils.Roll;

public class Ladino extends Personagem implements Interface {
    private int vidaMaxima;

    public Ladino(String nome, int idade, int raca, int forca, int constituicao, int destreza, int inteligencia, int carisma, int sabedoria) {
        super(nome, idade, raca, forca, destreza, inteligencia, constituicao, carisma, sabedoria);
        this.PV = 8 + this.constituicao;
        this.CA = 14 + this.destreza;
        this.vidaMaxima = this.PV;
    }

    @Override
    public int atacar(int defesa) {
        int dado = Roll.d20();
        int ataque = dado + this.destreza + 2;

        System.out.printf("%s realiza um ataque furtivo! Rolagem: %d (Total: %d)\n", nome, dado, ataque);

        if (dado == 20) {
            System.out.println("Acerto crítico!");
            int danoCritico = (Roll.d6() + this.destreza) * 2;
            System.out.printf("Dano crítico causado: %d\n", danoCritico);
            return danoCritico;

        } else if (ataque >= defesa){
            int dano = Roll.d6() + this.destreza;

            // Chance de ataque furtivo extra se a rolagem natural for alta
            if (dado >= 18) {
                int bonus = Roll.d6();
                dano += bonus;
                System.out.printf("Ataque furtivo! Dano bônus: +%d\n", bonus);
            }

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
        System.out.printf("%s usa a habilidade Ataque Duplo!\n", nome);
        int dano1 = Roll.d6() + this.destreza / 2;
        int dano2 = Roll.d6() + this.destreza / 2;
        int total = dano1 + dano2;
        System.out.printf("Dois golpes rápidos acertam o inimigo! Dano total: %d (%d + %d)\n", total, dano1, dano2);
    }
}
