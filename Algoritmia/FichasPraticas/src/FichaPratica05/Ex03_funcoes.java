package FichaPratica05;

import Bibliotecas.Arrays;

import java.util.Scanner;

import static Bibliotecas.Arrays.lerVetorInteiros;
import static Bibliotecas.Arrays.maiorElemento;

public class Ex03_Funcoes {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o tamanho do vetor: ");
        int tamanhoDoVetor = input.nextInt();

        int[] vetor = lerVetorInteiros(tamanhoDoVetor);

        int maiorElemento = maiorElemento(vetor);

        System.out.println("Maior: " + maiorElemento);
    }
}