package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import mft.Model.bl.ResourceBl;
import mft.Model.da.FormState;
import mft.Model.entity.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

    @FXML
    private Label resourceIdLbl, resourceTypeLbl, categoryLbl, publisherNameLbl, quantityLbl;


    @FXML
    private TableColumn<Resource, String> titleCol ,editionCol, authorCol, languageCol;

    @FXML
    private TableView<Resource> resourceTbl;



    @FXML
    private Button editBtn;



    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            List<Resource> resourceList = ResourceBl.getAllResources();
            refreshBookTbl(resourceList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resourceTbl.setOnMouseReleased(event -> {
            Resource resource = resourceTbl.getSelectionModel().getSelectedItem();
            if (resource != null) {
                resourceIdLbl.setText(String.valueOf(resource.getRESOURCE_ID()));
                resourceTypeLbl.setText(resource.getRESOURCE_TYPE());
                categoryLbl.setText(resource.getCATEGORY());
                publisherNameLbl.setText(resource.getPUBLISHER());
                quantityLbl.setText(String.valueOf(resource.getQUANTITY()));
            }
        });

        editBtn.setOnAction(event -> {
            Resource temp_resource = resourceTbl.getSelectionModel().getSelectedItem();
            FormState.resource = temp_resource;
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/ResourceUpdate.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            stage.setScene(scene);

        });




    }


    public void refreshBookTbl(List<Resource> bookList) throws Exception {
        ObservableList<Resource> observableList = FXCollections.observableList(bookList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("LANGUAGE"));
        resourceTbl.setItems(observableList);
    }
}
