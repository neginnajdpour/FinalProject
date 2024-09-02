package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    @FXML
    private TextField titleTxt,editionTxt ,authorTxt,publisherTxt,publicationyearTxt,availablecopiesTxt;

    @FXML
    private Label title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
