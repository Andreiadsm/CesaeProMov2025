package Ex03;

public class Marisco {
    private String especie;
    private int peso;
    private double precoKg;

    public Marisco(String especie, int peso, double precoKg) {
        this.especie = especie;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    public String getEspecie() {
        return especie;
    }

    public int getPeso() {
        return peso;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void exibirDetalhes() {
        System.out.println(this.especie + " | " + this.peso + " | ");
    }
}
