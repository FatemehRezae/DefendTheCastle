package ir.GameElements;
import ir.Soldier;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoldierRun extends Thread{
    private Soldier a;
    private int r;
    public SoldierRun(Soldier a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (a.getX() >= 1) {
            r = a.getX() - a.getSpeed();
            System.out.println(r);
            a.setX(r);
            a.getImageView().setTranslateX(a.getX());
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
