package Ex05;

public class Main {
    public static void main(String [] args) {
        // a) Instanciar dois carros
        Carro carroFrota = new Carro("Mercedes", "amg", "preto", 2025);
        Carro carroPessoal = new Carro("Volvo", "xc40", "cinza", 2025);

        //invocar método ligar para ambos
        carroFrota.ligar();
        carroPessoal.ligar();
    }
}
