package jogo;

import entidades.Heroi;
import entidades.NPC;
import entidades.TipoHeroi;
import entidades.Vendedor;
import itens.*;

import java.util.ArrayList;

public class Labirinto {

    public static Sala criarLabirinto() {
        ArrayList<Sala> todasAsSalas = new ArrayList<>();
        Sala entrada = new Sala("Entrada do Labirinto");
        todasAsSalas.add(entrada);

        int numeroDeSalas = 6 + new java.util.Random().nextInt(3); // 6 a 8 salas

        for (int i = 1; i < numeroDeSalas; i++) {
            Sala sala = new Sala("Sala " + i);

            // Armadilha aleatória
            if (Math.random() < 0.5) {
                sala.setDanoArmadilha(5 + new java.util.Random().nextInt(16)); // 5 a 20
            }

            // Inimigo aleatório
            if (Math.random() < 0.6) {
                NPC inimigo = new NPC("Inimigo " + i, 40, 6, 10);
                sala.adicionarInimigo(inimigo);
            }

            // Vendedor aleatório (máximo 1 vendedor por labirinto)
            if (Math.random() < 0.3 && !jaTemVendedor(todasAsSalas)) {
                sala.setVendedor(Vendedor.criarVendedorInicial());
            }

            todasAsSalas.add(sala);
        }

        // Conectar salas linearmente (com possíveis atalhos)
        for (int i = 0; i < todasAsSalas.size() - 1; i++) {
            Sala atual = todasAsSalas.get(i);
            Sala proxima = todasAsSalas.get(i + 1);
            atual.adicionarLigacao(proxima);

            if (i + 2 < todasAsSalas.size() && Math.random() < 0.3) {
                atual.adicionarLigacao(todasAsSalas.get(i + 2));
            }
        }

        return entrada;
    }

    public static void iniciarLabirinto(Heroi heroi, Sala salaAtual) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\nEntraste na sala: " + salaAtual.getNome());

            // Armadilha
            if (salaAtual.getDanoArmadilha() > 0) {
                System.out.println("Armadilha ativada! Perdeste " + salaAtual.getDanoArmadilha() + " de vida.");
                heroi.receberDano(salaAtual.getDanoArmadilha());
                if (!heroi.estaViva()) {
                    System.out.println("☠️ Morreste! Fim da aventura.");
                    return;
                }
            }

            if (salaAtual.temVendedor()) {
                System.out.println("Encontraste um vendedor com itens à venda!");
                salaAtual.getVendedor().vender(heroi);
            }

            if (!salaAtual.getInimigos().isEmpty()) {
                for (NPC inimigo : salaAtual.getInimigos()) {
                    System.out.println("👹 Inimigo encontrado: " + inimigo.getNome());
                    heroi.atacar(inimigo);
                }
            }

            // Verificar se é a última sala
            if (salaAtual.getLigacoes().isEmpty()) {
                System.out.println("Parabéns! Chegaste ao fim do labirinto!");
                return;
            }

            // Escolher próxima sala
            System.out.println("\nCaminhos disponíveis:");
            for (int i = 0; i < salaAtual.getLigacoes().size(); i++) {
                System.out.println("[" + i + "] " + salaAtual.getLigacoes().get(i).getNome());
            }

            System.out.print("Escolhe a próxima sala: ");
            int escolha = scanner.nextInt();

            if (escolha < 0 || escolha >= salaAtual.getLigacoes().size()) {
                System.out.println("\u274C Escolha inválida. Aventura terminada.");
                return;
            }

            // Avançar para a sala escolhida
            salaAtual = salaAtual.getLigacoes().get(escolha);
        }
    }

    private static boolean jaTemVendedor(ArrayList<Sala> salas) {
        for (Sala s : salas) {
            if (s.temVendedor()) {
                return true;
            }
        }
        return false;
    }
}