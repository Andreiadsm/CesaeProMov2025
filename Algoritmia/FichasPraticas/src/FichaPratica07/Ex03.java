package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static FichaPratica07.Ex02.escreverFicheiro;

public class Ex03 {
    public static void copiarFicheiro(String origem, String destino) throws FileNotFoundException {

        File ficheiroOrigem = new File(origem);
        File ficheiroDestino = new File(destino);

        Scanner sc = new Scanner(ficheiroOrigem);
        PrintWriter pw = new PrintWriter(ficheiroDestino);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            pw.println(linha);
        }

        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        copiarFicheiro("Ficheiros/exercicio_03_Alternativa01.txt", "Ficheiros/exercicio_03_copia.txt");
    }
}