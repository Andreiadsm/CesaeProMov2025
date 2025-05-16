package FichaPratica06;

import java.util.Scanner;

import static Bibliotecas.Visuais.fazerBarulho;

public class Ex01 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        String animalUtilizador;

        System.out.print("Insira um animal: ");
        animalUtilizador=input.next();

        fazerBarulho(animalUtilizador);
    }
}

