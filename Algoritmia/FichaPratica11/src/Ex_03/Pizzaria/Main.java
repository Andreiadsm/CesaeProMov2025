package Ex_03.Pizzaria;

import Pizzaria_Enums.TamanhoPizza;
import Pizzaria_Enums.UnidadeMedida;

public class Main {
    public static void main(String[] args) {
        Pizza pizzaPortugal = new Pizza("P1991", "Portugal",
                "Pizza tradicional com ingredientes nacionais que promete levar quem a come numa viagem pela cultura de Portugal.",
                19.90, TamanhoPizza.GRANDE);
        Pizza pizzaEUA = new Pizza("P1992", 'EUA', 'Pizza com todos os top ingredientes americanos, não dispensa acompanhar com coca cola', 23.9,TamanhoPizza.GRANDE)

        // Criar ingredientes
        Ingrediente massaAlta = new Ingrediente("I9922", "Massa Alta", UnidadeMedida.GRAMAS, 1.5);
        Ingrediente queijoCabra = new Ingrediente("I3476", "Queijo de Cabra", UnidadeMedida.GRAMAS, 2.8);
        Ingrediente chourica = new Ingrediente("I4445", "Rodela Chouriça de Mirandela", UnidadeMedida.UNIDADES, 35);
        Ingrediente molhoTomate = new Ingrediente("I0015", "Molho Tomate", UnidadeMedida.LITROS, 325);
        Ingrediente pimentoVerde = new Ingrediente("I0900", "Fatia Pimento Verde", UnidadeMedida.UNIDADES, 4);


        // Adicionar ingredientes à pizza
        pizzaPortugal.adicionarIngredientePizza(massaAlta, 1);
        pizzaPortugal.adicionarIngredientePizza(queijoCabra, 100);
        pizzaPortugal.adicionarIngredientePizza(chourica,3);
        pizzaPortugal.adicionarIngredientePizza(molhoTomate,100);
        pizzaPortugal.adicionarIngredientePizza(pimentoVerde,3);

        // Exibir


        // Editar quantidade


        // Remover um ingrediente



        // Exibir novamente

    }
}