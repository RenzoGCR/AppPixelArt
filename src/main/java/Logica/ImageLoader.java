package Logica;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageLoader {
    //cargar una imagen sin importar la ubicacion en disco del archivo
    public BufferedImage loadImage(String resourcePath) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("No se encontró el recurso en la ruta: " + resourcePath);
        }
        // Usamos la clase ImageIO para leer la imagen.
        BufferedImage image = ImageIO.read(inputStream);
        if (image == null) {
            throw new IOException("No se pudo leer la imagen. Posiblemente un formato no soportado.");
        }
        return image;
    }
}
