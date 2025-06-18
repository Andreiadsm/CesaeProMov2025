package Ex_01;

public class Eletronico extends Produto{
    public Eletronico (String descricao, double preco){
        super(descricao, preco);
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("Isto é uma roupa: " + super.descricao);
    }
}
