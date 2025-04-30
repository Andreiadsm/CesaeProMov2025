package FichaPratica03;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variaveis
        int numero=0, limite= 0, contador = 0;

        System.out.println("Quantos numeros deseja inserir: ");
        limite = input.nextInt();

        while (numero!= 0) {
            System.out.println("insira um numero: ");
            numero = input.nextInt();
            numero = numero + 1;
        }
    }
}
