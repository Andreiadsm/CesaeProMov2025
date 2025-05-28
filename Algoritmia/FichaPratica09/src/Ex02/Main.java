package Ex02;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("IBAN 1050 9385 483 22", "Ana Silva");
        ContaBancaria conta2 = new ContaBancaria("IBAN 1050 4545 456 44", "Pedro Pereira");
        ContaBancaria conta3 = new ContaBancaria("IBAN 1050 7546 879 55", "Antónia Félix");

        System.out.println("_______________________________________");
        conta1.exibirDetalhes();
        conta2.exibirDetalhes();
        conta3.exibirDetalhes();
        System.out.println("_______________________________________");

        // Fazer 3 depósitos
        conta1.depositar(500);
        conta2.depositar(10);
        conta3.depositar(2000);

        System.out.println("_______________________________________");
        conta1.exibirDetalhes();
        conta2.exibirDetalhes();
        conta3.exibirDetalhes();
        System.out.println("_______________________________________");

        conta1.pedirEmprestimo(10000);
        conta2.pedirEmprestimo(5000);
        System.out.println("_______________________________________");
        conta1.amortizarEmprestimo(250);
        conta2.amortizarEmprestimo(100);
        System.out.println("_______________________________________");
        conta1.exibirDetalhes();
        conta2.exibirDetalhes();
        conta3.exibirDetalhes();
        System.out.println("_______________________________________");

    }
}