package FichaPratica02;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int a, b, c;

        //Ler os numeros
        System.out.println("Insira o 1º numero: ");
        a = input.nextInt();

        System.out.println("Insira o 2º numero: ");
        b = input.nextInt();

        System.out.println("Insira o 3º numero: ");
        c = input.nextInt();

        //Ordem crescente
        if (a < b && a < c) {// a ... ...
            if (b < c) {// a b c
                System.out.println(a + " " + b + " " + c);
            } else { // a b c
                System.out.println(a + " " + c + " " + b);
            }
        }
        if (b < a && b < c) { // b ... ...
            System.out.println(b + " " + a + " " + c);
        } else {
            System.out.println(b + " " + c + " " + a);
        }

        if (c < a && c < b) { // c ... ...
            System.out.println(c + " " + a + " " + b);
        } else {
            System.out.println(c + " " + b + " " + a);
        }

    }
}
