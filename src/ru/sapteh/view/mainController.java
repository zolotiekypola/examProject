package ru.sapteh.view;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.sapteh.DataBase;
import ru.sapteh.model.Course;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mainController {
    //tab name courses
    String courseJava = "java";
    String courseCsharp = "c#";
    String courseCplus =  "c++";

    @FXML
    private TabPane tabCourse;
    //table course java
    @FXML
    private TableView<Course> tableJava;
    @FXML
    private TableColumn<Course,String> fxFioJava;
    @FXML
    private TableColumn<Course,String> fxData1Java;
    @FXML
    private TableColumn<Course,String> fxData2Java;
    @FXML
    private TableColumn<Course,String> fxData3Java;
    @FXML
    private TableColumn<Course,String> fxData4Java;
    //table course C#
    @FXML
    private TableView<Course> tableCsharp;
    @FXML
    private TableColumn<Course,String> fxFioCsharp;
    @FXML
    private TableColumn<Course,String> fxData1Csharp;
    @FXML
    private TableColumn<Course,String> fxData2Csharp;
    @FXML
    private TableColumn<Course,String> fxData3Csharp;
    @FXML
    private TableColumn<Course,String> fxData4Csharp;

    //Table course c++
    @FXML
    private TableView<Course> tableCplus;
    @FXML
    private TableColumn<Course,String> fxFioCplus;
    @FXML
    private TableColumn<Course,String> fxData1Cplus;
    @FXML
    private TableColumn<Course,String> fxData2Cplus;
    @FXML
    private TableColumn<Course,String> fxData3Cplus;
    @FXML
    private TableColumn<Course,String> fxData4Cplus;
    @FXML
    private Label labelJava;
    @FXML
    private Label labelCsharp;
    @FXML
    private Label labelCplus;
    @FXML
    private Button buttonSaveJava;
    @FXML
    private Button buttonSaveCsharp;
    @FXML
    private Button buttonSaveCplus;

    Connection connection;
    
    //DB connect
    public  mainController(){
        connection = new DataBase().getConnect();
    }

    ObservableList<Course> listJava = FXCollections.observableArrayList();
    ObservableList<Course> listCsharp = FXCollections.observableArrayList();
    ObservableList<Course> listCplus = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        //permission to edit
        tableJava.setEditable(true);
        tableCsharp.setEditable(true);
        tableCplus.setEditable(true);
        //data from course java
        try {
            String sqlSelect = "SELECT * FROM course WHERE course = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1,courseJava);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                listJava.add(new Course(resultSet.getInt("id"),
                        resultSet.getString("course"),
                        resultSet.getString("fio"),
                        resultSet.getString("2020.12.7"),
                        resultSet.getString("2020.12.8"),
                        resultSet.getString("2020.12.9"),
                        resultSet.getString("2020.12.10")));
            }
            fxFioJava.setCellValueFactory(new PropertyValueFactory<>("fio"));

            fxData1Java.setCellValueFactory(new PropertyValueFactory<>("data1"));
            fxData1Java.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData1Java.setMinWidth(50);
            fxData1Java.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData1(newData);
            });
            fxData2Java.setCellValueFactory(new PropertyValueFactory<>("data2"));
            fxData2Java.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData2Java.setMinWidth(50);
            fxData2Java.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData2(newData);
            });
            fxData3Java.setCellValueFactory(new PropertyValueFactory<>("data3"));
            fxData3Java.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData3Java.setMinWidth(50);
            fxData3Java.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData3(newData);
            });
            fxData4Java.setCellValueFactory(new PropertyValueFactory<>("data4"));
            fxData4Java.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData4Java.setMinWidth(50);
            fxData4Java.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData4(newData);
            });
            tableJava.setItems(listJava);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //data from course c#
        try {
            String sqlSelect = "SELECT * FROM course WHERE course = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1,courseCsharp);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                listCsharp.add(new Course(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
            fxFioCsharp.setCellValueFactory(new PropertyValueFactory<>("fio"));

            fxData1Csharp.setCellValueFactory(new PropertyValueFactory<>("data1"));
            fxData1Csharp.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData1Csharp.setMinWidth(50);
            fxData1Csharp.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData1(newData);
            });
            fxData2Csharp.setCellValueFactory(new PropertyValueFactory<>("data2"));
            fxData2Csharp.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData2Csharp.setMinWidth(50);
            fxData2Csharp.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData2(newData);
            });
            fxData3Csharp.setCellValueFactory(new PropertyValueFactory<>("data3"));
            fxData3Csharp.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData3Csharp.setMinWidth(50);
            fxData3Csharp.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData3(newData);
            });
            fxData4Csharp.setCellValueFactory(new PropertyValueFactory<>("data4"));
            fxData4Csharp.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData4Csharp.setMinWidth(50);
            fxData4Csharp.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData4(newData);
            });
            tableCsharp.setItems(listCsharp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //data from course c++
        try {
            String sqlSelect = "SELECT * FROM course WHERE course = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1,courseCplus);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                listCplus.add(new Course(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
            fxFioCplus.setCellValueFactory(new PropertyValueFactory<>("fio"));

            fxData1Cplus.setCellValueFactory(new PropertyValueFactory<>("data1"));
            fxData1Cplus.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData1Cplus.setMinWidth(50);
            fxData1Cplus.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData1(newData);
            });
            fxData2Cplus.setCellValueFactory(new PropertyValueFactory<>("data2"));
            fxData2Cplus.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData2Cplus.setMinWidth(50);
            fxData2Cplus.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData2(newData);
            });
            fxData3Cplus.setCellValueFactory(new PropertyValueFactory<>("data3"));
            fxData3Cplus.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData3Cplus.setMinWidth(50);
            fxData3Cplus.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData3(newData);
            });
            fxData4Cplus.setCellValueFactory(new PropertyValueFactory<>("data4"));
            fxData4Cplus.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
            fxData4Cplus.setMinWidth(50);
            fxData4Cplus.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
                TablePosition<Course, String> pos = event.getTablePosition();
                String newData = event.getNewValue();
                int row = pos.getRow();

                Course course = event.getTableView().getItems().get(row);
                course.setData4(newData);
            });
            tableCplus.setItems(listCplus);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //button save for course java
        buttonSaveJava.setOnAction(event -> {
            try {
                Course courseJava = tableJava.getSelectionModel().getSelectedItem();
                String sqlUpdate = "UPDATE course SET `2020.12.7` = ?, `2020.12.8` = ?, `2020.12.9` = ?, `2020.12.10` = ? WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1,courseJava.getData1());
                statement.setString(2,courseJava.getData2());
                statement.setString(3,courseJava.getData3());
                statement.setString(4,courseJava.getData4());
                statement.setInt(5,courseJava.getId());
                int i = statement.executeUpdate();
                if (i == 1){
                    labelJava.setTextFill(Color.GREEN);
                    labelJava.setText("Данные сохраненны");
                }else{
                    labelJava.setTextFill(Color.RED);
                    labelJava.setText("Данные не сохраненны");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //button save for course c#
        buttonSaveCsharp.setOnAction(event -> {
            try {
                Course courseCsharp = tableCsharp.getSelectionModel().getSelectedItem();
                String sqlUpdate = "UPDATE course SET `2020.12.7` = ?, `2020.12.8` = ?, `2020.12.9` = ?, `2020.12.10` = ? WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1,courseCsharp.getData1());
                statement.setString(2,courseCsharp.getData2());
                statement.setString(3,courseCsharp.getData3());
                statement.setString(4,courseCsharp.getData4());
                statement.setInt(5,courseCsharp.getId());
                int i = statement.executeUpdate();
                if (i == 1){
                    labelCsharp.setTextFill(Color.GREEN);
                    labelCsharp.setText("Данные сохраненны");
                }else{
                    labelCsharp.setTextFill(Color.RED);
                    labelCsharp.setText("Данные не сохраненны");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        buttonSaveCplus.setOnAction(event -> {
            try {
                Course courseCplus = tableCplus.getSelectionModel().getSelectedItem();
                String sqlUpdate = "UPDATE course SET `2020.12.7` = ?, `2020.12.8` = ?, `2020.12.9` = ?, `2020.12.10` = ? WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1,courseCplus.getData1());
                statement.setString(2,courseCplus.getData2());
                statement.setString(3,courseCplus.getData3());
                statement.setString(4,courseCplus.getData4());
                statement.setInt(5,courseCplus.getId());
                int i = statement.executeUpdate();
                if (i == 1){
                    labelCplus.setTextFill(Color.GREEN);
                    labelCplus.setText("Данные сохраненны");
                }else{
                    labelCplus.setTextFill(Color.RED);
                    labelCplus.setText("Данные не сохраненны");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void menuItemClose( ActionEvent actionEvent ) throws IOException, SQLException {
        ObservableList<Course> javaTest=FXCollections.observableArrayList();
        String courseJavaClose ="java";
        String sqlSelect="SELECT * FROM course WHERE course=?";
        PreparedStatement statement=connection.prepareStatement(sqlSelect);
        statement.setString(1,courseJavaClose);
        ResultSet result=statement.executeQuery();
        while (result.next()){
            javaTest.add(new Course(result.getInt(1),result.getString(2),
                    result.getString(3),result.getString(4),
                    result.getString(5),result.getString(6),result.getString(7)));
        }
        ObservableList<Course> cSharpTest=FXCollections.observableArrayList();
        String courseCsharpClose="c#";
        String sqlSelect1="SELECT * FROM course WHERE course=?";
        PreparedStatement statement1=connection.prepareStatement(sqlSelect1);
        statement1.setString(1,courseCsharpClose);
        ResultSet result1=statement1.executeQuery();
        while (result1.next()){
            cSharpTest.add(new Course(result1.getInt(1),result1.getString(2),
                    result1.getString(3),result1.getString(4),
                    result1.getString(5),result1.getString(6),result1.getString(7)));
        }
        ObservableList<Course> cPlusTest=FXCollections.observableArrayList();
        String courseCplusClose="c++";
        String sqlSelect2="SELECT * FROM course WHERE course=?";
        PreparedStatement statement2=connection.prepareStatement(sqlSelect2);
        statement2.setString(1,courseCplusClose);
        ResultSet result2=statement2.executeQuery();
        while (result2.next()){
            cPlusTest.add(new Course(result2.getInt(1),result2.getString(2),
                    result2.getString(3),result2.getString(4),
                    result2.getString(5),result2.getString(6),result2.getString(7)));
        }
        if (javaTest.equals(listJava)&&listCsharp.equals(cSharpTest)&&listCplus.equals(cPlusTest)){
            System.exit(0);
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("confirmClose.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            MenuItem menuItem = (MenuItem)actionEvent.getTarget();
            ContextMenu cMenu = menuItem.getParentPopup();
            Scene scene = cMenu.getScene();
            Window window = scene.getWindow();
            stage.initOwner( window );
            stage.show();
        }
    }

    @FXML
    private void menuItemExport() throws IOException {
        String fileName = "c://java/test.csv";
        File file = new File(fileName) ;
        PrintWriter pW = new PrintWriter(file, "windows-1251");

        SingleSelectionModel<Tab> selectionModel = tabCourse.getSelectionModel();
        if (selectionModel.getSelectedIndex()==0){
            for (Course course:listJava) {
                pW.write(course.toString());
            }
        }
        if (selectionModel.getSelectedIndex()==1){
            for (Course course:listCsharp) {
                pW.write(course.toString());
            }
        }
        if (selectionModel.getSelectedIndex()==2){
            for (Course course:listCplus) {
                pW.write(course.toString());
            }
        }
        pW.close();
    }

}
