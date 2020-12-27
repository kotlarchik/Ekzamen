package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/blank.fxml"));
        primaryStage.setTitle("Курсы");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//создаем окно подтверждения
                //далее заголовки и текст по желанию
                alert.setTitle("Выход");
                alert.setHeaderText("Вы уверены? Все несохранённые данные будут утеряны.");
                //создаем кнопки "да" и "нет"
                ButtonType buttonTypeOne = new ButtonType("Да");
                ButtonType buttonTypeCancel = new ButtonType("Нет", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);//додаем кнопки к самому окну подтверждения
                Optional<ButtonType> result = alert.showAndWait();//вызываем окно подтверждения
                if(result.get() == buttonTypeCancel) windowEvent.consume(); //отменяем событие если пользователь нажал отмен
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
