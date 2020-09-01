import filters.GrayScale;
import filters.utils.kernels.BlurKernel;
import filters.utils.kernels.SharpenKernel;
import filters.utils.kernels.SobelKernel;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            SobelKernel so = new SobelKernel();
            BlurKernel b = new BlurKernel();
            SharpenKernel sh = new SharpenKernel();
            BufferedImage img = GrayScale.transformImage((FileManager.loadImage("old.jpg")));
            img = b.transform(img);
            img = so.transform(img);
           // img = sh.transform(img);
            //
            FileManager.writeImageJPG(img, "new.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
