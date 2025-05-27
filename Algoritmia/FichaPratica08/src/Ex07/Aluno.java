package Ex07;
//definir classe aluno
public class Aluno { //atributos privados do aluno
    private String nome;
    private int idade;
    private String email;
    private String curso;
    private double media;
//construtor da classe para criar o novo aluno com os dados fornecidos
    public Aluno(String nome, int idade, String email, String curso, double media) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.curso = curso;
        this.media = media;
    }
//métodos de acesso getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }

    public double getMedia() {
        return media;
    }
//métodos de modificação (setters -curso e média)
    public void setMedia(double media) {
        this.media = media;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", curso='" + curso + '\'' +
                ", media=" + media +
                '}';
    }

    // Metodo que simula um aniversário, aumentando a idade em 1
    public void felizAniversario() {
        idade++;
    }

    // Metodo que verifica se o aluno está aprovado com base na média
    public boolean mediaAprovacao() {
        return media > 9.5;
    }

    // Metodo que imprime todos os dados do aluno no formato desejado
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Email: " + email + " | Curso: " + curso + " | Média: " + media);
    }
}