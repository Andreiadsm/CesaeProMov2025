package FichaPratica03;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //variaveis
        int numIntroduzido = 0, intervalo0_25 = 0, intervalo26_50 = 0, intervalo51_75 = 0, intervalo76_100 = 0;

        while (numIntroduzido >= 0) {
            //ler numero
            System.out.println("Insira um numero: ");
            numIntroduzido = input.nextInt();

            if (numIntroduzido >= 0 && numIntroduzido <= 25) {
                intervalo0_25++;
            }
            if (numIntroduzido >= 26 && numIntroduzido <= 50) {
                intervalo26_50++;
            }
            if (numIntroduzido >= 51 && numIntroduzido <= 75) {
                intervalo51_75++;
            }
            if (numIntroduzido >= 76 && numIntroduzido <= 100) {
                intervalo76_100++;
            }
        }
            System.out.println("[00,25]: " + intervalo0_25);
            System.out.println("[26,50]: " + intervalo26_50);
            System.out.println("[51,75]: " + intervalo51_75);
            System.out.println("[76,100]: " + intervalo76_100);
    }
}
