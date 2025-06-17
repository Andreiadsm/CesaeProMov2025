package entidades;

import itens.Consumivel;

/**
 * Representa um herói do tipo Fada.
 * Esta fada mágica ataca com feitiços encantados e tem oportunidade
 * de se curar após atacar.
 */
public class Fada extends Heroi {

    public Fada(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca, ouroInicial, tipo);
    }

    @Override
    public void atacar(NPC inimigo) {
        double danoRecebido = inimigo.getForca() * 0.6;
        int novaVida = getVidaAtual() - (int) Math.round(danoRecebido);
        setVidaAtual(Math.max(novaVida, 0));

        System.out.println("Sofreste " + Math.round(danoRecebido) + " de dano ao tentares esquivar com magia.");

        if (getVidaAtual() <= 0) {
            System.out.println("Foste derrotada antes de lançar o feitiço.");
            return;
        }

        int dano = getForca() + getArmaPrincipal().getAtaque();
        inimigo.receberDano(dano);
        System.out.println("Lançaste um feitiço e causaste " + dano + " de dano!");

        if (Math.random() < 0.3) {
            int cura = 10;
            setVidaAtual(Math.min(getVidaAtual() + cura, getVidaMax()));
            System.out.println("Recuperaste " + cura + " de vida com energia da floresta!");
        }

        if (!inimigo.estaViva()) {
            System.out.println("Derrotaste o inimigo com a tua magia!");
            adicionarOuro(inimigo.getOuro());
            subirNivel();
        }
    }
    /**
     * Mostra os detalhes da Fada (nome, vida, força, ouro e inventario).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Fada: " + getNome()
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
