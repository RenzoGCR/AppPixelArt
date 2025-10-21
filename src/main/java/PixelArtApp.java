import Logica.*;

public class PixelArtApp {
    public static void main(String[] args) {
        // Lógica para manejar los argumentos de la línea de comandos
        // Llama al PixelArtProcessor para realizar la conversión.
        // Rutas y dimensiones
        String sourceImage = "originalImages/Sora.png"; // INTRODUCIR NOMBRE DE ENTRADA DE IMAGEN
        String destinationImage = "src/main/resources/finalImage/MechaSora.png"; //INTRODUCIR NOMBRE DE SALIDA DE LA IMAGEN

        int targetWidth = 120;  // INTRODUCIR NUMERO DE PIXELES DESEADO PARA ANCHURA (idealmente entre 32 y 128)
        int targetHeight = 120; // INTRODUCIR NUMERO DE PIXELES DESEADO PARA ALTURA

        // Instancias de las clases de utilidad
        ImageLoader loader = new ImageLoader();
        ImageResizer resizer = new ImageResizer();
        ColorQuantizer quantizer = new ColorQuantizer();
        ImageSaver saver = new ImageSaver();

        // Instancia del procesador principal
        PixelArtProcessor processor = new PixelArtProcessor(loader, resizer,quantizer, saver);

        // Llamada al método de procesamiento
        processor.processImage(sourceImage, destinationImage, targetWidth, targetHeight);

    }
}
