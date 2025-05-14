package FichaPratica03;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

    //Ler variaveis
        int numero;
        int intervalo0_25 = 0;
        int intervalo26_50 = 0;
        int intervalo51_75 = 0;
        int intervalo76_100 = 0;

        //ler numeros
        System.out.println("Insira um numero positivo: ");
        numero = input.nextInt();

        //contar enquanto for positivo

        while (numero >= 0) {
            if (numero <= 25) {
                intervalo0_25 = intervalo0_25 + 1;
            } else if (numero <= 50) {
                intervalo26_50 = intervalo26_50 + 1;
            } else if (numero <= 75) {
                intervalo51_75 = intervalo51_75 + 1;
            } else if (numero <= 100) {
                intervalo76_100 = intervalo76_100 + 1;
            }

            System.out.println("insira um numero (negativo para terminar): ");
            numero = input.nextInt();
        }

        //Mostrar resultados
        System.out.println("Intervalos: ");
        System.out.println("[00,25]: " + intervalo0_25);
        System.out.println("[26,50]: " + intervalo26_50);
        System.out.println("[51,75]: " + intervalo51_75);
        System.out.println("[76,100]: " + intervalo76_100);
    }
}
