package Ex_03.Pizzaria;

import Pizzaria_Enums.TamanhoPizza;
import Pizzaria_Enums.UnidadeMedida;

public class Main {
    public static void main(String[] args) {
        Pizza pizzaPortugal = new Pizza("P1991", "Portugal",
                "Pizza tradicional com ingredientes nacionais que promete levar quem a come numa viagem pela cultura de Portugal.",
                19.90, TamanhoPizza.GRANDE);

        // Criar ingredientes
        Ingrediente massaAlta = new Ingrediente("I9922", "Massa Alta", UnidadeMedida.GRAMAS, 1.5, 200);
        Ingrediente queijoCabra = new Ingrediente("I3476", "Queijo de Cabra", UnidadeMedida.GRAMAS, 2.8, 75);
        Ingrediente chourica = new Ingrediente("I4445", "Rodela Chouriça de Mirandela", UnidadeMedida.UNIDADES, 35, 10);
        Ingrediente molhoTomate = new Ingrediente("I0015", "Molho Tomate", UnidadeMedida.LITROS, 325, 0.09);
        Ingrediente pimentoVerde = new Ingrediente("I0900", "Fatia Pimento Verde", UnidadeMedida.UNIDADES, 4, 6);

        // Adicionar ingredientes à pizza
        pizzaPortugal.adicionarIngrediente(massaAlta);
        pizzaPortugal.adicionarIngrediente(queijoCabra);
        pizzaPortugal.adicionarIngrediente(chourica);
        pizzaPortugal.adicionarIngrediente(molhoTomate);
        pizzaPortugal.adicionarIngrediente(pimentoVerde);

        // Exibir
        pizzaPortugal.exibirDetalhes();

        // Editar quantidade
        pizzaPortugal.editarQuantidadeIngrediente("I3476", 100); // muda Queijo de Cabra para 100g
        pizzaPortugal.exibirDetalhes();

        // Remover um ingrediente pelo objeto
        pizzaPortugal.removerIngrediente(queijoCabra);


        // Exibir novamente
        pizzaPortugal.exibirDetalhes();
    }
}