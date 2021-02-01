package ir;

import ir.GameElements.BlackTower;
import ir.GameElements.ElectroTower;
import ir.GameElements.Elixir;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Director {
    private Map map;
    private Menu menu;
    private Pane pane;
    private Stage stage;
    private Scene scene;
    public Director(Pane pane, Stage stage, Scene scene) {
        this.scene = scene;
        this.stage = stage;
        this.pane = pane;
        menu = new Menu();
        map = new Map("src/main/resources/map/map1.txt",pane);
        map.setName("Spring");
        menu.start(pane,stage,map,this);

    }
    public void Start(){
        BlackTower rightBT = new BlackTower(200,300,2,730,280);
        rightBT.draw(pane);
        ElectroTower rightET = new ElectroTower(200,300,2,780,170);
        rightET.draw(pane);
        BlackTower leftBT = new BlackTower(200,300,2,160,280);
        leftBT.draw(pane);
        ElectroTower leftET = new ElectroTower(200,300,2,210,170);
        leftET.draw(pane);
        Elixir e = new Elixir(0,100,pane);
        Elixir q = new Elixir(0,500,pane);
        Player player1 = new Player(1,pane,e,leftET,leftBT);
        Player player2 = new Player(2,pane,q,rightBT,rightET);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.RIGHT ||
                        keyEvent.getCode() == KeyCode.ENTER)
                    player1.keyHandler(keyEvent);
                if(keyEvent.getCode() == KeyCode.B || keyEvent.getCode() == KeyCode.C ||
                        keyEvent.getCode() == KeyCode.SPACE)
                    player2.keyHandler(keyEvent);
            }
        });
        e.start();
        q.start();
    }
}