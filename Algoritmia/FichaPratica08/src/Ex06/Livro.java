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

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo + " | Autor: " + autor + " | Categoria: " + categoria + " | Nº de Páginas: " + numPaginas + " | ISBN: " + ISBN);
    }

}