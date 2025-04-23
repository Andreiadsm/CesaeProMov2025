package FichaPratica02;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int num1, num2, resultado;
        String operacao;

        //Ler valores
        System.out.print("Insira o primeiro numero: ");
        num1 = input.nextInt();

        System.out.print("Insira o primeiro numero: ");
        num2 = input.nextInt();

        //Ler operação
        System.out.println("Insira a operação pretendida: + - * /");
        operacao = input.next();

        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                System.out.println("soma: " + resultado);
                break;

            case "-":
                resultado = num1 - num2;
                System.out.println("subtracao: " + resultado);
                break;

            case "*":
                resultado = num1 * num2;
                System.out.println("multiplicacao: " + resultado);
                break;

            case "/":
                resultado = num1 / num2;
                System.out.println("divisão" + resultado);
                break;

            default:
                System.out.println("Erro - operação desconhecida");
                break;
    }

    }
}