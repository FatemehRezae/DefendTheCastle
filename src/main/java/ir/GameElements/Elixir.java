package ir.GameElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Elixir extends Thread {
    private final int x;
    private int y;
    private int cost = 0;
    private final Pane pane;
    private ImageView imageView;

    public Elixir(int x, int y, Pane p) {
        pane = p;
        this.x = x;
        this.y = y;
        draw();
    }

    public void soldierMaking(int a) {
        cost -= a;
        imageView.setFitWidth(cost);
    }

    public void run() {
        while (cost < 100) {
            cost += 10;
            System.out.println(cost);
            imageView.setFitWidth(cost*10);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void draw() {
        try {
            Image image = new Image(new FileInputStream("src/main/resources/Untitled-1.png"));
            imageView = new ImageView(image);
            imageView.setTranslateX(x);
            imageView.setTranslateY(y);
            imageView.setFitHeight(50);
            imageView.setFitWidth(cost * 5);
            pane.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public int getCost() {
        return cost;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
