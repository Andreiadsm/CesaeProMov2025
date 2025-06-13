package entidades;

/**
 * Classe abstrata Entidade
 * Representa qualquer ser do jogo com nome, vida e força.
 * Pode ser um herói ou um inimigo (NPC).
 */
public abstract class Entidade {

    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;

    /**
     * Construtor da entidade.
     * Inicializa a vida atual igual à vida máxima.
     *
     * @param nome Nome da entidade
     * @param vidaMax Vida máxima
     * @param forca Força da entidade
     */
    public Entidade(String nome, int vidaMax, int forca) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaMax; // começa com a vida cheia
        this.forca = forca;
    }

    /**
     * Obtém o valor da força da entidade.
     *
     * @return A força atual da entidade.
     */
    public int getForca() {
        return forca;
    }

    /**
     * Obtém o nome da entidade.
     *
     * @return O nome atual da entidade.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para a entidade.
     *
     * @param nome O novo nome a atribuir.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a vida máxima da entidade.
     *
     * @return A vida máxima.
     */
    public int getVidaMax() {
        return vidaMax;
    }

    /**
     * Define um novo valor para a vida máxima da entidade.
     *
     * @param vidaMax O novo valor da vida máxima.
     */
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    /**
     * Obtém a vida atual da entidade.
     *
     * @return O valor atual de vida.
     */
    public int getVidaAtual() {
        return vidaAtual;
    }

    /**
     * Define um novo valor para a vida atual.
     *
     * @param vidaAtual O novo valor de vida atual.
     */
    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    /**
     * Define um novo valor para a força da entidade.
     *
     * @param forca O novo valor de força.
     */
    public void setForca(int forca) {
        this.forca = forca;
    }


    /**
     * Metodo utilitário para verificar se a entidade está viva.
     */
    public boolean estaViva() {
        return this.vidaAtual > 0;
    }

    /**
     * Aplica dano à entidade.
     *
     * @param dano valor de dano a subtrair à vida
     */
    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }
    /**
     * Mostra os detalhes atuais da entidade na consola:
     * nome, vida atual/máxima e força.
     */
    public void exibirDetalhes() {
        System.out.println(" Detalhes da Entidade:");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vidaAtual + "/" + this.vidaMax);
        System.out.println("Força: " + this.forca);
    }
}
