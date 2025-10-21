package Logica;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorQuantizer {
    //se reducen el numero de colores que hay en la imagen
    // Paleta de colores simple inspirada en sistemas retro (puedes expandirla)
    // Usaremos un conjunto de colores brillantes y saturados típicos del pixel art.
    private static final Color[] PIXEL_PALETTE = {
            new Color(0, 0, 0),         // Negro
            new Color(255, 255, 255),   // Blanco
            new Color(192, 192, 192),   // Gris Claro
            new Color(128, 128, 128),   // Gris Oscuro
            new Color(255, 0, 0),       // Rojo
            new Color(0, 255, 0),       // Verde
            new Color(0, 0, 255),       // Azul
            new Color(255, 255, 0),     // Amarillo
            new Color(255, 0, 255),     // Magenta
            new Color(0, 255, 255),     // Cyan
            new Color(128, 0, 0),       // Marrón Oscuro
            new Color(192, 128, 0),     // Naranja
            new Color(128, 0, 128),     // Púrpura
            new Color(0, 128, 0),       // Verde Oscuro
            new Color(0, 0, 128),       // Azul Oscuro
            new Color(128, 128, 0)      // Oliva
    };

    //Reduce el número de colores de una imagen mapeando cada píxel al color más cercano
    // dentro de una paleta fija.
    public BufferedImage quantize(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Recorrer cada píxel de la imagen redimensionada
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalRGB = image.getRGB(x, y);

                // Encontrar el color más cercano en nuestra paleta
                int closestColorRGB = findClosestColor(originalRGB);

                // Reemplazar el color original con el color de la paleta
                image.setRGB(x, y, closestColorRGB);
            }
        }
        return image;
    }

    //Busca el color más cercano en la PIXEL_PALETTE usando la distancia Euclidiana en el espacio RGB.
    private int findClosestColor(int originalRGB) {
        Color originalColor = new Color(originalRGB, true);

        int minDistanceSq = Integer.MAX_VALUE;
        Color closestColor = PIXEL_PALETTE[0]; // Inicializar con el primer color

        // Obtener los componentes R, G, B del color original
        int r1 = originalColor.getRed();
        int g1 = originalColor.getGreen();
        int b1 = originalColor.getBlue();

        for (Color paletteColor : PIXEL_PALETTE) {
            // Obtener los componentes R, G, B del color de la paleta
            int r2 = paletteColor.getRed();
            int g2 = paletteColor.getGreen();
            int b2 = paletteColor.getBlue();

            // Calcular la distancia al cuadrado (es más rápido que calcular la raíz cuadrada)
            int dr = r1 - r2;
            int dg = g1 - g2;
            int db = b1 - b2;

            int distanceSq = dr * dr + dg * dg + db * db;

            if (distanceSq < minDistanceSq) {
                minDistanceSq = distanceSq;
                closestColor = paletteColor;
            }
        }

        // Devolver el valor RGB del color más cercano
        return closestColor.getRGB();
    }
}
