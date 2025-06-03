package Ex03;

public class Peixe {
    private String especie;
    private double peso;
    private double precoKg;

    public Peixe(String especie, double peso, double precoKg) {
        this.especie = especie;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    public String getEspecie() {
        return especie;
    }

    public double getValorTotal() {
        return peso * precoKg;
    }

    public double getPeso() {
        return peso;
    }

    public void exibirDetalhes() {
        System.out.println("Peixe: " + especie + " | Peso: " + peso + " kg | Preço/Kg: " + precoKg + " €");
    }

}



