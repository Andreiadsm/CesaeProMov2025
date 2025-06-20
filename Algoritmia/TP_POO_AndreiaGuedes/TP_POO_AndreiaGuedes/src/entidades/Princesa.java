package entidades;

import itens.Consumivel;

/**
 * Classe Princesa.
 * Representa uma heroína do tipo Princesa, com ataque reforçado e elegância em batalha.
 */
public class Princesa extends Heroi {

    public Princesa(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca, ouroInicial, tipo);
    }

    /**
     * Ataca um inimigo.
     * A princesa sofre 90% da força do inimigo antes de atacar.
     * O dano causado é 120% da força base + ataque da arma.
     *
     * @param inimigo Inimigo a atacar.
     */
    @Override
    public void atacar(NPC inimigo) {
        double danoRecebido = inimigo.getForca() * 0.9;
        this.vidaAtual -= (int) Math.round(danoRecebido);
        System.out.println("Sofreste " + Math.round(danoRecebido) + " de dano ao enfrentares o inimigo.");

        if (this.vidaAtual <= 0) {
            this.vidaAtual = 0;
            System.out.println("Foste abatida antes de poderes reagir.");
            return;
        }

        int dano = (int) Math.round(this.forca * 1.2) + this.getArmaPrincipal().getAtaque();
        inimigo.receberDano(dano);
        System.out.println("Atacaste com bravura! Causaste " + dano + " de dano.");

        if (!inimigo.estaViva()) {
            System.out.println("Vitória! Derrotaste o inimigo com elegância.");
            this.adicionarOuro(inimigo.getOuro());
            this.subirNivel();
        }
    }

    /**
     * Mostra os detalhes da princesa (nome, vida, força, ouro e inventario).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Princesa: " + getNome()
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
