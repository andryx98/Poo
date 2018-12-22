package esercizi.ripassoJava.sort;

import java.util.Vector;

public class VectorSort {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i=0; i<args.length; i++) {
            vector.add(Integer.parseInt(args[i]));
        }
        insertionSort(vector);
        stampa(vector);
    }

    /**
     * stampa sulla linea di output il vettore
     *
     * @param vector è un vettore che verrà ordinato in ordine crescente
     */
    private static void stampa(Vector<Integer> vector) {
        for (int i : vector) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

    /**
     * insertionSort modifica il vettore vector
     * ritorna il vettore a con le sue componenti ordinate in modo crescente
     *
     * @param vector è un vettore di interi con almeno 1 o più elementi
     */
    public static void insertionSort(Vector<Integer> vector) {
        for (int i = 1; i < vector.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (vector.get(j) < vector.get(j-1)) {
                    int x = vector.get(j);
                    int y = vector.get(j-1);
                    swap(x, y);
                    vector.set(j-1,x);
                    vector.set(j,y);
                }
            }
        }
    }

    /**
     * swap scambia i valori dell'array a
     * ritorna il vettore a modificato
     * @param x
     * @param y
     */
    private static void swap( int x, int y) {
        int temp;
        temp = x;
        x = y;
        y = temp;
    }
}
