package Ex05;

public class Main {
    public static void main(String[] args) {

        // a) Instanciar 4 Pessoas
        Pessoa pessoa1 = new Pessoa("Joaquim", 30, "Porto", "quim@mail.pt", 911222333);
        Pessoa pessoa2 = new Pessoa("Joana", 28, "Algarve", "joana@mail.pt", 922333444);
        Pessoa pessoa3 = new Pessoa("José", 40, "Porto", "ze@mail.pt", 933111222);
        Pessoa pessoa4 = new Pessoa("Sofia", 18, "Lisboa", "sofia@mail.pt", 911888999);

        // b) Instanciar a Agenda
        Agenda aMinhaAgenda = new Agenda(10);

        // c) Adicionar 2 pessoas
        aMinhaAgenda.adicionarPessoa(pessoa1);
        aMinhaAgenda.adicionarPessoa(pessoa2);

        // d) Listar os contactos
        System.out.println("\n===== LISTAGEM INICIAL =====");
        aMinhaAgenda.listarContactos();

        // e) Adicionar mais 2 pessoas
        aMinhaAgenda.adicionarPessoa(pessoa3);
        aMinhaAgenda.adicionarPessoa(pessoa4);

        // f) Listar novamente
        System.out.println("\n===== LISTAGEM FINAL =====");
        aMinhaAgenda.listarContactos();

        // g) Pesquisar por cidade
        System.out.println("\n===== CONTACTOS DO PORTO =====");
        aMinhaAgenda.pesquisarCidade("Porto");

        System.out.println("\n===== CONTACTOS DE LISBOA =====");
        aMinhaAgenda.pesquisarCidade("Lisboa");

        System.out.println("\n===== CONTACTOS DO FUNCHAL =====");
        aMinhaAgenda.pesquisarCidade("Funchal");
    }
}
