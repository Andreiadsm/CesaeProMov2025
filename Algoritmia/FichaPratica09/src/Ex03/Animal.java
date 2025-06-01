package Ex03;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double peso;
    private String[] alimentacao;
    private ClasseReino classeReino;

    // Construtor
    public Animal(String nome, String especie, String paisOrigem, double peso, String[] alimentacao, ClasseReino classeReino) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.classeReino = classeReino;
    }

    // Método que faz barulho com switch-case
    public void fazerBarulho() {
        System.out.print("O " + especie + " " + nome + " faz barulho: ");
        switch (classeReino) {
            case MAMIFERO:
                System.out.println("Tininoninoni");
                break;
            case ANFIBIO:
                System.out.println("Brrrrrr");
                break;
            case AVE:
                System.out.println("Kwak Kwak");
                break;
            case PEIXE:
                System.out.println("Blub Blub Splash");
                break;
            case REPTIL:
                System.out.println("Psssssss");
                break;
            default:
                System.out.println("Som desconhecido");
        }
    }

    // Metodo para comer
    public void comer(String alimento, double pesoGramas) {
        boolean gostou = false;

        for (int i = 0; i < alimentacao.length; i++) {
            if (alimentacao[i].equalsIgnoreCase(alimento)) {
                gostou = true;
            }
        }

        if (gostou) {
            this.peso += pesoGramas/ 1000;//para passar gr para kg
            System.out.println("O " + especie + " " + nome + " comeu " + alimento + " e agora pesa " + this.peso + " kg.");
            fazerBarulho();
        } else {
            System.out.println("O " + especie + " " + nome + " não comeu " + alimento + " porque não gosta.");
        }
    }

    // Mostrar detalhes
    public void exibirDetalhes() {
        System.out.print("Nome: " + nome + " | Espécie: " + especie + " | País: " + paisOrigem +
                " | Peso: " + peso + " kg | Classe: " + classeReino + " | Alimentação: ");
        for (int i = 0; i < alimentacao.length; i++) {
            System.out.print(alimentacao[i]);
            if (i < alimentacao.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // nova linha
    }

    // Getter do peso
    public double getPeso() {
        return peso;
    }
}
