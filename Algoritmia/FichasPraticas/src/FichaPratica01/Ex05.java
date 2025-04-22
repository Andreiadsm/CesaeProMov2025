package FichaPratica01;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        double num1, num2, num3, mediaAritmetica, mediaPonderada;

        //Ler valores
        System.out.print("Insera o valor 1: ");
        num1 = input.nextDouble();

        System.out.print("Insera o valor 2: ");
        num2 = input.nextDouble();

        System.out.print("Insera o valor 3: ");
        num3 = input.nextDouble();

        //Calcular e apresentar media aritmetica
        mediaAritmetica= (num1 + num2 + num3) / 3;
        System.out.println("Média aritmética: " + mediaAritmetica);

        //Calcular e apresentar media ponderada
        mediaPonderada= (num1 * 0.2) + (num2* 0.3) + (num3 * 0.5);
        System.out.println("Média ponderada: " + mediaPonderada);

    }
}
