import algorithm.*;
import tools.ExportarTiempos;
import tools.LeerArchivoTxt;
import tools.TestMatricex;
import tools.TiempoEjecucion;

import java.io.IOException;

public class Main {
    static long inicio;
    static long fin;
    static int[][] Matriz1;
    static int[][] Matriz2;


    public static void main(String[] args) {
        // eleccion del algoritmo
        for(int algoritmo = 1; algoritmo <= 7; algoritmo++) {
            //iteraciones por las diferentes matrices nxn
            for (int caso = 1; caso <= 3; caso++) {
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
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_2x2.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2x2.txt",(int)Math.pow(2, caso));
                break;
            }
            case 2:{
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_4x4.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_4x4.txt",(int)Math.pow(2, caso));
                break;
            }
            case 3: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_8x8.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_8x8.txt",(int)Math.pow(2, caso));
                break;
            }
            default:
                break;

        }//cierra SWITCH
    }


}