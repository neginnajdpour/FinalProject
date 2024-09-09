package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import lombok.SneakyThrows;
import mft.Model.bl.BookBl;
import mft.Model.bl.MemberBl;
import mft.Model.entity.*;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    @FXML
    private TextField isbnTxt, titleTxt, editionTxt, authorTxt, publisherTxt, quantityTxt;

    @FXML
    private TextArea descriptionTxt;

    @FXML
    private ComboBox resourcetypeCmb , categoryCmb, languageCmb;

    @FXML
    private Button saveBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (ResourceType genre : ResourceType.values()) {
            resourcetypeCmb.getItems().add(genre);
        }

        for (Category genre : Category.values()) {
            categoryCmb.getItems().add(genre);
        };

        for (Language genre : Language.values()) {
            languageCmb.getItems().add(genre);
        };


        saveBtn.setOnAction(event -> {
            try {
                Book book = Book
                        .builder()
                        .ISBN(isbnTxt.getText())
                        .RESOURCE_TYPE("Book")
                        .TITLE(titleTxt.getText())
                        .EDITION(editionTxt.getText())
                        .AUTHOR(authorTxt.getText())
                        .CATEGORY("Category.Classic")
                        .PUBLISHER(publisherTxt.getText())
                        .LANGUAGE("English")
                        .QUANTITY(Integer.parseInt(quantityTxt.getText()))
                        .DESCRIPTION(descriptionTxt.getText())
                        .build();


                BookBl.save(book);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the book !");
                alert.showAndWait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });



    }


}
