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
     * Função que carrega um ficheiro para uma matriz
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
     * Função que mostra o menu do ADMIN
     */
    public static void menuAdmin(String[][] matrizFilmes) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n*-*-*-* MENU ADMIN *-*-*-*");
            System.out.println("1. Imprimir Ficheiros");
            System.out.println("2. Total de Ratings");
            System.out.println("3. Imprimir Estúdios");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    imprimirFicheiros(matrizFilmes);
                    break;
                case 2:
                    totalRatings(matrizFilmes);
                    break;
                case 3:
                    imprimirEstudios(matrizFilmes);
                    break;
                case 0:
                    System.out.println("Saiu do menu ADMIN.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    /**
     * Função que imprime o conteúdo da matriz de filmes
     */
    public static void imprimirFicheiros(String[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + ";");
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
     * Função que imprime estúdios únicos (sem repetições),
     * ex06 da Ficha 6 (verificação de ordem crescente),
     * onde se comparam elementos anteriores com o atual.
     */
    public static void imprimirEstudios(String[][] matriz) {
        System.out.println("Estúdios avaliados:");

        for (int linha = 0; linha < matriz.length; linha++) {

            // Obtemos o nome do estúdio na linha atual
            String estudioAtual = matriz[linha][5]; // Coluna 5 = estúdio

            // Variável para saber se já imprimi este estúdio
            boolean jaImprimi= false;

            for (int anterior = 0; anterior < linha; anterior++) {
                if (matriz[anterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaImprimi= true;
                }
            }

            // Se ainda não imprimi, mostra no ecrã
            if (!jaImprimi) {
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

        System.out.println("\nObrigada pela seu registo!\n");
        System.out.println("Nome: "+ nome);
        System.out.println("Contacto: "+ contacto);
        System.out.println("Email: "+ email);
    }

    /**
     * Função que apresenta o menu do CLIENTE
     *
     * @param matrizFilmes Matriz com os dados dos filmes
     */
    public static void menuCliente(String[][] matrizFilmes, String[][] matrizQuiz) throws FileNotFoundException {
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
            System.out.println("8. Imprimir catálogo por estúdio");
            System.out.println("9. Imprimir catálogo por género");
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
                    executarQuiz(matrizQuiz);
                    break;
                case 8:
                    imprimirCatalogoEstudio(matrizFilmes);
                    break;
                case 9:
                    imprimirCatalogoGenero(matrizFilmes);
                    break;
                case 0:
                    imprimirCopyright("Ficheiros/IMDV_Copyright.txt");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
    /**
     * Função que imprime o catálogo de filmes e avaliação
     */
    public static void imprimirCatalogo(String[][] matriz) {
        System.out.println("\n-*-*-* Catálogo de Filmes e Rating *-*-*-\n");

        for (int linha = 0; linha < matriz.length; linha++) {
            String titulo = matriz[linha][1];      // Coluna 1: título do filme
            String avaliacao = matriz[linha][2];   // Coluna 2: classificação
            System.out.println(titulo + " | " + avaliacao);
        }
    }

    /**
     * Função que imprime a arte gráfica de um dos filmes disponíveis do catalogo gráfico
     */
    public static void imprimirCatalogoGrafico() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n*-*-*-* Catálogos Gráficos Disponíveis *-*-*-*\n");
        System.out.println("1. Harry Potter");
        System.out.println("2. Interstellar");
        System.out.println("3. Lord of The Rings");
        System.out.println("4. Star Wars");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine(); // limpar buffer

        File ficheiro;

        switch (opcao) {
            case 1:
                ficheiro = new File("Ficheiros/HarryPotter.txt");
                break;
            case 2:
                ficheiro = new File("Ficheiros/Interstellar.txt");
                break;
            case 3:
                ficheiro = new File("Ficheiros/LordOfTheRings.txt");
                break;
            case 4:
                ficheiro = new File("Ficheiros/StarWars.txt");
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        Scanner sc = new Scanner(ficheiro);
        System.out.println("\n*-*-*-* Arte Gráfica do Filme *-*-*-*\n");

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    /**
     * Função que determina o estúdio com melhor média de avaliação
     * @param matriz matriz de filmes com 8 colunas onde a 5 corresponde ao estudio e a 2 corresponde ao rating
     */
    public static void imprimirMelhorEstudio(String[][] matriz) {
        String melhorEstudio = "";
        double melhorMedia = -1;

        for (int linhaAtual = 0; linhaAtual < matriz.length; linhaAtual++) {
            String estudioAtual = matriz[linhaAtual][5];
            boolean jaCalculado = false;

            // Verifica se o estúdio já foi processado antes
            for (int linhaAnterior = 0; linhaAnterior < linhaAtual; linhaAnterior++) {
                if (matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                }
            }

            if (!jaCalculado) {
                int contador = 0;
                double soma = 0;

                // Percorre toda a matriz para calcular a média de ratings do estúdio atual
                for (int linha = 0; linha < matriz.length; linha++) {
                    if (matriz[linha][5].equalsIgnoreCase(estudioAtual)) {
                        soma += Double.parseDouble(matriz[linha][2]);
                        contador++;
                    }
                }

                double media = soma / contador;

                if (media > melhorMedia) {
                    melhorMedia = media;
                    melhorEstudio = estudioAtual;
                }
            }
        }

        System.out.println("\nMelhor estúdio: " + melhorEstudio + " (" + melhorMedia + ")");
    }


    /**
     * Função que calcula o estúdio com pior média de rating
     * @param matriz Matriz com 8 colunas, onde a coluna 2 indica o rating e a coluna 5 o estúdio
     */
    public static void imprimirPiorEstudio(String[][] matriz) {
        String piorEstudio = "";
        double piorMedia = 11; // para garantir que é substituida

        for (int linhaAtual = 0; linhaAtual < matriz.length; linhaAtual++) {
            String estudioAtual = matriz[linhaAtual][5];
            boolean jaCalculado = false;

            // Verifica se o estúdio já foi processado antes
            for (int linhaAnterior = 0; linhaAnterior < linhaAtual; linhaAnterior++) {
                if (matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                    break;
                }
            }

            if (!jaCalculado) {
                int contador = 0;
                double soma = 0;

                // Percorre toda a matriz para calcular a média de ratings do estúdio atual
                for (int linha = 0; linha < matriz.length; linha++) {
                    if (matriz[linha][5].equalsIgnoreCase(estudioAtual)) {
                        soma += Double.parseDouble(matriz[linha][2]);
                        contador++;
                    }
                }

                double media = soma / contador;

                if (media < piorMedia) {
                    piorMedia = media;
                    piorEstudio = estudioAtual;
                }
            }
        }

        System.out.println("\nPior estúdio: " + piorEstudio + " (" + piorMedia + ")");
    }

    /**
     * Função que mostra a critica mais recente (ultima linha)
     */

    public static void imprimirCriticaMaisRecente(String[][] matriz) {
        int ultimaLinha = matriz.length - 1; // índice da última linha

        System.out.println("\n-*-*-* Crítica Mais Recente *-*-*\n");

        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            System.out.print(matriz[ultimaLinha][coluna] + " | ");
        }
    }

    /**
     * Função que carrega os dados de Quizz para uma matriz
     */
    public static String[][] ficheiroParaMatrizQuiz(String caminho) throws FileNotFoundException {
        int totalLinhas = contarLinhas(caminho) - 1; // Ignorar cabeçalho

        String[][] matrizQuiz = new String[totalLinhas][6];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        sc.nextLine(); // Saltar cabeçalho

        int linhaAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int coluna = 0; coluna < linhaSeparada.length; coluna++) {
                matrizQuiz[linhaAtual][coluna] = linhaSeparada[coluna];
            }

            linhaAtual++;
        }

        return matrizQuiz;
    }

    /**
     * Função que apresenta o Quizz e guarda a pontuação do utilizador.
     *
     * @param matrizQuiz Matriz com perguntas, opções e a resposta correta.
     */
    public static void executarQuiz(String[][] matrizQuiz) {
        Scanner input = new Scanner(System.in);
        int pontuacao = 0;

        System.out.println("\n-*-*-* QUIZZ IMDV *-*-*-\n");

        // Percorrer todas as perguntas
        for (int linha = 0; linha < matrizQuiz.length; linha++) {
            System.out.println("Pergunta " + (linha + 1)+ ": " +matrizQuiz[linha][0]);

            // Mostrar as 4 opções de resposta (colunas 1 a 4)
            for (int coluna = 1; coluna <= 4; coluna++) {
                System.out.println(coluna + ". " + matrizQuiz[linha][coluna]);
            }

            int resposta = 0;

            // Validar se a resposta está entre 1 e 4
            while (resposta < 1 || resposta > 4) {
                System.out.print("Escolha (1-4): ");
                resposta = input.nextInt();
            }

            // Obter resposta certa da matriz (coluna 5)
            int certa = Integer.parseInt(matrizQuiz[linha][5]);

            // Verificar se o utilizador acertou
            if (resposta == certa) {
                pontuacao++;
                System.out.println("Resposta certa!\n");
            } else {
                System.out.println("Errado. A resposta certa é " + certa + ": " + matrizQuiz[linha][certa] + "\n");
            }
        }

        // Mostrar pontuação
        System.out.println("Pontuação final: " + pontuacao + " / " + matrizQuiz.length);
    }

    /**
     * Função que imprime o catálogo de um estúdio, agrupando os filmes por género.
     * A estrutura segue o modelo visual apresentado no enunciado.
     *
     * @param matriz Matriz de filmes
     */
    public static void imprimirCatalogoEstudio(String[][] matriz) {
        Scanner input = new Scanner(System.in);

        System.out.print("> Estúdio a pesquisar: ");
        String estudio = input.nextLine();

        System.out.println("\n> **** " + estudio + " ****\n");

        for (int linha = 0; linha < matriz.length; linha++) {
            String estudioAtual = matriz[linha][5];

            if (estudioAtual.equalsIgnoreCase(estudio)) {
                String generoAtual = matriz[linha][7]; // Última coluna = género
                boolean jaImprimi = false;

                for (int linhaAnterior = 0; linhaAnterior < linha; linhaAnterior++) {
                    if (matriz[linhaAnterior][5].equalsIgnoreCase(estudio) && matriz[linhaAnterior][7].equalsIgnoreCase(generoAtual)) {
                        jaImprimi = true;
                    }
                }

                if (!jaImprimi) {
                    System.out.println(" >__ " + generoAtual + " __ ");

                    for (int linhaFilme = 0; linhaFilme < matriz.length; linhaFilme++) {
                        if (matriz[linhaFilme][5].equalsIgnoreCase(estudio) && matriz[linhaFilme][7].equalsIgnoreCase(generoAtual)) {
                            System.out.println("> " + matriz[linhaFilme][1]); // Coluna 1 = Título
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * Função que imprime o catálogo de um género (categoria), agrupando os filmes por estúdio, com formatação visual.
     *
     * @param matriz Matriz de filmes
     */
    public static void imprimirCatalogoGenero(String[][] matriz) {
        Scanner input = new Scanner(System.in);

        System.out.print("Género a pesquisar: ");
        String genero = input.nextLine();

        System.out.println("\n****" + genero + " ****\n");

        for (int linha = 0; linha < matriz.length; linha++) {
            String generoAtual = matriz[linha][7]; // Coluna 7: género
            if (generoAtual.equalsIgnoreCase(genero)) {
                String estudioAtual = matriz[linha][5]; // Coluna 5: estúdio
                boolean jaImprimi = false;

                // Verificar se já imprimi esse estúdio
                for (int linhaAnterior = 0; linhaAnterior < linha; linhaAnterior++) {
                    if (matriz[linhaAnterior][7].equalsIgnoreCase(genero) && matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                        jaImprimi = true;
                    }
                }

                // Se ainda não imprimi este estúdio para este género
                if (!jaImprimi) {
                    System.out.println("__ " + estudioAtual + " __");

                    for (int linhaFilme = 0; linhaFilme < matriz.length; linhaFilme++) {
                        if (matriz[linhaFilme][7].equalsIgnoreCase(genero) &&
                                matriz[linhaFilme][5].equalsIgnoreCase(estudioAtual)) {
                            System.out.println("> " + matriz[linhaFilme][1]); // Coluna 1: título
                        }
                    }

                    System.out.println();
                }
            }
        }
    }
    /**
     * Função que permite imprimir o copyright ao sair do menu cliente.
     * @param caminho ficheiro copyright
     * @throws FileNotFoundException
     */
    public static void imprimirCopyright(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}