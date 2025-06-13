package itens;

import entidades.Heroi;
import entidades.NPC;

/**
 * Classe abstrata que representa um item consumível no RPG.
 * Tipo especial de ItemHeroi que pode ser usado uma vez.
 * Como é abstrata, não pode ser instanciada diretamente — serve de base para outros consumíveis.
 */
public abstract class Consumivel extends ItemHeroi {
    public Consumivel(String nome, int preco) {
        super(nome, preco);
    }

    /**
     * Método abstrato que define o efeito do consumível quando usado por um herói.
     * Cada subclasse (como uma poção) implementa este comportamento específico.
     */
    public abstract void usar(Heroi heroi, NPC inimigo);

}
