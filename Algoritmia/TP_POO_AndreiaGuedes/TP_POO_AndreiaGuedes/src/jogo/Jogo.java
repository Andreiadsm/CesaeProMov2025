package jogo;

import entidades.*;
import java.util.Scanner;
import static java.lang.Thread.sleep;

/**
 * Classe principal do jogo. Contém o método main que inicia o ciclo do jogo.
 */
public class Jogo {

    /**
     * Método principal que inicia o jogo.
     * Permite ao utilizador criar um herói, entrar no labirinto,
     * jogar até ao fim e depois decidir se quer jogar novamente.
     */
    public static void main(String[] args) throws InterruptedException {
        // Música de fundo
        Audio.playMusic("AudioFiles/dark-exitement.wav");

        System.out.println("Inicia-se a aventura da tua vida no...");

        sleep(2000);

        Scanner scanner = new Scanner(System.in);

        do {
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
