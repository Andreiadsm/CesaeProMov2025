package FichaPratica03;

import java.util.Scanner;

public class Ex06_v2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int inicio, limite, salto = 1;

        // Ler valores
        System.out.print("Início do intervalo: ");
        inicio = input.nextInt();

        System.out.print("Limite do intervalo: ");
        limite = input.nextInt();

        while (inicio <= limite) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }
    }
}
