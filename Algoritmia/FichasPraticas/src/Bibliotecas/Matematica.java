package Bibliotecas;

public class Matematica {
    public static int modulo_diferenca_inteira (int a, int b) {
        int resultado;
        if (a > b){
            resultado = a - b;
        }
        else{
            resultado = b - a;
        }
        return resultado;
    }

    public static double pi(){
        return 3.1415926;
    }


}
