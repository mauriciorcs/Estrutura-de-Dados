import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MwisTest {

    @Test
    void TestMwis() {

        /**
         *Exemplos: apenas para primeiro teste
         * pesos = {1, 9, 3, 1, 4, 5, 4};
         * A[2] = max{A[1], A[0] + w2} = max{1, 0 + 9} = 9
         * A[3] = max{A[2], A[1] + w3} = max{9, 1 + 3} = 9
         * A[4] = max{A[3], A[2] + w4} = max{9, 9 + 1} = 10
         * A[5] = max{A[4], A[3] + w5} = max{10, 9 + 4} = 13
         * A[6] = max{A[5], A[4] + w6} = max{13, 10 + 5} = 15
         * A[7] = max{A[6], A[5] + w7} = max{15, 13 + 4} = 17
         * */


        // Teste 1:
        int[] pesos1 = {1, 9, 3, 1, 4, 5, 4};
        int[] esperado1 = {0, 1, 9, 9, 10, 13, 15, 17};

        int[] result1 = algoritmo(pesos1);
        assertArrayEquals(esperado1, result1);

        // Teste 2:
        int[] pesos2 = {1, 4, 5, 4};
        int[] esperado2 = {0, 1, 4, 6, 8};

        int[] result2 = algoritmo(pesos2);
        assertArrayEquals(esperado2, result2);

        // Teste 3:
        int[] pesos3 = {10, 1, 2, 3, 4, 5};
        int[] esperado3 = {0, 10, 10, 12, 13, 16, 18};

        int[] result3 = algoritmo(pesos3);
        assertArrayEquals(esperado3, result3);

        // Teste 4:
        int[] pesos4 = {1, 5, 8, 7, 9, 2};
        int[] esperado4 = {0, 1, 5, 9, 12, 18, 18};

        int[] result4 = algoritmo(pesos4);
        assertArrayEquals(esperado4, result4);
    }

    public static int[] algoritmo(int[] weights) {
        int n = weights.length + 1;
        int[] A = new int[n];

        A[0] = 0;
        A[1] = weights[0];

        for (int i = 2; i < n; i++) {
            A[i] = Math.max(A[i - 1], A[i - 2] + weights[i - 1]);
        }
        return A;
    }

}

