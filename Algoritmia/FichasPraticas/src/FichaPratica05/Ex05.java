package FichaPratica05;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] vetor = new int[10];
        int soma = 0;
        int cont = 0;

        //ler vetor
        for(int i=0; i<10; i++) {
            System.out.print("Insira no vetor[" + i +"]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("---------------------------------");

        //imprimir vetor
        for(int i=0; i<10; i++) {
            System.out.println("vetor[" + i +"]:" + vetor[i]);
            soma += vetor[i];
            cont++;
        }
        //imprime média
        System.out.println("Média: " + soma/cont);
    }
}
