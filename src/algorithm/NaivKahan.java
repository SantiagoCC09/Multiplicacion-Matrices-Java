package algorithm;

import tools.Imprimir;

public class NaivKahan extends Imprimir {

    public static void naiveKahan(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int c = 0;
                for (int k = 0; k < n; k++) {
                    int y = a[i][k] * b[k][j] - c;
                    int t = sum + y;
                    c = (t - sum) - y;
                    sum = t;
                }
                result[i][j] = sum;
            }
        }
//        imprimirMatriz(result);
    }

}
