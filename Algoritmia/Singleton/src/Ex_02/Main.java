package Ex_02;

import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {
        Logger l1 = new Logger ("ficheiro.txt");
        l1.logDaMensagem("O programa começou");
        l1.logDaMensagem(("Continua a executar...");
    }
}
