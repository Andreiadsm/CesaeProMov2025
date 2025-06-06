package Ex_03.Pizzaria;

import Pizzaria_Enums.UnidadeMedida;

import java.util.ArrayList;

public class Ingrediente {
    private String codigo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private double caloriasPorUnidade;

    public Ingrediente(String codigo, String nome, UnidadeMedida unidadeMedida, double caloriasPorUnidade, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.caloriasPorUnidade = caloriasPorUnidade;
    }

    public double getCaloriasPorUnidade() {
        return caloriasPorUnidade;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }


}
