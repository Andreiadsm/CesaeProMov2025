package FichaPratica02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // importamos o scanner
        Scanner input = new Scanner(System.in);

        // declarar variáveis
        double salario, taxa = 0;

        //Ler salário
        System.out.println("Insira o seu salário: ");
        salario = input.nextDouble();

        //Condição
        if (salario <= 15000) { //Taxa de 20%
            taxa = salario * 0.2;
            System.out.print("Paga taxa de 20%: " + taxa);
        }
        if (salario > 15000 && salario<=20000) {
            taxa = salario * 0.3;
            System.out.print("Paga taxa de 30%: " + taxa);
        }
        if (salario > 20000 && salario<=25000) {
            taxa = salario * 0.35;
            System.out.print("Paga taxa de 35%: " + taxa);
        }
        if (salario > 25000) {
            taxa = salario * 0.4;
            System.out.print("Paga taxa de 40%: " + taxa);
        }
    }
}
