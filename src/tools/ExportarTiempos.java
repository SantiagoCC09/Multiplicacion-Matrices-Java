package tools;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExportarTiempos {

    static List<String> algoritmo = new ArrayList<>(Arrays.asList("NaivStandard", "NaivOnArray", "NaivKahan", "NaivLoopUnrollingTwo", "NaivLoopUnrollingThree", "NaivLoopUnrollingFour", "WinogradOriginal", "WinogradScaled", "StrassenNaiv", "StrassenWinograd", "III-SequentialBlock", "III-ParallelBlock"));

    static List<String> matrices = new ArrayList<>(Arrays.asList("matriz2x2", "matriz4x4","matriz8x8"));

    public static void exportarTiempos(List<Long> lista, int item) throws IOException {
        String rutaArchivo = "src/TimeResult/" +algoritmo.get(item-1)+ ".txt"; // Especifica la ruta del archivo con el nombre proporcionado
        FileWriter escritor = new FileWriter(rutaArchivo);
        BufferedWriter bufferEscritor = new BufferedWriter(escritor);

        for (Long numero : lista) {
            bufferEscritor.write(numero.toString());
            bufferEscritor.newLine();
        }

        bufferEscritor.close();
    }
    public static void exportarTiemposMatriz(List<Long> lista, int item) throws IOException {
        String rutaArchivo = "src/TimeResultMatriz/" +matrices.get(item-1)+ ".txt"; // Especifica la ruta del archivo con el nombre proporcionado
        FileWriter escritor = new FileWriter(rutaArchivo);
        BufferedWriter bufferEscritor = new BufferedWriter(escritor);
        for (Long numero : lista) {
            bufferEscritor.write(numero.toString());
            bufferEscritor.newLine();
        }
        bufferEscritor.close();
    }

}

