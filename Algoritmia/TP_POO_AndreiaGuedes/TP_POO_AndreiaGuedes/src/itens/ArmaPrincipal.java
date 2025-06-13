package itens;

import entidades.TipoHeroi;
import java.util.ArrayList;

/**
 * Representa uma arma principal utilizável por heróis.
 * Contém atributos de ataque normal e ataque especial,
 * apenas pode ser usada por heróis permitidos.
 */
public class ArmaPrincipal extends ItemHeroi {
    private final int ataque;
    private final int ataqueEspecial;

    /**
     * Construtor da arma principal.
     *
     * @param nome Nome da arma
     * @param preco Preço em moedas de ouro
     * @param ataque Valor de ataque normal
     * @param ataqueEspecial Valor de ataque especial
     * @param heroisPermitidos Lista de tipos de herói que podem usar esta arma
     */
    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial, ArrayList<TipoHeroi> heroisPermitidos) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;

        for (TipoHeroi tipo : heroisPermitidos) {
            this.adicionarHeroiPermitido(tipo);
        }
    }
    /**
     * Obtém o valor do ataque normal da arma.
     * @return Valor de ataque normal.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtém o valor do ataque especial da arma.
     * @return Valor de ataque especial.
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    /**
     * Mostra os detalhes da arma principal na consola,
     * incluindo nome, preço, ataque normal, ataque especial
     * e heróis que a podem usar.
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Arma Principal: " + nome);
        System.out.println("Preço: " + preco + " moedas de ouro");
        System.out.println("Ataque: " + ataque);
        System.out.println("Ataque Especial: " + ataqueEspecial);
        System.out.print("Pode ser usada por: ");
        for (TipoHeroi tipo : heroisPermitidos) {
            System.out.print(tipo + " ");
        }
        System.out.println("\n");
    }
}
