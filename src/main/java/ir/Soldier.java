package ir;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Soldier {
    private int x;
    private int y;
    private final String name;
    private final int elixir;
    private int health;
    private int speed;
    private final int damage;
    private final int range;
    private Image image;
    private ImageView imgV;

    public Soldier(String name, int elixir, int health, int speed, int damage, int range, int x, int y) {
        this.name = name;
        this.elixir = elixir;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public void draw(Pane pane) {
        try {
            image = new Image(new FileInputStream("src/main/resources/Walking Soldiers/pakShodeh/photo_2021-01-27_17-59-36.png"));
            imgV = new ImageView(image);
            imgV.setTranslateX(x);
            imgV.setTranslateY(y);
            imgV.setFitHeight(30);
            imgV.setFitWidth(30);
            pane.getChildren().add(imgV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public ImageView getImageView() {
        return imgV;
    }

    public int getY() {
        return y;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSoldierName() {
        return name;
    }

    public int getElixir() {
        return elixir;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getRage() {
        return range;
    }
}
