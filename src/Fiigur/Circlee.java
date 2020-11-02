package Fiigur;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Circlee extends Figur {
   private Circle circle;
   private boolean cirSetForan = true;


      private TextField text;
   public Circlee() {
   }

   public Circlee(double y, double x,double radius) {
      circle = new Circle(x,y,50);
      circle.setFill(Color.RED);
     setX(x);
     setY(y);

      getCreate();

   }

   public boolean isCirSetForan() {
      return cirSetForan;
   }

   public Circle getCreate() {
      circle.setCursor(Cursor.HAND);
      /*circle.setOnMouseDragged(event ->{
         circle.setCenterX(event.getX());
         circle.setCenterY(event.getY());
      });


      circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
         @Override
         public void handle(MouseEvent e) {
            if(e.getButton() == MouseButton.SECONDARY){
               circle.setOnMouseDragged(event->{
                  circle.setRadius(event.getY());
               });
            }
         }
      });

       */
      circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
         if (ev.getButton() == MouseButton.PRIMARY){
            if(isCirSetForan()){
               circle.setCenterX(ev.getX());
               circle.setCenterY(ev.getY());
               circle.toFront();
            }
         }
      });
      circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
         if (ev.getButton() == MouseButton.SECONDARY){
            circle.setRadius(ev.getY());

         }

      });






      /*text = new TextField();
      circle.setOnMouseMoved(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
            String msg =
                    "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
                            "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
                            "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";

            text.setText(msg);

         }

      });
      */
      circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
         @Override
         public void handle(MouseEvent e) {
            if(e.getButton() == MouseButton.SECONDARY){
               circle.setOnMouseDragged(event->{
                  circle.setRadius(event.getY());
               });
            }
         }
      });

      return circle;
   }







  /* public Circle create(){
       circle.setCursor(Cursor.HAND);
      circle.setOnMouseDragged(event ->{
         circle.setCenterX(event.getX());
         circle.setCenterY(event.getY());
      });
   }

   */
 /*circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
      @Override
      public void handle(MouseEvent e) {
         if(e.getButton() == MouseButton.SECONDARY){
            circle.setOnMouseDragged(e->{
               circle.setRadius(circle.getRadius event.getY());
            });
         }
      }
   });

  */


}
