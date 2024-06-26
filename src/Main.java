import algorithm.*;
import tools.ExportarTiempos;
import tools.LeerArchivoTxt;
import tools.TiempoEjecucion;

import java.io.*;
import java.util.Random;

public class Main {
    static long inicio;
    static long fin;
    static int[][] Matriz1;
    static int[][] Matriz2;

    public static void main(String[] args) {
        // Elección del algoritmo
        //crearMatrices(); // GENERA LAS MATRICES (TARDA VARIOS MINUTOS POR SU MAGNITUD)

        // DOCUMENTAR LO DE ABAJO PARA PROBAR ALGORITMOS YA CREADOS Y DOCUMENTAR EL METODO // crearMatrices();

        // Llamar al método vaciarTiempos() para limpiar los archivos de tiempos antes de empezar
        /*          1.NaivOnArray
                    2.NaivLoopUnrollingTwo
                    3.NaivLoopUnrollingFour
                    4.StrassenNaiv
                    5.WinogradOriginal
                    6.WinogradScaled
                    7.StrassenWinograd
                    8.III_3_Sequential_Block
                    9.IV_3_Sequential_Block
                    10.V_3_SequentialBlock
                    11.III_4_Parallel_Block
                    12.IV_4_Parallel_Block
                    13.V_4_Parallel_Block
                    14.III_5_Enhanced_Parallel_Block
                    15.IV_5_Enhanced_Parallel_Block

                    Caso 1: 256
                    Caso 2: 512
                    Caso 3: 1024
                    Caso 4: 2048
                    Caso 5: 4096
                    Caso 6: 6144
                    Caso 7: 8192
                    Caso 8: 10240

                     */
        vaciarTiempos();
        for(int algoritmo=1; algoritmo<=15; algoritmo++){
            for(int caso=1; caso<=8; caso++){

        //int algoritmo =1;
        //int caso = 8;
                matrices(caso);
                algorithm(algoritmo);

                System.out.println("Termino algoritmo: " + algoritmo + " caso "+caso+"\n");

                //TiempoEjecucion.ResulTimeMatrix(caso);

                try {
                    ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matricesTiempoAlgoritmos, caso);
                    ExportarTiempos.exportarTiempos(TiempoEjecucion.matricesTiempoAlgoritmos, algoritmo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                TiempoEjecucion.matricesTiempoAlgoritmos.clear();




            }
        }



    }

    // Método para limpiar los archivos de tiempos
    public static void vaciarTiempos() {
        try {
            for (String algoritmo : ExportarTiempos.getAlgoritmo()) {
                String rutaArchivo = "src/TimeResult/" + algoritmo + ".txt";
                new PrintWriter(rutaArchivo).close();
            }
            for (String matriz : ExportarTiempos.getMatrices()) {
                String rutaArchivo = "src/TimeResultMatriz/" + matriz + ".txt";
                new PrintWriter(rutaArchivo).close();
            }
            System.out.println("Archivos de tiempos vaciados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearMatrices() {
        int n = 256; // Número de columnas
        int m = 256; // Número de filas

        // Generar la matriz con números aleatorios de 6 dígitos
        for (int i = 0; i < 8; i++) {
            int[][] matriz = generarMatriz(n, m);
            // Guardar la matriz en un archivo
            guardarMatrizEnArchivo(matriz, "src/1matriz/1matriz_" + n + "x" + m + ".txt");
            guardarMatrizEnArchivo(matriz, "src/2matriz/2matriz_" + n + "x" + m + ".txt");

            if (i < 4) {
                n = n * 2;
                m = m * 2;
            }else{
                n = n + 2048;
                m = m + 2048;
            }
        }

        System.out.println("Matrices generadas");
    }



    public static int[][] generarMatriz(int n, int m) {
        int[][] matriz = new int[m][n];
        Random rand = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(900000) + 100000; // Generar número aleatorio de 6 dígitos
            }
        }
        return matriz;
    }

    public static void guardarMatrizEnArchivo(int[][] matriz, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    writer.write(String.format("%d ", matriz[i][j])); // Escribir cada elemento de la matriz
                }
                writer.newLine(); // Nueva línea después de cada fila
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void algorithm(int option) {
        final double[][] matrizDouble1 = convertToIntToDouble(Matriz1);
        final double[][] matrizDouble2 = convertToIntToDouble(Matriz2);
        try {
            switch (option) {
                case 1:
                    // NaivOnArray
                    executeAlgorithm(() -> NaivOnArray.naivOnArray(Matriz1, Matriz2), option);
                    break;
                case 2:
                    // NaivLoopUnrollingTwo
                    executeAlgorithm(() -> NaivLoopUnrollingTwo.naiveLoopUnrollingTwo(Matriz1, Matriz2), option);
                    break;
                case 3:
                    // NaivLoopUnrollingFour
                    executeAlgorithm(() -> NaivLoopUnrollingFour.naivLoopUnrollingFour(Matriz1, Matriz2), option);
                    break;
                case 4:
                    // StrassenNaiv
                    executeAlgorithm(() -> StrassenNaiv.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 5:
                    // WinogradOriginal
                    executeAlgorithm(() -> WinogradOriginal.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 6:
                    // WinogradScaled
                    executeAlgorithm(() -> WinogradScaled.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 7:
                    // StrassenWinograd
                    executeAlgorithm(() -> StrassenWinograd.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 8:
                    // III_3_Sequential_Block
                    executeAlgorithm(() -> III_3_Sequential_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 9:
                    // IV_3_Sequential_Block
                    executeAlgorithm(() -> IV_3_Sequential_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 10:
                    // V_3_SequentialBlock
                    executeAlgorithm(() -> V_3_Sequential_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 11:
                    // III_4_Parallel_Block
                    executeAlgorithm(() -> III_4_Parallel_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 12:
                    // IV_4_Parallel_Block
                    executeAlgorithm(() -> IV_4_Parallel_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 13:
                    // V_4_Parallel_Block
                    executeAlgorithm(() -> V_4_Parallel_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 14:
                    // III_5_Enhanced_Parallel_Block
                    executeAlgorithm(() -> III_5_Enhanced_Parallel_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                case 15:
                    // IV_5_Enhanced_Parallel_Block
                    executeAlgorithm(() -> IV_5_Enhanced_Parallel_Block.multiply(matrizDouble1, matrizDouble2), option);
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } finally {
            // Liberar recursos
            Matriz1 = null;
            Matriz2 = null;
            System.gc(); // Sugerir recolección de basura
        }
    }

    private static void executeAlgorithm(Runnable algorithm, int option) {
        inicio = System.nanoTime();
        algorithm.run();
        fin = System.nanoTime();
        TiempoEjecucion.timeAlgortithm(inicio, fin);
        // Guardar tiempo inmediatamente después de la ejecución del algoritmo
    }

    public static double[][] convertToIntToDouble(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (double) matrix[i][j];
            }
        }
        return result;
    }

    public static void matrices(int caso) {
        switch (caso) {
            case 1:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_256x256.txt", 256);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_256x256.txt", 256);
                break;
            case 2:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_512x512.txt", 512);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_512x512.txt", 512);
                break;
            case 3:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_1024x1024.txt", 1024);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_1024x1024.txt", 1024);
                break;
            case 4:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_2048x2048.txt", 2048);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2048x2048.txt", 2048);
                break;
            case 5:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_4096x4096.txt", 4096);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_4096x4096.txt", 4096);
                break;
            case 6:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_6144x6144.txt", 6144);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_6144x6144.txt", 6144);
                break;
            case 7:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_8192x8192.txt", 8192);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_8192x8192.txt", 8192);
                break;
            case 8:
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_10240x10240.txt", 10240);
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_10240x10240.txt", 10240);
                break;
            default:
                break;
        }
    }
}