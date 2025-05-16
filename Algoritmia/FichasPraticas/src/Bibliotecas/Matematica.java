package Bibliotecas;

import java.util.Scanner;

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

    /**
     * Função que lê um número inteiro e positivo da consola
     * @return Número inteiro e positivo
     */
    public static int lerInteiroPositivo () {
        Scanner input = new Scanner(System.in);

        int numeroUtilizador;

        do{
        System.out.println("Introduza um número positivo: ");
        numeroUtilizador= input.nextInt();
        } while (numeroUtilizador < 0);

        return numeroUtilizador;
    }

}
