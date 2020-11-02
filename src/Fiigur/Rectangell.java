package Fiigur;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangell extends Figur {

   private Rectangle recta;
   private double musx;
   private  double musy;
   private boolean drar = false;
   private boolean setForan = true;

    //Rectangle r;


    public boolean isSetForan() {
        return setForan;
    }

    public Rectangell() {

    }


    public Rectangell(double x,double y,double width,double height) {
        recta = new Rectangle(x,y,width,height);
        setX(x);
        setY(y);



    }



  @Override
    public Shape getCreate(){
      recta.setCursor(Cursor.HAND);

      recta.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
                  if (ev.getButton() == MouseButton.PRIMARY){

                     // musx = ev.getSceneX();
                     // musy = ev.getSceneY();
                      //recta.getLayoutX();
                      //recta.getLayoutY();
                      if(isSetForan()){
                          recta.setX(ev.getX());
                          recta.setY(ev.getY());
                          recta.toFront();
                      }
                  }
      });
      recta.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
          if (ev.getButton() == MouseButton.SECONDARY){
              recta.setWidth(ev.getX());
              recta.setHeight(ev.getY());

          }

      });

        return recta;
    }



    /* pane.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
        xline = ev.getX();
        yline = ev.getY();

    });
                recta.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
        recta.setX(event.getX());
          recta.setY(event.getY());
    });
                pane.addEventHandler(MouseEvent.MOUSE_RELEASED, ev -> {
        line = null;
    });


     */




}
