package FichaPratica03;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int inicio=2, limite, salto=2;

        // Ler valores
        System.out.print("Limite do intervalo: ");
        limite = input.nextInt();

        while (inicio <= limite) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }
    }
}
