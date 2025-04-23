package FichaPratica02;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int a, b, c;

        //ler valores
        System.out.print("Insira o primeiro numero: ");
        a = input.nextInt();

        System.out.print("Insira o segundo numero: ");
        b = input.nextInt();

        System.out.print("Insira o segundo numero: ");
        c = input.nextInt();

        //Condições
        if (a<b && a<c) {
            System.out.println("menor :" + a);
        }

        if (b<a && b<c) {
            System.out.println("menor :" + b);
        }

        if (c<a && c<b) {
            System.out.println("menor" + c);
        }
    }
}
