package FichaPratica03;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Variáveis
        int numero, repeticoes = 0;
        String mensagem;

        //Ler numero e mensagem
        System.out.println("Insira um numero: ");
        numero = input.nextInt();

        System.out.println("Insira uma mensagem: ");
        input.nextLine();
        mensagem = input.nextLine();

        //imprimir mensagem x numero
        while (repeticoes<numero) {
            System.out.println(mensagem);
            repeticoes = repeticoes+1;
        }
    }
}
