package mft.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mft.Model.bl.MemberBl;
import mft.Model.bl.ResourceBl;
import mft.Model.da.FormState;
import mft.Model.entity.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResourceUpdateController implements Initializable {
    @FXML
    private Label resourceIdLbl;

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

        for (ResourceType genre : ResourceType.values()) {
            resourcetypeCmb.getItems().add(genre);
        }

        for (Category genre : Category.values()) {
            categoryCmb.getItems().add(genre);
        };

        for (Language genre : Language.values()) {
            languageCmb.getItems().add(genre);
        };

        resourceIdLbl.setText(String.valueOf(FormState.resource.getRESOURCE_ID()));
        isbnTxt.setText(FormState.resource.getISBN());
        titleTxt.setText(FormState.resource.getTITLE());
        editionTxt.setText(FormState.resource.getEDITION());
        authorTxt.setText(FormState.resource.getAUTHOR());
        publisherTxt.setText(FormState.resource.getPUBLISHER());
        quantityTxt.setText(String.valueOf(FormState.resource.getQUANTITY()));
        descriptionTxt.setText(FormState.resource.getDESCRIPTION());
        resourcetypeCmb.getSelectionModel().select(FormState.resource.getRESOURCE_TYPE());
        categoryCmb.getSelectionModel().select(FormState.resource.getCATEGORY());
        languageCmb.getSelectionModel().select(FormState.resource.getLANGUAGE());


        Integer resourceId = FormState.resource.getRESOURCE_ID();
        updateBtn.setOnAction(event -> {
            try {
                Resource book = Resource
                        .builder()
                        .RESOURCE_ID(Integer.parseInt(resourceIdLbl.getText()))
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
                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully updated the book !");
                alert.showAndWait();
                updateBtn.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/mft/View/BookSearch.fxml"));
                Parent root = loader.load();

                BookSearchController controller = loader.getController();
                List<Resource> resourceList = ResourceBl.getAllResources();
                controller.refreshBookTbl(resourceList);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
}
