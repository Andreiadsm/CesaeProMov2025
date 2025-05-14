package FichaPratica05;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //declarar variáveis
        int [] vetor = new int[10];
        int maior = vetor[0];

        //ler vetor
        for(int i=0; i<10; i++) {
            System.out.print("Insira no vetor[" + i +"]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("---------------------------------");

        //imprimir vetor
        for(int i=0; i<10; i++) {
            System.out.println("vetor[" + i +"]:" + vetor[i]);
        }

        //Encontrar e imprimir o numero maior
        for (int i=0; i< vetor.length; i++) {
            if (vetor[i]> maior) {
                maior = vetor[i];
            }
        }

        //Mostrar numero maior
        System.out.println("Maior elemento é: " + maior);
    }
}
