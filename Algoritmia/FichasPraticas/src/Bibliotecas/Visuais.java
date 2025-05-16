package Bibliotecas;

public class Visuais {

    public static void separador(){
        System.out.println("_______________________________________________________________________");
    }

    public static void limparConsola(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void fazerBarulho(String animal){

        switch (animal){
            case "Cão":
                System.out.println("Au au au ");
                break;

            case "Gato":
                System.out.println("Miau!");
                break;

            case "Peixe":
                System.out.println("Glub glub");
                break;

            default:
                System.out.println("Barulho desconhecido...");
        }
    }

    public  static void imprimirAsteriscos(int quantidade) {

        for (int i = 0; i< quantidade; i++) {
            System.out.print("*");
        }
    }
}
