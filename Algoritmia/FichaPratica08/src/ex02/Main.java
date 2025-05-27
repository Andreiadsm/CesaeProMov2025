package ex02;

public class Main {
    public static void main (String [] args) {
        Edificio edificio1 = new Edificio("Pereira", "rua quinta de Pereira","Vila Nova de Famalicão", "branco", 2, true);

        System.out.println(edificio1.getNome());
        System.out.println(edificio1.getRua());
        System.out.println(edificio1.getCidade());
        edificio1.setCorFachada("verde");
        System.out.println(edificio1.getNumAndares());
        System.out.println(edificio1.isGaragem());
    }
}
