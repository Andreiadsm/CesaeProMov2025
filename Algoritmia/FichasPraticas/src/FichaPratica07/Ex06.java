package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {

    public static void lerNomesIdades(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner in = new Scanner(ficheiro);

        int maior = 0;
        String nomeMaisVelho = "";

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(",");

            String nomeAtual = itensDaLinha[0].trim();
            int idadeAtual = Integer.parseInt(itensDaLinha[1].trim());

            if (idadeAtual > maior) {
                maior = idadeAtual;
                nomeMaisVelho = nomeAtual;
            }
        }

        System.out.println("Pessoa mais velha: " + nomeMaisVelho + " (" + maior + " anos)");
    }

    public static void main(String[] args) throws FileNotFoundException {
        lerNomesIdades("Ficheiros/exercicio_06.txt");
    }
}