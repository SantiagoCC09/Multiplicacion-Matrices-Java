package algorithm;

import tools.Imprimir;

public class NaivLoopUnrollingThree extends Imprimir {

    public static void naivLoopUnrollingThree(int[][] A, int[][] B) {
        int N = A.length;
        int[][] result = new int[N][N];
        int aux;
        if (N % 3 == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    aux = 0;
                    for (int k = 0; k < N; k += 3) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j];
                    }
                    result[i][j] = aux;
                }
            }
        } else if (N % 3 == 1) {
            int PP = N - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    aux = 0;
                    for (int k = 0; k < PP; k += 3) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j];
                    }
                    result[i][j] = aux + A[i][PP]*B[PP][j];
                }
            }
        } else {
            int PP = N - 2;
            int PPP = N - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    aux = 0;
                    for (int k = 0; k < PP; k += 3) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j];
                    }
                    result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j];
                }
            }
        }
//        imprimirMatriz(result);
    }



}
