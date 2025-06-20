public class Macaco extends Animal implements Terrestre{

    public Macaco(String nome, int idade, String cor, double peso) {
        super(nome, idade, cor, peso);
    }

    public void subirArvore(){
        System.out.println("O macaco está a subir à árvore!");
    }

    @Override
    public void andar() {
        System.out.println("O macaco anda com as mãos no chão");
    }

    @Override
    public void saltar() {
        System.out.println("O macaco salta muito");
    }
}
