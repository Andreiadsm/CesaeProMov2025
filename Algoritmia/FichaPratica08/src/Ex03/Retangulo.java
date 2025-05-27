package Ex03;

public class Retangulo {
    private String cor;
    private double largura;
    private double altura;

    public Retangulo(String cor, double largura, double altura) {
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularPerimetro () {
        return this.largura + this.altura + this.largura + this.altura;
    }

    public double calcularArea() {
        return this.altura * return.this.largura;
    }
}
