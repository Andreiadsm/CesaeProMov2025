package Ex02;

/**
 * Classe Conta Bancária - Representa uma Conta de um Banco, contém um saldo e pode fazer operações bancárias básicas.
 */
public class ContaBancaria {
    private String iban;
    private String titular;
    private double saldo = 0;
    private int anoAbertura = 2025;
    private double margemEmpréstimo = 0.5;
    private double valorDivida = 0;


    /**
     * Método construtor para <b>Conta Bancária</b>
     *
     * @param iban    IBAN - Identificador da <b>Conta Bancária</b>
     * @param titular Nome do Titular
     */
    public ContaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }

    /**
     * Método para depositar dinheiro
     *
     * @param valor Valor a depositar (€)
     */
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println(valor + " € depositados na conta " + this.iban);
    }

    /**
     * Método para levantar dinheiro
     *
     * @param valor Valor a levantar (€)
     */
    public void levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println(valor + " € levantados da conta " + this.iban);
        } else {
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Levantamento de " + valor + " € recusado.");
        }
    }

    /**
     * Método que permite transferir dinheiro de uma Conta para a outra
     *
     * @param contaDestino Conta que vai receber o dinheiro
     * @param valor        Valor a transferir (€)
     */
    public void transferencia(ContaBancaria contaDestino, double valor) {
        if (this.saldo >= valor) { // Transferência válida
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println(valor + " € transferidos de " + this.iban + " para " + contaDestino.iban);
        } else { // Transferência inválida
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Transferência de " + valor + " € para " + contaDestino.iban + " recusada.");
        }
    }

    /**
     * Método para exibir os detalhes de uma Conta
     */
    public void exibirDetalhes() {
        System.out.println(this.iban + " | " + this.titular + " | Saldo: " + this.saldo + " €");
    }

    /**
     * Método para pedir empréstimo
     */
    public void pedirEmprestimo(double valorEmprestimo) {
        double limite = this.saldo * this.margemEmpréstimo;

        if (this.valorDivida > 0) {
            System.out.println("Empréstimo recusado. Já existe um valor em dívida: " + this.valorDivida + "€.");
        } else if (valorEmprestimo > limite) {
            System.out.println("Empréstimo recusado. O valor pedido (" + valorEmprestimo + "€) excede o limite de " + limite + "€.");
        } else {
            this.saldo += valorEmprestimo;
            this.valorDivida = valorEmprestimo;
            System.out.println("Empréstimo concedido: " + valorEmprestimo + "€. Novo saldo: " + this.saldo + "€. Dívida atual: " + this.valorDivida + "€.");
        }
    }


    public void amortizarEmprestimo(double valorAmortizar) {
        if (this.valorDivida == 0) {
            System.out.println("Não existe dívida para amortizar.");
        } else if (valorAmortizar > this.valorDivida) {
            System.out.println("Erro: valor a amortizar (" + valorAmortizar + "€) é superior à dívida (" + this.valorDivida + "€).");
        } else if (valorAmortizar > this.saldo) {
            System.out.println("Erro: saldo insuficiente (" + this.saldo + "€) para amortizar " + valorAmortizar + "€.");
        } else {
            this.saldo -= valorAmortizar;
            this.valorDivida -= valorAmortizar;
            System.out.println("Amortização confirmada: " + valorAmortizar + "€. Saldo atual: " + this.saldo + "€. Dívida restante: " + this.valorDivida + "€.");
        }
    }
}