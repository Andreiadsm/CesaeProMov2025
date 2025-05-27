package Ex04;

public class Ex04 {
    public static void main(String[] args) {

        Circulo redondo = new Circulo("Amarelo", 5.9);

        System.out.println("Perimetro: "+redondo.calcularPerimetro(2* 3.14 * 5.9));

        Circulo redondoMaior = new Circulo("Azul", 10.2);

        System.out.println("Área: "+ redondo.calcularArea(3.14* 10.2 * 10.2));
    }
}
