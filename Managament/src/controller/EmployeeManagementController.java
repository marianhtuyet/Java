/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static Model.DAO.DB_URL;
import static Model.DAO.DRIVER;
import static Model.DAO.PASS;
import static Model.DAO.USER;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import Model.*;
import Model.EmployeeDAO;
import java.io.IOException;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javax.management.Query.value;
import javax.print.DocFlavor;

/**
 *
 * @author MyPC
 */
public class EmployeeManagementController implements Initializable {
//     khai bao cac list danh sach

    private EmployeeDAO Employees;
    List<Employee> listEmployees;
    ObservableList<Employee> list = FXCollections.observableArrayList();
    ObservableList<gender> genderList = FXCollections.observableArrayList(gender.values());
    ObservableList<Province> listprovince = FXCollections.observableArrayList(Province.values());
    List<Employee> newEmployees = new ArrayList<Employee>();
    @FXML
    private TableView<Employee> tbEmployee;
    @FXML
    private TableColumn<Employee, Integer> colID;
    @FXML
    private TableColumn<Employee, String> colName;
    @FXML
    private TableColumn<Employee, String> colEmail;
    @FXML
    private TableColumn<Employee, gender> colGender;
    @FXML
    private TableColumn<Employee, Integer> colCardNumber;
    @FXML
    private TableColumn<Employee, Province> colProvince_id;
    @FXML
    private TableColumn<Employee, String> colAddress;
    private AnchorPane rootpanel;
    ///from add employees
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Employees = new EmployeeDAO();
        listEmployees = Employees.getEmployee();
        setCellValueFactory();
        tbEmployee.setItems((ObservableList<Employee>) listEmployees);
        tbEmployee.getColumns().addAll(colID, colName, colEmail, colGender, colCardNumber, colProvince_id, colAddress);
        tbEmployee.setEditable(true);
//        ---edit cell in table
        setCellFactory();

        colProvince_id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Province>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Province> event) {
                TablePosition<Employee, Province> pos = event.getTablePosition();
                Province newProvince = event.getNewValue();
                int row = pos.getRow();
                Employee employee = event.getTableView().getItems().get(row);

                employee.setGender(newProvince.getIdProvince());

            }
        });
        colGender.setOnEditCommit((event) -> {
            TablePosition<Employee, gender> pos = event.getTablePosition();
            gender newgenner = event.getNewValue();
            int row = pos.getRow();
            Employee employee = event.getTableView().getItems().get(row);
            employee.setGender(newgenner.getCode());

        });
        colName.setOnEditCommit(event -> {
            TablePosition<Employee, String> pos = event.getTablePosition();
            String newString = event.getNewValue();
            int row = pos.getRow();
            if (newString.contains("!") || newString.contains("@") || newString.contains("#") || newString.contains("$")
                    || newString.contains("%") || newString.contains("^") || newString.contains("&") || newString.contains("*")
                    || newString.contains("(") || newString.contains(")") || newString.contains(".") || newString.contains(",")
                    || newString.contains("/") || newString.contains("?")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The name have !@#$$%^&. Please press againt");

                alert.show();
            } else {
                Employee employee = event.getTableView().getItems().get(row);
                employee.setName(newString);
            }
        });
        

    }

    @FXML
    public void EditCell() {

    }

    void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        colCardNumber.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_card_number"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        colGender.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee, gender>, ObservableValue<gender>>() {
            @Override
            public ObservableValue<gender> call(TableColumn.CellDataFeatures<Employee, gender> param) {
                Employee employee = param.getValue();
                int genderCode = employee.getGender();
                gender gen = gender.getByCode(genderCode);
                return new SimpleObjectProperty<gender>(gen);
            }
        });
        colProvince_id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee, Province>, ObservableValue<Province>>() {
            @Override
            public ObservableValue<Province> call(TableColumn.CellDataFeatures<Employee, Province> param) {
                Employee employee = param.getValue();
                int ProvinceId = employee.getProvince_id();
                Province province = Province.getByCode(ProvinceId);
                return new SimpleObjectProperty<Province>(province);
            }
        });
    }

    void setCellFactory() {
        colName.setCellFactory(new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>() {
            @Override
            public TableCell<Employee, String> call(TableColumn<Employee, String> param) {
                TextFieldTableCell textField = new TextFieldTableCell();
                textField.setAlignment(Pos.BASELINE_LEFT);

                return textField;
            }
        });
        colEmail.setCellFactory(new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>() {
            @Override
            public TableCell<Employee, String> call(TableColumn<Employee, String> param) {
                TextFieldTableCell textField = new TextFieldTableCell();
                textField.setAlignment(Pos.BASELINE_LEFT);
                return textField;
            }
        });
        colCardNumber.setCellFactory(new Callback<TableColumn<Employee, Integer>, TableCell<Employee, Integer>>() {
            @Override
            public TableCell<Employee, Integer> call(TableColumn<Employee, Integer> param) {
                TextFieldTableCell textField = new TextFieldTableCell();
                textField.setAlignment(Pos.CENTER);
                return textField;
            }
        });

        colAddress.setCellFactory(new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>() {
            @Override
            public TableCell<Employee, String> call(TableColumn<Employee, String> param) {
                TextFieldTableCell textField = new TextFieldTableCell();
                textField.setAlignment(Pos.CENTER);

                return textField;
            }
        });
        colGender.setCellFactory(ComboBoxTableCell.forTableColumn(genderList));

        colProvince_id.setCellFactory(ComboBoxTableCell.forTableColumn(listprovince));
    }

    public void Edittable() {
        
//     colID.setOnEditCommit(value);

    }

    @FXML
    private void btnAddClick(ActionEvent event) throws IOException {
        int max = 0;
        for (Employee e : listEmployees) {
            if (e.getId() > max) {
                max = e.getId();
            }
        }
        listEmployees.add(new Employee(max + 1));
        tbEmployee.setItems((ObservableList<Employee>) listEmployees);
        colID.setCellFactory(new Callback<TableColumn<Employee, Integer>, TableCell<Employee, Integer>>() {
            @Override
            public TableCell<Employee, Integer> call(TableColumn<Employee, Integer> param) {
                TextFieldTableCell textField = new TextFieldTableCell();
                textField.setAlignment(Pos.CENTER);

                return textField;
            }
        });
    }

    @FXML
    private void btnDeleteClick(ActionEvent event) {
    }

    @FXML
    private void btnSaveClick(ActionEvent event) {
        for (Employee row : tbEmployee.getItems()) {
            if (CheckEmployee(row) != 0) {
                newEmployees.add(row);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The information of employee was wrong! Please press againt");

                System.out.print("Can't submit data");
            }

        }
        for (int i = 0; i < newEmployees.size(); i++) {
            if (listEmployees.get(i).getId() == newEmployees.get(i).getId()) {
                Employees.UpdateEmployee(newEmployees.get(i));
            } else {
                Employees.AddEmployee(newEmployees.get(i));
            }
        }
    }

    int CheckEmployee(Employee e) {
        if (e.getId() != (int) e.getId()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.show();
            return 0;
        }
        if (e.getName().contains("!") || e.getName().contains("@") || e.getName().contains("#") || e.getName().contains("$")
                || e.getName().contains("%") || e.getName().contains("^") || e.getName().contains("&") || e.getName().contains("*")
                || e.getName().contains("(") || e.getName().contains(")") || e.getName().contains(".") || e.getName().contains(",")
                || e.getName().contains("/") || e.getName().contains("?")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.show();
            return 0;
        }
        if (!e.getEmail().contains("@")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.show();
            return 0;

        }
        return 1;
    }

}
