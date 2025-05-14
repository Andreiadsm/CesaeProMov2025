package FichaPratica03;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //variaveis

        int numeroInicial; //representa inicio do intervalo
        int numeroFinal; //representa fim do intervalo


        //ler numeros
        System.out.println("Insira o primeiro numero: ");
        numeroInicial = input.nextInt();
        System.out.println("Insira o segundo numero: ");
        numeroFinal = input.nextInt();

        while (numeroInicial<=numeroFinal) {
            if (numeroInicial% 5 == 0) {
                System.out.println(numeroInicial);
            }
            numeroInicial = numeroInicial + 1;
        }
    }
}
