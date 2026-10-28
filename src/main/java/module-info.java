module com.example.joaosecalebe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.joaosecalebe.Controller to javafx.fxml;
    exports com.example.joaosecalebe.Controller;
    opens com.example.joaosecalebe.Model to javafx.base;

    exports com.example.joaosecalebe;


}