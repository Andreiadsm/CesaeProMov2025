package FichaPratica04;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
// programa que leia dois valores e um carácter representando uma das quatro operações aritméticas (+, -, *, /). 
// Apresente o resultado de aplicar a operação correspondente aos valores. No final, deverá perguntar ao utilizador se deseja repetir, permitindo-lhe efetuar novos cálculos.
// Exemplo: Deseja continuar? (introduza s/n).

    // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double num1, num2, resultado;
        String operacao, continuar;

        do {

            // Ler num1
            System.out.print("Introduza num1: ");
            num1 = input.nextDouble();

            // Ler num2
            System.out.print("Introduza num2: ");
            num2 = input.nextDouble();

            // Ler operação
            System.out.print("Introduza a operação ( + - * / ): ");
            operacao = input.next();

            switch (operacao) {
                case "+":
                    resultado = num1 + num2;
                    System.out.println("Soma: " + resultado);
                    break;

                case "-":
                    resultado = num1 - num2;
                    System.out.println("Subtração: " + resultado);
                    break;

                case "*":
                    resultado = num1 * num2;
                    System.out.println("Multiplicação: " + resultado);
                    break;

                case "/":
                    resultado = num1 / num2;
                    System.out.println("Divisão: " + resultado);
                    break;

                default:
                    System.out.println("Operação Inválida: " + operacao);
                    break;
            }

            // Perceber se o utilizador quer continuar
            System.out.print("Deseja continuar? (s/n): ");
            continuar = input.next();

        } while (continuar.equalsIgnoreCase("s"));

}
}