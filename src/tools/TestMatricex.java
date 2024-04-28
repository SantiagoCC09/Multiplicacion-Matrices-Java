package tools;

import java.io.IOException;

public class TestMatricex {

    public static void ExportAllMatrix() throws IOException {
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz256x256,1);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz512x512,2);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz1024x1024,3);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz2048x2048,4);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz4096x4096,5);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz6144x6144,6);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz8192x8192,7);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz12288x12288,8);
    }
}
