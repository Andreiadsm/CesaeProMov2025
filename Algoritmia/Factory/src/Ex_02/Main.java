package Ex_02;

import Ex_01.FabricaProdutos;
import Ex_01.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Taco> stock = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n\n***** Programa de Gestão de Pedidos *****");
            System.out.println("1. Novo Pedido");
            System.out.println("2. Preparar Pedido");
            System.out.println("3. Cozinhar Pedido");
            System.out.println("4. Embalar Pedido");

            System.out.println("Insira a opção: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("\nNovo Pedido");
                    //tipo taco
                    System.out.println("Tipo Taco (Carne | Frango | Vegetariano): ");
                    input.nextLine();
                    String tipoTacoInput = input.nextLine();

                    //descricao
                    System.out.print("Nome: ");
                    String nomeTacoInput = input.nextLine();

                    //preco
                    System.out.println("Preço: ");
                    double precoTacoInput = input.nextDouble();

                    //criar o taco
                    Produto tacoNovo = FabricaTacos.criarTaco(tipoTacoInput,nomeTacoInput,precoTacoInput)

                    //adicionar ao array
                    stock.add(tacoNovo);

                    break;

                case 2:
                    System.out.println("Preparar pedido");
        }
        while()
        }
}
