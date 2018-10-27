/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<?> tbEmployee;
    @FXML
    private Button btnAddMovie;
    @FXML
    private Button btnEditMovie;
    @FXML
    private Button btnDeleteMovie;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAddClick(ActionEvent event) {
    }

    @FXML
    private void btnEditClick(ActionEvent event) {
    }

    @FXML
    private void btnDeleteClick(ActionEvent event) {
    }
    
    
    
}
