package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.Model.bl.ResourceBl;
import mft.Model.entity.Resource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

    @FXML
    private Label resourceIdLbl, resourceTypeLbl, categoryLbl, publisherNameLbl, quantityLbl;


    @FXML
    private TableColumn<Resource, String> titleCol ,editionCol, authorCol, languageCol;

    @FXML
    private TableView<Resource> resourcesTable;

    @FXML
    private TableView<Resource> bookTbl;

    @FXML
    private Button searchBtn;



    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            List<Resource> resourceList = ResourceBl.getAllResources();
            refreshBookTbl(resourceList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        bookTbl.setOnMouseReleased(event -> {
            Resource resource = bookTbl.getSelectionModel().getSelectedItem();
            if (resource != null) {


            }
        });


    }


    public void refreshBookTbl(List<Resource> bookList) throws Exception {
        ObservableList<Resource> observableList = FXCollections.observableList(bookList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("LANGUAGE"));
        bookTbl.setItems(observableList);
    }
}
