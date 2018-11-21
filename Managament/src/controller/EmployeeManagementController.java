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
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
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
    ObservableList<Province> listprovince = FXCollections.observableArrayList();
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
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Employees = new EmployeeDAO();
        listEmployees = Employees.getEmployee();
        setCellValueFactory();
        tbEmployee.setItems((ObservableList<Employee>) listEmployees);
//        tbEmployee.getColumns().addAll(colID, colName, colEmail, colGender, colCardNumber, colProvince_id, colAddress);
        tbEmployee.setEditable(true);
//        ---edit cell in table
        setCellFactory();
        tbEmployee.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        colProvince_id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Province>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<Employee, Province> event) {
//                TablePosition<Employee, Province> pos = event.getTablePosition();
//                Province newProvince = event.getNewValue();
//                int row = pos.getRow();
//                Employee employee = event.getTableView().getItems().get(row);
//
//                employee.setProvince_id(newProvince.getIdProvince());
//
//            }
//        });
//        colGender.setOnEditCommit((event) -> {
//            TablePosition<Employee, gender> pos = event.getTablePosition();
//            gender newgenner = event.getNewValue();
//            int row = pos.getRow();
//            Employee employee = event.getTableView().getItems().get(row);
//            employee.setGender(newgenner.getCode());
//
//        });
//
//        colName.setOnEditCommit((CellEditEvent<Employee, String> event) -> {
//            TablePosition<Employee, String> pos = event.getTablePosition();
//            String newString = event.getNewValue();
//            int row = pos.getRow();
//            Employee employee = event.getTableView().getItems().get(row);
//            employee.setName(newString);
//            if (newString.contains("!") || newString.contains("@") || newString.contains("#") || newString.contains("$")
//                    || newString.contains("%") || newString.contains("^") || newString.contains("&") || newString.contains("*")
//                    || newString.contains("(") || newString.contains(")") || newString.contains(".") || newString.contains(",")
//                    || newString.contains("/") || newString.contains("?")) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The name have !@#$$%^&. Please press againt");
//                alert.show();
//            } else {
//                
//            }
//        });
//        colEmail.setOnEditCommit((CellEditEvent<Employee, String> event) -> {
//            TablePosition<Employee, String> pos = event.getTablePosition();
//            String newString = event.getNewValue();
//            int row = pos.getRow();
//            Employee employee = event.getTableView().getItems().get(row);
//            employee.setEmail(newString);
//        });
//        colCardNumber.setOnEditCommit((CellEditEvent<Employee, Integer> event) -> {
//            TablePosition<Employee, Integer> pos = event.getTablePosition();
//            Integer newint = event.getNewValue();
//            int row = pos.getRow();
//            Employee employee = event.getTableView().getItems().get(row);
//            employee.setId_card_number(newint);
//        });
//            colAddress.setOnEditCommit((CellEditEvent<Employee, String> event) -> {
//            TablePosition<Employee, String> pos = event.getTablePosition();
//            String newString = event.getNewValue();
//            int row = pos.getRow();
//            Employee employee = event.getTableView().getItems().get(row);
//            employee.setAddress(newString);
//            });
        tbEmployee.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    return;
                }
                if (tbEmployee.getEditingCell() == null) {
                    if (event.getCode().isLetterKey() ) {
                        TablePosition focusePosition = tbEmployee.getFocusModel().getFocusedCell();
                        tbEmployee.edit(focusePosition.getRow(), focusePosition.getTableColumn());
                    }
                }
            }

        });
//        tbEmployee.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//
//                if (event.getCode() == KeyCode.ENTER) {
//
//                    // move focus & selection
//                    // we need to clear the current selection first or else the selection would be added to the current selection since we are in multi selection mode 
//                    TablePosition pos = tbEmployee.getFocusModel().getFocusedCell();
//
//                    if (pos.getRow() == -1) {
//                        tbEmployee.getSelectionModel().select(0);
//                    } // add new row when we are at the last row
//                    else if (pos.getRow() == tbEmployee.getItems().size() - 1) {
//                        addRow();
//                    } // select next row, but same column as the current selection
//                    else if (pos.getRow() < tbEmployee.getItems().size() - 1) {
//                        tbEmployee.getSelectionModel().clearAndSelect(pos.getRow() + 1, pos.getTableColumn());
//                    }
//
//                }
//
//            }
//        });
        tbEmployee.getSelectionModel().setCellSelectionEnabled(true);
        //  tbEmployee.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void addRow() {

        // get current position
        TablePosition pos = tbEmployee.getFocusModel().getFocusedCell();

        // clear current selection
        tbEmployee.getSelectionModel().clearSelection();

        // create new record and add it to the model
        Employee data = new Employee();
        tbEmployee.getItems().add(data);

        // get last row
        int row = tbEmployee.getItems().size() - 1;
        tbEmployee.getSelectionModel().select(row, pos.getTableColumn());

        // scroll to new row
        tbEmployee.scrollTo(data);

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
        
    }

    void setCellFactory() {
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colEmail.setCellFactory(TextFieldTableCell.forTableColumn());
         colCardNumber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        colGender.setCellFactory(ComboBoxTableCell.forTableColumn(genderList));

        colProvince_id.setCellFactory(ComboBoxTableCell.forTableColumn(listprovince));
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
    }

    @FXML
    private void btnDeleteClick(ActionEvent event) {
    }

    @FXML
    private void btnSaveClick(ActionEvent event) {
        for (Employee row : tbEmployee.getItems()) {
             newEmployees.add(row);
//            if (CheckEmployee(row) != 0) {
//                newEmployees.add(row);
//            } else {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The information of employee was wrong! Please press againt");
//
//                System.out.print("Can't submit data");
//            }

        }
        for (int i = 0; i < newEmployees.size(); i++) {
            if(i < listEmployees.size())
            {
            if (listEmployees.get(i).getId() == newEmployees.get(i).getId()) {
               // Employees.UpdateEmployee(newEmployees.get(i));
            } else {
                //Employees.AddEmployee(newEmployees.get(i));
            }
                
            }
            
               // Employees.AddEmployee(newEmployees.get(i));
            
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
            alert.showAndWait();
            return 0;

        }
        return 1;
    }

}
