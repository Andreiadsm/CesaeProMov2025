package ex02;

public class Edificio {
    private String nome;
    private String rua;
    private String cidade;
    private String corFachada;
    private int numAndares;
    private boolean garagem;

    public Edificio (String nome, String rua, String cidade, String corFachada, int numAndares, boolean garagem) {
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.corFachada = corFachada;
        this.numAndares = numAndares;
        this.garagem = garagem;
    }

    public String getNome() {
        return this.nome;
    }

    public String getRua() {
        return this.rua;
    }
    public String getCidade() {
        return this.cidade;
    }

    public void setCorFachada(String corFachada) {
        this.corFachada = corFachada;
    }
    public int getNumAndares() {
        return this.numAndares;
    }

    public boolean isGaragem() {
        return this.garagem;
    }
}
