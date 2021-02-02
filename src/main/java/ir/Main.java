package ir;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Save save;
    public void start(Stage stage) {
        save = new Save();
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 560, Color.BLACK);
        Starter starter = new Starter(this);
        starter.initializeStarter(root, stage,scene);
        stage.setResizable(false);
        stage.setTitle("Defend-Castle");
        stage.setScene(scene);
        stage.show();
    }

    public Save getSave() {
        return save;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
