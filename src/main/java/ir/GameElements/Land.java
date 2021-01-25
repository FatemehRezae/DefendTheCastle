package ir.GameElements;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Land {
    private String address;
    private Image image;

    public Land( String address) {
        this.address = address;
        draw();
    }

    private void draw() {
        try {
            image = new Image(new FileInputStream(address));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }
}
