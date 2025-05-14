package FichaPratica05;

import java.util.Scanner;

public class Ex07_correcao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] vetor = new int[5];
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
            if (vetor[i] > maior && vetor[i] % 2 == 0) {
                maior = vetor[i];
            }
        }

        //Mostrar numero maior par
        if (maior % 2 == 0) {
            System.out.println("Maior elemento  par é: " + maior);
        } else {
            System.out.println("Não há pares");
        }
    }
}
