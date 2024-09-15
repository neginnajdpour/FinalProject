package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.model.bl.ResourceBl;
import mft.model.entity.Category;
import mft.model.entity.Language;
import mft.model.entity.Resource;
import mft.model.entity.ResourceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResourceController implements Initializable {

    @FXML
    private TextField isbnTxt, titleTxt, editionTxt, authorTxt, publisherTxt, quantityTxt;

    @FXML
    private TextArea descriptionTxt;

    @FXML
    private ComboBox resourcetypeCmb , categoryCmb, languageCmb;

    @FXML
    private Button saveBtn, updateBtn, deleteBtn, newBtn;

    @FXML
    private TableColumn<Resource, Integer> resId;

    @FXML
    private TableColumn<Resource, String> isbnCol, titleCol ,editionCol, authorCol, languageCol;

    @FXML
    private TableView<Resource> resourceTbl;


    @SneakyThrows
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

        List<Resource> resourceList = ResourceBl.getAllResources();
        refreshBookTbl(resourceList);

        saveBtn.setOnAction(event -> {
            try {
                ResourceType resourceType = (ResourceType) resourcetypeCmb.getSelectionModel().getSelectedItem();
                Category category = (Category) categoryCmb.getSelectionModel().getSelectedItem();
                Language language = (Language) languageCmb.getSelectionModel().getSelectedItem();
                Resource book = Resource
                        .builder()
                        .ISBN(Integer.parseInt(isbnTxt.getText()))
                        .RESOURCE_TYPE(ResourceType.valueOf(resourceType.name()))
                        .title(titleTxt.getText())
                        .EDITION(editionTxt.getText())
                        .AUTHOR(authorTxt.getText())
                        .CATEGORY(Category.valueOf(category.name()))
                        .PUBLISHER(publisherTxt.getText())
                        .LANGUAGE(Language.valueOf(language.name()))
                        .QUANTITY(Integer.parseInt(quantityTxt.getText()))
                        .DESCRIPTION(descriptionTxt.getText())
                        .build();


                ResourceBl.save(book);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the book !");
                alert.showAndWait();

                refreshBookTbl(ResourceBl.getAllResources());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        updateBtn.setOnAction(event -> {
            try {
                ResourceType resourceType = (ResourceType) resourcetypeCmb.getSelectionModel().getSelectedItem();
                Category category = (Category) categoryCmb.getSelectionModel().getSelectedItem();
                Language language = (Language) languageCmb.getSelectionModel().getSelectedItem();
                Resource book = Resource
                        .builder()
                        //.RESOURCE_ID(Integer.parseInt(resourceIdLbl.getText()))
                        .ISBN(Integer.parseInt(isbnTxt.getText()))
                        .RESOURCE_TYPE(ResourceType.valueOf(resourceType.name()))
                        .title(titleTxt.getText())
                        .EDITION(editionTxt.getText())
                        .AUTHOR(authorTxt.getText())
                        .CATEGORY(Category.valueOf(category.name()))
                        .PUBLISHER(publisherTxt.getText())
                        .LANGUAGE(Language.valueOf(language.name()))
                        .QUANTITY(Integer.parseInt(quantityTxt.getText()))
                        .DESCRIPTION(descriptionTxt.getText())
                        .build();

                ResourceBl.update(book);
                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully updated the book !");
                alert.showAndWait();

                refreshBookTbl(ResourceBl.getAllResources());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        deleteBtn.setOnAction(event -> {
            try {
                ResourceBl.delete(Integer.valueOf(isbnTxt.getText()));
                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully deleted the book !");
                alert.showAndWait();

                refreshBookTbl(ResourceBl.getAllResources());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        newBtn.setOnAction(event -> {
            isbnTxt.setText("");
            titleTxt.setText("");
            editionTxt.setText("");
            authorTxt.setText("");
            publisherTxt.setText("");
            quantityTxt.setText("");
            descriptionTxt.setText("");
            resourcetypeCmb.getSelectionModel().clearSelection();
            categoryCmb.getSelectionModel().clearSelection();
            languageCmb.getSelectionModel().clearSelection();
        });

        resourceTbl.setOnMouseReleased(event -> {
            Resource resource = resourceTbl.getSelectionModel().getSelectedItem();
            if (resource != null) {
                isbnTxt.setText(resource.getISBN().toString());
                titleTxt.setText(resource.getTitle());
                editionTxt.setText(resource.getEDITION());
                authorTxt.setText(resource.getAUTHOR());
                publisherTxt.setText(resource.getPUBLISHER());
                quantityTxt.setText(String.valueOf(resource.getQUANTITY()));
                descriptionTxt.setText(resource.getDESCRIPTION());
                resourcetypeCmb.getSelectionModel().select(resource.getRESOURCE_TYPE());
                categoryCmb.getSelectionModel().select(resource.getCATEGORY());
                languageCmb.getSelectionModel().select(resource.getLANGUAGE());

            }
        });




    }

    public void refreshBookTbl(List<Resource> bookList) throws Exception {
        ObservableList<Resource> observableList = FXCollections.observableList(bookList);
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("LANGUAGE"));
        resourceTbl.setItems(observableList);
    }

}
