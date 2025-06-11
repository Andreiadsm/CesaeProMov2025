package jogo;
import itens.ItemHeroi;

import entidades.*;
import itens.Consumivel;
import itens.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

public class Labirinto {

    public static Sala criarLabirinto() {
        // Nível 0 (início)
        Sala entrada = new Sala("🌟 Entrada do Labirinto");

        // Nível 1
        Sala sala1A = new Sala(" Sala das Folhas");
        Sala sala1B = new Sala("Sala das Chamas");

        // Nível 2
        Sala sala2A = new Sala("Sala Sombria");
        Sala sala2B = new Sala("Sala Elétrica");
        Sala sala2C = new Sala("Sala Submersa");
        Sala sala2D = new Sala("Sala Congelada");

        // Conexões binárias (sempre 2 por sala)
        entrada.adicionarLigacao(sala1A);
        entrada.adicionarLigacao(sala1B);

        sala1A.adicionarLigacao(sala2A);
        sala1A.adicionarLigacao(sala2B);

        sala1B.adicionarLigacao(sala2C);
        sala1B.adicionarLigacao(sala2D);

        // Conteúdo das salas
        sala1A.setDanoArmadilha(10);
        sala1B.adicionarInimigo(new NPC("Esqueleto Flamejante", 30, 5, 10));

        sala2A.adicionarOuro(15);
        sala2B.setVendedor(Vendedor.criarVendedorInicial());

        sala2C.adicionarInimigo(new NPC("Serpente Marinha", 35, 6, 12));
        sala2D.setItemEscondido(new Pocao("Poção Congelante", 20, 40, 0, new ArrayList<>()));

        return entrada;
    }

    public static void iniciarLabirinto(Heroi heroi, Sala salaAtual) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("Entraste na sala: " + salaAtual.getNome());

            // 🧙 Vendedor
            if (salaAtual.temVendedor()) {
                System.out.println("Encontraste um vendedor!");
                salaAtual.getVendedor().vender(heroi);
            }

            // Inimigos
            if (!salaAtual.getInimigos().isEmpty()) {
                for (NPC inimigo : salaAtual.getInimigos()) {
                    System.out.println("Inimigo encontrado: " + inimigo.getNome());
                    heroi.atacar(inimigo);
                    if (!heroi.estaViva()) {
                        System.out.println("Foste derrotado pelo inimigo.");
                        return;
                    }
                }
            }

            // Escolher próximo caminho
            if (salaAtual.getLigacoes().isEmpty()) {
                System.out.println("🎉 Chegaste ao fim do labirinto!");
                return;
            }

            System.out.println("\nCaminhos disponíveis:");
            for (int i = 0; i < salaAtual.getLigacoes().size(); i++) {
                System.out.println("[" + i + "] " + salaAtual.getLigacoes().get(i).getNome());
            }

            System.out.print("Escolhe a próxima sala: ");
            int escolha = scanner.nextInt();

            if (escolha < 0 || escolha >= salaAtual.getLigacoes().size()) {
                System.out.println("Escolha inválida. Aventura terminada.");
                return;
            }

            // Avançar
            salaAtual = salaAtual.getLigacoes().get(escolha);
        }
    }

}
