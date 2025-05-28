package Ex03;

public class Retangulo {
    private String cor;
    private double largura;
    private double altura;

    /**
     * método construtor para retangulo
     * @param cor cor do retangulo
     * @param largura altura do retangulo (m)
     * @param altura largura do retangulo (m)
     */
    public Retangulo(String cor, double largura, double altura) {
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }
//getPerimetro tb é possivel - é um atributo calculado
    public double calcularPerimetro () {
        return this.largura + this.altura + this.largura + this.altura;
    }
//getArea - é um atributo calculado por isso nao inserimos na class
    public double calcularArea() {
        return this.altura * this.largura;
    }
}
