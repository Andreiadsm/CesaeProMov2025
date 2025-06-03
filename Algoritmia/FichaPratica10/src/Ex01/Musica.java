package Ex01;

public class Musica {
    private String titulo;
    private String genero;
    private String artista;
    private int duracaoSeg;

    public Musica(String titulo, String genero, String artista, int duracaoSeg) {
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
        this.duracaoSeg = duracaoSeg;
    }

    public int getDuracaoSeg() {
        return duracaoSeg;
    }

    public void exibirDetalhes() {
        System.out.println(this.titulo + " | " + this.genero + " | " + this.artista + " | " + this.duracaoSeg);
    }
}
