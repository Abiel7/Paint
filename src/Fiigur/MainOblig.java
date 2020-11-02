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


    ColorPicker picker = new ColorPicker();
    Label lbl = new Label(" velg farge ");
    ArrayList<Figur> figures = new ArrayList<>();


    private Pane pane;


    @Override
    public void start(Stage primaryStage) {

        pane = new Pane();
// lager radio button knapper
        RadioButton radioButton1 = new RadioButton("Rectangel");
        RadioButton radioButton2 = new RadioButton("Circle");
        RadioButton radioButton3 = new RadioButton("Linje");
//  togle group skal hjelp med å skille radio button hver kgng jeg trykker på en så skal kunn
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);

        // lager h box for å sorter knapper, label og
        HBox hbox = new HBox(lbl, picker, radioButton1, radioButton2, radioButton3);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(25, 50, 50, 60));
        pane.getChildren().add(hbox);

        /* her skal det tegenes figurer av circle rectangel og linje
        * linje circle og rectagnel har sin egen classe med de er subclasse av figure
        *
         */
       pane.setOnMouseClicked(ev ->{
            if(ev.getButton().equals(MouseButton.MIDDLE)) {
                if (radioButton1.isSelected()) {
                    Figur figurRectangel = new Rectangell(100, 200, 100, 100);
                    Shape s = figurRectangel.getCreate();
                    pane.getChildren().add(s);
                    figures.add(figurRectangel);
                    s.setFill(picker.getValue());
                } else if (radioButton2.isSelected()) {
                    Figur figurCircle = new Circlee(100, 100);
                    Shape c = figurCircle.getCreate();
                    figures.add(figurCircle);
                    pane.getChildren().add(c);
                    c.setFill(picker.getValue());
                } else if (radioButton3.isSelected()) {
                    Figur figLinje = new Linje();
                    Shape linjeShape = figLinje.getCreate();
                    figures.add(figLinje);
                    pane.getChildren().add(linjeShape);

                }
            }
        });

            Scene scene = new Scene(pane,700,650);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
