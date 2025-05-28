package Ex01;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    public Carro(String marca, String modelo, String cor, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public void ligar() {
        System.out.println("O " +this.marca + " " + this.modelo + " " + this.cor + " está ligado..." );
    }
}


