package entidades;

import itens.ArmaPrincipal;

/**
 * Representa um herói do tipo Dragão.
 * Este herói sofre dano reduzido ao ser atacado primeiro e depois contra-ataca.
 */
public class Dragao extends Heroi {

    public Dragao(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca, ouroInicial, tipo);
    }

    /**
     * Executa o ataque do Dragão a um inimigo.
     * O inimigo ataca primeiro, causando 80% do dano habitual.
     * Em seguida, o Dragão ataca. Se o inimigo for derrotado,
     * o Dragão recebe ouro e sobe de nível.
     *
     * @param inimigo O inimigo a ser atacado.
     */
    @Override
    public void atacar(NPC inimigo) {
        double danoRecebido = inimigo.getForca() * 0.8;
        this.vidaAtual -= (int) Math.round(danoRecebido);
        System.out.println("Foste atacado primeiro! Sofreste " + Math.round(danoRecebido) + " de dano.");

        if (this.vidaAtual <= 0) {
            this.vidaAtual = 0;
            System.out.println("Foste derrotado antes de atacar.");
            return;
        }

        int dano = this.forca + this.getArmaPrincipal().getAtaque();
        inimigo.receberDano(dano);
        System.out.println("Atacaste com " + dano + " de dano.");

        if (!inimigo.estaViva()) {
            System.out.println("Derrotaste o inimigo e subiste de nível!");
            this.adicionarOuro(inimigo.getOuro());
            this.subirNivel();
        }
    }

    /**
     * Mostra os detalhes do Dragão na consola:
     * nome, vida, força e ouro atual.
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Dragão: " + nome + ", Vida: " + vidaAtual + "/" + vidaMax
                + ", Força: " + forca + ", Ouro: " + getOuro());
    }
}
