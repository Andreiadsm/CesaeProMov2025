package Ex04;

public class Main {
    public static void main(String[] args) {
        Imovel imovel1 = new Imovel("Rua Oliveira", 11, "Porto", TipoImovel.CASA, Acabamento.USADA, 160, 3, 2, 10);

        Imovel imovel2 = new Imovel("Av. Marquês", 50, "Lisboa", TipoImovel.MANSAO, Acabamento.NOVA_COM_ALTO_ACABAMENTO, 280, 6, 4, 40);

        System.out.println("---- Detalhes dos Imóveis ----");
        imovel1.exibirDetalhes();
        System.out.println("------------------------");
        imovel2.exibirDetalhes();

        System.out.println("\n---- Imóvel mais caro ----");
        Imovel maisCaro = imovel1.compararImoveis(imovel2);
        maisCaro.exibirDetalhes();
    }
}

