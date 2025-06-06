package Ex_03.Pizzaria;

public class IngredientePizza {
    private Ingrediente ingrediente;
    double qtd;

    public IngredientePizza(Ingrediente ingrediente, double qtd) {
        this.ingrediente = ingrediente;
        this.qtd = qtd;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
}
