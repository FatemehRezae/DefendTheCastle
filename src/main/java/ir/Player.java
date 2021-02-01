package ir;

import ir.GameElements.Elixir;
import ir.GameElements.ShowCards;
import ir.GameElements.SoldierRun;
import ir.GameElements.Tower;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Player {
    private int x;
    private String soldierName;
    private String address;
    private int num;
    private ArrayList<ShowCards> cards;
    private ArrayList<Soldier> soldiers;
    private ArrayList<KeyCode> keys;
    private ArrayList<Tower> targets;
    private KeyEvent keyEvent;
    private Pane pane;
    private Elixir elixir;
    private Soldier soldier;
    private int i = 0;

    public Player(int num, Pane pane, Elixir elixir, Tower one, Tower two) {
        targets = new ArrayList<>();
        targets.add(one);
        targets.add(two);
        soldiers = new ArrayList<>();
        this.elixir = elixir;
        this.pane = pane;
        this.num = num;
        cards = new ArrayList<>();
        keys = new ArrayList<>();
        this.keyEvent = keyEvent;
        setInfo();
    }

    public void setLimit(Soldier s) {
        if(num == 1) {
            if (targets.get(0).getRange() > s.getRage())
                s.setLimit(targets.get(0).getX() + 80 + targets.get(0).getRange() );
            else s.setLimit(targets.get(0).getX() + 80 + s.getRage());
        }else {
            if (targets.get(0).getRange() > s.getRage())
                s.setLimit(targets.get(0).getX() - (targets.get(0).getRange() + 60));
            else s.setLimit(targets.get(0).getX() - (s.getRage() + 60));
        }
    }

    public ArrayList<KeyCode> getKeys() {
        return keys;

    }

    public void keyHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(keys.get(0))) {
            if (i < 3) {
                i++;
            } else i = 0;
        }
        if (keyEvent.getCode().equals(keys.get(1))) {
            if (i > 0) {
                i--;
            } else i = 3;
        }
        if (keyEvent.getCode().equals(keys.get(2))) {
            decideAddress();
            if (Soldier.cost(soldierName) <= elixir.getCost()) {
                soldier = new Soldier(soldierName, address, x, 225);
                soldiers.add(soldier);
                soldier.draw(pane);
                elixir.soldierMaking(soldier.getElixir());
                if (!targets.isEmpty()) {
                    setLimit(soldier);
                } else {
                    if (num == 1)
                        soldier.setLimit(130);
                    else soldier.setLimit(800);
                }
                SoldierRun b = new SoldierRun(soldier,num);
                b.start();
            }
        }
    }

    public void decideAddress() {
        if (i == 0) {
            soldierName = "Dragon";
            if (num == 1) {
                address = "src/main/resources/Walking Soldiers/RightDragon.png";

            } else {
                address = "src/main/resources/Walking Soldiers/LeftDragon.png";
            }
        } else if (i == 1) {
            soldierName = "HogRider";
            if (num == 1) {
                address = "src/main/resources/Walking Soldiers/RightHog.png";
            } else {
                address = "src/main/resources/Walking Soldiers/LeftHog.png";
            }
        } else if (i == 2) {
            soldierName = "Prince";
            if (num == 1) {
                address = "src/main/resources/Walking Soldiers/PrinceRight.png";
            } else {
                address = "src/main/resources/Walking Soldiers/PrinceLeft.png";
            }
        } else {
            soldierName = "Witch";
            if (num == 1) {
                address = "src/main/resources/Walking Soldiers/RightWitch.png";
            } else {
                address = "src/main/resources/Walking Soldiers/LeftWitch.png";
            }
        }
    }

    public void cards(int y) {
        ShowCards a = new ShowCards(250, y, "src/main/resources/soldiers/BabyDragonCard.png", pane);
        ShowCards b = new ShowCards(305, y, "src/main/resources/soldiers/HogRiderCard.png", pane);
        ShowCards c = new ShowCards(360, y, "src/main/resources/soldiers/PrinceCard.png", pane);
        ShowCards d = new ShowCards(420, y, "src/main/resources/soldiers/WitchCard.png", pane);
        cards.add(a);
        cards.add(b);
        cards.add(c);
        cards.add(d);
    }

    public void setInfo() {
        this.num = num;
        keys = new ArrayList<>();
        if (num == 1) {
            x = 820;
            keys.add(KeyCode.RIGHT);
            keys.add(KeyCode.LEFT);
            keys.add(KeyCode.ENTER);
            cards(50);
        }
        if (num == 2) {
            x = 120; //??
            keys.add(KeyCode.B);
            keys.add(KeyCode.C);
            keys.add(KeyCode.SPACE);
            cards(400);
        }
    }

}
