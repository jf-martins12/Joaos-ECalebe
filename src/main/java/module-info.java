module com.example.joaosecalebe {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.joaosecalebe;
    exports com.example.joaosecalebe.Controller;
    exports com.example.joaosecalebe.Model;

    opens com.example.joaosecalebe to javafx.fxml;
    opens com.example.joaosecalebe.Controller to javafx.fxml;

    opens com.example.joaosecalebe.Model to javafx.base;
}