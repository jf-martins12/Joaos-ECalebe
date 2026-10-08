module com.example.joaosecalebe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.joaosecalebe to javafx.fxml;
    exports com.example.joaosecalebe;

    opens com.example.joaosecalebe.Controller to javafx.fxml;
    exports com.example.joaosecalebe.Controller;

    opens com.example.joaosecalebe.Model to javafx.fxml;
    exports com.example.joaosecalebe.Model;

    opens com.example.joaosecalebe.DataBase to javafx.fxml;
    exports com.example.joaosecalebe.DataBase;

}