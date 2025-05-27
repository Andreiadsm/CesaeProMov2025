package Ex05;

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

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public void ligar() {
        System.out.println("O " +marca + " " + modelo + " " + cor + " está ligado..." );
    }
}


