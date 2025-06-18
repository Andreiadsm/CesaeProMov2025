package Ex_01;

public class DatabaseConection {
    // Atributo de Classe - Local de armazenamento para o único objeto que vai existir desta classe
    private static DatabaseConection instance;

    // Atributos de instância - Atributos "normais" que estamos habituados
    private String connectionString;

    // Construtor "normal", fica privado
    private DatabaseConection(String connectionString){
        this.connectionString = connectionString;
    }

    // Construtor tuning, que permite controlar se criamos o primeiro objeto (novo) ou retornamos o que já existe
    public static DatabaseConection getInstance(String connectionString) {
        if (instance == null) {
            instance = new DatabaseConection(connectionString);
        }
        return instance;
    }

    public void connect(){
        //Código para conectar à base de dados usando a connectionString
        System.out.println("Conectado à base de dados: " + connectionString);
    }

    public void disconnect () {
        //Código para desconectar da base de dados
        System.out.println("Desconectado da base de dados: " + connectionString);
    }

    //Outros métodos da classe
}
