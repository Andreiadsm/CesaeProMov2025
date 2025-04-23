package FichaPratica01;

import java.util.Scanner;

public class Ex07 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            //Declarar variáveis
            double preco1, preco2, preco3, soma, desconto, somacomdesconto;

            //Ler valores
            System.out.print("Insira o valor1: ");
            preco1 = input.nextInt();

            System.out.print("Insira o valor2: ");
            preco2 = input.nextInt();

            System.out.print("Insira o valor3: ");
            preco3 = input.nextInt();

            //Calcular a soma
            soma= preco1 + preco2 + preco3;

            //Apresentar o resultado
            System.out.println("Soma" + soma);

            //Calcurar desconto
            desconto = (preco1 * 0.1) + (preco2 * 0.1) + (preco3 * 0.1);

            //Apresentar o resultado
            System.out.println("desconto: " + desconto);

            //Calcular total desconto
            somacomdesconto = soma - desconto;
            System.out.println("Preço com desconto: " +somacomdesconto);



    }
}
