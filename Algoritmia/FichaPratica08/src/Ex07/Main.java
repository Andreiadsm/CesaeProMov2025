package Ex07;

public class Main {
    public static void main(String [] args) {
        //instanciar dois alunos
        Aluno aluno1 = new Aluno("Andreia Guedes", 38, "martinsandreiad@gmail.com", "Software Developer", 15);
        Aluno aluno2 = new Aluno("Roberto Couto", 28, "rc@gmail.com", "Software Developer", 7.5);

        // Chamada do metodo exibirDetalhes para mostrar os dados do aluno1
        aluno1.exibirDetalhes();

        // Chamada do metodo mediaAprovacao para mostrar se aluno esta aprovado ou reprovado
        System.out.println("Aprovado? " + aluno1.mediaAprovacao());


        System.out.println("________________________________________");

        // Chamada do metodo exibirDetalhes para mostrar os dados do aluno2
        aluno2.exibirDetalhes();

        // Verificação da situação de aprovação do aluno2 e impressão do resultado
        System.out.println("Aprovado? " + aluno2.mediaAprovacao());
    }
}
