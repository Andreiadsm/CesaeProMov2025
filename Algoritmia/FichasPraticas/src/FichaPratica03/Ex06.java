package FichaPratica03;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //declarar variáveis
        int numeroInicial, numeroFinal;

        //Ler numeros
        System.out.println("Insira o numero inicial: ");
        numeroInicial = input.nextInt();

        System.out.println("Insina o numero final: ");
        numeroFinal = input.nextInt();

        //do numero até 0
        while (numeroInicial <= numeroFinal) {
            System.out.println(numeroInicial);
            numeroInicial = numeroInicial + 1;
        }
    }
}
