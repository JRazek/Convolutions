import filters.GrayScale;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            FileManager.writeImageJPG(GrayScale.transform(FileManager.loadImage("old.jpg")), "new.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
