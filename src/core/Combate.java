package core;

import models.Personagem;
import utils.Roll;
import models.Inimigo;
import interfaces.Interface;
import java.util.Scanner;

public class Combate {

    public static void combateTurnos(Personagem jogador, Inimigo inimigo, Scanner scanner) {
        System.out.printf("\nCombate iniciado entre %s e %s!\n", jogador.getNome(), inimigo.getNome());

        boolean jogadorVivo = true;
        boolean turnoJogador = true;

        while (jogadorVivo && inimigo.estaVivo()) {
            if (turnoJogador) {
                System.out.println("\nSeu turno! Escolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Usar habilidade especial");
                System.out.println("3 - Tentar curar");

                int acao = scanner.nextInt();

                if (jogador instanceof Interface) {
                    Interface pInterface = (Interface) jogador;

                    switch (acao) {
                        case 1:
                            int dano = pInterface.atacar(inimigo.getDefesa());
                            inimigo.setPV(inimigo.getPV() - dano);
                            System.out.printf("%s causou %d de dano!\n", jogador.getNome(), dano);
                            break;
                        case 2:
                            int dano2 = pInterface.usarHabilidade();
                            inimigo.setPV(inimigo.getPV() - dano2);
                            if(dano2 != 0) {
                                System.out.printf("%s causou %d de dano com a habilidade especial!\n", jogador.getNome(), dano2);
                            }
                            break;
                        case 3:
                            System.out.print("Você toma uma poção de vida!");
                            int cura = Roll.d8() + 2;
                            System.out.println("Você recupera " + cura + " pontos de vida.");
                            pInterface.curar(cura);
                            break;
                        default:
                            System.out.println("Ação inválida! Você perde o turno.");
                    }
                } else {
                    System.out.println("Erro: jogador não implementa Interface!");
                }

            } else {
                // Turno do inimigo
                System.out.printf("\nTurno de %s!\n", inimigo.getNome());
                int rollAtaque = Roll.d20() + inimigo.getAtaque() + 2;

                if (rollAtaque >= jogador.getCA()) {
                    int danoInimigo = Roll.d4() + inimigo.getAtaque();
                    System.out.printf("%s acerta você com %d de dano!\n", inimigo.getNome(), danoInimigo);
                    jogador.setPV(jogador.getPV() - danoInimigo);

                    if (jogador.getPV() <= 0) {
                        jogadorVivo = false;
                    }
                } else {
                    System.out.printf("%s errou o ataque!\n", inimigo.getNome());
                }
            }

            turnoJogador = !turnoJogador;
        }

        if (jogadorVivo) {
            System.out.printf("\nVocê derrotou o %s e venceu o combate!\n", inimigo.getNome());
        } else {
            System.out.println("\nVocê foi derrotado...");
            System.out.println("Game Over.");
            System.exit(0);
        }
    }

}
