package FichaPratica02;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declara variáveis
        int horas, minutos;

        // Ler horas e minutos
        System.out.println("Introduza horas: "); //lê horas
        horas = input.nextInt(); //Lê minutos

        System.out.println("Introduza minutos: "); //lê minutos
        minutos = input.nextInt();

        //Apresentar horas e minutos no sistema de 12h
        if (horas <= 12) {
            System.out.println(horas + ":" + minutos + "am");
        }
        else { //horas maior que 12
            System.out.println(horas + ":" + minutos + "pm");
        }
    }
}
