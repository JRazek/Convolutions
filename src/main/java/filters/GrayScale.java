package filters;

import java.awt.image.BufferedImage;

public class GrayScale {
    public static BufferedImage toGrayScale(BufferedImage img){
        return new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    }
}
