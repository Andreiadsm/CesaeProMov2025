package itens;

import entidades.Heroi;
import entidades.NPC;
import entidades.TipoHeroi;

import java.util.ArrayList;

/**
 * Subclasse de Consumivel, pode ser usado para causar dano instantâneo no combate.
 * Apenas certos tipos de heróis podem utilizá-lo, conforme definido no construtor.
 */
public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo, ArrayList<TipoHeroi> heroisPermitidos) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;

        // Adiciona todos os heróis permitidos recebidos
        for (TipoHeroi tipo : heroisPermitidos) {
            this.adicionarHeroiPermitido(tipo);
        }
    }

    /**
     * Retorna o valor do ataque instantâneo deste consumível.
     *
     * @return Valor do ataque instantâneo.
     */
    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    /**
     * Aplica os efeitos do consumível de combate ao inimigo.
     *
     * @param heroi   Herói que usa o item
     * @param inimigo Inimigo que sofre o dano
     */

    public void usar(Heroi heroi, NPC inimigo) {
        inimigo.receberDano(ataqueInstantaneo);
        System.out.println("Usaste " + getNome() + " e causaste " + ataqueInstantaneo + " de dano!");
    }

    public void usar(Heroi heroi) {
        return;
    }

    /**
     * Exibe todos os detalhes do consumível de combate no console.
     * Mostra nome, preço, ataque instantâneo e os heróis que podem usá-lo.
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Consumível de Combate: " + getNome());
        System.out.println("Preço: " + getPreco() + " moedas de ouro");
        System.out.println("Ataque instantâneo: " + ataqueInstantaneo);
        System.out.print("Pode ser usado por: ");
        for (TipoHeroi tipo : getHeroisPermitidos()) {
            if (tipo == TipoHeroi.FADA) {
                System.out.print("Fada ");
            } else if (tipo == TipoHeroi.PRINCESA) {
                System.out.print("Princesa ");
            } else if (tipo == TipoHeroi.DRAGAO) {
                System.out.print("Dragão ");
            }
        }
        System.out.println();
    }
}
