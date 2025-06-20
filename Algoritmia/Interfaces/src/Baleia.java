public class Baleia extends Animal implements Aquatico{

    public Baleia(String nome, int idade, String cor, double peso) {
        super(nome, idade, cor, peso);
    }

    public void respirarNaSuperficie(){
        System.out.println("BSHHHHHHHHHHHHHHHHHHHHHHHHHHH");
    }

    @Override
    public void nadar() {
        System.out.println("A baleia está a nadar");
    }

    @Override
    public void mergulhar() {
        System.out.println("A baleia mergulha 10 metros");
    }
}
