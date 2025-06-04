package Pizzaria;

import Pizzaria_Enums.unidadeMedida;

import java.util.ArrayList;

public class Ingrediente {
    private String codigo;
    private String nome;
    private String descrição;
    private double preco;

    private unidadeMedida medida;

    private double numCalorias;

    public Ingrediente(String codigo, String nome, String descrição, double preco, unidadeMedida medida, double numCalorias) {
        this.codigo = codigo;
        this.nome = nome;
        this.descrição = descrição;
        this.preco = preco;
        this.medida = medida;
        this.numCalorias = numCalorias;
    }

    public void exibirDetalhes(){
        System.out.println(this.codigo + " | " + this.nome + " | " + this.descrição + " | " + this.preco + " | " + this.numCalorias + this.medida);
    }
}
