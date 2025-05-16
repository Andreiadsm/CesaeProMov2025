package FichaPratica06;

import java.util.Scanner;

import static Bibliotecas.Matematica.*;
import static Bibliotecas.Visuais.separador;

public class Demonstracao {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num1, num2, res;

        System.out.print("Introduza um número: ");
        num1 = input.nextInt( );

        System.out.print("Introduza um número: ");
        num2 = input.nextInt( );

        res = modulo_diferenca_inteira (num1, num2);
        System.out.println("Módulo Dif. Int.: " + res);

        separador();

        System.out.println(pi());

    }
}
