package Ex06;

public class Atleta {
        private String nome;
        private String modalidade;
        private double altura;
        private double peso;
        private String paisOrigem;
        private int rankingMundial;

        public Atleta(String nome, String modalidade, double altura, double peso, String paisOrigem, int rankingMundial) {
            this.nome = nome;
            this.modalidade = modalidade;
            this.altura = altura;
            this.peso = peso;
            this.paisOrigem = paisOrigem;
            this.rankingMundial = rankingMundial;
        }

        public String getPaisOrigem() {
            return paisOrigem;
        }

        public void exibirDetalhes() {
            System.out.println("Nome: " + nome + " | Modalidade: " + modalidade + " | Altura: " + altura + "m | Peso: " + peso + "kg" +
                    " | País: " + paisOrigem + " | Ranking Mundial: " + rankingMundial);
        }

        public String getNome() {
        return nome;
        }
}


