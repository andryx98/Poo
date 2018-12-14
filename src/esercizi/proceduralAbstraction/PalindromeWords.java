package esercizi.proceduralAbstraction;

public class PalindromeWords {
    public static void main(String[] args) throws EmptyStringException {
        String word = "";
        stampa(word);
    }

    /**
     * stampa serve per rappresentare l'output
     * @param word è una stringa di caratteri alfabetici
     */

    private static void stampa(String word) throws EmptyStringException {
        if (!isPalindrome(word)) {
            System.out.print("La stringa word non è palindroma");
        } else {
            System.out.print("La stringa word è palindroma");
        }
    }

    /**
     * isPalindrome verifica se una stringa è palindroma oppure no
     * @return un valore booleano
     * @param word è una stringa di caratteri alfabetici
     */

    public static boolean isPalindrome(String word) throws EmptyStringException {
        String msg = "La string è vuota";
        try {
            if (word == "") {
                throw new EmptyStringException(msg);
            } else {
                for (int i = 0; i < word.length() / 2; i++) {
                    if (word.charAt(i) != word.charAt(word.length() - (i + 1))) {
                        return false;
                    }
                }
                return true;
            }
        } catch (EmptyStringException ese) {
            ese.printStackTrace();
        }
        return false;
    }
}
