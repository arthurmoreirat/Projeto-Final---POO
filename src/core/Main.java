package core;

import models.Personagem;

public class Main {
    public static void main(String[] args) {
        // Criação do personagem
        Personagem jogador = CriadorDePersonagem.criarPersonagem();

        // Teste de informações
        System.out.println("\n=== Personagem Criado ===");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Idade: " + jogador.getIdade());
        System.out.println("Raça: " + jogador.getRaca());
        System.out.println("Classe: " + jogador.getClass().getSimpleName());
        System.out.println("Pontos de Vida: " + jogador.getPV());
    }
}