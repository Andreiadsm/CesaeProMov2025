package Ex01;

public class Main {
    public static void main (String[] args) {
        Pessoa pessoa1 = new Pessoa ( "Vitor", 25, 1.7);
        Pessoa pessoa2 = new Pessoa ( "Joaquim", 40, 1.8);
        Pessoa pessoa3 = new Pessoa ("José",  30, 1.65);

        System.out.println(pessoa3.getIdade());
        pessoa3.setIdade(50);
        System.out.println(pessoa3.getIdade());
    }
}
