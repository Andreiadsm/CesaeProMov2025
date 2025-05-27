package Ex04;

public class Main {
    public static void main(String[] args) {

        // a) Instanciar dois círculos
        Circulo c1 = new Circulo("Azul", 3.5);
        Circulo c2 = new Circulo("Vermelho", 5.0);

        // b) Verificar qual tem o maior raio e imprimir só os dados desse
        if (c1.getRaio() > c2.getRaio()) {
            System.out.println("Círculo maior:");
            System.out.println("Perímetro: " + c1.calcularPerimetro());
            System.out.println("Área: " + c1.calcularArea());
        } else {
            System.out.println("Círculo maior:");
            System.out.println("Perímetro: " + c2.calcularPerimetro());
            System.out.println("Área: " + c2.calcularArea());
        }
    }
}


