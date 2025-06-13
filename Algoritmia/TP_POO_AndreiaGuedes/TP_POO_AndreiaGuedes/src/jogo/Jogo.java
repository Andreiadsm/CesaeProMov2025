package jogo;

import entidades.*;
import java.util.Scanner;

/**
 * Classe principal do jogo. Contém o método main e o ciclo do jogo.
 */
public class Jogo {

    /**
     * Metodo principal que inicia o jogo.
     * Cria o herói e chama o método que executa o jogo.
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Audio.playMusic("AudioFiles/dark-exitement.wav");

        do {
            System.out.println("Inicia-se a aventura da tua vida no...");
            System.out.println("*-*-*-*-*-* LABIRINTO DOS PERIGOS *-*-*-*-*-*\n");
            System.out.println("Há muito tempo, uma antiga relíquia poderosa foi perdida no labirinto.");
            System.out.println("Muitos aventureiros tentaram recuperá-la, mas nenhum sobreviveu.");
            System.out.println("Agora, um herói corajoso deve entrar no Labirinto dos Perigos,");
            System.out.println("enfrentar monstros, armadilhas e desafios para salvar o reino.\n");
            System.out.println("Será que serás tu esse herói? A aventura começa agora!\n");

            Thread.sleep(2000);

            Heroi heroi = Heroi.criarPersonagem();
            labirintoDosPerigos(heroi);

            System.out.println("\nQueres jogar de novo? [s/n]");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }

    /**
     * Método que representa o jogo: movimentação pelo labirinto,
     * combate, encontros e decisões do herói.
     *
     * @param heroi Herói criado pelo jogador.
     */
    public static void labirintoDosPerigos(Heroi heroi) {
        Sala salaInicial = Labirinto.criarLabirinto();
        Labirinto.iniciarLabirinto(heroi, salaInicial);

        System.out.println("\nEstado final da personagem:");
        heroi.exibirDetalhes();
    }
}
