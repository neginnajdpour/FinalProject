package mft.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.util.ResourceBundle;

public class BorrowController implements Initializable {

    @FXML
    private DatePicker curDateTxt , dueDateTxt;

    @FXML
    private Button issueBtn, clearBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        issueBtn.setOnAction(e -> {

        });
    }
}
