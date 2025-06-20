public class Crocodilo extends Animal implements Terrestre, Aquatico {
    private double comprimentoCauda;
    private double forcaMordida;

    public Crocodilo(String nome, int idade, String cor, double peso, double comprimentoCauda, double forcaMordida) {
        super(nome, idade, cor, peso);
        this.comprimentoCauda = comprimentoCauda;
        this.forcaMordida = forcaMordida;
    }

    @Override
    public void nadar() {

    }

    @Override
    public void mergulhar() {

    }

    @Override
    public void andar() {

    }

    @Override
    public void saltar() {

    }
}
