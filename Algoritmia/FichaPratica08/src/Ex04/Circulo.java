package Ex04;

public class Circulo {
    private String cor;
    private double raio;

    public Circulo(String cor, double raio) {
        this.cor = cor;
        this.raio = raio;
    }

    public double getRaio() {
        return this.raio;
    }

    public String getCor() {
        return this.cor;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

