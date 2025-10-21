import Logica.ImageLoader;
import Logica.ImageResizer;
import Logica.ImageSaver;
import Logica.PixelArtProcessor;

public class PixelArtApp {
    public static void main(String[] args) {
        // Lógica para manejar los argumentos de la línea de comandos
        // Llama al PixelArtProcessor para realizar la conversión.
        // Rutas y dimensiones
        String sourceImage = "originalImages/RafaelNadal.png"; // ¡Asegúrate de que este archivo exista!
        String destinationImage = "src/main/resources/finalImage/MechaRafaelNadal.png";

        int targetWidth = 80;  // Ancho deseado en píxeles (idealmente entre 32 y 128)
        int targetHeight = 80; // Alto deseado en píxeles

        // Instancias de las clases de utilidad
        ImageLoader loader = new ImageLoader();
        ImageResizer resizer = new ImageResizer();
        ImageSaver saver = new ImageSaver();

        // Instancia del procesador principal
        PixelArtProcessor processor = new PixelArtProcessor(loader, resizer, saver);

        // Llamada al método de procesamiento
        processor.processImage(sourceImage, destinationImage, targetWidth, targetHeight);

    }
}
