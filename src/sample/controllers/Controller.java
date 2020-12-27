package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.ConnectionDB;
import sample.model.Blank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    // Подключение к БД
    Connection connection = null;
    public Controller(){
        connection = new ConnectionDB().getConnection();
    }

    ObservableList<Blank> oopList = FXCollections.observableArrayList();
    ObservableList<Blank> javaList = FXCollections.observableArrayList();
    ObservableList<Blank> eclipseList = FXCollections.observableArrayList();

    // Table OOP
    @FXML
    private TableView<Blank> tableOOP;
    @FXML
    private TableColumn<Blank, String> columnOOPstudent;
    @FXML
    private TableColumn<Blank, String> columnOOPdate1;
    @FXML
    private TableColumn<Blank, String> columnOOPdate2;
    @FXML
    private TableColumn<Blank, String> columnOOPdate3;
    @FXML
    private TableColumn<Blank, String> columnOOPdate4;

    // Table Java
    @FXML
    private TableView<Blank> tableJava;
    @FXML
    private TableColumn<Blank, String> columnJavaStudent;
    @FXML
    private TableColumn<Blank, String> columnJavadate1;
    @FXML
    private TableColumn<Blank, String> columnJavadate2;
    @FXML
    private TableColumn<Blank, String> columnJavadate3;
    @FXML
    private TableColumn<Blank, String> columnJavadate4;

    // Table Eclipse
    @FXML
    private TableView<Blank> tableEclipse;
    @FXML
    private TableColumn<Blank, String> columnEclipseStudent;
    @FXML
    private TableColumn<Blank, String> columnEclipsedate1;
    @FXML
    private TableColumn<Blank, String> columnEclipsedate2;
    @FXML
    private TableColumn<Blank, String> columnEclipsedate3;
    @FXML
    private TableColumn<Blank, String> columnEclipsedate4;

    @FXML
    public void initialize(){
        try {
            // OOP.
            String course = "OOP";
            String sqlSelectOOP = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelectOOP);
            statement.setString(1, course);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){ oopList.add(new Blank(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            }
            columnOOPstudent.setCellValueFactory(new PropertyValueFactory<>("student"));

            columnOOPdate1.setCellValueFactory(new PropertyValueFactory<>("date1"));
            columnOOPdate1.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnOOPdate1.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate1(newRating);
            });

            columnOOPdate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnOOPdate2.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnOOPdate2.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate2(newRating);
            });

            columnOOPdate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnOOPdate3.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnOOPdate3.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate3(newRating);
            });

            columnOOPdate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            columnOOPdate4.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnOOPdate4.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate4(newRating);
            });

            tableOOP.setItems(oopList);
            tableOOP.setEditable(true);
            tableOOP.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                    showPersonDetails(newValue));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // JAVA.
        try {
            String course = "Java";
            String sqlSelectJava = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelectJava);
            statement.setString(1, course);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){ javaList.add(new Blank(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)));
            }
            columnJavaStudent.setCellValueFactory(new PropertyValueFactory<>("student"));

            columnJavadate1.setCellValueFactory(new PropertyValueFactory<>("date1"));
            columnJavadate1.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnJavadate1.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate1(newRating);
            });

            columnJavadate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnJavadate2.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnJavadate2.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate2(newRating);
            });

            columnJavadate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnJavadate3.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnJavadate3.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate3(newRating);
            });

            columnJavadate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            columnJavadate4.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnJavadate4.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate4(newRating);
            });

            tableJava.setItems(javaList);
            tableJava.setEditable(true);
            tableJava.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                    showPersonDetails(newValue));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // ECLIPSE.
        try {
            String course = "Eclipse";
            String sqlSelectEclipse = "SELECT * FROM blank WHERE courses = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelectEclipse);
            statement.setString(1, course);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){ eclipseList.add(new Blank(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)));
            }
            columnEclipseStudent.setCellValueFactory(new PropertyValueFactory<>("student"));

            columnEclipsedate1.setCellValueFactory(new PropertyValueFactory<>("date1"));
            columnEclipsedate1.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnEclipsedate1.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate1(newRating);
            });

            columnEclipsedate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnEclipsedate2.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnEclipsedate2.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate2(newRating);
            });

            columnEclipsedate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnEclipsedate3.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnEclipsedate3.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate3(newRating);
            });

            columnEclipsedate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            columnEclipsedate4.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());
            columnEclipsedate4.setOnEditCommit((TableColumn.CellEditEvent<Blank, String> event) -> {
                TablePosition<Blank, String> pos = event.getTablePosition();
                String newRating = event.getNewValue();
                int row = pos.getRow();
                Blank blank = event.getTableView().getItems().get(row);
                blank.setDate4(newRating);
            });

            tableEclipse.setItems(eclipseList);
            tableEclipse.setEditable(true);
            tableEclipse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                    showPersonDetails(newValue));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showPersonDetails(Blank blank) {
        if (blank != null){
            System.out.println(blank.getId() + " " + blank.getStudent() + " " + blank.getCourses() + " " + blank.getDate1() + " " +
                    blank.getDate2() + " " + blank.getDate3() + " " + blank.getDate4());
        }
    }

    // Button save OOP.
    public void pressSaveOOP(ActionEvent event){
        try {
            Blank blankOOP = tableOOP.getSelectionModel().getSelectedItem();
            String sqlUpdateOOP = "UPDATE blank SET dateOne = ?, dateTwo = ?, dateThree = ?, dateFour = ? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sqlUpdateOOP);
            statement.setString(1, blankOOP.getDate1());
            statement.setString(2, blankOOP.getDate2());
            statement.setString(3, blankOOP.getDate3());
            statement.setString(4, blankOOP.getDate4());
            statement.setInt(5, blankOOP.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Button save Java.
    public void pressSaveJava(ActionEvent event){
        try {
            Blank blankJava = (Blank) tableJava.getSelectionModel().getSelectedItem();
            String sqlUpdateJava = "UPDATE blank SET dateOne = ?, dateTwo = ?, dateThree = ?, dateFour = ? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sqlUpdateJava);
            statement.setString(1, blankJava.getDate1());
            statement.setString(2, blankJava.getDate2());
            statement.setString(3, blankJava.getDate3());
            statement.setString(4, blankJava.getDate4());
            statement.setInt(5, blankJava.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Button save Eclipse.
    public void pressSaveEclipse(ActionEvent event){
        try {
            Blank blankEclipse = (Blank) tableEclipse.getSelectionModel().getSelectedItem();
            String sqlUpdateEclipse = "UPDATE blank SET dateOne = ?, dateTwo = ?, dateThree = ?, dateFour = ? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sqlUpdateEclipse);
            statement.setString(1, blankEclipse.getDate1());
            statement.setString(2, blankEclipse.getDate2());
            statement.setString(3, blankEclipse.getDate3());
            statement.setString(4, blankEclipse.getDate4());
            statement.setInt(5, blankEclipse.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
