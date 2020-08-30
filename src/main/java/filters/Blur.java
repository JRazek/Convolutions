package filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Blur {
    public static BufferedImage transform(BufferedImage oldImg, int intensity){
        int width = oldImg.getWidth();
        int height = oldImg.getHeight();
        BufferedImage newImage = new BufferedImage(width-2, height-2, oldImg.getType());

        for(int y = 0; y < height; y ++){
            for(int x = 0; x  < width; x++){
                Color c = new Color(oldImg.getRGB(x,y));
                float gScale = ((0.3f * c.getRed()) + (0.59f * c.getGreen()) + (0.11f * c.getBlue()));
                Color grayPixel = new Color (gScale,gScale,gScale);
                newImage.setRGB(x, y, grayPixel.getRGB());
            }
        }
        return null;
    }
}
