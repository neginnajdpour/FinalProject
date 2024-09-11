package mft.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import mft.Model.bl.MemberBl;
import mft.Model.bl.ResourceBl;
import mft.Model.da.FormState;
import mft.Model.entity.Member;
import mft.Model.entity.Resource;
import mft.Model.entity.ResourceType;

import java.net.URL;
import java.util.ResourceBundle;

public class ResourceUpdateController implements Initializable {

    @FXML
    private TextField isbnTxt, titleTxt, editionTxt, authorTxt, publisherTxt, quantityTxt;

    @FXML
    private TextArea descriptionTxt;

    @FXML
    private ComboBox resourcetypeCmb , categoryCmb, languageCmb;

    @FXML
    private Button updateBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Resource resource = new Resource();
        resource = FormState.resource;

        isbnTxt.setText(resource.getISBN());
        titleTxt.setText(resource.getTITLE());
        editionTxt.setText(resource.getEDITION());
        authorTxt.setText(resource.getAUTHOR());
        publisherTxt.setText(resource.getPUBLISHER());
        quantityTxt.setText(String.valueOf(resource.getQUANTITY()));
        descriptionTxt.setText(resource.getDESCRIPTION());
        resourcetypeCmb.getSelectionModel().select(resource.getRESOURCE_TYPE());
        categoryCmb.getSelectionModel().select(resource.getCATEGORY());
        languageCmb.getSelectionModel().select(resource.getLANGUAGE());

        updateBtn.setOnAction(event -> {
            try {
                Resource book = Resource
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


                ResourceBl.update(book);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully updated the book !");
                alert.showAndWait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });




    }
}
