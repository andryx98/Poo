public class Main {
    public static void main(String[] args) {
        int[] A = {2, 3, 3};
        System.out.println(algoritmo(A, 3, 10));
    }

    public static int algoritmo(int[] A, int n, int k) {
        int[] B = new int[k];
        for (int i = 0; i < k; i++) {
            B[i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            B[A[i]] = B[A[i]] + 1;
        }
        int x = 1;
        int v = B[A[0]];
        for (int i = 1; i < n - 1; i++) {
            if (B[A[i]] > v) {
                x = i;
                v = B[A[i]];
            }
        }
        return A[x];
    }
}
