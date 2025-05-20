package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex05 {
    public static void lerNumerosInteiros(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        Integer soma = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLinha = linha.split(" ");


            for (int i = 0; i < itensDaLinha.length; i++) {
                soma+=Integer.parseInt(itensDaLinha[i]); ;
            }
        }
            System.out.println("A soma dos elementos no ficheiro " + caminho + " é: " + soma);
        }

    public static void main(String[] args) throws FileNotFoundException {
        lerNumerosInteiros("Ficheiros/exercicio_05_31.txt");
    }
}

