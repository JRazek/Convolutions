package filters.utils.kernels;

import filters.GrayScale;
import filters.utils.Kernel;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class SobelKernel {
    Kernel kernelX;
    Kernel kernelY;
    static float[][] x = {
            { 1,  2,  1 },
            { 0,  0,  0 },
            {-1, -2, -1 }
    };
    static float[][] y = {
            { 1,  0, -1 },
            { 2,  0, -2 },
            { 1,  0, -1 }
    };
    public SobelKernel() throws IllegalArgumentException {
        kernelX = new Kernel(x);
        kernelY = new Kernel(y);
    }
    public BufferedImage transform(BufferedImage oldImg){
        int height = oldImg.getHeight();
        int width = oldImg.getWidth();
        BufferedImage newImg = new BufferedImage(width, height, oldImg.getType());
        int biggest = 0;
        for(int y = 1; y < height-1; y ++){
            for(int x = 1; x < width-1; x++){
                float[][] tmp = new float[3][3];
                for(int j = 0; j < 3; j++){
                    for(int i = 0; i < 3; i++){
                        int grayScaled = GrayScale.transformPixel(new Color(oldImg.getRGB(x + i -1 ,y + j -1)));
                        tmp[i][j] = grayScaled;
                    }
                }
                Kernel tmpKernel = new Kernel(tmp);
               // System.out.println("multiply = " + this.kernelX.multiply(tmpKernel));
                int xM = (int)this.kernelX.multiply(tmpKernel)/9;
                int yM = (int)this.kernelY.multiply(tmpKernel)/9;
                int sobeledGray = (int)(Math.sqrt( xM*xM + yM*yM ));
                Color sobeledRGB = new Color(sobeledGray, sobeledGray, sobeledGray);
                newImg.setRGB(x, y, sobeledRGB.getRGB());
            }
        }
        return newImg;
    }
}
