package Ex03;
import java.util.Arrays;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double peso; // em Kg
    private String[] alimentacao;
    private ClasseReino classeReino;

    // Construtor completo
    public Animal(String nome, String especie, String paisOrigem, double peso, String[] alimentacao, ClasseReino classeReino) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.classeReino = classeReino;
    }

    // Metodo que faz barulho consoante a classe do reino
    public void fazerBarulho() {
        switch (classeReino) {
            case MAMIFERO -> System.out.println("Tininonini");
            case ANFIBIO -> System.out.println("Brrrrrr");
            case AVE -> System.out.println("Kwak Kwak");
            case PEIXE -> System.out.println("Blub Blub Splash");
            case REPTIL -> System.out.println("Psssssss");
        }
    }

    // Metodo para comer
    public void comer(String alimento, double pesoGramas) {
        boolean podeComer = false;

        // Percorremos o array
        for (int i = 0; i < alimentacao.length; i++) {
            if (alimentacao[i].equalsIgnoreCase(alimento)) {
                podeComer = true;
            }
        }

        if (podeComer) {
            double pesoKg = pesoGramas / 1000.0;
            this.peso += pesoKg;
            System.out.println("O " + especie + " " + nome + " comeu " + alimento + ".");
            fazerBarulho();
        } else {
            System.out.println("O " + especie + " " + nome + " não comeu " + alimento + ".");
        }
    }


    // Mostrar dados do animal
    public void exibirDetalhes() {
        System.out.print("Nome: " + nome + " | Espécie: " + especie + " | País: " + paisOrigem + " | Peso: " + peso + " kg" + " | Classe: " + classeReino + " | Alimentação: ");

        // Mostrar manualmente os alimentos
        for (int i = 0; i < alimentacao.length; i++) {
            System.out.print(alimentacao[i]);
            if (i < alimentacao.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // para nova linha no fim
    }

    public double getPeso() {
        return peso;
    }
}
