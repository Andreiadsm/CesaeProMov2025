package Ex02;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João", 31, 961567788, "joao@hotmail.com");
        Pessoa pessoa2 = new Pessoa("Andreia", 38, 961297788, "andreia@hotmail.com");
        Pessoa pessoa3 = new Pessoa("Ana", 27, 911397788, "ana@hotmail.com");
        Pessoa pessoa4 = new Pessoa("Filipe", 22, 911397742, "Filipe@hotmail.com");
        Pessoa pessoa5 = new Pessoa("Pedro", 17, 911699577, "Pedro@gmail.com");
        Pessoa pessoa6 = new Pessoa("Carlos", 29, 911699577, "Carlos@outlook.com");

        // Criamos o sorteio
        Sorteio sorteio1 = new Sorteio("Euromilhoes", 10000);

        //inscrever pessoas
        sorteio1.inscreverParticipante(pessoa1);
        sorteio1.inscreverParticipante(pessoa2);
        sorteio1.inscreverParticipante(pessoa3);
        sorteio1.inscreverParticipante(pessoa4);
        sorteio1.inscreverParticipante(pessoa5);
        sorteio1.inscreverParticipante(pessoa6);

        // Imprimir detalhes
        System.out.println("-------------------------------------------------------");
        sorteio1.imprimirParticipantes();


        //sortear
        System.out.println("\n*******************Vencedor*************************");
        Pessoa vencedor = sorteio1.sortearVencedor();
        vencedor.exibirDetalhes();

    }
}
