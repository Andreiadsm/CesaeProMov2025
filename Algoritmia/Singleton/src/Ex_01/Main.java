package Ex_01;

public class Main {
    public static void main(String [] args){
        DatabaseConection db1 = DatabaseConection.getInstance("localhost: 8000");
        db1.connect();

        DatabaseConection db2 = DatabaseConection.getInstance("localhost: 5376");
        db1.connect();
    }

}
