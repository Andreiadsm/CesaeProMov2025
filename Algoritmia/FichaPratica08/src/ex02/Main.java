package ex02;

public class Main {
    public static void main(String[] args) {

        Edificio ed01 = new Edificio("Edifício Espetacular", "Rua das Flores", "Porto", "Amarelo", 10, false);

        System.out.println("********** Especificações do " + ed01.getNome() + " **********");
        System.out.println("Rua: " + ed01.getRua());
        System.out.println(ed01.getCidade() + " | Cor: " + ed01.getCorFachada());
        System.out.println("Número de Andares: " + ed01.getNumAndares());
        if (ed01.getGaragem()) {
            System.out.println("Tem Garagem");
        } else {
            System.out.println("Não tem garagem");
        }

        ed01.setCorFachada("Azul");

        System.out.println("********** Especificações do " + ed01.getNome() + " **********");
        System.out.println("Rua: " + ed01.getRua());
        System.out.println(ed01.getCidade() + " | Cor: " + ed01.getCorFachada());
        System.out.println("Número de Andares: " + ed01.getNumAndares());
        if (ed01.getGaragem()) {
            System.out.println("Tem Garagem");
        } else {
            System.out.println("Não tem garagem");
        }

    }
}
