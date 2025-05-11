package FichaPratica01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        int numero1, numero2, soma, subtracao, divisao, multiplicacao;

        //Ler numero1
        System.out.print("Introduz um numero: ");
        numero1= input.nextInt();

        //Ler numero2
        System.out.print("Introduz um numero: ");
        numero2= input.nextInt();

        //Fazer o cálculo soma
        soma=numero1 + numero2;

        //Apresentar resultado
        System.out.println("Soma" + soma);

        //Fazer o cálculo subtracao
        subtracao=numero1 - numero2;

        //Apresentar resultado
        System.out.println("Subtração" + subtracao);

        //Fazer o cálculo divisão
        divisao=numero1 / numero2;

        //Apresentar resultado
        System.out.println("Divisão" + divisao);

        //Fazer o cálculo multiplicação
        multiplicacao=numero1 * numero2;

        //Apresentar resultado
        System.out.println("Multiplicação" + multiplicacao);
    }
}
