package jogo;

import entidades.NPC;
import entidades.Vendedor;
import java.util.ArrayList;

/**
 * Representa uma sala no labirinto do jogo.
 * Cada sala pode conter inimigos, armadilhas, ouro, e estar ligada a outras salas.
 * Algumas salas podem também ter vendedores.
 */
public class Sala {
    private String nome;
    private ArrayList<Sala> ligacoes;
    private ArrayList<NPC> inimigos;
    private Vendedor vendedor;
    private boolean temVendedor;
    private int ouroNaSala;
    private int danoArmadilha;

    /**
     * Construtor da sala.
     *
     * @param nome Nome identificador da sala.
     */
    public Sala(String nome) {
        this.nome = nome;
        this.ligacoes = new ArrayList<Sala>();
        this.inimigos = new ArrayList<NPC>();
        this.vendedor = new Vendedor();
        this.temVendedor = false;
        this.ouroNaSala = 0;
        this.danoArmadilha = 0;
    }

    /** @return O nome da sala.
     */
    public String getNome() {
        return nome; }

    /** @return Lista de salas ligadas a esta.
     */
    public ArrayList<Sala> getLigacoes() {
        return ligacoes; }

    /** @return Lista de inimigos presentes na sala.
     */
    public ArrayList<NPC> getInimigos() {
        return inimigos; }

    /** @return Dano causado por uma armadilha presente na sala.
     */
    public int getDanoArmadilha() {
        return danoArmadilha; }

    /** @return O vendedor presente na sala, se existir.
     */
    public Vendedor getVendedor() {
        return vendedor; }

    /** @return true se a sala tiver vendedor, false caso contrário.
     */
    public boolean temVendedor() {
        return temVendedor; }

    /** @return Quantidade de ouro disponível na sala.
     */
    public int getOuroNaSala() {
        return ouroNaSala; }

    /**
     * Define a quantidade de ouro presente na sala.
     *
     * @param ouroNaSala Quantidade de ouro.
     */
    public void setOuroNaSala(int ouroNaSala) {
        this.ouroNaSala = ouroNaSala; }

    /**
     * Liga esta sala a outra.
     *
     * @param sala Sala a adicionar como ligação.
     */
    public void adicionarLigacao(Sala sala) {
        this.ligacoes.add(sala); }

    /**
     * Adiciona um inimigo à sala.
     *
     * @param inimigo NPC inimigo a ser adicionado.
     */
    public void adicionarInimigo(NPC inimigo) {
        this.inimigos.add(inimigo); }

    /**
     * Define o dano causado por uma armadilha nesta sala.
     *
     * @param danoArmadilha Valor do dano.
     */
    public void setDanoArmadilha(int danoArmadilha) {
        this.danoArmadilha = danoArmadilha; }

    /**
     * Define um vendedor para a sala e marca que a sala tem vendedor.
     *
     * @param vendedor Instância de Vendedor.
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.temVendedor = true;
    }
}
