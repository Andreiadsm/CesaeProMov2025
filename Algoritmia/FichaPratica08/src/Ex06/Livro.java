package Ex06;

public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int numPaginas;
    private int ISBN;

    public Livro(String titulo, String autor, String categoria, int numPaginas, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + this.titulo + " | Autor: " + this.autor + " | Categoria: " + this.categoria + " | Nº de Páginas: " + this.numPaginas + " | ISBN: " + this.ISBN);
    }

}