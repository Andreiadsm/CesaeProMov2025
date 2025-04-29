package FichaPratica03;

import java.util.Scanner;

public class Ex04_v2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inicio = 0, limite, salto = 1;

        System.out.println("limite do intervalo : ");
        limite = input.nextInt();

        while (inicio <= limite) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }
    }
}
