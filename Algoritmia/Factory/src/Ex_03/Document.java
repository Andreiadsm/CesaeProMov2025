package Ex_03;

abstract class Document {
    protected String autor;
    protected String nome;
    protected String extensao;

    public Document(String autor, String nome, String extensao) {
        this.autor = autor;
        this.nome = nome;
        this.extensao = extensao;
    }

    public void open() {
        System.out.println("Documento aberto do tipo " + extensao + ": " + nome);
    }

    public void save() {
        System.out.println("Documento guardado do tipo " + extensao + ": " + nome);
    }

    public void close() {
        System.out.println("Documento fechado do tipo " + extensao + ": " + nome);
    }
}
