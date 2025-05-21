package TrabalhoPratico;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static TrabalhoPratico.Funcoes.*;// invocar diretamente as funções

public class TrabalhoPratico {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);// Importar scanner para ler dados do utilizador

        System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
        String tipoUtilizador = input.nextLine();

        if (tipoUtilizador.equalsIgnoreCase("ADMIN")) {// Se o utilizador for ADMIN
            String username;
            String password;
            boolean loginValido = false;

            while (!loginValido) { //repete enquanto não for válido
                System.out.print("USERNAME: ");
                username = input.nextLine();

                System.out.print("PASSWORD: ");
                password = input.nextLine();

                String[][] logins = ficheiroParaMatrizLogins("Ficheiros/IMDV_AdminLogin.csv");

                loginValido = validarLogin(logins, username, password); //valida as credenciais

                if (!loginValido) {// avisa o utilizador se for inválido
                    System.out.println("Login inválido. Tente novamente.\n");
                }
            }

            // Se o login for aceite, carregar os dados dos filmes e mostrar o menu de admin
            System.out.println("Login com sucesso!\n");

            String[][] filmes = ficheiroParaMatriz("Ficheiros/IMDV_Filmes.csv");

            // Mostrar o menu do administrador
            menuAdmin(filmes);

            return; // Termina aqui o programa para não avançar para o CLIENTE
        }

        // Caso o utilizador seja CLIENTE
        if (tipoUtilizador.equalsIgnoreCase("CLIENTE")) {
            System.out.println("Bem-vindo CLIENTE!");
            // Chamar o menuCliente()
            return;
        }

        // Se o utilizador introduzir algo que não seja ADMIN ou CLIENTE
        System.out.println("Tipo de utilizador inválido.");
    }
}