package Logica;

import java.awt.image.BufferedImage;
import java.io.IOException;

//Esta es la clase principal que contiene la lógica para
//convertir las imágenes. No debería tener ninguna referencia a la consola o
//a la interfaz gráfica, lo que la hace reutilizable.

//PROVISIONAL SOLO CON IMAGELOADER, IMAGERESIZER Y IMAGESAVER
public class PixelArtProcessor {
    private final ImageLoader loader;
    private final ImageResizer resizer;
    private final ColorQuantizer quantizer;
    private final ImageSaver saver;


    // Constructor que recibe las dependencias
    public PixelArtProcessor(ImageLoader loader, ImageResizer resizer,ColorQuantizer quantizer, ImageSaver saver) {
        this.loader = loader;
        this.resizer = resizer;
        this.quantizer = quantizer;
        this.saver = saver;
    }

    public void processImage(String sourceResourcePath, String destinationImagePath, int targetWidth, int targetHeight) {
        try {
            // 1. Cargar la imagen desde los recursos
            System.out.println("Cargando imagen: " + sourceResourcePath);
            BufferedImage originalImage = loader.loadImage(sourceResourcePath);

            // 2. Redimensionar la imagen a las dimensiones deseadas
            System.out.println("Redimensionando a " + targetWidth + "x" + targetHeight + "px...");
            BufferedImage resizedImage = resizer.resize(originalImage, targetWidth, targetHeight);

            // 3. Cuantizar los colores (APLICAR EL EFECTO PIXEL ART)
            System.out.println("Aplicando cuantización de color...");
            BufferedImage quantizedImage = quantizer.quantize(resizedImage); // LLAMADA CLAVE

            // 4. Guardar la imagen redimensionada
            System.out.println("Guardando imagen en: " + destinationImagePath);
            saver.saveImage(resizedImage, destinationImagePath);

            System.out.println("Proceso completado con éxito.");

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error durante el procesamiento de la imagen: " + e.getMessage());
        }
    }


}
