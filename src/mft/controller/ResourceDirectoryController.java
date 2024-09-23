package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mft.model.bl.ResourceBl;
import mft.model.entity.*;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class ResourceDirectoryController implements Initializable {

    @FXML
    private ComboBox searchCmb;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<Resource> resourceTbl;

    @FXML
    private TableColumn<Resource, String> titleCol, authorCol, isbnCol, publisherCol, editionCol, categoryCol, languageCol;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (SearchCriteria genre : SearchCriteria.values()) {
            searchCmb.getItems().add(genre);
        }

        searchBtn.setOnAction(event -> {

            String searchCriteria = searchCmb.getSelectionModel().getSelectedItem().toString();
            if (searchCriteria == "RESOURCE_ID") {
                try {
                    refreshResourceTbl(Collections.singletonList(ResourceBl.getResourceById(Integer.parseInt(searchTxt.getText()))));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (searchCriteria == "ISBN") {
                try {
                    refreshResourceTbl(Collections.singletonList(ResourceBl.getResourcesByISBN(Integer.valueOf(searchTxt.getText()))));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (searchCriteria == "TITLE") {
                try {
                    refreshResourceTbl(ResourceBl.getResourceByTitle(searchTxt.getText()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (searchCriteria == "AUTHOR") {
                try {
                    refreshResourceTbl(ResourceBl.getResourcesByAuthor(searchTxt.getText()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (searchCriteria == "PUBLISHER") {
                try {
                    refreshResourceTbl(ResourceBl.getResourcesByPublisher(searchTxt.getText()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void refreshResourceTbl(List<Resource> resourceList) {

        ObservableList<Resource> observableList = FXCollections.observableList(resourceList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR1"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHER"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));        ;
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("LANGUAGE"));
        resourceTbl.setItems(observableList);

    }

}
