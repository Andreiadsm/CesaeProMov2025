package Ex_03.Pizzaria;

import Pizzaria_Enums.TamanhoPizza;

import java.util.ArrayList;

public class Pizza {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private TamanhoPizza tamanho;
    private ArrayList<Ingrediente> ingredientes;

    public Pizza(String codigo, String nome, String descricao, double preco, TamanhoPizza tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        if (ingredientes.size() < 5) {
            ingredientes.add(ingrediente);
            System.out.println("Ingrediente " + ingrediente.getNome() + " adicionado à pizza.");
        } else {
            System.out.println("A pizza já tem o máximo de 5 ingredientes.");
        }
    }

    public void editarQuantidade(String codigoIngrediente, double novaQuantidade) {
        for (Ingrediente ing : ingredientes) {
            if (ing.getCodigo().equals(codigoIngrediente)) {
                ing.setQuantidade(novaQuantidade);
                System.out.println("Quantidade do ingrediente " + ing.getNome() + " atualizada para " + novaQuantidade);
                return;
            }
        }
        System.out.println("Ingrediente não encontrado.");
    }

    public void editarQuantidadeIngrediente(String codigoIngrediente, double novaQuantidade) {
        for (Ingrediente ing : ingredientes) {
            if (ing.getCodigo().equals(codigoIngrediente)) {
                ing.setQuantidade(novaQuantidade);
                System.out.println("Quantidade de " + ing.getNome() + " atualizada para " + novaQuantidade + ".");
                return;
            }
        }
        System.out.println("Ingrediente com código " + codigoIngrediente + " não encontrado.");
    }

    public void removerIngrediente(Ingrediente ingredienteRemover) {
        if (ingredientes.remove(ingredienteRemover)) {
            System.out.println("Ingrediente " + ingredienteRemover.getNome() + " removido.");
        } else {
            System.out.println("Ingrediente não encontrado.");
        }
    }

    public double calcularCalorias() {
        double total = 0;
        for (Ingrediente ing : ingredientes) {
            total += ing.calcularCaloriasTotais();
        }
        return total;
    }

    public void exibirDetalhes() {
        System.out.println("\n***** Pizza " + this.nome + " *****");
        System.out.println("Código: " + this.codigo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Tamanho: " + this.tamanho);
        int i = 1;
        for (Ingrediente ing : ingredientes) {
            System.out.println("Ingrediente " + i + ": [ " + ing.getCodigo() + " | " + ing.getNome() + " | " + ing.getUnidadeMedida() + " | " + ing.getCaloriasPorUnidade() + " Kcal ] : " + ing.getQuantidade() + " " + ing.getUnidadeMedida().toString().toLowerCase() + ".");
            i++;
        }
        System.out.println("Total de Calorias: " + this.calcularCalorias() + " Kcal");
        System.out.println("********************************************\n");
    }
}

