package FichaPratica03;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        // Declarar as variáveis
        int inicio, limite;

        // Ler valores
        System.out.print("numero inicial: ");
        inicio = input.nextInt();

        System.out.print("numero final: ");
        limite = input.nextInt();


        while (inicio < limite) {
            if (inicio%5 ==0) {
                System.out.println(inicio);
            }
            inicio = inicio + 1; //inicio++
        }
    }
}
