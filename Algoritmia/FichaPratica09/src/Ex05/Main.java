package Ex05;

public class Main {
    public static void main(String[] args) {
        // a) Criar 4 pessoas
        Pessoa p1 = new Pessoa("Andreia", 38, "Porto", "andreia@mail.com", "912345678");
        Pessoa p2 = new Pessoa("Carlos", 40, "Lisboa", "carlos@mail.com", "913333333");
        Pessoa p3 = new Pessoa("Joana", 25, "Porto", "joana@mail.com", "914444444");
        Pessoa p4 = new Pessoa("Bruno", 50, "Braga", "bruno@mail.com", "915555555");

        // b) Criar agenda com 5 espaços
        Agenda agenda = new Agenda(5);

        System.out.println("============== AGENDA INICIAL ==============");
        agenda.exibirDetalhes();

        // c) Adicionar 2 pessoas
        agenda.adicionarPessoa(p1);
        agenda.adicionarPessoa(p2);

        System.out.println("\n========= DEPOIS DE ADICIONAR 2 CONTACTOS =========");
        agenda.exibirDetalhes();

        // e) Adicionar mais 2
        agenda.adicionarPessoa(p3);
        agenda.adicionarPessoa(p4);

        System.out.println("\n========= DEPOIS DE ADICIONAR MAIS 2 CONTACTOS =========");
        agenda.exibirDetalhes();

        // g) Pesquisa por cidade
        System.out.println("\n========= PESQUISA POR CIDADE: PORTO =========");
        agenda.pesquisarContactos("Porto");

    }
}
