package Logica;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer {
    //Esta clase se encarga de redimensionar la imagen para darle ese efecto de pocos píxeles. Escalado de NEAREST NEIGHBOR
    public BufferedImage resize(BufferedImage originalImage, int newWidth, int newHeight) {
        // 1. Crea una nueva imagen de destino con las dimensiones deseadas.
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        // 2. Usa un objeto Graphics2D para dibujar la imagen original en la nueva imagen,
        //    forzando el uso de un algoritmo de escalado "duro".
        Graphics2D g2d = resizedImage.createGraphics();

        // 3. Establece el hint de renderizado para el escalado.
        //    RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR es clave.
        g2d.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
        );

        // 4. Dibuja la imagen original, escalándola al nuevo tamaño.
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return resizedImage;
    }
}
