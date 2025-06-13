package itens;

import entidades.Heroi;
import entidades.NPC;
import entidades.TipoHeroi;

/**
 * Representa uma poção utilizável por heróis, que pode restaurar vida
 * e aumentar temporariamente a força. A sua eficácia depende da compatibilidade
 * com o tipo de herói.
 */
public class Pocao extends Consumivel {
    private int vidaACurar;
    private int aumentoForca;

    public Pocao(String nome, int preco, int vidaACurar, int aumentoForca, java.util.ArrayList<TipoHeroi> heroisPermitidos) {
        super(nome, preco);
        this.vidaACurar = vidaACurar;
        this.aumentoForca = aumentoForca;

        for (TipoHeroi tipo : heroisPermitidos) {
            this.adicionarHeroiPermitido(tipo);
        }
    }

    public int getVidaACurar() {
        return vidaACurar;
    }

    public int getAumentoForca() {
        return aumentoForca;
    }

    /**
     * Aplica os efeitos da poção ao herói, se o tipo for compatível.
     * Restaura a vida (sem ultrapassar o máximo) e aumenta a força.
     *
     * @param heroi O herói que vai usar a poção
     * @param inimigo Ignorado neste contexto (mas essencial pela assinatura da superclasse)
     */
    @Override
    public void usar(Heroi heroi, NPC inimigo) {
        if (!heroisPermitidos.contains(heroi.getTipoHeroi())) {
            System.out.println("Esta poção não é compatível com o teu tipo de herói.");
            return;
        }

        int vidaAntes = heroi.getVidaAtual();
        int novaVida = Math.min(heroi.getVidaMax(), vidaAntes + vidaACurar);
        heroi.setVidaAtual(novaVida);
        heroi.setForca(heroi.getForca() + aumentoForca);

        System.out.println("Usaste a poção: " + getNome());
        System.out.println("Recuperaste " + (novaVida - vidaAntes) + " de vida.");
        System.out.println("A tua força aumentou em " + aumentoForca + ".");
    }

    public void usar(Heroi heroi) {
        return;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Poção: " + nome);
        System.out.println("Preço: " + preco + " moedas de ouro");
        System.out.println("Cura: " + vidaACurar);
        System.out.println("Bónus de força: " + aumentoForca);
        System.out.print("Pode ser usada por: ");
        for (TipoHeroi tipo : heroisPermitidos) {
            System.out.print(tipo + " ");
        }
        System.out.println("\n");
    }
}
