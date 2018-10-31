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

import Model.Employee;
import Model.EmployeeDAO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javax.management.Query.value;

/**
 *
 * @author MyPC
 */
public class EmployeeManagementController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Employee> tbEmployee;
    @FXML
    private TableColumn<Employee, Integer> colID;
    @FXML
    private TableColumn<Employee, String> colName;
    @FXML
    private TableColumn<Employee, String> colEmail;
    @FXML
    private TableColumn<Employee, Integer> colSex;
    @FXML
    private TableColumn<Employee, Integer> colCardNumber;
    @FXML
    private TableColumn<Employee, Integer> colProvince;
    @FXML
    private TableColumn<Employee, String> colAddress;
    @FXML
    private AnchorPane rootpanel;

    @FXML
    private void btnAddClick(ActionEvent event) {
    }

    @FXML
    private void btnEditClick(ActionEvent event) {
    }

    @FXML
    private void btnDeleteClick(ActionEvent event) {
    }
    private EmployeeDAO Employees;
    List<Employee> listEmployees;
    ObservableList<Employee> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        colSex.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("sex"));
        colCardNumber.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_card_number"));
        colProvince.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("province_id"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        Employees = new EmployeeDAO();
        tbEmployee.setItems((ObservableList<Employee>) Employees.getEmployee());
//        tbEmployee.setVisible(true);
        rootpanel.setPadding(new Insets(5));

        tbEmployee.setEditable(true);
//        colSex.setCellFactory( col -> {
//            TableCell<Employee, Integer> c = new TableCell<>();
//            final ComboBox<String> comboBox = new ComboBox<>();
//            
//        });
    }

}
