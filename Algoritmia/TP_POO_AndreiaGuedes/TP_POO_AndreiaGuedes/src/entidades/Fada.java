package entidades;

import itens.ArmaPrincipal;

/**
 * Representa um herói do tipo Fada.
 * Esta fada mágica ataca com feitiços encantados e tem oportunidade
 * de se curar após atacar.
 */
public class Fada extends Heroi {

    public Fada(String nome, int vida, int forca, int ouroInicial, TipoHeroi tipo) {
        super(nome, vida, forca, ouroInicial, tipo);
    }

    /**
     * Executa o ataque da fada a um inimigo.
     * O inimigo ataca primeiro, causando 60% da sua força em dano.
     * A fada contra-ataca com a sua força e a da arma principal.
     * Existe a possibilidade de 30% de recuperar vida após o ataque.
     *
     * @param inimigo O inimigo a enfrentar.
     */
    @Override
    public void atacar(NPC inimigo) {
        double danoRecebido = inimigo.getForca() * 0.6;
        this.vidaAtual -= (int) Math.round(danoRecebido); // uso direto do atributo
        System.out.println(" Sofreste " + Math.round(danoRecebido) + " de dano ao tentares esquivar com magia.");

        if (this.vidaAtual <= 0) {
            this.vidaAtual = 0;
            System.out.println("Foste derrotada antes de lançar o feitiço.");
            return;
        }

        int dano = this.forca + this.getArmaPrincipal().getAtaque(); // uso direto da força
        inimigo.receberDano(dano);
        System.out.println("Lançaste um feitiço e causaste " + dano + " de dano!");

        if (Math.random() < 0.3) {
            int cura = 10;
            this.vidaAtual = Math.min(this.vidaMax, this.vidaAtual + cura);
            System.out.println("Recuperaste " + cura + " de vida com energia da floresta!");
        }

        if (!inimigo.estaViva()) {
            System.out.println("Derrotaste o inimigo com a tua magia!");
            this.adicionarOuro(inimigo.getOuro());
            this.subirNivel();
        }
    }

    /**
     * Exibe os detalhes atuais da fada.
     * Inclui nome, vida, força e ouro.
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Fada: " + nome + ", Vida: " + vidaAtual + "/" + vidaMax
                + ", Força: " + forca + ", Ouro: " + getOuro());
    }
}
