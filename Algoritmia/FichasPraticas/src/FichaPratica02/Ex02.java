package FichaPratica02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // importamos o scanner
        Scanner input = new Scanner(System.in);

        // declarar variáveis
        double salario, taxa = 0;

        //Ler números
        System.out.println("Insira o seu salário: ");
        salario = input.nextDouble();

        //Condição
        if (salario <= 15000) { //Taxa de 20%
                taxa = salario * 0.2;
                System.out.print("Paga taxa de 20%: " + taxa);
            }
        else { // Taxa de 30%
                taxa = salario * 0.3;
                System.out.println("Paga taxa de 30%: " + taxa);
            }


}
}
