package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex07 {

    public static void contarLinhasPalavras(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int linhas = 0;
        int palavras = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            linhas++;

            String[] listaPalavras = linha.split(" "); // divide a linha pelas palavras
            palavras += listaPalavras.length;         // soma a quantidade de palavras
        }

        System.out.println("Número de linhas: " + linhas);
        System.out.println("Número de palavras: " + palavras);
    }

    public static void main(String[] args) throws FileNotFoundException {
        contarLinhasPalavras("Ficheiros/exercicio_07.txt");
    }
}