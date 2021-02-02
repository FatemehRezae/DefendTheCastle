package ir.GameElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShowCards {

    private final int x;
    private final int y;
    private final String address;
    private final Pane pane;

    public ShowCards(int x, int y, String address, Pane pane) {
        this.x = x;
        this.y = y;
        this.address = address;
        this.pane = pane;
        draw();
    }

    private void draw() {
        try {
            Image image = new Image(new FileInputStream(address));
            ImageView imgV1 = new ImageView(image);
            imgV1.setTranslateX(x);
            imgV1.setTranslateY(y);
            imgV1.setFitHeight(50);
            imgV1.setFitWidth(50);
            pane.getChildren().add(imgV1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }


    public int getY() {
        return y;
    }

    public String getAddress() {
        return address;
    }

    public Pane getPane() {
        return pane;
    }

}