package jogo;

import entidades.*;

import java.util.Scanner;
/**
 * Classe principal do jogo. Contém o metodo main que inicia o ciclo do jogo.
 */
public class Jogo {

    /**
     * Metodo principal que inicia o jogo.
     * Permite ao utilizador criar um herói, entrar no labirinto,
     * jogar até ao fim e depois decidir se quer jogar novamente.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Iniciar Jogo");

            // Criação da personagem pelo utilizador
            Heroi heroi = Heroi.criarPersonagem();

            // Criação do labirinto inicial
            Sala salaInicial = Labirinto.criarLabirinto();

            // Início do jogo dentro do labirinto
            Labirinto.iniciarLabirinto(heroi, salaInicial);

            // Mostra o estado final da personagem após o jogo
            System.out.println("\nEstado final da personagem:");
            heroi.exibirDetalhes();

            // Pergunta se o jogador quer repetir
            System.out.println("\nQueres jogar de novo? [s/n]");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        System.out.println("Obrigado por jogar!");
    }
}