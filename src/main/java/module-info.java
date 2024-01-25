module com.example.gogoclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gogoclient to javafx.fxml;
    exports com.example.gogoclient;
    exports com.example.controllers;
    opens com.example.controllers to javafx.fxml;
}