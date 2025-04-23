package FichaPratica02;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //ASSUMIMOS QUE NUM2 NUM1 PODEM SER DIFERENTES

        //Declarar variáveis
        int num1, num2;

        // Ler números
        System.out.print("Insira o número: ");
        num1 = input.nextInt();

        System.out.print("Insira o número: ");
        num2 = input.nextInt();

        //Imprimir o maior nº
        if (num1 > num2) {
            System.out.println("Maior: " + num1);
        }
        else {
            System.out.println("Maior: " + num2);
        }
    }
}
