package FichaPratica01;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Declarar variáveis
        double raio, circunferencia, area;

        //Ler raio
        System.out.print("Insira o raio: ");
        raio= input.nextDouble();

        //Cacular e apresentar a circunferencia
        circunferencia= 2* 3.14 * raio;
        System.out.println("Circunferencia: " + circunferencia);


        //Calcular e apresentar a area
        area= 3.14 * raio * raio;
        System.out.println("área" + area);
    }
}
