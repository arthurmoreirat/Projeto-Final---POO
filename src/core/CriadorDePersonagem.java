package core;

import java.util.*;
import models.*;
import utils.Roll;

public class CriadorDePersonagem {

    private static final Scanner scanner = new Scanner(System.in);

    public static Personagem criarPersonagem() {
        System.out.println("=== CRIAÇÃO DE PERSONAGEM ===");

        // Nome
        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();

        // Idade
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // limpar buffer do enter

        // Raça
        System.out.print("Digite a raça do personagem: ");
        String raca = scanner.nextLine();

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Agora vamos determinar os atributos que seu personagem terá. Os atributos são representações numéricas da aptidão de seu personagem para diferentes situações. Precisa se esgueirar sorrateiramente? A sua destreza vai ser necessária. Precisa desvender uma língua antiga? Sua inteligência virá a calhar. Para todas as situações que você encontrar, seus atributos serão muito importantes.");
        System.out.println("Os atributos são mais ou menos relevantes para certas classes (Magos utilizam a INTELIGÊNCIA como base para utilizar magias e Guerreiros usam FORÇA ou DESTREZA para atacar, por exemplo.), mas isso não o impede de construir seu personagem como bem entender.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

        // Rolagem de atributos
        System.out.println("\nRolando os atributos (4d6, soma dos 3 maiores)...");
        List<Integer> atributos = rolarAtributos();

        System.out.println("\nSeus valores rolados: " + atributos);
        System.out.println("Distribua os valores entre os atributos: Força, Constituição, Destreza, Inteligência, Carisma, Sabedoria.");

        // Distribuição dos modificadores
        String[] nomesAtributos = {"Força", "Constituição", "Destreza", "Inteligência", "Carisma", "Sabedoria"};
        Map<String, Integer> modificadores = new LinkedHashMap<>();

        for (String atributo : nomesAtributos) {
            System.out.print("Escolha um valor para " + atributo + ": ");
            int valor = scanner.nextInt();
            while (!atributos.contains(valor)) {
                System.out.println("Valor inválido. Escolha um valor disponível: " + atributos);
                valor = scanner.nextInt();
            }
            int mod = calcularModificador(valor);
            modificadores.put(atributo, mod);
            atributos.remove(Integer.valueOf(valor));
            System.out.printf("%s definido com modificador %+d\n", atributo, mod);
        }

        // Escolha da classe com loop de validação
        Personagem personagem = null;
        while (personagem == null) {
            System.out.println("\nEscolha a classe:");
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Ladino");
            System.out.println("3 - Mago");
            int opcao = scanner.nextInt();

            try {
                personagem = switch (opcao) {
                    case 1 -> new Guerreiro(
                            nome, idade, raca,
                            modificadores.get("Força"),
                            modificadores.get("Constituição"),
                            modificadores.get("Destreza"),
                            modificadores.get("Inteligência"),
                            modificadores.get("Carisma"),
                            modificadores.get("Sabedoria")
                    );
                    case 2 -> new Ladino(
                            nome, idade, raca,
                            modificadores.get("Força"),
                            modificadores.get("Constituição"),
                            modificadores.get("Destreza"),
                            modificadores.get("Inteligência"),
                            modificadores.get("Carisma"),
                            modificadores.get("Sabedoria")
                    );
                    case 3 -> new Mago(
                            nome, idade, raca,
                            modificadores.get("Força"),
                            modificadores.get("Constituição"),
                            modificadores.get("Destreza"),
                            modificadores.get("Inteligência"),
                            modificadores.get("Carisma"),
                            modificadores.get("Sabedoria")
                    );
                    default -> throw new IllegalArgumentException("Classe inválida!");
                };
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        // Resumo final
        System.out.printf("\nPersonagem criado com sucesso! Bem-vindo, %s, o %s!\n", nome, personagem.getClass().getSimpleName());
        System.out.println("\nResumo dos modificadores:");
        for (String atributo : nomesAtributos) {
            System.out.printf("%-15s: %+d\n", atributo, modificadores.get(atributo));
        }

        return personagem;
    }

    // Rola 4d6, soma os 3 maiores, 6 vezes, com efeito de suspense
    private static List<Integer> rolarAtributos() {
        List<Integer> resultados = new ArrayList<>();

        System.out.println("Rolando os atributos...");

        for (int i = 0; i < 6; i++) {
            List<Integer> rolagens = new ArrayList<>();
            System.out.print("Rolagem " + (i + 1) + ": ");

            // Rola 4 dados de 6 lados
            for (int j = 0; j < 4; j++) {
                int dado = Roll.d6();
                rolagens.add(dado);

                // Exibe o dado rolado
                System.out.print(dado + " ");
                try {
                    Thread.sleep(500); // pausa de 0,5 segundo entre cada dado
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Ordena do maior para o menor
            Collections.sort(rolagens, Collections.reverseOrder());

            // Soma os 3 maiores
            int soma = rolagens.get(0) + rolagens.get(1) + rolagens.get(2);
            resultados.add(soma);

            System.out.println("-> Soma dos 3 maiores: " + soma);

            try {
                Thread.sleep(700); // pausa antes da próxima rolagem
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }

    // Calcula modificador baseado no valor do atributo
    private static int calcularModificador(int valor) {
        if (valor >= 20) return +5;
        if (valor >= 18) return +4;
        if (valor >= 16) return +3;
        if (valor >= 14) return +2;
        if (valor >= 12) return +1;
        if (valor >= 10) return 0;
        if (valor >= 8) return -1;
        if (valor >= 6) return -2;
        if (valor >= 4) return -3;
        return -4; // mínimo para valor 3
    }
}
