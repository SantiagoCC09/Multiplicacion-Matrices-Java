package tools;

import java.io.IOException;

public class TestMatricex {

    public static void ExportAllMatrix() throws IOException {
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz2x2,1);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz4x4,2);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz8x8,3);
    }
}
