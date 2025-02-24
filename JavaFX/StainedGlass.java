package edu.bloomu.hw3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Draws an array of squares with random rotation and random color to make
 * a stained-glass pattern
 *
 * @author Riley Simmons
 */
public class StainedGlass extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        final int width = 300;
        final int height = 300;
        Scene scene = new Scene(root, width, height, Color.BLACK);

        int cubeLen = 20;
        int n = width / cubeLen;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cubeX = i * cubeLen;
                int cubeY = j * cubeLen;
                Rectangle rect = new Rectangle(cubeX, cubeY, cubeLen, cubeLen);
                rect.setStroke(Color.BLACK);
                rect.setStrokeWidth(2);
                ThreadLocalRandom rand = ThreadLocalRandom.current();
                int rotate = rand.nextInt(-45, 46);
                rect.setRotate(rotate);
                rect.setFill(randomColor());

                root.getChildren().add(rect);

            }
        }

        stage.setTitle("Stained Glass");
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Generates a random color.
     *
     */
    private static Color randomColor() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        float colorR = rand.nextFloat();
        float colorG = rand.nextFloat();
        float colorB = rand.nextFloat();
        return new Color(colorR, colorG, colorB, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
