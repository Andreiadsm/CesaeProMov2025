package Ex03;

public class Main {
    public static void main(String[] args) {

        // Criar Animal 1
        Animal leao = new Animal(
                "Simba",
                "Leão",
                "África do Sul",
                190.0,
                new String[]{"carne", "frango", "peixe"},
                ClasseReino.MAMIFERO
        );

        // Criar Animal 2
        Animal rã = new Animal(
                "Kiko",
                "Rã Verde",
                "Brasil",
                0.8,
                new String[]{"insetos", "moscas", "larvas"},
                ClasseReino.ANFIBIO
        );

        System.out.println("========= DETALHES DOS ANIMAIS =========");
        leao.exibirDetalhes();
        rã.exibirDetalhes();

        System.out.println("\n========= TENTATIVA DE ALIMENTAÇÃO INCORRETA =========");
        leao.comer("alface", 300);   // alimento inválido
        rã.comer("banana", 100);     // alimento inválido

        System.out.println("\n========= TENTATIVA DE ALIMENTAÇÃO CORRETA =========");
        leao.comer("frango", 500);   // válido
        rã.comer("moscas", 50);      // válido

        System.out.println("\n========= ESTADO FINAL DOS ANIMAIS =========");
        leao.exibirDetalhes();
        rã.exibirDetalhes();

        System.out.println("\n============== FIM DA SIMULAÇÃO ==============");
    }
}
