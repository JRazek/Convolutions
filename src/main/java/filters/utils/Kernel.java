package filters.utils;

import filters.GrayScale;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Kernel {
    float [][] values;
    int sizeXORY;
    int valuesSum;
    public Kernel(float[][] v) throws IllegalArgumentException{
        if(v.length != v[0].length)
            throw new IllegalArgumentException(new Error("the kernel is not square!"));
        sizeXORY = v.length;
        if((sizeXORY / 2) * 2 == sizeXORY)
            throw new IllegalArgumentException(new Error("the sqrt of 'size' must be the odd num!"));
        values = v;
        valuesSum = 0;
        for(int i = 0; i < values.length; i ++) {
            for(int j = 0; j < values[0].length; j ++){
                valuesSum += values[j][i];
            }
        }

    }

    public int getSizeXORY() {
        return sizeXORY;
    }

    public float[][] getValues() {
        return values;
    }

    public float multiply(Kernel k) throws IllegalArgumentException{
        if(k.getSizeXORY() != sizeXORY)
            throw new IllegalArgumentException(new Error("cannot multiply different size kernels"));
        float sum = 0;
        for(int y = 0; y < k.getSizeXORY(); y++){
            for(int x = 0; x < k.getSizeXORY(); x++){
                sum += k.getValues()[x][y] * this.values[x][y];
               // if(test)System.out.println(sum);
            }
        }
        return sum;
    }
    public BufferedImage transform(BufferedImage oldImg){
        int height = oldImg.getHeight();
        int width = oldImg.getWidth();
        BufferedImage newImg = new BufferedImage(width, height, oldImg.getType());
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
                int finalPixel = ((int)this.multiply(tmpKernel)/valuesSum);
                Color finalRGB = new Color(finalPixel, finalPixel, finalPixel);
                newImg.setRGB(x, y, finalRGB.getRGB());
               /* System.out.println(sobeledGray);
                Color sobeledRGB = new Color(sobeledGray, sobeledGray, sobeledGray);
                */
            }
        }
        return newImg;
    }

    public int getValuesSum() {
        return valuesSum;
    }
}
