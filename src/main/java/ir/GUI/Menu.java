package ir.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu {
    private Map map;
    public void start(Pane pane, Stage stage,Map map){
        this.map = map;
        Background background = null;
        background = getBackground(new File("src/main/resources/Wallpaper.png"));
        pane.setBackground(background);
        Button continUe = new Button("Continue");
        Button newGame = new Button("New Game");
        Button exit = new Button("Exit");
        MenuItem spring = new MenuItem("Spring");
        MenuItem winter = new MenuItem("Winter");
        MenuButton mapChose = new MenuButton("Map", null, spring,winter);
        //set translate
        mapChose.setTranslateX(490);
        mapChose.setTranslateY(380);
        continUe.setTranslateX(485);
        continUe.setTranslateY(409);
        newGame.setTranslateX(480);
        newGame.setTranslateY(437);
        exit.setTranslateX(500);
        exit.setTranslateY(465);

        pane.getChildren().addAll(continUe,exit,newGame,mapChose);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    stage.close();
                }
            }
        });
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pane.setBackground(Background.EMPTY);
                pane.getChildren().clear();
                map.readMapFile();
            }
        });
        spring.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                map.choseMap("src/main/resources/map/map1.txt");
            }
        });
        winter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                map.choseMap("src/main/resources/map/map2.txt");
            }
        });
    }

    private Background getBackground(File file) {
        BackgroundFill backgroundFill= null;
        try {
            backgroundFill = new BackgroundFill(new ImagePattern(
                    new Image(new FileInputStream(file))),CornerRadii.EMPTY, Insets.EMPTY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Background(backgroundFill);
    }
}
