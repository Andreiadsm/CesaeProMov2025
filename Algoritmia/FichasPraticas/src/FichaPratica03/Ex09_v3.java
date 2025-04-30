package FichaPratica03;

import java.util.Scanner;

public class Ex09_v3 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        // Declarar as variáveis
        int numero = 0, soma = 0, contador = 0, media;

        while (numero != -1) {
            // Ler numero
            System.out.print("Introduza um número: ");
            numero = input.nextInt();

            if (numero != -1) {
                soma = soma + numero;
                contador++;
            }
        }


        // Calcular e apresentar a media
        media = soma / contador;

        System.out.println("Média: " + media);
    }
}
