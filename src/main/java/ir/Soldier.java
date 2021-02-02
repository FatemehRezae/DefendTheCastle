package ir;

import ir.GameElements.SoldierRun;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Soldier {
    private final Player player;
    private int limit;
    private int x;
    private int y;
    private final String name;
    private  int elixir;
    private int health;
    private int speed;
    private  int damage;
    private  int range;
    private ImageView imgV;
    private final String address;
    private SoldierRun soldierRun;

    public Soldier(String name,String address, int x, int y,Player player) {
        this.player = player;
        this.name = name;
        this.x = x;
        this.y = y;
        this.address = address;
        setStuff();
    }

    public Player getPlayer() {
        return player;
    }

    public void setStuff(){
        if(name.equals("Prince")){
            elixir = 30;
            health = 600;
            speed = 5;
            damage = 400;
            range = 1;
        }
        if(name.equals("Witch")){
            elixir = 15;
            health = 300;
            speed = 1;
            damage = 200;
            range = 2;
        }
        if(name.equals("HogRider")){
            elixir = 10;
            health = 200;
            speed = 3;
            damage = 250;
            range = 1;
        }
        if(name.equals("Dragon")){
            elixir = 10;
            health = 1000;
            speed = 1;
            damage = 150;
            range = 1;
        }
        if(getX() < 500)
            speed *=-1;

    }
    public void isDead(){
        imgV.setTranslateX(-500);
        soldierRun.stop();

    }
    public void draw(Pane pane) {
        try {
            Image image = new Image(new FileInputStream(address));
            imgV = new ImageView(image);
            imgV.setTranslateX(x);
            imgV.setTranslateY(y);
            imgV.setFitHeight(60);
            imgV.setFitWidth(60);
            pane.getChildren().add(imgV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }
    public static int cost(String a){
        if(a.equals("Prince")){
            return  30;
        }
        if(a.equals("Witch")){
            return  15;
        }
        if(a.equals("HogRider")){
            return  10;

        }
        if(a.equals("Dragon")){
            return   10;

        }
        return 0;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void makeSoldierRun() {
        soldierRun = new SoldierRun(this, player.getNum());
        soldierRun.start();
    }

    public int getLimit() {
        return limit;
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
