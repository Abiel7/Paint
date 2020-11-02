package Fiigur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import testShapes.Form;

import java.util.ArrayList;

public class MainOblig extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ColorPicker picker = new ColorPicker();
    Label lbl = new Label(" velg farge ");
    ArrayList<Figur> figures = new ArrayList<Figur>();
    private Line line;
    private Pane pane;
    private double xline;
    private double yline;
    BorderPane root= null;
    double bredde, høyde;
    TextArea musPosisjon;
    Figur figuren;
    @Override
    public void start(Stage primaryStage) {

        pane = new Pane();

        RadioButton radioButton1 = new RadioButton("Rectangel");
        RadioButton radioButton2 = new RadioButton("Circle");
        RadioButton radioButton3 = new RadioButton("Linje");

        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);


        HBox hbox = new HBox(lbl, picker, radioButton1, radioButton2, radioButton3);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(25, 50, 50, 60));
        pane.getChildren().add(hbox);



       pane.setOnMouseClicked(ev ->{
            if(ev.getButton().equals(MouseButton.MIDDLE)){
                if (radioButton1.isSelected()) {
                    Figur figurRectangel = new Rectangell(100, 200, 100, 100);
                    Shape s = figurRectangel.getCreate();
                    pane.getChildren().add(s);
                    figures.add(figurRectangel);
                    s.setFill(picker.getValue());
                }
            }

        });


        pane.setOnMouseClicked(event ->{
            if(event.getButton().equals(MouseButton.MIDDLE)){
                if (radioButton2.isSelected()) {
                    Figur figurCircle = new Circlee(100, 100, 50);
                    Shape c = figurCircle.getCreate();
                    figures.add(figurCircle);
                    //figurCircle.nyStørrelse();
                    pane.getChildren().add(c);
                    c.setFill(picker.getValue());


                }
            }



        });



        /*radioButton1.setOnAction(event -> {
            if (radioButton1.isSelected()) {
                Figur figurRectangel = new Rectangell(100, 200, 100, 100);
                Shape s = figurRectangel.getCreate();
                pane.getChildren().add(s);
                figures.add(figurRectangel);
                s.setFill(picker.getValue());
            }
        });

         */





        radioButton3.setOnAction(event -> {

            if (radioButton3.isSelected()) {
                pane.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
                    xline = ev.getX();
                    yline = ev.getY();

                });
                pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
                    if (line == null) {
                        addLine(ev.getX(), ev.getY());
                    } else {
                        line.setEndX(ev.getX());
                        line.setEndY(ev.getY());
                    }
                });
                pane.addEventHandler(MouseEvent.MOUSE_RELEASED, ev -> {
                    line = null;
                });
            }
        });




        // arraylist.add(figur);
            // når jeg tykker på canvs så lager den figuren, den blir stored av arraylist


            //ArrayList<Figur> figures = new ArrayList<Figur>();
            //figures.add(figur);
            //figures.add(figur2);
            //figures.add(figur3);


            Scene scene = new Scene(pane,700,650);
            primaryStage.setScene(scene);
            primaryStage.show();


        }







    private void addLine(double x, double y) {
        line = new Line(xline, yline, x, y);
        pane.getChildren().add(line);

    }


}
