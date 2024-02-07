package tools;

import java.util.ArrayList;
import java.util.List;

public class TiempoEjecucion {
    public static List<Long> matricesTiempoAlgoritmos = new ArrayList<>();

    public static List<Long> matriz2x2 = new ArrayList<>();
    public static List<Long> matriz4x4 = new ArrayList<>();
    public static List<Long> matriz8x8 = new ArrayList<>();
    public static List<Long> matriz16x16 = new ArrayList<>();
    public static List<Long> matriz32x32 = new ArrayList<>();
    public static List<Long> matriz64x64 = new ArrayList<>();
    public static List<Long> matriz128x128 = new ArrayList<>();
    public static List<Long> matriz256x256 = new ArrayList<>();
    public static List<Long> matriz512x512 = new ArrayList<>();
    public static List<Long> matriz1024x1024 = new ArrayList<>();
    public static List<Long> matriz2048x2048 = new ArrayList<>();
    public static List<Long> matriz4096x4096 = new ArrayList<>();

    public static void timeAlgortithm(long inicio, long fin){
        long time = (fin - inicio);
        matricesTiempoAlgoritmos.add(time);
        System.out.println(" Time: "+time+"ns");
    }

    public static void ResulTimeMatrix(int parametro){
        for (int i = 1; i <= parametro; i++) {
            switch (i) {
                case 1:
                    matriz2x2.add(matricesTiempoAlgoritmos.get(0));
                    break;
                case 2:
                    matriz4x4.add(matricesTiempoAlgoritmos.get(1));
                    break;
                case 3:
                    matriz8x8.add(matricesTiempoAlgoritmos.get(2));
                    break;
                case 4:
                    matriz16x16.add(matricesTiempoAlgoritmos.get(3));
                    break;
                case 5:
                    matriz32x32.add(matricesTiempoAlgoritmos.get(4));
                    break;
                case 6:
                    matriz64x64.add(matricesTiempoAlgoritmos.get(5));
                    break;
                case 7:
                    matriz128x128.add(matricesTiempoAlgoritmos.get(6));
                    break;
                case 8:
                    matriz256x256.add(matricesTiempoAlgoritmos.get(7));
                    break;
                case 9:
                    matriz512x512.add(matricesTiempoAlgoritmos.get(8));
                    break;
                case 10:
                    matriz1024x1024.add(matricesTiempoAlgoritmos.get(9));
                    break;
                case 11:
                    matriz2048x2048.add(matricesTiempoAlgoritmos.get(10));
                    break;
                case 12:
                    matriz4096x4096.add(matricesTiempoAlgoritmos.get(11));
                    break;
                default:
            }
        }
    }

}
