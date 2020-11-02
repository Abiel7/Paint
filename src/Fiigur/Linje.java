package Fiigur;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Linje extends Figur{
    private Line line;
    private double xline,yline;


    public Linje() {


    }
        public Linje(double xStart ,double yStart){
            line  = new Line(xline,yline,xStart,yStart);
            setX(xline);
            setY(yline);

        }

    @Override
    public Shape getCreate() {
      /*  if (radioButton3.isSelected()) {
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

       */

        return line;
    }

    /*private void addLine(double x, double y) {
        l = new Line(xline, yline, x, y);
        root.getChildren().add(l);

    }

     */
}
