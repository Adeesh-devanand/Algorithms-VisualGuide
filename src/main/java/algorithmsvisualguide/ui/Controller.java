package algorithmsvisualguide.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    public Button button1;

    @FXML
    public Circle vertice;

    private double xOffset = 0;
    private double yOffset = 0;

    public void initialize() {
    }

    @FXML
    protected void onButtonClick() {
        System.out.println("clicked!!");
    }

    @FXML
    public void onDragDetected(MouseEvent event) {
        System.out.println("DragDetected");

        xOffset = event.getSceneX() - vertice.getLayoutX();
        yOffset = event.getSceneY() - vertice.getLayoutY();
    }

    @FXML
    public void onMouseDragged(MouseEvent event) {
        System.out.println("DragDetected");

        double newX = event.getSceneX() - xOffset;
        double newY = event.getSceneY() - yOffset;


        vertice.setLayoutX(newX);
        vertice.setLayoutY(newY);
    }
}

