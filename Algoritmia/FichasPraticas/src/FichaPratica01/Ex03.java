package FichaPratica01;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        //Declarar variáveis
        int comprimento, largura, perimetro, area;

        //Ler dimensões
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Introduz a altura do retangulo: ");
            comprimento = input.nextInt();

            System.out.print("Introduz a largura do retangulo: ");
            largura = input.nextInt();

            //Calcular e apresentar o perimetro
            perimetro = comprimento + comprimento + largura + largura;

            //Apresentar o resultado
            System.out.println("perimetro" + perimetro);

            //Calcular e apresentar a area
            area = comprimento * largura;

            //Apresentar o resultado
            System.out.println("area" + area);
        }
    }
}
