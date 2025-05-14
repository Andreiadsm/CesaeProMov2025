package FichaPratica01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int numero1, numero2, soma;

        //Ler numero1
        System.out.print("Introduz um numero: ");
        numero1= input.nextInt();

        //Ler numero2
        System.out.print("Introduz um numero: ");
        numero2= input.nextInt();

        //Fazer o cálculo
        soma=numero1 + numero2;


        //Apresentar resultado
        System.out.println("Soma" + soma);
        // Close the scanner
        input.close();
    }
}