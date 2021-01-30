package ir;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int num;
    private ArrayList<Soldier> card;
    private ArrayList<KeyCode> interestedInKeys;
    private KeyEvent keyEvent;

    public Player(int num,ArrayList<KeyCode> interestedInKeys, KeyEvent keyEvent) {
        this.num = num;
       card = new ArrayList<>();
        this.interestedInKeys = interestedInKeys;
        this.keyEvent = keyEvent;
    }
    public void setInfo(int num) {
        this.num=num;
        interestedInKeys=new ArrayList<>();
        if(num==1){
            interestedInKeys.add(KeyCode.ENTER);
            interestedInKeys.add(KeyCode.LEFT);
            interestedInKeys.add(KeyCode.RIGHT);
        }
        if(num==2){
            interestedInKeys.add(KeyCode.C);
            interestedInKeys.add(KeyCode.B);
            interestedInKeys.add(KeyCode.SPACE);

        }
    }

}
