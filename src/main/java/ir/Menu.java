package ir;

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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu {
    private Director d;
    private Map map;
    private Pane pane;
    public void start(Pane pane, Stage stage, Map map, Director d){
        this.d = d;
        this.map = map;
        this.pane = pane;
        Background background = getBackground(new File("src/main/resources/Wallpaper.png"));
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
        continUe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pane.setBackground(Background.EMPTY);
                pane.getChildren().clear();
                map.readMapFile();
                d.Start();
            }
        });
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pane.setBackground(Background.EMPTY);
                pane.getChildren().clear();
                map.readMapFile();
                d.Start();
            }
        });
        spring.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                map.setName("Spring");
                map.choseMap("src/main/resources/map/map1.txt");

            }
        });
        winter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                map.choseMap("src/main/resources/map/map2.txt");
                map.setName("Winter");
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
    public void setUp(){
        Text player1 = new Text(20,30,"Player One");
        player1.setFill(Color.YELLOW);
        player1.setFont(Font.font ("Agency FB", 30));
        Text player2 = new Text(880,400,"Player Two");
        player2.setFill(Color.RED);
        player2.setFont(Font.font ("Agency FB", 30));
        pane.getChildren().addAll(player1,player2);
    }
}
