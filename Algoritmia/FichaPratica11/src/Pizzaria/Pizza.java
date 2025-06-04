package Pizzaria;

import Pizzaria_Enums.tamanhoPizza;

import java.util.ArrayList;

public class Pizza {
   private String codigo;
   private String nome;
   private String descricao;
   private double preco;
   private tamanhoPizza tamanho;

    private ArrayList<Ingrediente> ingredientesPizza;


    public Pizza(String codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientesPizza = new ArrayList<Ingrediente>();
    }

    public void exibirDetalhes() {
        for (Pizza pizzaAtual : this.ingredientesPizza){
            pizzaAtual.exibirDetalhes();
    }

    public void adicionarIngrediente (Ingrediente ingredienteNovo)
        if(this.ingredientesPizza()< 5){
            this.ingredientesPizza.add(ingredienteNovo);
        }
    }
}

