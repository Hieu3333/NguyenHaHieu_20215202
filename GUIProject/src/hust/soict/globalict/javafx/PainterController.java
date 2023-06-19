/*
 * package hust.soict.globalict.javafx;
 * 
 * import java.awt.Color;
 * 
 * import javafx.event.ActionEvent; import javafx.fxml.FXML; import
 * javafx.scene.input.MouseEvent; import javafx.scene.layout.Pane; import
 * javafx.scene.shape.Circle; public class PainterController {
 * 
 * @FXML private Pane drawingAreaPane;
 * 
 * @FXML void clearButtonPressed(ActionEvent event) {
 * drawingAreaPane.getChildren().clear(); }
 * 
 * @FXML void drawingAreaMouseDragged(MouseEvent event) { Circle newCirle = new
 * Circle(event.getX(), event.getY(),4);
 * drawingAreaPane.getChildren().add(newCirle); }
 * 
 * }
 */

package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private boolean check;

    @FXML
    private ToggleGroup same;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (check) {
    	    Circle newCirle = new Circle(event.getX(), event.getY(),4,Color.BLACK);
    	    drawingAreaPane.getChildren().add(newCirle);
    	}
    	else {
    		Circle newCirle = new Circle(event.getX(), event.getY(),4,Color.WHITE);
        	drawingAreaPane.getChildren().add(newCirle);
    	}
    }

    @FXML
    void eraserButtonPressed(ActionEvent event) {
    	check = false;
    }

    @FXML
    void penButtonPressed(ActionEvent event) {
    	check = true;
    }

}

