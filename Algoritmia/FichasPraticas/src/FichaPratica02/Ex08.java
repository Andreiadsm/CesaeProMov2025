package FichaPratica02;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        //Declarar variáveis
        double nota1, nota2, nota3, mediaponderada;

        //ler valores
        System.out.print("Insira a nota 1: ");
        nota1 = input.nextDouble();

        System.out.print("Insira a nota2: ");
        nota2 = input.nextDouble();

        System.out.print("Insira a nota 3: ");
        nota3 = input.nextDouble();

        //Media ponderada
        mediaponderada = (nota1 * 0.25) + (nota2 * 0.35) + (nota3 * 0.4);
        System.out.println("Média ponderada: " + mediaponderada);

        //Condição
        if (mediaponderada <= 9.5) {
            System.out.println("não aprovado");
        }
        else {
            System.out.println("aprovado");
        }

    }
}
