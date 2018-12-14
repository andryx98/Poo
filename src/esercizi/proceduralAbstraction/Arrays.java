package esercizi.proceduralAbstraction;

public class Arrays {
    /**
     * The mission of this class is to provide a number of
     * standalone procedures that can be useful for manipulating
     * arrays of ints.
     */

    public static void main(String[] args) {
        int[] a = {10, 34, 2, 57, 21, 86, 43, 95};
        int x = 47;
        try {
            System.out.println("Ho trovato il valore x: " + search(a, x) + " nel vettore disordinato a");
        } catch (ValoreNonTrovatoException vnte) {
            vnte.printStackTrace();
        }
        try {
            System.out.println("Ho trovato il valore x: " + searchSorted(a, x) + " nel vettore a ordinato in modo crescente");
        } catch (ValoreNonTrovatoException vnt) {
            vnt.printStackTrace();
        }
    }

    /**
     * search x in a
     */
    public static int search(int[] a, int x) throws ValoreNonTrovatoException {
        int i = 0;
        int y = 0;
        String msg = "Il valore x non esiste nel vettore disordinato a!";
        while (i < a.length) {
            if (x == a[i]) {
                y = a[i];
                i++;
            } else {
                i++;
            }
        }
        if (y != x) {
            throw new ValoreNonTrovatoException(msg);
        } else {
            return y;
        }
    }

    /**
     * cerca il valore x nel vettore a, quando a è ordinato in modo crescente
     * restituisce il valore x
     *
     * @param a è un vettore che contiene 1 o più elementi
     * @param x è il valore da cercare dentro il vettore a
     * @throws ValoreNonTrovatoException se x non viene trovato nel vettore a
     */
    public static int searchSorted(int[] a, int x) throws ValoreNonTrovatoException {
        insertionSort(a);
        int i = 0;
        int y = 0;
        String msg = "Il valore x non esiste nel vettore a ordinato in modo crescente!";
        while (i < a.length) {
            if (x == a[i]) {
                y = a[i];
                i++;
            } else {
                i++;
            }
        }
        if (y != x) {
            throw new ValoreNonTrovatoException(msg);
        } else {
            return y;
        }
    }

    /**
     * insertionSort modifica il vettore a
     * ritorna il vettore a con le sue componenti ordinate in modo crescente
     *
     * @param a è un vettore di interi con almeno 1 o più elementi
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j);
                }
            }
        }
    }

    /**
     * swap scambia i valori dell'array a
     * ritorna il vettore a modificato
     *
     * @param a deve essere un vettore con 1 o più elementi
     * @param j è un indice del vettore sul quale verrà eseguito lo swap, deve essere compreso tra 0 e lunghezza -1
     */
    private static void swap(int[] a, int j) {
        int temp;
        temp = a[j];
        a[j] = a[j - 1];
        a[j - 1] = temp;
    }
}
