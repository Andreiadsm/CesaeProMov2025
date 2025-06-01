package Ex06;

public class Main {
    public static void main(String[] args) {

        // a) Instanciar 6 Atletas
        Atleta atleta1 = new Atleta("Joana Silva", "Natação", 1.65, 58, "Portugal", 10);
        Atleta atleta2 = new Atleta("Carlos Mendes", "Atletismo", 1.80, 70, "Espanha", 5);
        Atleta atleta3 = new Atleta("Yuki Tanaka", "Judo", 1.60, 52, "Japão", 3);
        Atleta atleta4 = new Atleta("Ana Costa", "Ténis", 1.70, 60, "Portugal", 12);
        Atleta atleta5 = new Atleta("Liam Brown", "Boxe", 1.85, 80, "Inglaterra", 8);
        Atleta atleta6 = new Atleta("Pedro Oliveira", "Ciclismo", 1.75, 65, "Portugal", 20);

        // b) Instanciar 2 Competições
        Competicao compLisboa = new Competicao("Jogos da Juventude", "Portugal", 5);
        Competicao compTokyo = new Competicao("Campeonato Asiático", "Japão", 5);

        // c) Adicionar 2 atletas à primeira competição
        compLisboa.inscreverAtleta(atleta1);
        compLisboa.inscreverAtleta(atleta2);

        // d) Adicionar mais 2 atletas à segunda competição
        compTokyo.inscreverAtleta(atleta3);
        compTokyo.inscreverAtleta(atleta5);

        // e) Listar os participantes de ambas as competições
        compLisboa.listarParticipantes();
        compTokyo.listarParticipantes();

        // f) Adicionar mais atletas
        compLisboa.inscreverAtleta(atleta4);
        compLisboa.inscreverAtleta(atleta6);

        // g) Listar novamente
        compLisboa.listarParticipantes();

        // h) Mostrar atletas da casa em cada competição
        compLisboa.atletasDaCasa();
        compTokyo.atletasDaCasa();
    }
}
