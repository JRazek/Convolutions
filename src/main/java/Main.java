import filters.utils.kernels.BlurKernel;
import filters.utils.kernels.SobelKernel;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            SobelKernel s = new SobelKernel();
            BlurKernel b = new BlurKernel();
            BufferedImage img = ((FileManager.loadImage("test.jpg")));
            img = b.transform(s.transform(img));
            FileManager.writeImageJPG(img, "new.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
