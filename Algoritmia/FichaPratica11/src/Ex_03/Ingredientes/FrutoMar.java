package Ex_03.Ingredientes;


import Ex_03.Enums.UnidadeMedida;

public class FrutoMar extends Topping {
    private Ex_03.Enums.TipoFrutoMar tipo;

    public FrutoMar(int id, String nome, UnidadeMedida medida, double kcalPorMedida, Ex_03.Enums.OrigemIngrediente origem, Ex_03.Enums.TipoFrutoMar tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }

    @Override
    public void imprimirTipoIngrediente() {
        System.out.println("Isto é um Fruto do Mar");
    }
}