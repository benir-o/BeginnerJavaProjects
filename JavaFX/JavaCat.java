package edu.bloomu.hw2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Draws a friendly and (partly) scalable pikachu strictly using
 * JavaFX basic shapes.
 *
 * @author Riley Simmons
 */
public class JavaCat extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        final int width = 500;
        final int height = 500;
        Scene scene = new Scene(root, width, height);

        // Calculate position values
        final int centerX = width / 2;
        final int centerY = height / 2;
        final int pikaEarLeftX = (int) (centerX * .6);
        final int pikaEarRightX = (int) (centerX * 1.4);
        final int pikaEarY = (int) (centerY / 2.8);

        final int strokeWidth = 3;

        // Define basic colors used
        Color pikaYellow = new Color(1, 1, 0, 1);
        Color pikaBlack = new Color(.24, .2, .2, 1);
        Color pikaRed = new Color(.9, .3, .3, 1);
        Color pikaOutline = pikaBlack.darker();

        // Draw the head
        Ellipse pikaHead = new Ellipse(centerX, centerY * .8,
                width / 5, height / 6);
        pikaHead.setFill(pikaYellow);
        pikaHead.setStroke(pikaOutline);
        pikaHead.setStrokeWidth(strokeWidth);

        // Draw the ears
        Ellipse pikaLeftEar = new Ellipse(pikaEarLeftX, pikaEarY,
                width / 20, height / 6);
        pikaLeftEar.setFill(pikaYellow);
        pikaLeftEar.setRotate(-35);
        pikaLeftEar.setStroke(pikaOutline);
        pikaLeftEar.setStrokeWidth(strokeWidth);

        Ellipse pikaRightEar = new Ellipse(pikaEarRightX, pikaEarY,
                width / 20, height / 6);
        pikaRightEar.setFill(pikaYellow);
        pikaRightEar.setRotate(35);
        pikaRightEar.setStroke(pikaOutline);
        pikaRightEar.setStrokeWidth(strokeWidth);

        // Draw the body
        Ellipse pikaBodyRight = new Ellipse(centerX * 1.05, centerY * 1.3,
                width / 5, height / 4);
        pikaBodyRight.setFill(pikaYellow);
        pikaBodyRight.setRotate(-15);
        pikaBodyRight.setStroke(pikaOutline);
        pikaBodyRight.setStrokeWidth(strokeWidth);

        Ellipse pikaBodyLeft = new Ellipse(centerX * .95, centerY * 1.3,
                width / 5, height / 4);
        pikaBodyLeft.setFill(pikaYellow);
        pikaBodyLeft.setRotate(15);
        pikaBodyLeft.setStroke(pikaOutline);
        pikaBodyLeft.setStrokeWidth(strokeWidth);

        // Draw the feet
        Ellipse pikaLeftFoot = new Ellipse(centerX * .80, centerY * 1.77,
                width / 30, height / 12);
        pikaLeftFoot.setFill(pikaYellow);
        pikaLeftFoot.setRotate(50);
        pikaLeftFoot.setStroke(pikaOutline);
        pikaLeftFoot.setStrokeWidth(strokeWidth);

        Ellipse pikaRightFoot = new Ellipse(centerX * 1.2, centerY * 1.77,
                width / 30, height / 12);
        pikaRightFoot.setFill(pikaYellow);
        pikaRightFoot.setRotate(-50);
        pikaRightFoot.setStroke(pikaOutline);
        pikaRightFoot.setStrokeWidth(strokeWidth);

        // Draw the tail in separate parts
        Polygon tailPart1 = new Polygon(width * .98, height / 15, width * .85,
                height / 15, width * .73, height / 5, width * .84, height / 5);
        tailPart1.setFill(pikaYellow);
        tailPart1.setStroke(pikaOutline);
        tailPart1.setStrokeWidth(strokeWidth);

        Polygon tailPart2 = new Polygon(width * .84, height / 5, width * .73,
                height / 5, width * .78, height / 2.4, width * .88, height / 2.4);
        tailPart2.setFill(pikaYellow);
        tailPart2.setStroke(pikaOutline);
        tailPart2.setStrokeWidth(strokeWidth);

        Polygon tailPart3 = new Polygon(width * .88, height / 2.4, width * .78,
                height / 2.4, width * .72, height / 1.9, width * .82, height / 1.9);
        tailPart3.setFill(pikaYellow);
        tailPart3.setStroke(pikaOutline);
        tailPart3.setStrokeWidth(strokeWidth);

        Polygon tailPart4 = new Polygon(width * .82, height / 1.9, width * .72,
                height / 1.9, width * .74, height / 1.5, width * .83, height / 1.5);
        tailPart4.setFill(pikaYellow);
        tailPart4.setStroke(pikaOutline);
        tailPart4.setStrokeWidth(strokeWidth);

        Polygon tailPart5 = new Polygon(width * .83, height / 1.5, width * .74,
                height / 1.5,
                width * .63, height / 1.4, width * .68, height / 1.2);
        tailPart5.setFill(pikaYellow);
        tailPart5.setStroke(pikaOutline);
        tailPart5.setStrokeWidth(strokeWidth);

        // Draw the arms
        Color transparent = new Color(0, 0, 0, 0);
        Arc leftArm1 = new Arc(width * .16, height * .74, width * .3,
                height * .3, 2, 38);
        leftArm1.setType(ArcType.OPEN);
        leftArm1.setFill(transparent);
        leftArm1.setStroke(pikaOutline);
        leftArm1.setStrokeWidth(strokeWidth);

        Arc leftArm2 = new Arc(width * .6, height * .53, width * .3,
                height * .3, 190, 40);
        leftArm2.setType(ArcType.OPEN);
        leftArm2.setFill(transparent);
        leftArm2.setStroke(pikaOutline);
        leftArm2.setStrokeWidth(strokeWidth);

        Arc leftHand = new Arc(width * .42, height * .721, width * .04,
                height * .04, 250, 100);
        leftHand.setType(ArcType.OPEN);
        leftHand.setFill(transparent);
        leftHand.setStroke(pikaOutline);
        leftHand.setStrokeWidth(strokeWidth);

        // * expressions inside Arc parameters are for
        // calculating symmetry to the left arm
        Arc rightArm1 = new Arc((centerX - width * .16) + centerX, height * .74,
                width * .3, height * .3, 180 - 2, -38);
        rightArm1.setType(ArcType.OPEN);
        rightArm1.setFill(transparent);
        rightArm1.setStroke(pikaOutline);
        rightArm1.setStrokeWidth(strokeWidth);

        Arc rightArm2 = new Arc((centerX - width * .6) + centerX, height * .53,
                width * .3, height * .3, 180 - 190, -40);
        rightArm2.setType(ArcType.OPEN);
        rightArm2.setFill(transparent);
        rightArm2.setStroke(pikaOutline);
        rightArm2.setStrokeWidth(strokeWidth);

        Arc rightHand = new Arc((centerX - width * .42) + centerX, height * .721,
                width * .04, height * .04, 180 - 250, -100);
        rightHand.setType(ArcType.OPEN);
        rightHand.setFill(transparent);
        rightHand.setStroke(pikaOutline);
        rightHand.setStrokeWidth(strokeWidth);


        // Draw objects without outlines that go over outlines
        // Fix the ear outlines
        Ellipse pikaLeftEarFix = new Ellipse(pikaEarLeftX, pikaEarY,
                width / 21, height / 7);
        pikaLeftEarFix.setFill(pikaYellow);
        pikaLeftEarFix.setRotate(-35);

        Ellipse pikaRightEarFix = new Ellipse(pikaEarRightX, pikaEarY,
                width / 21, height / 7);
        pikaRightEarFix.setFill(pikaYellow);
        pikaRightEarFix.setRotate(35);

        // Fix the head to body outline
        Ellipse pikaHeadFix = new Ellipse(centerX, centerY * .9,
                width / 6, height / 7);
        pikaHeadFix.setFill(pikaYellow);

        // Fix the body outlines
        Ellipse pikaBodyFix = new Ellipse(centerX * 1.03, centerY * 1.3,
                width / 5, height / 4.09);
        pikaBodyFix.setFill(pikaYellow);
        pikaBodyFix.setRotate(-15);

        // Fix the tail outlines for each tail part
        Polygon tailFix1 = new Polygon(width * .839, height / 5.09, width * .739,
                height / 5.09, width * .739, height / 4.91, width * .839, height / 4.91);
        tailFix1.setFill(pikaYellow);

        Polygon tailFix2 = new Polygon(width * .876, height / 2.43, width * .782,
                height / 2.43, width * .782, height / 2.37, width * .876, height / 2.37);
        tailFix2.setFill(pikaYellow);

        Polygon tailFix3 = new Polygon(width * .818, height / 1.92, width * .727,
                height / 1.92, width * .725, height / 1.88, width * .818, height / 1.88);
        tailFix3.setFill(pikaYellow);

        Polygon tailFix4 = new Polygon(width * .826, height / 1.52, width * .742,
                height / 1.52, width * .742, height / 1.49, width * .826, height / 1.494);
        tailFix4.setFill(pikaYellow);

        // Draw the eyes and details
        Circle leftEye = new Circle(width * .4, height * .36, width * .04);
        leftEye.setFill(Color.BLACK);

        Circle rightEye = new Circle((centerX - width * .4) + centerX, height * .36,
                width * .04);
        rightEye.setFill(Color.BLACK);

        Circle leftEyeSpot = new Circle(width * .412, height * .34,
                width * .015);
        leftEyeSpot.setFill(Color.WHITE);

        Circle rightEyeSpot = new Circle((centerX - width * .412) + centerX,
                height * .34, width * .015);
        rightEyeSpot.setFill(Color.WHITE);

        // Draw the nose
        Polygon pikaNose = new Polygon(centerX, centerY * .8, centerX * .98,
                centerY * .78, centerX * 1.02, centerY * .78);

        // Draw red spots
        Circle leftCheek = new Circle(centerX * .75, centerY * .9, width * .04);
        leftCheek.setFill(pikaRed);
        Circle rightCheek = new Circle((centerX - centerX * .75) + centerX,
                centerY * .9, width * .04);
        rightCheek.setFill(pikaRed);

        // Draw the mouth
        Arc leftMouth = new Arc(centerX * .95, centerY * .7, width * .1,
                height * .1, 255, 30);
        leftMouth.setType(ArcType.OPEN);
        leftMouth.setFill(transparent);
        leftMouth.setStroke(pikaOutline);
        leftMouth.setStrokeWidth(strokeWidth);

        Arc rightMouth = new Arc((centerX - centerX * .95) + centerX, centerY * .7,
                width * .1, height * .1, 255, 30);
        rightMouth.setType(ArcType.OPEN);
        rightMouth.setFill(transparent);
        rightMouth.setStroke(pikaOutline);
        rightMouth.setStrokeWidth(strokeWidth);

        Ellipse mouthMain = new Ellipse(centerX, centerY * .93, centerX * .08,
                centerY * .14);
        mouthMain.setFill(Color.DARKRED);
        mouthMain.setStroke(pikaOutline);
        mouthMain.setStrokeWidth(strokeWidth);

        // Fix the mouth
        Ellipse leftMouthFix = new Ellipse(centerX * .95, centerY * .695,
                width * .1, height * .1);
        leftMouthFix.setFill(pikaYellow);

        Ellipse rightMouthFix = new Ellipse((centerX - centerX * .95) + centerX,
                centerY * .695, width * .1, height * .1);
        rightMouthFix.setFill(pikaYellow);

        root.getChildren().addAll(tailPart1, tailPart2, tailPart3, tailPart4, tailPart5,
                tailFix1, tailFix2, tailFix3, tailFix4,
                pikaLeftFoot, pikaRightFoot, pikaBodyRight, pikaBodyLeft, pikaLeftEar,
                pikaRightEar, pikaHead,
                pikaLeftEarFix, pikaRightEarFix, pikaHeadFix, pikaBodyFix,
                leftMouth, rightMouth, mouthMain, leftMouthFix, rightMouthFix,
                leftArm1, leftArm2, leftHand, rightArm1, rightArm2, rightHand,
                leftEye, rightEye, leftEyeSpot, rightEyeSpot,
                pikaNose, leftCheek, rightCheek);
        stage.setTitle("PikaJavaCat");
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
