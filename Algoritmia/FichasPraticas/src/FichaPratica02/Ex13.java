package FichaPratica02;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declara variáveis
        int horas, minutos;

        // Ler horas e minutos
        System.out.println("Introduza horas (0-24): "); //lê horas
        horas = input.nextInt();

        System.out.println("Introduza minutos (0-59): "); //lê minutos
        minutos = input.nextInt();

        //Converter para formato de 12h
        if (horas <= 12) { //manhã
            System.out.println(horas + ":" + minutos + "am");
        } else {// tarde
            horas = horas -12;
            System.out.println(horas + ":" + minutos + "pm");
        }
    }
}
