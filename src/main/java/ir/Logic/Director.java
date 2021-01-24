package ir.Logic;

import ir.GUI.Map;
import ir.GUI.Menu;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Director {
    private Map map;
    private Menu menu;
    private Pane pane;
    private Stage stage;

    public Director(Pane pane, Stage stage) {
        this.stage = stage;
        this.pane = pane;
        menu = new Menu();
        map = new Map("src/main/resources/map/map1.txt",pane);
        menu.start(pane,stage,map);
    }
}
