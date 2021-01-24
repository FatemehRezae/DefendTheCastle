package ir.GameElements;

import javafx.scene.image.Image;

public abstract class Tower {
    private int health;
    private int damage;
    private int range;
    private Image image;
    private int rowIndex ;
    private int columnIndex;

    public Tower(int health, int damage, int range, Image image, int rowIndex, int columnIndex) {
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.image = image;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public abstract void draw();
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

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
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

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
