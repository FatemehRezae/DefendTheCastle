package ir.GameElements;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElectroTower extends Tower{
    public ElectroTower(int health, int damage, int range, Image image, int rowIndex, int columnIndex) {
        super(health, damage, range, image, rowIndex, columnIndex);
    }

    @Override
    public void draw() {
        try {
            if (getColumnIndex() > 500)
                setImage(new Image(new FileInputStream("src/main/resources/Towers/RightDarkTower.png")));
            else setImage(new Image(new FileInputStream("src/main/resources/Towers/RightTesla.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
