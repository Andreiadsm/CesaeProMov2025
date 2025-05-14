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
            soma = soma + numero; // atualizar a soma
            quantidade = quantidade + 1; // atualizar quantidade
            System.out.print("introduza um número: "); // ler numero seguinte
            numero= input.nextInt();
        }

            if (quantidade > 0) {
                double media = (double) soma / quantidade;
                System.out.println("Média: " + media);
            } else {
                System.out.println("numero inválido");
            }
        }
}
