package FichaPratica03;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int inicio =5, numeroLido, salto=1;

        // Ler valores
        System.out.print("Limite do intervalo: ");
        numeroLido = input.nextInt();

        while (inicio < numeroLido) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }

        inicio=numeroLido+1;
        int limite =numeroLido+5;

        while (inicio <= limite) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }
    }
}
