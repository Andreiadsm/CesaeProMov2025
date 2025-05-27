package Ex06;

public class Main {
        public static void main(String [] args) {
        //Instanciar dois livros
            Livro l1 = new Livro("Cem anos de solidão", "Jose Garcia Marquez", "romance", 448,978-85-0101-207-4);
            Livro l2 = new Livro ("Becoming, a minha história", "Michelle Obama", "biografia", 480, 978-989-784-278-8);

        //invocar método para ambos
            l1.exibirDetalhes();
            l2.exibirDetalhes();
        }
}

