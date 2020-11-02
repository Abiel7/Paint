package Fiigur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;

public class Polynom extends Figur{
    Polygon polygon;
    //private final DoubleProperty x, y;

    /*public Polynom(Color color,DoubleProperty x, DoubleProperty y){
        super(x.get(), y.get(), 10);

        this.x = x;
        this.y = y;
    }

     */
    public Polynom(double x1, double y1, double x2, double y2, double x3, double y3) {

        polygon = new Polygon();
        polygon.getPoints().setAll(x1,y1,x2, y2, x3, y3);
        polygon.setStroke(Color.FORESTGREEN);
        polygon.setStrokeWidth(4);
        polygon.setStrokeLineCap(StrokeLineCap.ROUND);
        polygon.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));
    }

    public Polygon getCreate() {

        return polygon;
    }

    private ObservableList<Polynom> create( final ObservableList<Double> points ){
        ObservableList<Polynom> nodes = FXCollections.observableArrayList();
        for ( int i = 0;i<points.size();i+=2){
            final int idx = i;

            DoubleProperty xProperty = new SimpleDoubleProperty(points.get(i));
            DoubleProperty yProperty = new SimpleDoubleProperty(points.get(i + 1));

            xProperty.addListener(new ChangeListener<Number>() {
                @Override public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {
                    points.set(idx, (double) x);
                }
            });

            yProperty.addListener(new ChangeListener<Number>() {
                @Override public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {
                    points.set(idx + 1, (double) y);
                }
            });

            //nodes.add(new Polynom(Color.GOLD, xProperty, yProperty));
        }
        return nodes;
    }




}
