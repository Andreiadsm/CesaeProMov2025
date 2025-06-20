public class Elefante extends Animal implements Terrestre{
    private double comprimentoTromba;

    public Elefante(String nome, int idade, String cor, double peso, double comprimentoTromba) {
        super(nome, idade, cor, peso);
        this.comprimentoTromba = comprimentoTromba;
    }

    public void abanarTromba(){
        System.out.println("O elefante está na brincadeira");
    }

    @Override
    public void andar() {
        System.out.println("O elefante está a andar");
    }

    @Override
    public void saltar() {
        System.out.println("O elefante dá saltos muito pequenos");
    }
}
