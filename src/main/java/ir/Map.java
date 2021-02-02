package ir;

import ir.GameElements.Land;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.*;

public class Map {
    private String name;
    private String add;
    private int x = 0;
    private int y = 205;
    private final Pane pane;

    public Map(String add, Pane pane) {
        this.add = add;
        this.pane = pane;
    }

    public void readMapFile() {
        x =0;
        y = 205;
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(add))) {
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    mapReader(line.charAt(i));
                }
            }
        } catch (IOException e) {
            System.out.println("A problem occurred while trying to read the map file\n" + e.getMessage());
        }finally {
            drawCastles();
            initialize();
        }
    }
    public void initialize(){
        Canvas canvas = new Canvas(1100, 900);
        GraphicsContext context = canvas.getGraphicsContext2D();
        // draw message
        context.setFont(new Font("Arial Black", 15));
        context.setLineWidth(2);
        context.setFill(Color.YELLOW);
        context.setStroke(Color.ORANGE);

        String text1 = "Left Player";
        String text2 = "B + C + Space";
        String text3 = "Right Player";
        String text4 = "Right + Left + Enter";

// x , y set mishan
        context.fillText(text1, 30, 400);
        context.strokeText(text1, 30, 400);
        context.fillText(text2, 20, 420);
        context.strokeText(text2, 20, 420);

// x , y set mishan
        context.fillText(text3, 860, 40);
        context.strokeText(text3, 860, 40);
        context.fillText(text4, 830, 60);
        context.strokeText(text4, 830, 60);
        pane.getChildren().add(canvas);
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
                this.y = y + 20;
                x = 0;
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drawCastles() {
        String string;
        String nextStr;
        string = "src/main/resources/Towers/leftSpringCastle.png";
        nextStr = "src/main/resources/Towers/rightSpringCastle.png";
        if (name.equals("Winter")) {
            string = "src/main/resources/Towers/leftIceCastle.png";
            nextStr = "src/main/resources/Towers/rightIceCastle.png";
        }
        try {
            Image image = new Image(new FileInputStream(string));
            ImageView leftCastle = new ImageView(image);
            leftCastle.setFitWidth(130);
            leftCastle.setFitHeight(130);
            leftCastle.setTranslateX(0);
            leftCastle.setTranslateY(208);
            pane.getChildren().add(leftCastle);
            Image image1 = new Image(new FileInputStream(nextStr));
            ImageView rightCastle = new ImageView(image1);
            rightCastle.setFitWidth(130);
            rightCastle.setFitHeight(130);
            rightCastle.setTranslateX(865);
            rightCastle.setTranslateY(208);
            pane.getChildren().add(rightCastle);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
