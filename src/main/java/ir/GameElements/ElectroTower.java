package ir.GameElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElectroTower extends Tower{
    public ElectroTower(int health, int damage, int range, int x, int y) {
        super(health, damage, range, x, y);
    }

    @Override
    public void draw(Pane p) {
        try {
            if (getX() > 500)
                setImage(new Image(new FileInputStream("src/main/resources/Towers/RightTesla.png")));
            else setImage(new Image(new FileInputStream("src/main/resources/Towers/LeftTesla.png")));
            setImageView(new ImageView(getImage()));
            getImageView().setTranslateX(getX());
            getImageView().setTranslateY(getY());
            getImageView().setFitWidth(80);
            getImageView().setFitHeight(80);
            p.getChildren().add(getImageView());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
