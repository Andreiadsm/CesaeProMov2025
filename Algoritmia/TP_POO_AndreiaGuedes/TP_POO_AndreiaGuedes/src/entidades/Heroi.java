package entidades;

import itens.ArmaPrincipal;
import itens.Consumivel;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Classe abstrata que representa um herói jogável no RPG.
 * Cada herói possui atributos como vida, força, ouro, arma principal e inventário de consumíveis.
 */
public abstract class Heroi extends Entidade {
    private TipoHeroi tipo;
    private int nivel;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;
    private boolean ataqueEspecialUsado = false;

    public Heroi(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca);
        this.ouro = ouroInicial;
        this.nivel = 1;
        this.inventario = new ArrayList<Consumivel>();
        this.tipo = tipo;

        ArrayList<TipoHeroi> permitido = new ArrayList<>();
        permitido.add(tipo);

        // Define a arma inicial com base no tipo do herói
        if (tipo == TipoHeroi.FADA) {
            this.armaPrincipal = new ArmaPrincipal("Varinha Inicial", 5, 1, 2, permitido);
        } else if (tipo == TipoHeroi.PRINCESA) {
            this.armaPrincipal = new ArmaPrincipal("Espada Inicial", 6, 2, 3, permitido);
        } else if (tipo == TipoHeroi.DRAGAO) {
            this.armaPrincipal = new ArmaPrincipal("Garras Pequenas", 7, 3, 4, permitido);
        }
    }


    public boolean isAtaqueEspecialUsado() {
        return ataqueEspecialUsado;
    }

    public void setAtaqueEspecialUsado(boolean usado) {
        this.ataqueEspecialUsado = usado;
    }
    /**
     * @return O tipo do herói.
     */
    public TipoHeroi getTipoHeroi() {
        return this.tipo;
    }

    /**
     * Define o ouro atual.
     * @param ouro Quantidade de ouro.
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }
    /**
     * @return Ouro atual do herói.
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Adiciona ouro ao total.
     * @param valor Quantidade a adicionar.
     */
    public void adicionarOuro(int valor) {
        this.ouro += valor;
    }

    /**
     * @return Inventário de consumíveis do herói.
     */
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    /**
     * @return A arma principal do herói.
     */
    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    /**
     * Define uma nova arma principal.
     * @param armaPrincipal A nova arma.
     */
    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    /**
     * Adiciona um consumível ao inventário.
     * @param item O consumível a adicionar.
     */
    public void adicionarConsumivel(Consumivel item) {
        this.inventario.add(item);
    }

    /**
     * Sobe de nível, aumenta a força e restaura a vida.
     */
    public void subirNivel() {
        this.nivel++;
        this.setForca(this.getForca() + 1);
        this.setVidaAtual(this.getVidaMax());
    }

    /**
     * Cria um novo herói com input do utilizador.
     *
     * @return Uma instância de Fada, Princesa ou Dragão.
     */
    public static Heroi criarPersonagem() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolhe o tipo de herói com que queres jogar:\n");
        System.out.println("[1] Fada");
        System.out.println("[2] Princesa");
        System.out.println("[3] Dragão");
        System.out.print("> ");
        int escolhaTipo = scanner.nextInt(); scanner.nextLine();

        TipoHeroi tipoHeroi;
        String nomeClasse;
        if (escolhaTipo == 1) {
            tipoHeroi = TipoHeroi.FADA;
            nomeClasse = "Fada";
        } else if (escolhaTipo == 2) {
            tipoHeroi = TipoHeroi.PRINCESA;
            nomeClasse = "Princesa";
        } else {
            tipoHeroi = TipoHeroi.DRAGAO;
            nomeClasse = "Dragão";
        }

        System.out.println("Escolheste jogar com o herói " + nomeClasse + "!");

        System.out.println("\nEscolhe a dificuldade:");
        System.out.println("[1] Fácil");
        System.out.println("[2] Difícil");
        System.out.print("> ");

        int dificuldade = scanner.nextInt(); scanner.nextLine();
        int pontosTotais;
        int ouroInicial;

        if (dificuldade == 1) {
            pontosTotais = 300;
            ouroInicial = 30;
        } else {
            pontosTotais = 220;
            ouroInicial = 20;
        }


        System.out.print("\nComo se chama a tua personagem? ");
        String nome = scanner.nextLine();

        System.out.println("\nTens " + pontosTotais + " pontos para distribuir.");
        System.out.println("Cada ponto de FORÇA custa 5 pontos. O resto vai para VIDA.");
        System.out.println("Podes escolher entre 0 e " + (pontosTotais / 5) + " pontos para FORÇA.");

        int forca;
        do {
            System.out.print("Quantos pontos queres para FORÇA? (0 a " + (pontosTotais / 5) + "): ");
            forca = scanner.nextInt(); scanner.nextLine();
        } while (forca * 5 > pontosTotais);

        int vida = pontosTotais - (forca * 5);

        System.out.println("\n*-*-*-*-*-*-* Resumo da personagem *-*-*-*-*-*-* ");
        System.out.println("Classe: " + nomeClasse);
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        System.out.println("Ouro inicial: " + ouroInicial);

        if (tipoHeroi == TipoHeroi.FADA) {
            return new Fada(nome, vida, forca, ouroInicial, tipoHeroi);
        } else if (tipoHeroi == TipoHeroi.PRINCESA) {
            return new Princesa(nome, vida, forca, ouroInicial, tipoHeroi);
        } else {
            return new Dragao(nome, vida, forca, ouroInicial, tipoHeroi);
        }
    }

    /**
     * Aplica dano ao herói, garantindo que a vida não fica negativa.
     * @param dano Quantidade de dano a receber.
     */
    public void receberDano(int dano) {
        this.setVidaAtual(this.getVidaAtual() - dano);
        if (this.getVidaAtual() < 0) {
            this.setVidaAtual(0);
        }
    }

    /**
     * Metodo abstrato de ataque que será implementado nas subclasses.
     *
     * @param inimigo O inimigo a ser atacado.
     */
    public abstract void atacar(NPC inimigo);

    /**
     * Exibe os detalhes da personagem.
     */
    public abstract void exibirDetalhes();
}
