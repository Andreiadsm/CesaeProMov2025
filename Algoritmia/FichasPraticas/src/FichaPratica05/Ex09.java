package FichaPratica05;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3]; // Declara uma matriz 3x3
        int somaElementos= 0;

        // Leitura da matriz


        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("-------------------------------------");

        //Somar os elementos da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
               somaElementos += matriz[linha][coluna];
            }
        }
        System.out.println("Soma dos elementos: " + somaElementos);
    }
}
