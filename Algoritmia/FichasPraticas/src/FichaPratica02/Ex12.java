package FichaPratica02;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //declarar variaveis
        int opcao;

        //Listar as opções
        System.out.println("*****MENU*****");
        System.out.println("1. Criar");
        System.out.println("2. Atualizar");
        System.out.println("3. Eliminar");
        System.out.println("4. Sair");

        //Ler opções
        System.out.println("insira a sua opção: ");
        opcao=input.nextInt();

        //Casos
        switch (opcao) {
            case 1:
                System.out.println("Criar");
                break;
            case 2:
                System.out.println("Atualizar");
                break;
            case 3:
                System.out.println("Eliminar");
                break;
            case 4:
                System.out.println(" ");
                break;
            default:
                System.out.println("operação inválida");

        }
    }
}
