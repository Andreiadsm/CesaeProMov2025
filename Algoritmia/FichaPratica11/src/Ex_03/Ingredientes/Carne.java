package Ex_03.Ingredientes;


import Ex_03.Enums.UnidadeMedida;

public class Carne extends Ex_03.Ingredientes.Topping {
    private Ex_03.Enums.TipoCarne tipo;

    public Carne(int id, String nome, UnidadeMedida medida, double kcalPorMedida, Ex_03.Enums.OrigemIngrediente origem, Ex_03.Enums.TipoCarne tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }

    @Override
    public void imprimirTipoIngrediente() {
        System.out.println("Isto é uma Carne");
    }
}