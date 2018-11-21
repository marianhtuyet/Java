/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author MyPC
 */
public class MovieManagementController {

    @FXML
    private TableView<?> tbEmployee;
    @FXML
    private JFXTextField tfID;
    @FXML
    private JFXTextField tfName;
    @FXML
    private JFXTextField tfImage;
    @FXML
    private JFXPasswordField tfDuration;
    @FXML
    private JFXTextField tfDirector;
    @FXML
    private JFXTextField tfLanguage;
    @FXML
    private JFXButton btnNew;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField tfLinkTrailer;
    @FXML
    private JFXTextField tfCast;
    @FXML
    private JFXTextField tfGenre;
    @FXML
    private JFXDatePicker DatePickerRelease;
    @FXML
    private JFXTextField tfRate;
    @FXML
    private JFXTextField tfShowhome;
    @FXML
    private JFXTextField tfContent;
    @FXML
    private TableColumn<?, ?> colSerial;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colImage;
    @FXML
    private TableColumn<?, ?> colDuration;
    @FXML
    private TableColumn<?, ?> colDirector;
    @FXML
    private TableColumn<?, ?> colGenre;
    @FXML
    private TableColumn<?, ?> colLanguage;
    @FXML
    private TableColumn<?, ?> colRelease;
    @FXML
    private TableColumn<?, ?> colRate;
    @FXML
    private TableColumn<?, ?> colContent;

    @FXML
    private void btnDeleteClick(ActionEvent event) {
    }

    @FXML
    private void BtnNewClick(ActionEvent event) {
    }

    @FXML
    private void btnSaveClick(ActionEvent event) {
    }

    @FXML
    private void TableClick(MouseEvent event) {
    }
    
}
