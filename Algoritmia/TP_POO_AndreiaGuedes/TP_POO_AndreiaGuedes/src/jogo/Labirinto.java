package jogo;

import entidades.*;
import itens.Consumivel;
import itens.ConsumivelCombate;
import itens.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por criar o labirinto do jogo e gerir a lógica da exploração.
 */
public class Labirinto {
    /**
     * Cria e configura a estrutura completa do labirinto.
     * Instancia as salas, define as ligações entre elas,
     * insere armadilhas, inimigos, vendedores e ouro.
     *
     * @return A sala inicial do labirinto (ponto de entrada do herói).
     */
    public static Sala criarLabirinto() {
        Sala entrada = new Sala("Entrada do Labirinto");
        Sala folhas = new Sala("Sala das Folhas");
        Sala chamas = new Sala("Sala das Chamas");
        Sala eletrica = new Sala("Sala Elétrica");
        Sala sombria = new Sala("Sala Sombria");
        Sala gelada = new Sala("Sala Gelada");
        Sala finalSala = new Sala("Sala do Cristal");

        entrada.adicionarLigacao(folhas);
        entrada.adicionarLigacao(chamas);

        folhas.adicionarLigacao(eletrica);
        folhas.adicionarLigacao(sombria);

        chamas.adicionarLigacao(sombria);
        chamas.adicionarLigacao(gelada);

        eletrica.adicionarLigacao(finalSala);
        sombria.adicionarLigacao(finalSala);
        gelada.adicionarLigacao(finalSala);

        // Adicionar armadilhas
        chamas.setDanoArmadilha(10);
        gelada.setDanoArmadilha(12);

        // Adicionar inimigos
        eletrica.adicionarInimigo(new NPC("Guarda Elétrico", 35, 7, 12));
        sombria.adicionarInimigo(new NPC("Goblin das Sombras", 30, 6, 10));
        gelada.adicionarInimigo(new NPC("Serpente de Gelo", 40, 8, 15));
        finalSala.adicionarInimigo(new NPC("Guardião do Cristal", 60, 12, 20));

        // Adicionar vendedores
        eletrica.setVendedor(Vendedor.criarVendedorInicial());

        // Adicionar ouro nas salas
        folhas.setOuroNaSala(15);
        chamas.setOuroNaSala(10);

        return entrada;
    }
    /**
     * Verifica e aplica o dano de armadilha presente na sala.
     * Caso o herói morra, imprime mensagem e retorna false.
     *
     * @param heroi Herói a ser afetado
     * @param salaAtual Sala atual onde o herói se encontra
     * @return false se o herói morrer, true caso contrário
     */
    private static boolean tratarArmadilha(Heroi heroi, Sala salaAtual) {
        if (salaAtual.getDanoArmadilha() > 0) {
            System.out.println("Armadilha ativada! Perdeste " + salaAtual.getDanoArmadilha() + " de vida.");
            heroi.receberDano(salaAtual.getDanoArmadilha());
            if (!heroi.estaViva()) {
                System.out.println("Morreste. Fim da aventura.");
                return false;
            }
        }
        return true;
    }

    /**
     * Permite ao herói interagir com um vendedor, se existir na sala.
     *
     * @param heroi Herói que pode comprar itens
     * @param salaAtual Sala atual onde o herói se encontra
     */
    private static void tratarVendedor(Heroi heroi, Sala salaAtual) {
        if (salaAtual.temVendedor()) {
            System.out.println("Encontraste um vendedor!");
            salaAtual.getVendedor().vender(heroi);
        }
    }

    /**
     * Pergunta ao jogador se deseja usar uma poção antes de entrar em combate.
     * Mostra a lista de poções e aplica os efeitos da escolhida, se for válida.
     *
     * @param heroi Herói que pode usar poções
     * @param scanner Scanner para ler a entrada do utilizador
     */
    private static void usarPocaoAntesCombate(Heroi heroi, Scanner scanner) {
        ArrayList<Pocao> pocoes = new ArrayList<>();
        for (Consumivel item : heroi.getInventario()) {
            if (item instanceof Pocao) pocoes.add((Pocao) item);
        }

        if (!pocoes.isEmpty()) {
            System.out.println("Queres usar uma poção antes do combate? [s/n]");
            if (scanner.next().equalsIgnoreCase("s")) {
                for (int i = 0; i < pocoes.size(); i++) {
                    System.out.print("[" + i + "] ");
                    pocoes.get(i).mostrarDetalhes();
                }
                System.out.print("Opção escolhida: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // limpar buffer
                if (opcao >= 0 && opcao < pocoes.size()) {
                    Pocao p = pocoes.get(opcao);
                    p.usar(heroi);
                    heroi.getInventario().remove(p);
                }
            }
        }
    }
    /**
     * Trata o combate entre o herói e os inimigos da sala atual.
     * Permite usar consumíveis, realizar ataques normais ou especiais,
     * e determina o desfecho com base na vida das entidades.
     *
     * @param heroi Herói que participa no combate
     * @param salaAtual Sala onde os inimigos estão presentes
     * @param scanner Scanner para interação com o jogador
     * @return false se o herói morrer, true se vencer
     */
private static boolean tratarCombate(Heroi heroi, Sala salaAtual, Scanner scanner) {
        for (NPC inimigo : salaAtual.getInimigos()) {
            System.out.println("Inimigo encontrado: " + inimigo.getNome());

            // Consumíveis de combate
            ArrayList<ConsumivelCombate> consumiveis = new ArrayList<>();
            for (Consumivel c : heroi.getInventario()) {
                if (c instanceof ConsumivelCombate) consumiveis.add((ConsumivelCombate) c);
            }

            if (!consumiveis.isEmpty()) {
                System.out.println("Queres usar um consumível de combate? [s/n]");
                if (scanner.next().equalsIgnoreCase("s")) {
                    for (int i = 0; i < consumiveis.size(); i++) {
                        System.out.print("[" + i + "] ");
                        consumiveis.get(i).mostrarDetalhes();
                    }
                    System.out.print("Opção escolhida: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    if (opcao >= 0 && opcao < consumiveis.size()) {
                        ConsumivelCombate usado = consumiveis.get(opcao);
                        usado.usar(heroi, inimigo);
                        heroi.getInventario().remove(usado);
                    }
                }
            }

            boolean ataqueEspecialUsado = false;

            for (int i = 0; i < 2 && inimigo.estaViva() && heroi.estaViva(); i++) {
                System.out.println("Queres usar o ataque especial? [s/n]");
                if (!ataqueEspecialUsado && scanner.next().equalsIgnoreCase("s")) {
                    int danoEspecial = heroi.getArmaPrincipal().getAtaqueEspecial() + heroi.getForca();
                    inimigo.receberDano(danoEspecial);
                    System.out.println("Usaste ataque especial e causaste " + danoEspecial + " de dano!");
                    ataqueEspecialUsado = true;
                } else {
                    heroi.atacar(inimigo);
                }

                if (inimigo.estaViva()) {
                    inimigo.atacar(heroi);
                    if (!heroi.estaViva()) {
                        System.out.println("Foste derrotado.");
                        return false;
                    }
                }
            }

            if (!heroi.estaViva()) {
                System.out.println("Foste derrotado.");
                return false;
            }
        }

        salaAtual.getInimigos().clear();
        return true;
    }

    /**
     * Inicia a exploração do labirinto a partir de uma sala inicial.
     * O herói encontra armadilhas, vendedor, combates, e escolhe o caminho a seguir.
     * O jogo termina se o herói morrer ou derrotar inimigos e chegar à sala final, vencendo assim o jogo.
     *
     * @param heroi      Herói jogável que explora o labirinto.
     * @param salaAtual  Sala onde o herói começa.
     */
    public static void iniciarLabirinto(Heroi heroi, Sala salaAtual) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEntraste na sala: " + salaAtual.getNome());

            if (salaAtual.getOuroNaSala() > 0) {
                System.out.println("Encontraste " + salaAtual.getOuroNaSala() + " moedas de ouro na sala!");
                heroi.adicionarOuro(salaAtual.getOuroNaSala());
                salaAtual.setOuroNaSala(0);
            }

            if (!tratarArmadilha(heroi, salaAtual)) return;

            tratarVendedor(heroi, salaAtual);

            usarPocaoAntesCombate(heroi, scanner);

            if (!salaAtual.getInimigos().isEmpty()) {
                if (!tratarCombate(heroi, salaAtual, scanner)) return;
            }

            if (salaAtual.getNome().equals("Sala do Cristal")) {
                System.out.println("Parabéns! Venceste o labirinto!");
                return;
            }

            System.out.println("\nCaminhos disponíveis:");
            for (int i = 0; i < salaAtual.getLigacoes().size(); i++) {
                System.out.println("[" + i + "] " + salaAtual.getLigacoes().get(i).getNome());
            }

            System.out.print("Escolhe a próxima sala: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha < 0 || escolha >= salaAtual.getLigacoes().size()) {
                System.out.println("Escolha inválida. Aventura terminada.");
                return;
            }

            salaAtual = salaAtual.getLigacoes().get(escolha);
        }
    }
}
