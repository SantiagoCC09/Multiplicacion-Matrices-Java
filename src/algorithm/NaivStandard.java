package algorithm;

import tools.Imprimir;

public class NaivStandard extends Imprimir {

    public static void naivStandard(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        int aux;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aux = 0;
                for (int k = 0; k < n; k++) {
                    aux += a[i][k]*b[k][j];
                }
                result[i][j] = aux;
            }
        }
//        imprimirMatriz(result);
    }
}
