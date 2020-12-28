package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.*;
import sample.ConnectionDB;
import sample.model.Blank;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Controller {
    Connection connection = null;
    public Controller() {
        connection = new ConnectionDB().getConnection();
    }
    ObservableList<Blank> listCourse = FXCollections.observableArrayList();
    ObservableList<Blank> checking = FXCollections.observableArrayList();
    ObservableList<String> list = FXCollections.observableArrayList("OOP", "Java", "Eclipse");

    @FXML
    private ComboBox<String> comboBoxCourse;
    @FXML
    private Label labelCourse;
    @FXML
    private TableView<Blank> tableCourse;
    @FXML
    private TableColumn<Blank, String> fullNameColumn;
    @FXML
    private TableColumn<Blank, String> columnDate1;
    @FXML
    private TableColumn<Blank, String> columnDate2;
    @FXML
    private TableColumn<Blank, String> columnDate3;
    @FXML
    private TableColumn<Blank, String> columnDate4;

    private String nameCourse;

    // Всплывающий список.
    public void actionComboBoxCourse() throws IOException {
    // Очистка таблицы.
        if (listCourse != null) {
            for (int i = 0; i < listCourse.size(); i++) {
                listCourse.remove(i--);
            }
        }
        // Запись в объект.
        labelCourse.setText(comboBoxCourse.getValue());
        nameCourse = comboBoxCourse.getValue();
        try {
            String sqlSelect = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1, nameCourse);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listCourse.add(new Blank(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Прсомотр и изменение данных в таблице.
    @FXML
    public void initialize() {
        comboBoxCourse.setItems(list);
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("student"));
        columnDate1.setCellValueFactory(new PropertyValueFactory<>("date1"));
        columnDate1.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
        columnDate1.setOnEditCommit((TableColumn.CellEditEvent<Blank,String> event) -> {
            TablePosition<Blank, String> pos = event.getTablePosition();
            String student = event.getNewValue();
            int row = pos.getRow();

            Blank course = event.getTableView().getItems().get(row);
            course.setDate1(student);
        });

        columnDate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
        columnDate2.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
        columnDate2.setOnEditCommit((TableColumn.CellEditEvent<Blank,String> event) -> {
            TablePosition<Blank, String> pos = event.getTablePosition();
            String student = event.getNewValue();
            int row = pos.getRow();

            Blank course = event.getTableView().getItems().get(row);
            course.setDate2(student);
        });
        columnDate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
        columnDate3.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
        columnDate3.setOnEditCommit((TableColumn.CellEditEvent<Blank,String> event) -> {
            TablePosition<Blank, String> pos = event.getTablePosition();
            String student = event.getNewValue();
            int row = pos.getRow();

            Blank course = event.getTableView().getItems().get(row);
            course.setDate3(student);
        });
        columnDate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
        columnDate4.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
        columnDate4.setOnEditCommit((TableColumn.CellEditEvent<Blank,String> event) -> {
            TablePosition<Blank, String> pos = event.getTablePosition();
            String student = event.getNewValue();
            int row = pos.getRow();

            Blank course = event.getTableView().getItems().get(row);
            course.setDate4(student);
        });
        tableCourse.setEditable(true);
        tableCourse.setItems(listCourse);
        showPersonDetails(null);
        tableCourse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                showPersonDetails(newValue));
    }

    private void showPersonDetails(Blank blank) {
        if (blank != null) {
            System.out.println(blank.getId() + " " + blank.getStudent() + " " + blank.getCourses() + " " + blank.getDate1() + " " +
                    blank.getDate2() + " " + blank.getDate3() + " " + blank.getDate4());
        }
    }

    // Кнопка сохранения.
    public void buttonSave(ActionEvent event) throws IOException {
        try {
            Blank blank = tableCourse.getSelectionModel().getSelectedItem();
            String sqlUpdate = "UPDATE blank SET dateOne = ?, dateTwo = ?, dateThree = ?, dateFour = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, blank.getDate1());
            statement.setString(2, blank.getDate2());
            statement.setString(3, blank.getDate3());
            statement.setString(4, blank.getDate4());
            statement.setInt(5, blank.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Кнопка выхода.
    public void buttonExit(ActionEvent event){
        try {
            String sqlSelect = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1, nameCourse);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                checking.add(new Blank(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4),
                        result.getString(5), result.getString(6), result.getString(7)));

            }

            // Проверка сохранения данных.
            if (checking.equals(listCourse)){
                System.exit(0);
            }else {
                Parent root = FXMLLoader.load(getClass().getResource("/sample/view/wind.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Exit");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/icon.png")));
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    // Кнопка выхода в MenuBar.
    public void buttonMenuBarExit(){
        try {
            String sqlSelect = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1, nameCourse);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                checking.add(new Blank(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4),
                        result.getString(5), result.getString(6), result.getString(7)));
            }

            // Проверка сохранения.
            if (checking.equals(listCourse)){
                System.exit(0);
            }else {
                Parent root = FXMLLoader.load(getClass().getResource("/sample/view/wind.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Exit");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/icon.png")));
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    // Экспорт файла.
    public void buttonMenuBarExport() throws IOException {
        DirectoryChooser dir = new DirectoryChooser();
        dir.setTitle("Выберите путь");
        File directory = dir.showDialog(new Stage());
        if ( directory != null){
            File file = new File(directory + "/"  + nameCourse + ".csv");
            file.createNewFile();

            PrintWriter printWriter = new PrintWriter(file,"windows-1251");
            for (Blank blank: listCourse) {
                printWriter.write(blank.toString());
            }
            printWriter.close();
        }
    }
}