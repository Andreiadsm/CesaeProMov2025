package entidades;

/**
 * Classe NPC (inimigo não jogável).
 * Representa um inimigo que pode atacar o herói.
 */
public class NPC extends Entidade {

    private int ouro;
    public NPC(String nome, int vidaMax, int forca, int ouro) {
        super(nome, vidaMax, forca);
        this.ouro = ouro;
    }

    /**
     * Obtém a quantidade de ouro que o NPC possui.
     *
     * @return Ouro do NPC.
     */
    public int getOuro() {
        return this.ouro;
    }

    /**
     * Define a quantidade de ouro do NPC.
     *
     * @param ouro Novo valor de ouro.
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Ataca um herói, aplicando dano igual à força do NPC.
     *
     * @param heroi Herói a ser atacado.
     */
    public void atacar(Heroi heroi) {
        int dano = this.getForca();
        heroi.receberDano(dano);
        System.out.println(this.getNome() + " atacou e causou " + dano + " de dano.");
    }

    /**
     * Mostra os detalhes do NPC (nome, vida, força, ouro).
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("INIMIGO: " + this.getNome());
        System.out.println("Vida: " + this.getVidaAtual() + "/" + this.getVidaMax());
        System.out.println("Força: " + this.getForca());
        System.out.println("Ouro transportado: " + this.ouro);
    }
}
