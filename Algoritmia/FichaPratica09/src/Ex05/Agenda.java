package Ex05;

public class Agenda {
    private int anoCriacao = 2025;
    private Pessoa[] listaContactos;
    private int totalContactos = 0;

    public Agenda(int tamanhoLista) {
        listaContactos = new Pessoa[tamanhoLista];
    }

    public void adicionarPessoa(Pessoa novaPessoa) {
        if (totalContactos < listaContactos.length) {
            listaContactos[totalContactos] = novaPessoa;
            totalContactos++;
        } else {
            System.out.println("Agenda cheia. Não é possível adicionar mais contactos.");
        }
    }

    public void listarContactos() {
        System.out.println("Lista de Contactos:");
        for (int i = 0; i < totalContactos; i++) {
            listaContactos[i].exibirDetalhes();
        }
    }

    public void pesquisarCidade (String cidadePesquisa) {
        System.out.println("Contactos da cidade: " + cidadePesquisa);
        for (int i = 0; i < totalContactos; i++) {
            if (listaContactos[i].getCidade().equalsIgnoreCase(cidadePesquisa)) {
                listaContactos[i].exibirDetalhes();
            }
        }
    }

    public void exibirDetalhes() {
        System.out.println("Ano de Criação: " + anoCriacao);
        System.out.println("Total de contactos: " + totalContactos + "/" + listaContactos.length);
        System.out.println("Contactos:");
        for (int i = 0; i < totalContactos; i++) {
            listaContactos[i].exibirDetalhes();
        }
    }

}
