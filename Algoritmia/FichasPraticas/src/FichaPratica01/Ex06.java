package FichaPratica01;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        //Importar scanner
        Scanner input= new Scanner(System.in);

        //Declarar variáveis
        int valor1, valor2;

        //Ler valor1
        System.out.print("Insira um valor: ");
        valor1= input.nextInt();

        //Ler valor2
        System.out.print("Insira um valor: ");
        valor2= input.nextInt();

        //Permuta
        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        //Permutar
        System.out.println("após a troca: " );
        System.out.println("valor1: " + valor1);
        System.out.println("valor2: " + valor2);
    }
}
