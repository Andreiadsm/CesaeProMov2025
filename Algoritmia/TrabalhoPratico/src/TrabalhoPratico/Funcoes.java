package TrabalhoPratico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Funcoes {

    /**
     * Função que conta quantas linhas tem um ficheiro
     * @param caminho Caminho para o ficheiro
     * @return Número total de linhas
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static int contarLinhas(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        int totalLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            totalLinhas++;
        }

        return totalLinhas;
    }

    /**
     * Função que carrega os dados de login (username e password) para uma matriz
     */
    public static String[][] ficheiroParaMatrizLogins(String caminho) throws FileNotFoundException {
        int totalLinhas = contarLinhas(caminho);
        String[][] matrizLogins = new String[totalLinhas][2];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int linhaAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            matrizLogins[linhaAtual][0] = linhaSeparada[0];
            matrizLogins[linhaAtual][1] = linhaSeparada[1];

            linhaAtual++;
        }

        return matrizLogins;
    }

    /**
     * Função que carrega os dados dos filmes para uma matriz mas ignora cabeçalho
     * @param caminho Caminho do ficheiro de filmes
     * @return Matriz com 8 colunas e uma linha por filme
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {
        int totalLinhas = contarLinhas(caminho) - 1; // Ignorar cabeçalho
        String[][] matriz = new String[totalLinhas][8];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        sc.nextLine(); // Saltar cabeçalho

        int linhaAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int i = 0; i < linhaSeparada.length; i++) {
                matriz[linhaAtual][i] = linhaSeparada[i];
            }

            linhaAtual++;
        }

        return matriz;
    }

    /**
     * Função que verifica se o login existe na matriz
     */
    public static boolean validarLogin(String[][] matriz, String username, String password) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0].equals(username) && matriz[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função que mostra o menu do ADMIN
     */
    public static void menuAdmin(String[][] matrizFilmes) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Consulta de Ficheiros");
            System.out.println("2. Total de Ratings");
            System.out.println("3. Imprimir Todos os Estúdios");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    consultaFicheiros(matrizFilmes);
                    break;
                case 2:
                    totalRatings(matrizFilmes);
                    break;
                case 3:
                    imprimirEstudios(matrizFilmes);
                    break;
                case 0:
                    System.out.println("A sair do menu ADMIN.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    /**
     * Função que imprime o conteúdo da matriz de filmes
     */
    public static void consultaFicheiros(String[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + " | ");
            }
            System.out.println();
        }
    }

    /**
     * Função que mostra o total de ratings (linhas da matriz)
     */
    public static void totalRatings(String[][] matriz) {
        System.out.println("Total de ratings: " + matriz.length);
    }

    /**
     * Função que imprime estúdios únicos (sem repetições)
     */
    public static void imprimirEstudios(String[][] matriz) {
        System.out.println("Estúdios avaliados:");

        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5]; // Coluna 5 = estúdio
            boolean duplicado = false;

            for (int j = 0; j < i; j++) {
                if (matriz[j][5].equalsIgnoreCase(estudioAtual)) {
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                System.out.println("- " + estudioAtual);
            }
        }
    }
}
