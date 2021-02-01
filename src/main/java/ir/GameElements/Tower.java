package ir.GameElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Tower {
    private int health;
    private int damage;
    private int range;
    private Image image;
    private int y ;
    private int x;
    private ImageView imageView;

    public Tower(int health, int damage, int range, int x, int y) {
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public abstract void draw(Pane p);
    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getHealth() {
        return health;
    }

    public Image getImage() {
        return image;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
