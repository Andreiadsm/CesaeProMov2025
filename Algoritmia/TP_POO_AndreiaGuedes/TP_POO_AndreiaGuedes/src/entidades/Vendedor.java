package entidades;

import itens.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um vendedor no jogo.
 * O vendedor oferece itens que podem ser comprados por heróis,
 * desde que sejam compatíveis com o tipo do herói.
 */
public class Vendedor {

    private ArrayList<ItemHeroi> loja;

    /**
     * Construtor da classe Vendedor.
     * Inicializa a loja como uma lista vazia.
     */
    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Adiciona um item à loja.
     *
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(ItemHeroi item) {
        loja.add(item);
    }

    /**
     * Retorna a lista de itens disponíveis na loja.
     *
     * @return Lista de itens da loja.
     */
    public ArrayList<ItemHeroi> getLoja() {
        return loja;
    }

    /**
     * Cria um vendedor com um conjunto inicial de itens disponíveis para todos os tipos de heróis.
     *
     * @return Instância de Vendedor com itens pré-definidos.
     */
    public static Vendedor criarVendedorInicial() {
        Vendedor vendedor = new Vendedor();

        ArrayList<TipoHeroi> todos = new ArrayList<>();
        todos.add(TipoHeroi.FADA);
        todos.add(TipoHeroi.PRINCESA);
        todos.add(TipoHeroi.DRAGAO);

        vendedor.adicionarItem(new Pocao("Poção Universal", 15, 25, 0, todos));
        vendedor.adicionarItem(new Pocao("Poção de Vida Média", 30, 50, 0, todos));
        vendedor.adicionarItem(new Pocao("Elixir de Força", 25, 0, 2, todos));
        vendedor.adicionarItem(new Pocao("Poção de Força Grande", 35, 0, 5, todos));

        vendedor.adicionarItem(new ConsumivelCombate("Bomba", 20, 12, todos));
        vendedor.adicionarItem(new ConsumivelCombate("Granada", 18, 10, todos));

        ArrayList<TipoHeroi> soFada = new ArrayList<>();
        soFada.add(TipoHeroi.FADA);
        vendedor.adicionarItem(new ArmaPrincipal("Varinha Brilhante", 30, 20, 35, soFada));

        ArrayList<TipoHeroi> soPrincesa = new ArrayList<>();
        soPrincesa.add(TipoHeroi.PRINCESA);
        vendedor.adicionarItem(new ArmaPrincipal("Espada Real", 35, 25, 40, soPrincesa));

        ArrayList<TipoHeroi> soDragao = new ArrayList<>();
        soDragao.add(TipoHeroi.DRAGAO);
        vendedor.adicionarItem(new ArmaPrincipal("Garras Flamejantes", 40, 30, 45, soDragao));

        vendedor.adicionarItem(new Pocao("Poção de Energia", 20, 15, 0, todos));
        vendedor.adicionarItem(new ConsumivelCombate("Raio Congelante", 22, 14, todos));
        vendedor.adicionarItem(new Pocao("Elixir Supremo", 45, 60, 4, todos));

        return vendedor;
    }

    /**
     * Inicia o processo de venda de itens ao herói.
     * Filtra os itens disponíveis com base no tipo do herói, apresenta opções e realiza a compra.
     *
     * @param heroi Herói que quer comprar um item.
     */
    public void vender(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        // Filtra apenas itens compatíveis com o tipo do herói
        ArrayList<ItemHeroi> disponiveis = new ArrayList<>();
        for (ItemHeroi item : loja) {
            for (TipoHeroi tipo : item.getHeroisPermitidos()) {
                if (tipo.equals(heroi.getTipoHeroi())) {
                    disponiveis.add(item);
                    return;
                }
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum item disponível para o teu tipo de herói.");
            return;
        }

        // Mostrar até 5 itens
        int limite = Math.min(5, disponiveis.size());
        System.out.println("\nLoja da Vendedora - Itens compatíveis:");
        for (int i = 0; i < limite; i++) {
            System.out.print("[" + i + "] ");
            disponiveis.get(i).mostrarDetalhes();
        }

        System.out.println("Escolhe o número do item que queres comprar ou -1 para sair:");
        System.out.print("> ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == -1) {
            System.out.println("Saíste da loja.");
            return;
        }

        if (escolha < 0 || escolha >= limite) {
            System.out.println("Opção inválida.");
            return;
        }

        ItemHeroi item = disponiveis.get(escolha);

        if (heroi.getOuro() < item.getPreco()) {
            System.out.println("Não tens ouro suficiente.");
            return;
        }

        heroi.setOuro(heroi.getOuro() - item.getPreco());

        if (item instanceof ArmaPrincipal) {
            heroi.setArmaPrincipal((ArmaPrincipal) item);
            System.out.println("Nova arma equipada!");
        } else if (item instanceof Consumivel) {
            heroi.adicionarConsumivel((Consumivel) item);
            System.out.println("Consumível adicionado ao inventário.");
        }

        System.out.println("Compra feita com sucesso! Ouro restante: " + heroi.getOuro());
    }
}
