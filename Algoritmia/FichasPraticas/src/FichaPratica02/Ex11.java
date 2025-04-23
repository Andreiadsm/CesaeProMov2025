package FichaPratica02;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        double saldo, valormovimento;
        String operacao;

        //Ler saldo
        System.out.println("Introduza o seu saldo: ");
        saldo = input.nextInt();

        //Ler valor a movimentar
        System.out.println("Valor a movimentar: ");
        valormovimento = input.nextDouble();

        //Condição
        if (saldo + valormovimento >= 0) { // movimento válido
            System.out.println("transação efetuada");
        }
        else {
            System.out.println ("Saldo atual: " + saldo);
        }
        System.out.println("Saldo atual: " + saldo);
    }
}
