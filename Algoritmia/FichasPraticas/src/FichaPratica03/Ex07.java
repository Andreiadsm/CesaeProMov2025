package FichaPratica03;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero = 0;
        int soma = 0;

        while (numero <= 100) {
            System.out.println(numero);
            soma = soma + numero;
            numero = numero + 1;
        }
        System.out.println("Somatório: " + soma);
    }
}

