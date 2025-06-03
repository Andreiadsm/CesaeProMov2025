package Ex02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Sorteio {
    private String nome;
    private double premio;
    private ArrayList<Pessoa> listaParticipantes;

    public Sorteio(String nome, double premio) {
        this.nome = nome;
        this.premio = premio;
        this.listaParticipantes = new ArrayList<Pessoa>();
    }

    public void inscreverParticipante(Pessoa pessoaNova) {
        if (pessoaNova.getIdade() >= 18) {
            this.listaParticipantes.add(pessoaNova);
            System.out.println("Inscrição efetuada");
        } else {
            System.out.println("Impossivel realizar inscrição, deve ser maior de idade");
        }
    }
    public void imprimirParticipantes(){
        System.out.println("\n*************"+this.nome + " | " + this.premio + "€ ********************");

        int contadorPessoas = 1;

        for (Pessoa pessoaAtual : this.listaParticipantes){
            System.out.println("Inscrito nº " + contadorPessoas++ + ": ");
            pessoaAtual.exibirDetalhes();
        }
    }


    public Pessoa sortearVencedor() {
        Random rd = new Random();
        int indexVencedor= rd.nextInt(listaParticipantes.size());
        return listaParticipantes.get(indexVencedor);
    }
}
