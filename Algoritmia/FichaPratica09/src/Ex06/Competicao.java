package Ex06;

public class Competicao {
    private String nome;
    private String pais;
    private Atleta[] listaAtletas;

    // Construtor com nome, país e número máximo de atletas
    public Competicao(String nome, String pais, int maxParticipantes) {
        this.nome = nome;
        this.pais = pais;
        this.listaAtletas = new Atleta[maxParticipantes];
    }

    // Método para inscrever um atleta (na primeira posição livre)
    public void inscreverAtleta(Atleta atletaNovo) {
        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] == null) {
                listaAtletas[i] = atletaNovo;
                System.out.println("Atleta " + atletaNovo.getNome() + " inscrito com sucesso em " + nome);
                return;
            }
        }
        System.out.println("Competição cheia! Não é possível inscrever mais atletas em " + nome);
    }

    // Método para listar todos os atletas inscritos
    public void listarParticipantes() {
        System.out.println("\n====== Participantes da competição: " + nome + " (" + pais + ") ======");
        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] != null) {
                listaAtletas[i].exibirDetalhes();
            }
        }
        System.out.println("===========================================================");
    }

    // Método para mostrar apenas os atletas cujo país é igual ao da competição
    public void atletasDaCasa() {
        System.out.println("\n------ Atletas da casa (" + pais + ") na competição: " + nome + " ------");
        boolean encontrou = false;

        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] != null && listaAtletas[i].getPaisOrigem().equalsIgnoreCase(pais)) {
                listaAtletas[i].exibirDetalhes();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum atleta da casa.");
        }

        System.out.println("-----------------------------------------------------------");
    }
}
