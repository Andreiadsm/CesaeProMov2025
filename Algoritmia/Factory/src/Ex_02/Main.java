package Ex_02;

import Ex_01.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Taco> TacosPedidos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n\n***** Programa de Gestão de Pedidos *****");
            System.out.println("1. Novo Pedido");
            System.out.println("2. Preparar Pedido");
            System.out.println("3. Cozinhar Pedido");
            System.out.println("4. Embalar Pedido");

            System.out.println("Insira a opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nNovo Pedido");
                    //tipo taco
                    System.out.println("Tipo Taco: (Carne | Frango | Vegetariano ");
                    String tipoTacoInput = input.nextLine();

                    //descricao
                    System.out.print("Tipo: ");
                    String nomeTacoInput = input.nextLine();

                    //preco
                    System.out.println("Preço: ");
                    double precoTacoInput = input.nextDouble();

                    //criar o taco
                    Taco tacoNovo = FabricaTacos.criarTaco(tipoTacoInput, nomeTacoInput, precoTacoInput);

                    //adicionar ao array
                    TacosPedidos.add(tacoNovo);

                    break;

                case 2:
                    System.out.println("Preparar pedido");

                    for (Taco tacoAtual : TacosPedidos){
                        tacoAtual.prepare();
                    }

                    break;
                case 3:
                    System.out.println("Cozinhar pedido");

                    for (Taco tacoAtual : TacosPedidos){
                        tacoAtual.bake();
                    }
                    break;
                case 4:
                    System.out.println("Preparar pedido");

                    for (Taco tacoAtual : TacosPedidos){
                        tacoAtual.box();
                    }
                default:
                    System.out.println("\nOpção Inválida");
            }
            }while (opcao != 0);
        }
    }
