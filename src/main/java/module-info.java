module algorithmsvisualguide {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;
    requires annotations;

//    opens algorithmsvisualguide to javafx.fxml;
//    exports algorithmsvisualguide;
    exports algorithmsvisualguide.ui;
    opens algorithmsvisualguide.ui to javafx.fxml;
}