package filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale {
    public static BufferedImage transformImage(BufferedImage oldImg){
        int [] kernel = {
            1,2,1,
            2,4,2,
            1,2,1,
    };
        int width = oldImg.getWidth();
        int height = oldImg.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, oldImg.getType());

        for(int y = 0; y < height; y ++){
            for(int x = 0; x  < width; x++){
                Color c = new Color(oldImg.getRGB(x,y));
                int gScale = transformPixel(c);
                Color grayPixel = new Color (gScale,gScale,gScale);
                newImage.setRGB(x, y, grayPixel.getRGB());
            }
        }
        return newImage;
    }
    public static int transformPixel(Color c){
        //return (int)((0.3f * c.getRed()) + (0.59f * c.getGreen()) + (0.11f * c.getBlue()));
        return (c.getRed() + c.getGreen() + c.getBlue())/3;
    }
}
