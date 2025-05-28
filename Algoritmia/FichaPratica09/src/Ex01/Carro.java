package Ex01;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private int potenciaCv;
    private int cc;
    private TipoCombustivel combustivel;
    private double consumoL100km;

    public Carro(String marca, String modelo, String cor, int ano, int potenciaCv, int cc, TipoCombustivel combustivel, double consumoL100km) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.potenciaCv = potenciaCv;
        this.cc = cc;
        this.combustivel = combustivel;
        this.consumoL100km = consumoL100km;
    }

    public int getIdade() {
        return 2025 - this.ano;
    }
    public void ligar() {
        if (this.getIdade()>30 && this.combustivel.equals(TipoCombustivel.DIESEL)){
            System.out.println("Deita fumo... custa a pegar... O carro está ligado! \n Vrum-vrum-vrum");
        } else{
            System.out.println("Custa a pegar... O carro está ligado! \n Vrum-vrum-vrum!");
        }
        if (this.getIdade()<=30 && this.potenciaCv<250){
            System.out.println("O carro está ligado. Vruuummmmmmmmmm");
        } else {
            System.out.println("O carro está ligado. VRUMMMMMMMMMMMMM");
        }
    }

    public Carro corrida(Carro adversario) {

        if (this.potenciaCv > adversario.potenciaCv) {
            // Ganha o meu carro por cv
            return this;
        } else {

            if (this.potenciaCv < adversario.potenciaCv) {
                // Ganha o adversario por cv
                return adversario;
            } else {
                // Empate de cv

                if (this.cc > adversario.cc) {
                    // Ganha o meu carro por cc
                    return this;
                } else {

                    if (this.cc < adversario.cc) {
                        // Ganha o adversario por cc
                        return adversario;
                    } else {
                        // Empate de cc

                        if (this.getIdade() < adversario.getIdade()) {
                            // Ganha o meu carro por idade
                            return this;
                        } else {

                            if (this.getIdade() > adversario.getIdade()) {
                                // Ganha o adversario por idade
                                return adversario;
                            } else {
                                // Empate
                                return null;
                            }

                        }
                    }

                }

            }

        }
    }

    public void exibirDetalhes() {
        System.out.println(this.marca + " " + this.modelo + " | " + this.ano + " | " + this.cor);
    }
}


