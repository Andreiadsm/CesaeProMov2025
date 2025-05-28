package Ex_09;

import Ex09.Funcionario;

public class Main {
    public static void main(String[] args) {

        // Instanciar um funcionário com dados iniciais
        Funcionario funcionario = new Funcionario("Joana Silva", "joana.silva@email.com", "Marketing", 1200);

        System.out.println("---- Dados iniciais ----");
        funcionario.exibirDados();

        // Aumentar o salário em 15%
        funcionario.aumentarSalario(15);

        System.out.println("\n---- Dados após aumento salarial de 15% ----");
        funcionario.exibirDados();
    }
}
