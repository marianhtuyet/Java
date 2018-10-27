/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotableview;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MyPC
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_name;
    @FXML
    private TableColumn<ModelTable, String> col_email;
    @FXML
    private TableColumn<ModelTable, String> col_etc;
//    
//    List<ModelTable> list = new ArrayList<>();
//    list.add(new ModelTable("Jacob", "Smith", "jacob.smith@example.com", "a"));
//    list.add(new )
    
   final  ObservableList<ModelTable> oblist =  FXCollections.observableArrayList(
    new ModelTable("Jacob", "Smith", "jacob.smith@example.com", "a"),
    new ModelTable("Isabella", "Johnson", "isabella.johnson@example.com", "b"),
    new ModelTable("Ethan", "Williams", "ethan.williams@example.com", "c"),
    new ModelTable("Emma", "Jones", "emma.jones@example.com", "d"),
    new ModelTable("Michael", "Brown", "michael.brown@example.com", "e")
            );
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_id.setCellFactory(new PropertyValueFactory<>("id"));
        col_name.setCellFactory(new PropertyValueFactory<>("name"));
        col_email.setCellFactory(new PropertyValueFactory<>("email"));
        col_etc.setCellFactory(new PropertyValueFactory<>("etc"));
        table.setItems(oblist);
    }    
    
}
