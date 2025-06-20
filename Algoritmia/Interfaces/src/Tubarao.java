public class Tubarao extends Animal implements Aquatico{

    private boolean agressivo;

    public Tubarao(String nome, int idade, String cor, double peso, boolean agressivo) {
        super(nome, idade, cor, peso);
        this.agressivo = agressivo;
    }

    @Override
    public void nadar() {
        System.out.println("O tubarão está a nadar");
    }

    @Override
    public void mergulhar() {
        System.out.println("O tubarão mergulha bem devagar");
    }
}
