package FichaPratica05;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3]; // Declara uma matriz 3x3

        // Leitura da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira um numero na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }
        int maior = matriz[0][0];
        int menor = matriz[0][0];

        //Encontrar e imprimir o numero maior
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] > maior) {
                    maior = matriz[linha][coluna];
                }
                if (matriz[linha][coluna] < menor) {
                    menor = matriz[linha][coluna];
                }
            }
        }

        //Mostrar numero maior
        System.out.println("Maior elemento é: " + maior + "e menor elemento é: " + menor);

        //imprimir a matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
