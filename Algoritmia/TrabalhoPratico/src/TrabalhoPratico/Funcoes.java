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
     * Função que valida o login na matriz
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
                    break; // impresso sai do ciclo
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

        System.out.println("\nUtilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);
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
     * Função que imprime o catálogo de filmes
     */
    public static void imprimirCatalogo(String[][] matriz) {
        System.out.println("\n-*-*-* Catálogo de Filmes Avaliados *-*-*-\n");

        for (int linha = 0; linha < matriz.length; linha++) {
            String titulo = matriz[linha][1];      // Coluna 1: título do filme
            String avaliacao = matriz[linha][2];   // Coluna 2: classificação
            System.out.println(titulo + " | Avaliação: " + avaliacao);
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
        }

        // Ler e imprimir o conteúdo do ficheiro escolhido
        File ficheiro = new File(caminhoFicheiro);
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
        double melhorMedia = 0;

        int linhaAtual = 0;

        // Percorrer todas as linhas da matriz de filmes
        while (linhaAtual < matriz.length) {

            String estudioAtual = matriz[linhaAtual][5];
            boolean jaCalculado = false;

            // Verificar se este estúdio já foi processado
            for (int linhaAnterior = 0; linhaAnterior < linhaAtual; linhaAnterior++) {
                if (matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                }
            }

            // Se ainda não foi calculado, processa o estúdio
            if (!jaCalculado) {
                int somaRatings = 0;
                int contadorFilmes = 0;

                int linhaPesquisa = 0;

                // Percorrer novamente a matriz para somar os ratings do estúdio
                while (linhaPesquisa < matriz.length) {
                    if (matriz[linhaPesquisa][5].equalsIgnoreCase(estudioAtual)) {
                        somaRatings += Double.parseDouble(matriz[linhaPesquisa][2]);
                        contadorFilmes++;
                    }
                    linhaPesquisa++;
                }

                double mediaEstudio = somaRatings / contadorFilmes;

                // Atualizar se este estúdio tiver uma média melhor
                if (mediaEstudio > melhorMedia) {
                    melhorMedia = mediaEstudio;
                    melhorEstudio = estudioAtual;
                }
            }

            linhaAtual++;
        }

        // Imprimir o estúdio com melhor média
        System.out.println("\nMelhor estúdio: " + melhorEstudio + " (" + melhorMedia + ")");
    }

    /**
     * Função que calcula o estúdio com pior média de rating
     * @param matriz com 8 colunas, onde a coluna 2 indica o rating e a coluna5 o estudio
     */
    public static void imprimirPiorEstudio(String[][] matriz) {

        String piorEstudio = "";
        double piorMedia = 10; // Inicializa com nº alto para garantir que vai ser substituído

        int linhaAtual = 0;

        while (linhaAtual < matriz.length) {

            String estudioAtual = matriz[linhaAtual][5];
            boolean jaCalculado = false;

            for (int linhaAnterior = 0; linhaAnterior < linhaAtual; linhaAnterior++) {
                if (matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                    jaCalculado = true;
                    break;
                }
            }

            if (!jaCalculado) {
                int somaRatings = 0;
                int contadorFilmes = 0;
                int linhaPesquisa = 0;

                while (linhaPesquisa < matriz.length) {
                    if (matriz[linhaPesquisa][5].equalsIgnoreCase(estudioAtual)) {
                        somaRatings += Double.parseDouble(matriz[linhaPesquisa][2]); // Coluna 2: rating
                        contadorFilmes++;
                    }
                    linhaPesquisa++;
                }

                double mediaEstudio = somaRatings / contadorFilmes;

                if (mediaEstudio < piorMedia) {
                    piorMedia = mediaEstudio;
                    piorEstudio = estudioAtual;
                }
            }

            linhaAtual++;
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
     * Função que permite mostrar o conteúdo do quizz e armazenar respostas do utilizador.
     * @param matrizQuiz com perguntas, opções de resposta possiveis e resposta certa.
     */
    public static void executarQuiz(String[][] matrizQuiz) {
        Scanner input = new Scanner(System.in);
        int pontuacao = 0;

        System.out.println("\n-*-*-* QUIZZ IMDV *-*-*-\n");

        for (int i = 0; i < matrizQuiz.length; i++) {
            System.out.println("Pergunta " + (i + 1) + ": " + matrizQuiz[i][0]);
            System.out.println("1. " + matrizQuiz[i][1]);
            System.out.println("2. " + matrizQuiz[i][2]);
            System.out.println("3. " + matrizQuiz[i][3]);
            System.out.println("4. " + matrizQuiz[i][4]);

            int respostaUtilizador;

            do {
                System.out.print("Escolhe a opção (1-4): ");
                respostaUtilizador = input.nextInt();
            } while (respostaUtilizador < 1 || respostaUtilizador > 4);

            int respostaCorreta = Integer.parseInt(matrizQuiz[i][5]);

            if (respostaUtilizador == respostaCorreta) {
                pontuacao++;
                System.out.println("\nAcertou!\n");
            } else {
                System.out.println("\nErrado. Resposta correta: " + respostaCorreta + ". " + matrizQuiz[i][respostaCorreta - 1] + "\n");
            }
        }

        System.out.println("Pontuação final: " + pontuacao + " / " + matrizQuiz.length);
    }

    /**
     * Função que permite imprimir o copyright ao sair do menu cliente.
     * @param caminho ficheiro copyright
     * @throws FileNotFoundException
     */
    public static void imprimirCopyright(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        System.out.println("");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }


    /**
     * Função que imprime o catálogo de um estúdio, agrupando os filmes por género.
     * A estrutura segue o modelo visual apresentado no enunciado.
     *
     * @param matriz Matriz de filmes
     */
    public static void imprimirCatalogoEstudio(String[][] matriz) {
        Scanner input = new Scanner(System.in);

        System.out.print("Estúdio a pesquisar: ");
        String estudio = input.nextLine();

        System.out.println();
        System.out.println("**** " + estudio + " *****\n");
        System.out.println();

        for (int linha = 0; linha < matriz.length; linha++) {
            String estudioAtual = matriz[linha][5];

            if (estudioAtual.equalsIgnoreCase(estudio)) {
                String generoAtual = matriz[linha][7]; // Última coluna = género
                boolean jaImprimi = false;

                for (int linhaAnterior = 0; linhaAnterior < linha; linhaAnterior++) {
                    if (matriz[linhaAnterior][5].equalsIgnoreCase(estudio) && matriz[linhaAnterior][7].equalsIgnoreCase(generoAtual)) {
                        jaImprimi = true;
                        break;
                    }
                }

                if (!jaImprimi) {
                    System.out.println(" __ " + generoAtual + " __ ");

                    for (int linhaFilme = 0; linhaFilme < matriz.length; linhaFilme++) {
                        if (matriz[linhaFilme][5].equalsIgnoreCase(estudio) &&
                                matriz[linhaFilme][7].equalsIgnoreCase(generoAtual)) {
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

        System.out.println();
        System.out.println("****" + genero + " ****\n");
        System.out.println();

        for (int linha = 0; linha < matriz.length; linha++) {
            String generoAtual = matriz[linha][7]; // Coluna 7: género

            if (generoAtual.equalsIgnoreCase(genero)) {
                String estudioAtual = matriz[linha][5]; // Coluna 5: estúdio
                boolean jaImprimi = false;

                // Verificar se já imprimi esse estúdio
                for (int linhaAnterior = 0; linhaAnterior < linha; linhaAnterior++) {
                    if (matriz[linhaAnterior][7].equalsIgnoreCase(genero) && matriz[linhaAnterior][5].equalsIgnoreCase(estudioAtual)) {
                        jaImprimi = true;
                        break;
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
}