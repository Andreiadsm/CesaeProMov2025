package Ex05;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;
    private String email;
    private String telemovel;

    public Pessoa(String nome, int idade, String cidade, String email, String telemovel) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public String getCidade() {
        return cidade;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Cidade: " + cidade +
                " | Email: " + email + " | Telemóvel: " + telemovel);
    }
}

