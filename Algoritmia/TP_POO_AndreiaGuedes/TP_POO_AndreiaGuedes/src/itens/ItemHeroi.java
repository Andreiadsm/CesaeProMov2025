package itens;

import entidades.TipoHeroi;


import java.util.ArrayList;
/**
 * Classe abstrata que representa um item utilizável por heróis.
 * Pode ser uma arma ou consumível. Contém nome, preço e tipos de heróis compatíveis.
 */
public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<TipoHeroi> heroisPermitidos;


    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = new ArrayList<TipoHeroi>();
    }
    /**
     * Retorna o nome do item.
     *
     * @return Nome do item.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Retorna o preço do item.
     *
     * @return Preço em ouro.
     */
    public int getPreco() {
        return preco;
    }
    /**
     * Retorna a lista de tipos de heróis que podem usar este item.
     *
     * @return Lista de tipos de heróis.
     */
    public ArrayList<TipoHeroi> getHeroisPermitidos() {
        return heroisPermitidos;
    }
    /**
     * Adiciona um tipo de herói à lista de compatibilidade do item.
     *
     * @param tipoHeroi Tipo de herói permitido.
     */
    public void adicionarHeroiPermitido(TipoHeroi tipoHeroi) {
        heroisPermitidos.add(tipoHeroi);
    }
    /**
     * Exibe os detalhes do item no terminal.
     * Implementado pelas subclasses.
     */
    public abstract void mostrarDetalhes();
}
