package Ex_03.Pizzaria;

import Pizzaria_Enums.UnidadeMedida;

public class Ingrediente {
    private String codigo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private double caloriasPorUnidade;
    private double quantidade; // uso específico da pizza

    public Ingrediente(String codigo, String nome, UnidadeMedida unidadeMedida, double caloriasPorUnidade, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.caloriasPorUnidade = caloriasPorUnidade;
        this.quantidade = quantidade;
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public double calcularCaloriasTotais() {
        return caloriasPorUnidade * quantidade;
    }

    @Override
    public String toString() {
        return "[ " + codigo + " | " + nome + " | " + unidadeMedida + " | " + caloriasPorUnidade + " Kcal ] : " +
                quantidade + " " + unidadeMedida.toString().toLowerCase();
    }
}
