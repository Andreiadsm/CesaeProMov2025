package Ex04;

public class Imovel {
    private String rua;
    private int numeroPorta;
    private String cidade;
    private TipoImovel tipo;
    private Acabamento acabamento;
    private double areaTotal;
    private int numQuartos;
    private int numCasasBanho;
    private double areaPiscina;

    public Imovel(String rua, int numeroPorta, String cidade, TipoImovel tipo,
                  Acabamento acabamento, double areaTotal, int numQuartos, int numCasasBanho, double areaPiscina) {
        this.rua = rua;
        this.numeroPorta = numeroPorta;
        this.cidade = cidade;
        this.tipo = tipo;
        this.acabamento = acabamento;
        this.areaTotal = areaTotal;
        this.numQuartos = numQuartos;
        this.numCasasBanho = numCasasBanho;
        this.areaPiscina = areaPiscina;
    }

    public double calcularValor() {
        double precoBasePorM2 = 0;

        switch (tipo) {
            case APARTAMENTO:
                precoBasePorM2 = 1000;
                break;
            case CASA:
                precoBasePorM2 = 3000;
                break;
            case MANSAO:
                precoBasePorM2 = 5000;
                break;
        }

        double valorTotal = precoBasePorM2 * areaTotal;

        switch (acabamento) {
            case PARA_RESTAURO:
                valorTotal *= 0.5;
                break;
            case USADA:
                valorTotal *= 0.9;
                break;
            case NOVA:
                break; // sem alteração
            case NOVA_COM_ALTO_ACABAMENTO:
                valorTotal *= 1.25;
                break;
        }

        valorTotal += numQuartos * 7500;
        valorTotal += numCasasBanho * 10500;
        valorTotal += areaPiscina * 1000;

        return valorTotal;
    }

    public void alterarAcabamento(Acabamento novoAcabamento) {
        this.acabamento = novoAcabamento;
    }

    public Imovel compararImoveis(Imovel outro) {
        if (this.calcularValor() >= outro.calcularValor()) {
            return this;
        } else {
            return outro;
        }
    }

    public void exibirDetalhes() {
        System.out.println("Imóvel em " + rua + ", nº " + numeroPorta + ", " + cidade);
        System.out.println("Tipo: " + tipo + " | Acabamento: " + acabamento);
        System.out.println("Área: " + areaTotal + " m² | Quartos: " + numQuartos + " | Casas de Banho: " + numCasasBanho + " | Piscina: " + areaPiscina + " m²");
        System.out.println("Valor estimado: " + calcularValor() + " €");
    }
}
