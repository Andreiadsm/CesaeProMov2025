package FichaPratica03;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int numero;

        //Ler número
        System.out.println("Introduza um número: ");
        numero = input.nextInt();

        //do numero até 0
        while (numero >=0) {
            System.out.println(numero);
            numero = numero - 1;
        }
    }
}
