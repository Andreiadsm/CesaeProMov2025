package FichaPratica05;

import java.util.Scanner;

public class ex06_vitor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] vetor = new int[5];
        boolean crescente = true;

        //ler vetor
        for(int i=0; i<10; i++) {
            System.out.print("Insira no vetor[" + i +"]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("---------------------------------");

        // Perceber se o vetor é crescente
        for (int i = 1; i < vetor.length; i++) {
                if (vetor[i] <= vetor[i - 1]) {
                    crescente = false;
                }
            }

        if (crescente) {
        System.out.println("Crescente");
    } else {
        System.out.println("Não Crescente");}
    }
}
