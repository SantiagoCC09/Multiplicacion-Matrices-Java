import algorithm.*;
import tools.ExportarTiempos;
import tools.LeerArchivoTxt;
import tools.TestMatricex;
import tools.TiempoEjecucion;

import java.io.*;
import java.util.Random;

public class Main {
    static long inicio;
    static long fin;
    static int[][] Matriz1;
    static int[][] Matriz2;


    public static void main(String[] args) {
        // eleccion del algoritmo
        crearMatrices(); // GENERA LAS MATRICES (TARDA VARIOS MINUTOS POR SU MAGNITUD)

        //DESDOCUMENTAR PARA PROBAR ALGORITMOS YA CREADOS Y DOCUMENTAR EL METODO //crearMatrices();
        /*
        for(int algoritmo = 1; algoritmo <= 7; algoritmo++) {
            //iteraciones por las diferentes matrices nxn
            for (int caso = 1; caso <= 8; caso++) {
                matrices(caso);
                algorithm(algoritmo);
            }
            System.out.println("Termino algoritmo: " + algoritmo+ "\n");
            try {
                ExportarTiempos.exportarTiempos(TiempoEjecucion.matricesTiempoAlgoritmos, algoritmo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            TiempoEjecucion.ResulTimeMatrix(TiempoEjecucion.matricesTiempoAlgoritmos.size());
            TiempoEjecucion.matricesTiempoAlgoritmos.clear();
        }
        try {
            TestMatricex.ExportAllMatrix();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */

    }
    public static void crearMatrices(){
        int n = 512; // Número de columnas
        int m = 512; // Número de filas

        // Generar la matriz con números aleatorios de 6 dígitos

        for(int i=0; i<8; i++){
                int[][] matriz = generarMatriz(n, m);
                // Guardar la matriz en un archivo
                guardarMatrizEnArchivo(matriz, "src/1matriz/1matriz_"+n+"x"+m+".txt");
                guardarMatrizEnArchivo(matriz, "src/2matriz/2matriz_"+n+"x"+m+".txt");
                if(i<=3){
                    n=n*2;
                    m=m*2;
                }else{
                    if(i==6){
                        n=n+4096;
                        m=m+4096;
                    }else{
                        n=n+2048;
                        m=m+2048;
                    }
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


    public static void algorithm(int option){
        switch (option){
            case 1:{
                inicio = System.nanoTime();
                NaivStandard.naivStandard(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 2:{
                inicio = System.nanoTime();
                NaivOnArray.naivOnArray(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 3:{
                inicio = System.nanoTime();
                NaivKahan.naiveKahan(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 4:{
                inicio = System.nanoTime();
                NaivLoopUnrollingTwo.naiveLoopUnrollingTwo(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 5:{
                inicio = System.nanoTime();
                NaivLoopUnrollingThree.naivLoopUnrollingThree(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 6:{
                inicio = System.nanoTime();
                NaivLoopUnrollingFour.naivLoopUnrollingFour(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 7:{
                inicio = System.nanoTime();
                StrassenNaiv.multiply(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            default: {
                System.out.println("Opcion incorrecta");
            }
        }//cierra SWITCH
    }

    public static void matrices(int caso){
        switch (caso){
            case 1:{
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_512x512.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_512x512.txt",(int)Math.pow(2, caso));
                break;
            }
            case 2:{
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_1024x1024.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_1024x1024.txt",(int)Math.pow(2, caso));
                break;
            }
            case 3: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_2048x2048.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2048x2048.txt",(int)Math.pow(2, caso));
                break;
            }
            case 4: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_4096x4096.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_4096x4096.txt",(int)Math.pow(2, caso));
                break;
            }
            case 5: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_8192x8192.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_8192x8192.txt",(int)Math.pow(2, caso));
                break;
            }
            case 6: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_10240x10240.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2048x2048.txt",(int)Math.pow(2, caso));
                break;
            }
            case 7: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_12288x12288.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_12288x12288.txt",(int)Math.pow(2, caso));
                break;
            }
            case 8: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_16384x16384.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_16384x16384.txt",(int)Math.pow(2, caso));
                break;
            }
            default:
                break;

        }//cierra SWITCH
    }


}