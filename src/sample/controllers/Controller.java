package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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

    @FXML
    private TableView tableOOP;
    @FXML
    private TableColumn columnOOPstudent;
    @FXML
    private TableColumn columnOOPdate1;
    @FXML
    private TableColumn columnOOPdate2;
    @FXML
    private TableColumn columnOOPdate3;
    @FXML
    private TableColumn columnOOPdate4;

    @FXML
    private TableView tableJava;
    @FXML
    private TableColumn columnJavaStudent;
    @FXML
    private TableColumn columnJavadate1;
    @FXML
    private TableColumn columnJavadate2;
    @FXML
    private TableColumn columnJavadate3;
    @FXML
    private TableColumn columnJavadate4;

    @FXML
    private TableView tableEclipse;
    @FXML
    private TableColumn columnEclipseStudent;
    @FXML
    private TableColumn columnEclipsedate1;
    @FXML
    private TableColumn columnEclipsedate2;
    @FXML
    private TableColumn columnEclipsedate3;
    @FXML
    private TableColumn columnEclipsedate4;

    @FXML
    private Button buttonSaveOOP;
    @FXML
    private Button buttonSaveJava;
    @FXML
    private Button buttonSaveEclipse;

    @FXML
    public void initialize(){
        try {
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
                        resultSet.getString(7)));
            }
            columnOOPstudent.setCellValueFactory(new PropertyValueFactory<>("student"));

            columnOOPdate1.setCellValueFactory(new PropertyValueFactory<>("date1"));
            columnOOPdate1.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());

            columnOOPdate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnOOPdate2.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());

            columnOOPdate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnOOPdate3.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());

            columnOOPdate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            columnOOPdate4.setCellFactory(TextFieldTableCell.<Blank>forTableColumn());

            tableOOP.setItems(oopList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
            columnJavadate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnJavadate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnJavadate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            tableJava.setItems(javaList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
            columnEclipsedate2.setCellValueFactory(new PropertyValueFactory<>("date2"));
            columnEclipsedate3.setCellValueFactory(new PropertyValueFactory<>("date3"));
            columnEclipsedate4.setCellValueFactory(new PropertyValueFactory<>("date4"));
            tableEclipse.setItems(eclipseList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void pressSaveOOP(ActionEvent event){

    }
    public void pressSaveJava(ActionEvent event){

    }
    public void pressSaveEclipse(ActionEvent event){

    }
}
