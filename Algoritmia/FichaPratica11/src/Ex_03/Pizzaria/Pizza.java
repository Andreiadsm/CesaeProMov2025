package Ex_03.Pizzaria;

import Pizzaria_Enums.TamanhoPizza;

import java.util.ArrayList;

public class Pizza {
    private int MAX_INGREDIENTES = 5;
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private TamanhoPizza tamanho;
    private ArrayList<IngredientePizza> Lista;

    public Pizza(String codigo, String nome, String descricao, double preco, TamanhoPizza tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.Lista = new ArrayList<IngredientePizza>();
    }


    public void adicionarIngredientePizza(Ingrediente ingredienteNovo, double qtd) {
       if(this.Lista.size()) < this.MAX_INGREDIENTES){
           IngredientePizza ipNovo = new IngredientePizza (ingredienteNovo, qtd);
           this.Lista.add(ingredienteNovo);
    }

    }

}

