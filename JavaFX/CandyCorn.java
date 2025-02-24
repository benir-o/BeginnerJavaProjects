package edu.bloomu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Draws a candy corn - like picture with JavaFX
 *
 * @author Riley Simmons
 */
public class CandyCorn extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        final int width = 300;
        final int height = 300;
        final int slices = 10;
        final int rectSlices = slices / 2;
        final int rotateDegrees = 180 / rectSlices;
        Scene scene = new Scene(root, width, height, Color.BLACK);

        // Draw the main circles
        Circle outterCircle = new Circle(width / 2, height / 2, width / 2 - 15);
        outterCircle.setFill(Color.YELLOW);
        Circle middleCircle = new Circle(width / 2, height / 2, width / 3);
        middleCircle.setFill(Color.ORANGERED);
        Circle innerCircle = new Circle(width / 2, height / 2, width / 5);
        innerCircle.setFill(Color.WHITE);
        Circle smallCircle = new Circle(width / 2, height / 2, width / 9);
        root.getChildren().addAll(outterCircle, middleCircle, innerCircle, smallCircle);

        // Places slices in the candy corn
        for (int i = 0; i < rectSlices; i++) {
            Rectangle rect = new Rectangle(0, height / 2 - 3, width, 6);
            rect.setRotate(i * rotateDegrees);
            root.getChildren().add(rect);
        }

        stage.setTitle("Candy Corn");
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
