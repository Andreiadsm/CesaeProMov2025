package jogo;

import entidades.*;
import itens.Consumivel;
import itens.ConsumivelCombate;
import itens.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

public class Labirinto {

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

        chamas.setDanoArmadilha(10);
        gelada.setDanoArmadilha(12);

        eletrica.adicionarInimigo(new NPC("Guarda Elétrico", 35, 7, 12));
        sombria.adicionarInimigo(new NPC("Goblin das Sombras", 30, 6, 10));
        gelada.adicionarInimigo(new NPC("Serpente de Gelo", 40, 8, 15));

        eletrica.setVendedor(Vendedor.criarVendedorInicial());
        finalSala.adicionarInimigo(new NPC("Guardião do Cristal", 60, 12, 20));

        return entrada;
    }

    public static void iniciarLabirinto(Heroi heroi, Sala salaAtual) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEntraste na sala: " + salaAtual.getNome());

            // Armadilhas
            if (salaAtual.getDanoArmadilha() > 0) {
                System.out.println("Armadilha ativada! Perdeste " + salaAtual.getDanoArmadilha() + " de vida.");
                heroi.receberDano(salaAtual.getDanoArmadilha());
                if (!heroi.estaViva()) {
                    System.out.println("Morreste. Fim da aventura.");
                    return;
                }
            }

            // Vendedor
            if (salaAtual.temVendedor()) {
                System.out.println("Encontraste um vendedor!");
                salaAtual.getVendedor().vender(heroi);
            }

            // Usar poção
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
                        heroi.setVidaAtual(Math.min(heroi.getVidaAtual() + p.getVidaACurar(), heroi.getVidaMax()));
                        heroi.setForca(heroi.getForca() + p.getAumentoForca());
                        heroi.getInventario().remove(p);
                        System.out.println("Usaste a poção " + p.getNome());
                    }
                }
            }

            // Combate
            if (!salaAtual.getInimigos().isEmpty()) {
                for (NPC inimigo : salaAtual.getInimigos()) {
                    System.out.println("Inimigo encontrado: " + inimigo.getNome());

                    // Consumível de combate
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
                                inimigo.receberDano(usado.getAtaqueInstantaneo());
                                heroi.getInventario().remove(usado);
                                System.out.println("Usaste " + usado.getNome() + " e causaste " + usado.getAtaqueInstantaneo() + " de dano!");
                            }
                        }
                    }

                    // Ataque do herói (1ª vez)
                    System.out.println("Queres usar o ataque especial? [s/n]");
                    String respostaEspecial = scanner.next().toLowerCase();
                    if (respostaEspecial.equals("s")) {
                        int danoEspecial = heroi.getArmaPrincipal().getAtaqueEspecial() + heroi.getForca();
                        inimigo.receberDano(danoEspecial);
                        System.out.println("Usaste ataque especial e causaste " + danoEspecial + " de dano!");
                    } else {
                        heroi.atacar(inimigo);
                    }

                    // Contra-ataque do inimigo
                    if (inimigo.estaViva()) {
                        inimigo.atacar(heroi);
                        if (!heroi.estaViva()) {
                            System.out.println("Foste derrotado. O labirinto venceu.");
                            return;
                        }

                        // Segundo ataque do herói, se estiver vivo
                        System.out.println("Queres usar o ataque especial? [s/n]");
                        respostaEspecial = scanner.next().toLowerCase();
                        if (respostaEspecial.equals("s")) {
                            int danoEspecial = heroi.getArmaPrincipal().getAtaqueEspecial() + heroi.getForca();
                            inimigo.receberDano(danoEspecial);
                            System.out.println("Usaste ataque especial e causaste " + danoEspecial + " de dano!");
                        } else {
                            heroi.atacar(inimigo);
                        }
                    }

                    if (!heroi.estaViva()) {
                        System.out.println("Foste derrotado. O labirinto venceu.");
                        return;
                    }
                }

                salaAtual.getInimigos().clear(); // limpar após derrotar todos
            }

            // Vitória final
            if (salaAtual.getNome().equals("Sala do Cristal")) {
                System.out.println("Parabéns! Derrotaste o Guardião do Cristal e venceste o labirinto!");
                return;
            }

            // Próxima sala
            System.out.println("\nCaminhos disponíveis:");
            for (int i = 0; i < salaAtual.getLigacoes().size(); i++) {
                System.out.println("[" + i + "] " + salaAtual.getLigacoes().get(i).getNome());
            }

            System.out.print("Escolhe a próxima sala: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (escolha < 0 || escolha >= salaAtual.getLigacoes().size()) {
                System.out.println("Escolha inválida. Aventura terminada.");
                return;
            }

            salaAtual = salaAtual.getLigacoes().get(escolha);
        }
    }
}
