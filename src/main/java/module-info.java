module com.example.joaosecalebe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.joaosecalebe.Controller to javafx.fxml;
    exports com.example.joaosecalebe.Controller;

    exports com.example.joaosecalebe;

}