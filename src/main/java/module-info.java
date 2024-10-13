module es.ieslosmontecillos.keyevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.keyevent to javafx.fxml;
    exports es.ieslosmontecillos.keyevent;
}