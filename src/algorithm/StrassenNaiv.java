package algorithm;

public class StrassenNaiv {
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        int[][] R = new int[n][n];

        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];

        else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            int[][] M1 = multiply(add(A11, A22), add(B11, B22));
            int[][] M2 = multiply(add(A21, A22), B11);
            int[][] M3 = multiply(A11, sub(B12, B22));
            int[][] M4 = multiply(A22, sub(B21, B11));
            int[][] M5 = multiply(add(A11, A12), B22);
            int[][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int[][] M7 = multiply(sub(A12, A22), add(B21, B22));

            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = add(sub(add(M1, M3), M2), M6);

            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }
        return R;
    }
    public static int[][] sub(int[][] A, int[][] B) {
        int n = A.length;

        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];

        return C;
    }
    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        // Creating a 2D square matrix
        int[][] C = new int[n][n];
        // Iterating over elements of 2D matrix
        // Outer loop for rows
        for (int i = 0; i < n; i++)
            // Inner loop for columns
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        // Returning the resultant matrix
        return C;
    }
    public static void split(int[][] P, int[][] C, int iB, int jB) {
        // Iterating over elements of 2D matrix
        // Outer loop for rows
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            // Inner loop for columns
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    public static void join(int[][] C, int[][] P, int iB, int jB) {
        // Outer loop for rows
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            // Inner loop for columns
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }

}
