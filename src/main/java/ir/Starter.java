package ir;

import ir.GameElements.BlackTower;
import ir.GameElements.ElectroTower;
import ir.GameElements.Elixir;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Starter {
    private  Pane pane;
    private  Stage stage;
    private Scene scene;
    private Menu menu;
    private Map map;
    private Elixir e;
    private Elixir q;

    public void initializeStarter(Pane pane, Stage stage, Scene scene){
        this.scene = scene;
        this.stage = stage;
        this.pane = pane;
        menu = new Menu();
        map = new Map("src/main/resources/map/map1.txt", pane);
        map.setName("Spring");
        menu.start(pane, stage, map, this);

    }
    public void Start() {
        BlackTower rightBT = new BlackTower(2000, 300, 2, 730, 280);
        rightBT.draw(pane);
        ElectroTower rightET = new ElectroTower(1500, 250, 3, 780, 170);
        rightET.draw(pane);
        BlackTower leftBT = new BlackTower(2000, 300, 2, 160, 280);
        leftBT.draw(pane);
        ElectroTower leftET = new ElectroTower(1500, 250, 3, 210, 170);
        leftET.draw(pane);
        e = new Elixir(0, 100, pane);
        q = new Elixir(0, 500, pane);
        Player player1 = new Player(1, pane, e, leftET, leftBT, this);
        Player player2 = new Player(2, pane, q, rightBT, rightET, this);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.RIGHT ||
                    keyEvent.getCode() == KeyCode.ENTER)
                player1.keyHandler(keyEvent);
            if (keyEvent.getCode() == KeyCode.B || keyEvent.getCode() == KeyCode.C ||
                    keyEvent.getCode() == KeyCode.SPACE)
                player2.keyHandler(keyEvent);
            if (keyEvent.getCode() == KeyCode.E)
                Platform.exit();
        });
    }

    public Pane getPane() {
        return pane;
    }

    public void win(Player plyer) {
        Platform.runLater(() -> {
            e.stop();
            q.stop();
            pane.getChildren().clear();
            if (plyer.getNum() == 1)
                System.out.println("Right Playr Won!");
            else
                System.out.println("Left Player Won!");
            initializeStarter(pane,stage,scene);
            menu.start(pane,stage,map,this);
        });

    }
}