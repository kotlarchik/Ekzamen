package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.ConnectionDB;
import java.sql.Connection;

public class ControllerWind {
    Connection connection = null;
    public ControllerWind(){ connection = new ConnectionDB().getConnection(); }

    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonBack;

    // Кнопка закрытия программы в окне предупреждения.
    public void pressExit(ActionEvent event){
        System.exit(0);
    }

    // Кнопка закрытия окна предупреждения.
    public void pressBack(ActionEvent event){
        buttonBack.getScene().getWindow().hide();
    }
}
