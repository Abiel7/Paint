package Fiigur;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Linje extends Figur{
private Line line;
private double x;
private double y;


    public Linje(Line line) {

        this.line = line;
    }
        public Linje(double xStart ,double yStart){
            line  = new Line(x,y,xStart,yStart);
            setX(x);
            setY(y);

        }
        // legger til circle for å dra linje
        protected void  cir(double x, double y){
        Circle cir =  new Circle(x,y,15);
        cir.fillProperty().set(Color.RED);

        }
    @Override
    public Shape getCreate() {

        return line;
    }
}
