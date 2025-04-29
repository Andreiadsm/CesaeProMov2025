package FichaPratica03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // Declarar as variáveis
        int numero;
        int quantidade = 0;
        int soma = 0;

        // Ler valores
        System.out.print("Insira um número: ");
        numero = input.nextInt();

        while (numero != -1) {
            System.out.println("Insira um número: ");
            soma = soma + numero;
            quantidade = quantidade + 1;
            numero++;
        }
            if (numero < 0) {
                System.out.println("Media: " + soma / quantidade);
            } else {
                System.out.println("numero inválido");
            }
        }
}
