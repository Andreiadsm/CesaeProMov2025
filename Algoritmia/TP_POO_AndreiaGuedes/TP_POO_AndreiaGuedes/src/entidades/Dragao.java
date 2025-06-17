package entidades;

import itens.Consumivel;

/**
 * Representa um herói do tipo Dragão.
 * Este herói sofre dano reduzido ao ser atacado primeiro e depois contra-ataca.
 */
public class Dragao extends Heroi {

    public Dragao(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca, ouroInicial, tipo);
    }

    @Override
    public void atacar(NPC inimigo) {
        double danoRecebido = inimigo.getForca() * 0.8;
        int novaVida = getVidaAtual() - (int) Math.round(danoRecebido);
        setVidaAtual(Math.max(novaVida, 0));  // garante que não vai abaixo de 0

        System.out.println("Foste atacado primeiro! Sofreste " + Math.round(danoRecebido) + " de dano.");

        if (getVidaAtual() <= 0) {
            System.out.println("Foste derrotado antes de atacar.");
            return;
        }

        int dano = getForca() + getArmaPrincipal().getAtaque();
        inimigo.receberDano(dano);
        System.out.println("Atacaste com " + dano + " de dano.");

        if (!inimigo.estaViva()) {
            System.out.println("Derrotaste o inimigo e subiste de nível!");
            adicionarOuro(inimigo.getOuro());
            subirNivel();
        }
    }

    /**
     * Mostra os detalhes do Dragão (nome, vida, força, ouro e inventario).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Dragão: " + getNome()
                + ", Vida: " + getVidaAtual() + "/" + getVidaMax()
                + ", Força: " + getForca()
                + ", Ouro: " + getOuro());

        if (getInventario().isEmpty()) {
            System.out.println("Inventário: (vazio)");
        } else {
            System.out.println("Inventário:");
            for (Consumivel item : getInventario()) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}