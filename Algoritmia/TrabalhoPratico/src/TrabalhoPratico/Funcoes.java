package TrabalhoPratico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Funcoes {

    /**
     * Função que conta quantas linhas tem um ficheiro
     *
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
     *
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
            System.out.println("\n*-*-*-* MENU ADMIN *-*-*-*");
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
     * Função que imprime estúdios únicos (sem duplicados)
     */
    public static void imprimirEstudios(String[][] matriz) {
        System.out.println("Estúdios avaliados:");

        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5]; // Coluna 5 = estúdio
            boolean duplicado = false;

            for (int anterior = 0; anterior < i; anterior++) {
                if (matriz[anterior][5].equalsIgnoreCase(estudioAtual)) {
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                System.out.println("- " + estudioAtual);
            }
        }
    }

    /**
     * Função que simula o registo de um novo utilizador
     */
    public static void registarUtilizador() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Registar Utilizador ---");

        System.out.print("Insira Nome: ");
        String nome = input.nextLine();

        System.out.print("Insira Contacto: ");
        String contacto = input.nextLine();

        System.out.print("Insira Email: ");
        String email = input.nextLine();

        System.out.println("\nUtilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);
    }

    /**
     * Função que apresenta o menu do CLIENTE
     *
     * @param matrizFilmes Matriz com os dados dos filmes
     */
    public static void menuCliente(String[][] matrizFilmes) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n-*-*-* MENU CLIENTE *-*-*-\n");
            System.out.println("1. Registar Utilizador");
            System.out.println("2. Registar um Novo Rating");
            System.out.println("3. Ver Melhor Filme de um Estúdio");
            System.out.println("4. Ver Pior Filme de um Estúdio");
            System.out.println("5. Consultar Média de Avaliações de um Filme");
            System.out.println("6. Ver Todos os Filmes com Avaliação Acima de um Valor");
            System.out.println("7. Ver Número de Filmes Avaliados por Estúdio");
            System.out.println("8. Consultar Todos os Géneros de Filmes");
            System.out.println("9. Ver Total de Filmes Avaliados");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    registarUtilizador();
                    break;
                case 2:
                    imprimirCatalogo(matrizFilmes);
                    break;
                case 3:
                    // verMelhorFilmeEstudio(matrizFilmes);

                    break;
                case 4:
                    // verPiorFilmeEstudio(matrizFilmes);
                    break;
                case 5:
                    // consultarMediaAvaliacoes(matrizFilmes);
                    break;
                case 6:
                    // filmesAcimaDeValor(matrizFilmes);
                    break;
                case 7:
                    // numeroFilmesPorEstudio(matrizFilmes);
                    break;
                case 8:
                    // consultarGenerosFilmes(matrizFilmes);
                    break;
                case 9:
                    // totalFilmesAvaliados(matrizFilmes);
                    break;
                case 0:
                    System.out.println("A sair do menu CLIENTE.");
                    //imprimir copyright
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void imprimirCatalogo(String[][] matriz) {
        System.out.println("\n-*-*-* Catálogo de Filmes Avaliados *-*-*-\n");

        for (int linha = 0; linha < matriz.length; linha++) {
            String titulo = matriz[linha][1];      // Coluna 1: título do filme
            String avaliacao = matriz[linha][2];   // Coluna 2: classificação
            System.out.println(titulo + " | Avaliação: " + avaliacao);
        }
    }
}