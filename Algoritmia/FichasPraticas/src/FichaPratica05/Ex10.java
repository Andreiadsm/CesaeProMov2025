package FichaPratica05;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][5]; // Declara uma matriz 3x5

        // Leitura da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira um numero na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("-------------------------------------");

        //imprimir a matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        //pedir numero ao utilizador para depois pesquisar
        System.out.print("Insira um numero para pesquisar: ");
        int numero = input.nextInt();

        //declarar contador
        int cont = 0;

        //contar numeros na matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == numero) {
                    cont++;
                }
            }
        }
        System.out.println("Há " + cont + " posições na matriz com o número " + numero);
    }
}