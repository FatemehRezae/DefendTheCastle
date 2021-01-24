package ir.GUI;

import ir.GameElements.Land;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private String add;
    private int x = 120;
    private int y = 205;
    private Pane pane;
//    ImageView rightKing = new ImageView(new Image("src/main/resources/Towers/RightCastle.png"));
//            rightKing.setTranslateX(880);
//            rightKing.setTranslateY(260);
//            rightKing.setFitHeight(40);
//            rightKing.setFitWidth(40);
//            pane.getChildren().add(rightKing);
    public Map(String add, Pane pane) {
        this.add = add;
        this.pane = pane;
    }

    public void readMapFile() {
        String line;
        int row = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(add))) {
            int rowIndex = -1;
            while ((line = bufferedReader.readLine()) != null) {
                rowIndex++;
                for (int i = 0; i < line.length(); i++) {
                    mapReader(line.charAt(i));
                }
            }

        } catch (IOException e) {
            System.out.println("A problem occurred while trying to read the map file\n" + e.getMessage());
        }
    }

    public void choseMap(String add) {
        this.add = add;
    }

    public void mapReader(char ch) {
        switch (ch) {
            case 'g':
                ImageView grass = new ImageView(new Land("src/main/resources/map/landScape/grass.png").getImage());
                grass.setTranslateX(x);
                grass.setTranslateY(y);
                grass.setFitHeight(20);
                grass.setFitWidth(20);
                pane.getChildren().add(grass);
                this.x = x + 20;
                break;
            case 's':
                ImageView stone = new ImageView(new Land("src/main/resources/map/landScape/stone.png").getImage());
                stone.setTranslateX(x);
                stone.setTranslateY(y);
                stone.setFitHeight(20);
                stone.setFitWidth(20);
                pane.getChildren().add(stone);
                this.x = x + 20;
                break;
            case 'w':
                ImageView way = new ImageView(new Land("src/main/resources/map/landScape/way.png").getImage());
                way.setTranslateX(x);
                way.setTranslateY(y);
                way.setFitHeight(20);
                way.setFitWidth(20);
                pane.getChildren().add(way);
                this.x = x + 20;
                break;
            case 'i':
                ImageView ice = new ImageView(new Land("src/main/resources/map/landScape/ice.png").getImage());
                ice.setTranslateX(x);
                ice.setTranslateY(y);
                ice.setFitHeight(20);
                ice.setFitWidth(20);
                pane.getChildren().add(ice);
                this.x = x + 20;
                break;
            case ';':
                this.y =y + 20;
                x = 120;
                break;
        }
    }
}
