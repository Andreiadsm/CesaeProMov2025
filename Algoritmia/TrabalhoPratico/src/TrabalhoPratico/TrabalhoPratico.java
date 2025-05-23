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
                System.out.println("Tipo de utilizador inválido. Tente novamente.\n");
            }
        }

        // ADMIN
        if (tipoUtilizador.equalsIgnoreCase(admin)) {
            String username;
            String password;
            boolean loginValido = false;

            while (!loginValido) {
                System.out.print("USERNAME: ");
                username = input.nextLine();

                System.out.print("PASSWORD: ");
                password = input.nextLine();

                String[][] logins = ficheiroParaMatrizLogins("Ficheiros/IMDV_AdminLogin.csv");

                loginValido = validarLogin(logins, username, password);

                if (!loginValido) {
                    System.out.println("Login inválido. Tente novamente.\n");
                }
            }

            System.out.println("Login com sucesso!\n");
            String[][] filmes = ficheiroParaMatriz("Ficheiros/IMDV.csv");
            menuAdmin(filmes);
        }

        // CLIENTE
        else {
            String[][] filmes = ficheiroParaMatriz("Ficheiros/IMDV.csv");
            String[][] quiz = ficheiroParaMatrizQuiz("Ficheiros/Quiz.csv");
            menuCliente(filmes, quiz);
            imprimirCopyright("Ficheiros/IMDV_Copyright.txt");
        }
    }
}