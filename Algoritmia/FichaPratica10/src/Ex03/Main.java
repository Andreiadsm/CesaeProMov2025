package Ex03;

public class Main {
    public static void main(String[] args) {
        Peixe peixe1 = new Peixe("salmão", 2, 15.9 );
        Peixe peixe2 = new Peixe("dourada", 3, 19.9 );
        Peixe peixe3 = new Peixe("robalo", 4, 24.9 );

        Marisco marisco1 = new Marisco("camarão tigre", 1, 13);
        Marisco marisco2 = new Marisco("berbigão", 2, 23.5);
        Marisco marisco3 = new Marisco("santola", 3, 33);

        BarcoPesca barco1 = new BarcoPesca("Marisol", "azul", "2020", 5,25 );

        barco1.pescarPeixe(peixe1);
        barco1.pescarPeixe(peixe2);
        barco1.pescarPeixe(peixe3);
        barco1.pescarMarisco(marisco1);
        barco1.pescarMarisco(marisco2);
        barco1.pescarMarisco(marisco3);

        // Imprimir relatório
        barco1.imprimirRelatorio();

    }
}





