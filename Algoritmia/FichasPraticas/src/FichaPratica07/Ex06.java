package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {

    public static void lerNomesIdades(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner in = new Scanner(ficheiro);

        int maior = 0;
        String nome;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(",");

            int idade = Integer.parseInt(itensDaLinha[1]);
            String nomeMaior = (itensDaLinha[0]);
            if (idade > maior && nome == nomeMaior) {
                maior = idade;
                nomeMaior = nome;
            }
            }

        System.out.println("Maior nome e Maior idade encontrada: " + nome + maior);
        }

    public static void main(String[] args) throws FileNotFoundException {
        lerNomesIdades("Ficheiros/exercicio_06.txt");
    }
}