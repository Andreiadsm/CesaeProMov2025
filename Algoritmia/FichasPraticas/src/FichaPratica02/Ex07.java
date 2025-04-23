package FichaPratica02;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int num1;

        // Ler números
        System.out.print("Insira o número: ");
        num1 = input.nextInt();

        //Apresentar se é par ou ímpar
        if  (num1 % 2 == 0) {
            System.out.println("é par");
        }
        else {
            System.out.println(" é impar");
        }
    }
}
