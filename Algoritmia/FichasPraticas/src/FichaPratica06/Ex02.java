package FichaPratica06;

import java.util.Scanner;

import static Bibliotecas.Matematica.lerInteiroPositivo;

import static Bibliotecas.Visuais.imprimirAsteriscos;

public class Ex02 {
    public static void main(String[] args) {
        // Import do Scanner
        Scanner input = new Scanner(System.in);

        int numero = lerInteiroPositivo ();
        imprimirAsteriscos(numero);
    }
}
