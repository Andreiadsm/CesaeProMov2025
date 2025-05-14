package FichaPratica05;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        //declarar variáveis
        int [] vetor = new int[12];
        int soma = 0;

        //ler vetor
        for(int i=0; i<vetor.length; i++) {
            System.out.print("Insira comissão vetor [" + i +"]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("---------------------------------");

        //imprimir vetor
        for(int i=0; i<vetor.length; i++) {
            System.out.println("mês[" + i + "]:" + vetor[i]);
            soma += vetor[i];
        }

        System.out.println("Total comissões: " + soma);
    }
}
