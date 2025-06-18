package Ex_02;

public class FabricaTacos {
    public static Taco criarTaco(String tipoTaco, String nome, double preco){

        switch (tipoTaco){
            case "TacoCarne":
                return new TacoCarne(nome, preco);
            case "TacoFrango":
                return new TacoFrango(nome, preco);
            case "Taco Veggie":
                return new TacoVeggie(nome, preco);
            default:
                throw new IllegalArgumentException("Tipo de taco não reconhecido");
        }
    }
}
