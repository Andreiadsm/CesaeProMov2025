package FichaPratica03;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Perguntar quantos números serão inseridos
        System.out.print("Quantos números deseja inserir? ");
        int quantidade = input.nextInt();

        if (quantidade < 2) {
            System.out.println("É necessário pelo menos dois números.");
            return;
        }

        // Variáveis principais
        System.out.print("Introduza o primeiro número: ");
        int numeroInicial = input.nextInt(); // primeiro número

        int contar = 1; // já lemos o primeiro número

        while (contar < quantidade) {
            System.out.print("Introduza o próximo número: ");
            int numeroSeguinte = input.nextInt(); // próximo número

            if (numeroSeguinte < numeroInicial) {
                System.out.println("Sequência não crescente.");
                return; // termina logo
            } else {
                numeroInicial = numeroSeguinte; // atualizar para comparar depois
            }

            contar = contar + 1; // aumentar o contador
        }

        // Se terminou o while sem problemas:
        System.out.println("Sequência crescente.");
    }
}
