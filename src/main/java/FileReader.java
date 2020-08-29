import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public static BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }
}
