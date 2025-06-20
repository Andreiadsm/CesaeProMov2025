package Ex_02;

public abstract class Taco {

    protected String nome;
    protected double preco;

    public Taco (String nome, double preco){
        this.nome =nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract void prepare();
    public abstract void bake();
    public abstract void box();
}
