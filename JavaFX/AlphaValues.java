package BeginnerJavaProjects.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

/**
 * Demonstrates different alpha values for
 * semi-transparent shapes.
 * @author Riley Simmons
 */
public class AlphaValues extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        final int width = 500;
        final int height = 300;
        Scene scene = new Scene(root, width, height);

        // Music Listening vvv
        // ♫╘♪ⁿ♪♪♪♪♪♪Cª¢¡c♥+7575++5♣5♣5775♣5♣5777■^■zÄ
        // PUBLIC STATIC VOID MAIN ???????????????
        // Calculate common values
        final int centerX = width / 2;
        final int centerY = height / 2;
        final int leftCenterX = centerX / 2;
        final int rightCenterX = centerX + leftCenterX;
        final int topCenterY = centerY / 2;
        final int bottomBarY = (int) (topCenterY + .75 * centerY);
        final int circlePosY = (int) (topCenterY * .8);
        final int circleRadius = (int) (centerX / 5);

        Circle leftCircle = new Circle(leftCenterX, circlePosY, circleRadius);
        Circle middleCircle = new Circle(centerX, circlePosY, circleRadius);
        Circle rightCircle = new Circle(rightCenterX, circlePosY, circleRadius);

        Color alpha1 = new Color(0, 0, 0, .2);
        Color alpha1Outline = alpha1.darker();
        Color alpha2 = new Color(0, 0, 0, .5);
        Color alpha2Outline = alpha2.darker();
        Color alpha3 = new Color(0, 0, 0, .8);
        Color alpha3Outline = alpha3.darker();
        Color circleColor = new Color(.1, 0, .7, .5);

        leftCircle.setFill(circleColor);
        leftCircle.setStroke(alpha1Outline);
        middleCircle.setFill(circleColor);
        middleCircle.setStroke(alpha2Outline);
        rightCircle.setFill(circleColor);
        rightCircle.setStroke(alpha3Outline);

        // draw left rectangle
        int lRectX1 = leftCenterX - circleRadius;
        Rectangle leftRect = new Rectangle(lRectX1, circlePosY,
                2 * circleRadius, bottomBarY);
        leftRect.setFill(alpha1);
        leftRect.setStroke(alpha1Outline);

        // draw middle rectangle
        Rectangle middleRect = new Rectangle(centerX - circleRadius, circlePosY,
                2 * circleRadius, bottomBarY);
        middleRect.setFill(alpha2);
        middleRect.setStroke(alpha2Outline);

        // draw right rectangle
        Rectangle rightRect = new Rectangle(rightCenterX - circleRadius, circlePosY,
                2 * circleRadius, bottomBarY);
        rightRect.setFill(alpha3);
        rightRect.setStroke(alpha3Outline);

        // draw text
        Font genFont = Font.font("ariel", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Text alpha1Text = new Text(leftCenterX - 20, bottomBarY + 90, "0.20");
        Text alpha2Text = new Text(centerX - 20, bottomBarY + 90, "0.50");
        Text alpha3Text = new Text(rightCenterX - 20, bottomBarY + 90, "0.80");
        alpha1Text.setFont(genFont);
        alpha2Text.setFont(genFont);
        alpha3Text.setFont(genFont);

        root.getChildren().addAll(leftCircle, middleCircle, rightCircle,
                leftRect, middleRect, rightRect, alpha1Text, alpha2Text, alpha3Text);
        stage.setTitle("Alpha Values");
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
