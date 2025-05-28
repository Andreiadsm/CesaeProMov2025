package Ex03;

public class Main {
    public static void main(String[] args) {
        String[] alimentosLeao = {"carne", "frango", "peixe"};
        Animal leao = new Animal("Simba", "Leão", "África do Sul", 190.0, alimentosLeao, ClasseReino.MAMIFERO);

        System.out.println("---- Dados do Animal ----");
        leao.exibirDetalhes();

        // b) O animal faz barulho
        System.out.println("\nBarulho:");
        leao.fazerBarulho();

        // c) Tentar alimentar com alimento que não gosta
        System.out.println("\nTentativa com alimento errado:");
        double pesoAntes = leao.getPeso();
        leao.comer("ervas", 500); // 500g de ervas
        double pesoDepois = leao.getPeso();
        System.out.println("Peso antes: " + pesoAntes + " kg | Peso depois: " + pesoDepois + " kg");

        // d) Alimentar com alimento que gosta
        System.out.println("\nAlimentação correta:");
        leao.comer("carne", 1000); // 1kg de carne
        leao.exibirDetalhes();
    }
}
