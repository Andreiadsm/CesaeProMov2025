package TrabalhoPratico;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static TrabalhoPratico.Funcoes.*;// invocar diretamente as funções

public class TrabalhoPratico {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        String admin = "ADMIN";
        String cliente = "CLIENTE";
        String tipoUtilizador = "";

        // Repete enquanto o tipo não for válido
        while (!tipoUtilizador.equalsIgnoreCase(admin) && !tipoUtilizador.equalsIgnoreCase(cliente)) {
            System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
            tipoUtilizador = input.nextLine();

            if (!tipoUtilizador.equalsIgnoreCase(admin) && !tipoUtilizador.equalsIgnoreCase(cliente)) {
                System.out.println("Utilizador inválido. Tente novamente.\n");
            }
        }

        if (tipoUtilizador.equalsIgnoreCase(admin)) {
            boolean loginValido = false;

            // Repete até o login ser válido
            while (!loginValido) {
                System.out.print("USERNAME: ");
                String username = input.nextLine();

                System.out.print("PASSWORD: ");
                String password = input.nextLine();

                String[][] logins = ficheiroParaMatrizLogins("Ficheiros/IMDV_AdminLogin.csv");

                // Percorrer a matriz para validar login
                for (int i = 0; i < logins.length; i++) {
                    if (logins[i][0].equals(username) && logins[i][1].equals(password)) {
                        loginValido = true;
                    }
                }

                if (!loginValido) {
                    System.out.println("Login inválido. Tente novamente.\n");
                }
            }

            System.out.println("Login com sucesso!\n");
            String[][] filmes = ficheiroParaMatriz("Ficheiros/IMDV.csv");
            menuAdmin(filmes);
        }

        else {// utilizador cliente
            String[][] filmes = ficheiroParaMatriz("Ficheiros/IMDV.csv");
            String[][] quiz = ficheiroParaMatrizQuiz("Ficheiros/Quiz.csv");
            menuCliente(filmes, quiz);
        }
    }
}