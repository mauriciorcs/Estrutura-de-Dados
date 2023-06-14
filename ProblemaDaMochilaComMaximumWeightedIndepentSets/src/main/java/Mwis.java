public class Mwis {

    public static int[] mwis(int[] weights) {
        int n = weights.length + 1;
        int[] A = new int[n];

        A[0] = 0;
        A[1] = weights[0];

        for (int i = 2; i < n; i++) {
            A[i] = Math.max(A[i - 1], A[i - 2] + weights[i - 1]);
        }

        // Imprimir o array A
        for (int i = 0; i < n; i++) {
            System.out.println("A[" + i + "] = " + A[i]);
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println("Primeiro problema: ");
        int[] weights1 = {1, 9, 3, 1, 4, 5, 4};
        mwis(weights1);

        System.out.println("Segundo problema:");
        int[] weights2 = {1, 4, 5, 4};
        mwis(weights2);

        System.out.println("Terceiro problema:");
        int[] weights3 = {1, 5, 8, 7, 9, 2};
        mwis(weights3);

    }
}




