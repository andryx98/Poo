package esercizi.ripassoJava.sort;

public class MyBetterSort {
    public enum ModoDiOrdinare {
        Crescente,
        Decrescente

    }

    public static void main(String args[]) {
        int[] datiDaOrdinare = {10, 23, 32, 1, 42, 59, 67, 84};
        ModoDiOrdinare dir = ModoDiOrdinare.Decrescente;
        insertionSort(datiDaOrdinare, dir);
        stampa(datiDaOrdinare);
    }

    /**
     * stampa serve per rappresentare il vettore datiDaOrdinare
     * mostra sullo standard output il vettore datiDaOrdinare
     * @param datiDaOrdinare è un vettore con almeno 1 o più elementi
     */


    public static void stampa(int[] datiDaOrdinare) {
        for (int i:datiDaOrdinare) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * InsertionSort ordina il vettore datiDaOrdinare
     * restituisce datiDaOrdinare modificato
     * @param datiDaOrdinare è un vettore che contiene almeno 1 o più elementi
     */

    public static void insertionSort(int[] datiDaOrdinare, ModoDiOrdinare dir) {
        for (int i = 1; i < datiDaOrdinare.length; i++) {
            for (int j = i; j > 0; j--) {
                direzione(datiDaOrdinare, dir, j);
            }
        }
    }

    /**
     * direzione sceglie il modo di ordinare da applicare al vettore datiDaOrdinare
     * restituisce datiDaOrdinare modificato
     * @param datiDaOrdinare è un vettore con 1 o più elementi
     * @param dir è il modo di ordinare scelto
     * @param j serve per scandire il vettore datiDaOrdinare
     */

    private static void direzione(int[] datiDaOrdinare, ModoDiOrdinare dir, int j) {
        switch (dir) {
            case Crescente: {
                if (datiDaOrdinare[j] < datiDaOrdinare[j - 1]) {
                    swap(datiDaOrdinare, j);
                }
            } break;
            case Decrescente: {
                if (datiDaOrdinare[j] > datiDaOrdinare[j - 1]) {
                    swap(datiDaOrdinare, j);
                }
            } break;
        }
    }

    /**
     * swap
     * @param datiDaOrdinare
     * @param j
     */

    private static void swap(int[] datiDaOrdinare, int j) {
        int temp;
        temp = datiDaOrdinare[j];
        datiDaOrdinare[j] = datiDaOrdinare[j - 1];
        datiDaOrdinare[j - 1] = temp;
    }
}
