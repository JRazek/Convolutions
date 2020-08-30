import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileManager {
    public static BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }
    public static void writeImageJPG(BufferedImage img, String name) throws IOException {
        File outputFile = new File(name);
        ImageIO.write(img, "jpg", outputFile);
    }
}
