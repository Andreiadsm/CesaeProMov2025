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
    public static void menuCliente(String[][] matrizFilmes) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n-*-*-* MENU CLIENTE *-*-*-\n");
            System.out.println("1. Registar utilizador");
            System.out.println("2. Imprimir catálogo");
            System.out.println("3. Imprimir catálogo gráfico");
            System.out.println("4. Imprimir melhor estúdio");
            System.out.println("5. Imprimir pior estúdio");
            System.out.println("6. Ver critica mais recente");
            System.out.println("7. Fazer Quizz");
            System.out.println("8. Imprimir catálogo estúdio");
            System.out.println("9. Imprimir catálogo categoria");
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
                    imprimirCatalogoGrafico();
                    break;
                case 4:
                    imprimirMelhorEstudio(matrizFilmes);
                    break;
                case 5:
                    imprimirPiorEstudio(matrizFilmes);
                    break;
                case 6:
                    imprimirCriticaMaisRecente(matrizFilmes);
                    break;
                case 7:
                    imprimirMenuQuizz();
                    break;
                case 8:
                    // catalogoEstudioFormatado;
                    break;
                case 9:
                    // imprimirCatalogoCategoria;
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

    /**
     * Função que imprime a arte gráfica de um dos filmes disponíveis
     */
    public static void imprimirCatalogoGrafico() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Catálogos Gráficos Disponíveis ---");
        System.out.println("1. Harry Potter");
        System.out.println("2. Interstellar");
        System.out.println("3. Lord of The Rings");
        System.out.println("4. Star Wars");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine(); // limpar buffer

        String caminhoFicheiro = "";

        switch (opcao) {
            case 1:
                caminhoFicheiro = "Ficheiros/HarryPotter.txt";
                break;
            case 2:
                caminhoFicheiro = "Ficheiros/Interstellar.txt";
                break;
            case 3:
                caminhoFicheiro = "Ficheiros/LordOfTheRings.txt";
                break;
            case 4:
                caminhoFicheiro = "Ficheiros/StarWars.txt";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        // Ler e imprimir o conteúdo do ficheiro escolhido
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        System.out.println("\n*-*-*-* Arte Gráfica do Filme *-*-*-*\n");

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void imprimirMelhorEstudio(String[][] matriz) {


        String melhorEstudio = "";// variável melhorEstudio inicializada como boa prática ensinada

        double melhorMedia = -1; //garantiamos que a inicializar a -1 qualquer média será mairo

        // Variável para controlar a linha atual da matriz
        int linha = 0;

        // Ciclo para percorrer todas as linhas da matriz
        while (linha < matriz.length) {

            // Apanhar o nome do estúdio na linha atual (coluna 5)
            String estudioAtual = matriz[linha][5];

            // Vamos verificar se já calculei este estúdio antes
            boolean jaCalculado = false;

            // Percorrer as linhas anteriores para ver se este estúdio já foi tratado
            for (int anterior = 0; anterior < linha; anterior++) {
                if (matriz[anterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                }
            }

            // Se for a primeira vez que encontramos este estúdio, então vamos calcular
            if (!jaCalculado) {

                int total = 0;       // Somatório dos ratings do estúdio
                int contador = 0;    // Número de filmes desse estúdio

                int pesquisa = 0;

                // Percorrer novamente toda a matriz para somar os ratings do estúdio atual
                while (pesquisa < matriz.length) {
                    if (matriz[pesquisa][5].equalsIgnoreCase(estudioAtual)) {
                        total += Double.parseDouble(matriz[pesquisa][2]); // rating está na coluna 2
                        contador++;
                    }
                    pesquisa++;
                }

                // Calcular a média dos ratings para o estúdio atual
                double media = (double) total / contador;

                // Se esta média for melhor do que a melhor encontrada até agora, atualizamos
                if (media > melhorMedia) {
                    melhorMedia = media;
                    melhorEstudio = estudioAtual;
                }
            }

            // Avançar para a próxima linha da matriz
            linha++;
        }

        // Mostrar o estúdio com a melhor média
        System.out.println("\nMelhor estúdio: " + melhorEstudio + " (" + melhorMedia + ")");
    }

    /**
     * Função que mostra o estúdio com a pior classificação média
     */
    public static void imprimirPiorEstudio(String[][] matriz) {

        String piorEstudio = "";         // Armazena o nome do estúdio com pior média
        double piorMedia = 999;          // Começa com um valor alto para garantir que a 1ª média seja menor

        int linha = 0;

        while (linha < matriz.length) {

            String estudioAtual = matriz[linha][5];
            boolean jaCalculado = false;

            // Verifica se já processámos este estúdio
            for (int anterior = 0; anterior < linha; anterior++) {
                if (matriz[anterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                }
            }

            if (!jaCalculado) {
                int total = 0;
                int contador = 0;

                int pesquisa = 0;

                while (pesquisa < matriz.length) {
                    if (matriz[pesquisa][5].equalsIgnoreCase(estudioAtual)) {
                        total += Double.parseDouble(matriz[pesquisa][2]); // rating na coluna 2
                        contador++;
                    }
                    pesquisa++;
                }

                double media = (double) total / contador;

                // Se esta média for menor que a pior encontrada até agora, atualizamos
                if (media < piorMedia) {
                    piorMedia = media;
                    piorEstudio = estudioAtual;
                }
            }
            linha++;
        }

        System.out.println("\nPior estúdio: " + piorEstudio + " (" + piorMedia + ")");
    }

    /**
     * Função que mostra a critica mais recente (ultima linha)
     */

    public static int imprimirCriticaMaisRecente(String[][] matriz) {
        int ultimaLinha = matriz.length - 1; // índice da última linha

        System.out.println("\n-*-*-* Crítica Mais Recente *-*-*\n");

        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            System.out.print(matriz[ultimaLinha][coluna] + " | ");
        }
        return (ultimaLinha);
    }

    /**
     * Função que mostra o menu do Quizz
     */
    public static void imprimirMenuQuizz(String[][] matrizQuizz) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n*-*-*-* Quizz *-*-*-*\n");
            System.out.println("1ª pergunta");
            System.out.println("2ª pergunta");
            System.out.println("3ª pergunta");
            System.out.println("4ª Pergunta");
            System.out.print("5ª Pergunta");
            System.out.print("Sair");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    imprimirPergunta1(matrizQuizz);
                    break;
                case 2:
                    //imprimirPergunta2(matrizQuizz);
                    break;
                case 3:
                    //imprimirPergunta3(matrizQuizz);
                    break;
                case 4:
                    //imprimirPergunta4(matrizQuizz);
                    break;
                case 5:
                    //imprimirPergunta5(matrizQuizz);
                    break;
                case 0:
                    System.out.println("Encerrar o Programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    /**
     * Função que carrega os dados de Quizz para uma matriz
     */
    public static String[][] ficheiroParaMatrizQuizz(String caminho) throws FileNotFoundException {
        int totalLinhas = contarLinhas(caminho);
        String[][] matrizQuizz = new String[totalLinhas][5];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int linhaAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            matrizQuizz[linhaAtual][0] = linhaSeparada[0];
            matrizQuizz[linhaAtual][1] = linhaSeparada[1];
            matrizQuizz[linhaAtual][2] = linhaSeparada[2];
            matrizQuizz[linhaAtual][3] = linhaSeparada[3];
            matrizQuizz[linhaAtual][4] = linhaSeparada[4];
            matrizQuizz[linhaAtual][5] = linhaSeparada[5];

            linhaAtual++;
        }

        return totalLinhas;
    }

    /**
     * Função que imprime o conteúdo da matriz Quizz
     */
    public static void consultaQuizz(String[][] matrizQuizz) throws FileNotFoundException {
        for (int linha = 0; linha < matrizQuizz.length; linha++) {
            for (int coluna = 0; coluna < matrizQuizz[0].length; coluna++) {
            }
            System.out.println();
        }
        return consultaQuizz();
    }

    /**
     * Função que verifica se lê e imprime pergunta 1 da matriz
     */
    public static String imprimirPergunta1(String[][] consultaQuizz) { throws FileNotFoundException {
        String pergunta1 = consultaQuizz[0][0];
        return pergunta1;
    }

}