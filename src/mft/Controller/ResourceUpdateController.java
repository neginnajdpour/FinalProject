package mft.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mft.Model.da.FormState;
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

    }
}
