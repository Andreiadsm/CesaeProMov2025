package FichaPratica06;

import java.util.Scanner;

public class Ex05 {

    /**
     * Função preenche um array
     * @param tamanho a determinar
     * @return numeros em cada posição
     */
    public static int[] lerVetorInteiros(int tamanho) {
        int[] vetorPreencher = new int[tamanho];

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Ler vetor
        for (int i = 0; i < vetorPreencher.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetorPreencher[i] = input.nextInt();
        }

        return vetorPreencher;
    }

    /**
     * funçao de imprimir na consola
     * @param vetor
     */
    public static void imprimirVetorInteiros(int[] vetor){

        // Imprimir vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "]: " + vetor[i]);
        }

    }


    /**
     * Função que determina qual num
     * @param vetor de numeros inteiros
     * @return o numero maior
     */
    public static int maior (int [] vetor){
        int maior = vetor[0];

        for (int i=0; i< vetor.length; i++) {
            if (vetor[i]> maior) {
                maior = vetor[i];
            }
            return maior;
        }
    }

    public static void imprimirMaior(int[] vetor){
        int maior;
        System.out.print(maior);
        }

    /**
     * Função que determina qual num
     * @param vetor de numeros inteiros
     * @return o numero menor
     */
    public static int menor (int [] vetor){
        int menor = vetor[0];

        for (int i=0; i< vetor.length; i++) {
            if (vetor[i]< menor) {
                menor = vetor[i];
            }
            return menor;
        }
    }

    public static void imprimirMenor(int[] vetor){
        int menor;
        System.out.print(menor);
    }

    public static boolean vetorCrescente(int[] vetor){
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] <= vetor[i - 1]) {
                return false;
            }
    }
        return true;
}
