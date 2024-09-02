package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mft.Model.entity.Genre;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    @FXML
    private TextField titleTxt;

    @FXML
    private TextField editionTxt;

    @FXML
    private TextField authorTxt;

    @FXML
    private TextField publisherTxt;

    @FXML
    private TextField publicationyearTxt;

    @FXML
    private TextField availablecopiesTxt;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private ComboBox genreCmb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        for (Genre genre : Genre.values()) {
            genreCmb.getItems().add(genre);
        }

    }
}
