package ir.GameElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShowCards {

    private int x;
    private int y;
    private String address;
    private Pane pane;
    private Image image;
    private ImageView imgV1;

    public ShowCards(int x, int y, String address, Pane pane) {
        this.x = x;
        this.y = y;
        this.address = address;
        this.pane = pane;
        draw();
    }

    private void draw() {
        try {
            image = new Image(new FileInputStream(address));
            imgV1 = new ImageView(image);
            imgV1.setTranslateX(x);
            imgV1.setTranslateY(y);
            imgV1.setFitHeight(40);
            imgV1.setFitWidth(40);
            pane.getChildren().add(imgV1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

    public int getX() {
        return x;
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

    public Image getImage() {
        return image;
    }

    public ImageView getImgV1() {
        return imgV1;
    }
}