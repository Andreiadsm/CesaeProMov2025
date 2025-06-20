package Ex_02;

public class FabricaTacos {
    public static Taco criarTaco(String tipoTaco, String nome, double preco){

        switch (tipoTaco){
            case "Carne":
                return new TacoCarne(nome, preco);
            case "Frango":
                return new TacoFrango(nome, preco);
            case "Vegetariano":
                return new TacoVeggie(nome, preco);
            default:
                throw new IllegalArgumentException("Tipo de taco não reconhecido");
        }
    }
}
