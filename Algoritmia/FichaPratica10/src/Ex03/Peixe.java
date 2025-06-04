package Ex03;

public class Peixe {
    private String especie;
    private double pesoKg;
    private double preco;

    public Peixe(String especie, double peso, double precoKg) {
        this.especie = especie;
        this.pesoKg = peso;
        this.preco = precoKg;
    }

    public String getEspecie() {
        return especie;
    }

    public double getValorTotal() {
        return pesoKg * preco;
    }

    public double getPeso() {
        return pesoKg;
    }

    public void exibirDetalhes() {
        System.out.println("Peixe: " + especie + " | Peso: " + pesoKg + " kg | Preço/Kg: " + preco + " €");
    }

}



