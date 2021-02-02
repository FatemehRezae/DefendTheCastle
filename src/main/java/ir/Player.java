package ir;

import ir.GameElements.Elixir;
import ir.GameElements.ShowCards;
import ir.GameElements.Tower;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


import java.util.ArrayList;

public class Player {
    private Starter starter;
    private int firstWin = 0;
    private int secondWin = 0;
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

    public Player(int num, Pane pane, Elixir elixir, Tower one, Tower two, Starter dir) {
        starter = dir;
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
        elixir.start();
        setInfo();
    }

    public void setLimit(Soldier s) {
        if (!targets.isEmpty()) {
            if (num == 1)
                s.setLimit(targets.get(0).getX() + s.getRage());
            if (num == 2)
                s.setLimit(targets.get(0).getX() - (targets.get(0).getRange() + 60));
        }
        else if (num == 1) {
            s.setLimit(180);
            winCount(s);
        }
        else if (num == 2) {s.setLimit(980);winCount(s);}
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
                soldier = new Soldier(soldierName, address, x, 225, this);
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
                soldier.makeSoldierRun();
            }
        }
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public void deadSoldier(Soldier a) {
        soldiers.remove(a);
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public ArrayList<Tower> getTargets() {
        return targets;
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

    public void deadTarget(Tower t) {
        try {
            t.getImageView().setTranslateX(-500);
            targets.remove(t);
            if (targets.isEmpty()) {
                if (num == 1) {
                    for (Soldier s : soldiers
                    ) {
                        soldier.setLimit(180);
                    }
                } else {
                    for (Soldier s : soldiers
                    ) {
                        soldier.setLimit(980);
                    }
                }
            }
        }catch (NullPointerException e){

        }

    }

    public void cards(int y) {
        ShowCards a = new ShowCards(360, y, "src/main/resources/soldiers/BabyDragonCard.png", pane);
        ShowCards b = new ShowCards(415, y, "src/main/resources/soldiers/HogRiderCard.png", pane);
        ShowCards c = new ShowCards(470, y, "src/main/resources/soldiers/PrinceCard.png", pane);
        ShowCards d = new ShowCards(530, y, "src/main/resources/soldiers/WitchCard.png", pane);
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
            x = 120;
            keys.add(KeyCode.B);
            keys.add(KeyCode.C);
            keys.add(KeyCode.SPACE);
            cards(400);
        }
    }

    public void winCount(Soldier s) {
        try {
            if (num == 1) {
                for (int i = 0; i < soldiers.size() ;i ++) {
                    if (s.getImageView().getX() <= 180) {
                        firstWin++;
                        break;
                    }
                }
                if (firstWin !=0) {
                    for (int i = 0; i < soldiers.size() ;i ++) {
                        soldiers.get(i).isDead();
                        deadSoldier(soldiers.get(i));
                    }
                    starter.win(this);
                    Thread.currentThread().stop();

                }
            } else if(num == 2) {
                for (int i = 0; i < soldiers.size() ;i ++) {
                    if (s.getImageView().getX() >= 980) {
                        secondWin++;
                        break;
                    }
                }
                if (secondWin != 0) {
                    for (int i = 0; i < soldiers.size() ; i++) {
                        soldiers.get(i).isDead();
                        deadSoldier(soldiers.get(i));
                    }

                }
            }

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
}
