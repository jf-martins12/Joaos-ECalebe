module com.example.joaosecalebe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.joaosecalebe to javafx.fxml;
    exports com.example.joaosecalebe;
}