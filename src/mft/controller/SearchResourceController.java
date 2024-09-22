package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mft.model.bl.MemberBl;
import mft.model.bl.ResourceBl;
import mft.model.entity.Member;
import mft.model.entity.Resource;
import mft.model.entity.ResourceType;
import mft.model.entity.SearchCriteria;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchResourceController implements Initializable {

    @FXML
    private ComboBox searchCmb;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<Resource> resourceTable;

    @FXML
    private TableColumn<Resource, String> titleCol , authorCol , isbnCol , publisherCol , editionCol , categoryCol , languageCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (SearchCriteria genre : SearchCriteria.values()) {
            searchCmb.getItems().add(genre);
        }

        searchBtn.setOnAction(event -> {

            String searchCriteria = searchCmb.getSelectionModel().getSelectedItem().toString();
            if (searchCriteria == "RESOURCE_ID")
            {
                try {
                    refreshResourceTbl((List<Member>) ResourceBl.getResourceById(Integer.parseInt(searchTxt.getText()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


        });






    }

    public void refreshResourceTbl(List<Member> resourceList) {

        ObservableList<Member> observableList = FXCollections.observableList(resourceList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("Gender"));        ;
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("Active"));
        resourceTable.setItems(observableList);

    }
}
