package Logica;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver {
    //guardar una imagen
    public void saveImage(BufferedImage image, String destinationPath) throws IOException {
        File outputFile = new File(destinationPath);

        // Se asegura de que el directorio de destino exista
        File parentDir = outputFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        ImageIO.write(image, "PNG", outputFile);
    }
}
