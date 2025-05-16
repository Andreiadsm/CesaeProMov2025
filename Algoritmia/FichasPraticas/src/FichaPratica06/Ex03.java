package FichaPratica06;

public class Ex03 {

    /**
     * Função que determina se um número é ou não par
     * @param num Númeor a analisar
     * @return true se par // false se ímpar
     */
    public static boolean par(int num){
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que determina se um númeor é positivo ou negativo
     * @param num Número a analisar
     * @return true se positivo || false se negativo
     */
    public static boolean positivo (int num) {
        if (num>=0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que determina se um número é primo ou não
     * @param num Número a analisar
     * @return true se positivo || false se negativo
     */
    public static boolean primo (int num) {
        for (int divisor = 2; divisor<num; divisor++) {
            if (num % divisor == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Função que determina se um número é perfeito ou não
     * @param num Número a analisar
     * @return true se perfeito || false se negativo
     */
    public static boolean perfeito (int num) {
        int somaDivisores = 0;

        for (int divisor = 1; divisor < num; divisor++) {
            if (num % divisor == 0) {
                somaDivisores += divisor;
            }
        }

        if (somaDivisores == num) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Função que determina se um número é triangular ou não
     * @param num Número a analisar
     * @return true se triangular || false se negativo
     */
    public static boolean triangular (int num) {
        int triangulares =0;

        for (int i = 1; triangulares < num; i++) {
            triangulares+= 1;
            if (triangulares == num){
                return true;
            }
        }

        return false;
    }
}
