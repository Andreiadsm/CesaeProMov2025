package TrabalhoPratico;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static TrabalhoPratico.Funcoes.*;// invocar diretamente as funções

public class TrabalhoPratico {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in); // Ferramenta para ler dados do utilizador

        String tipoUtilizador = "";

        // Repetir enquanto o tipo não for válido
        while (!tipoUtilizador.equalsIgnoreCase("ADMIN") && !tipoUtilizador.equalsIgnoreCase("CLIENTE")) {
            System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
            tipoUtilizador = input.nextLine();

            if (!tipoUtilizador.equalsIgnoreCase("ADMIN") && !tipoUtilizador.equalsIgnoreCase("CLIENTE")) {
                System.out.println("Tipo de utilizador inválido. Tente novamente.\n");
            }
        }

        // Se o utilizador for ADMIN
        if (tipoUtilizador.equalsIgnoreCase("ADMIN")) {
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

        } else { // é ClIENTE
            String[][] filmes = ficheiroParaMatriz();
            menuCliente(filmes);

            String[][] quiz = ficheiroParaMatrizQuiz("Ficheiros/IMDV_Quiz.csv");

        }
    }
}