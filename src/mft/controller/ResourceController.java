package mft.controller;

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
import mft.model.bl.ResourceBl;
import mft.model.entity.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class ResourceController implements Initializable {

    @FXML
    private TextField   titleTxt , subjectTxt , quantityTxt , isbnTxt, author1Txt , editionTxt , contentTxt , publisherTxt, seriesTxt, costTxt, author2Txt , keywordTxt  ;

    @FXML
    private ComboBox resourcetypeCmb , categoryCmb, languageCmb , statusCmb;

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

        for (Status genre : Status.values()) {
            statusCmb.getItems().add(genre);
        };

//        List<Resource> resourceList = ResourceBl.getAllResources();
//        refreshBookTbl(resourceList);

        saveBtn.setOnAction(event -> {
            try {
                ResourceType resourceType = (ResourceType) resourcetypeCmb.getSelectionModel().getSelectedItem();
                Category category = (Category) categoryCmb.getSelectionModel().getSelectedItem();
                Language language = (Language) languageCmb.getSelectionModel().getSelectedItem();
                Status status = (Status) statusCmb.getSelectionModel().getSelectedItem();
                Resource resource = Resource
                        .builder()
                        .TITLE(titleTxt.getText())
                        .RESOURCE_TYPE(ResourceType.valueOf(resourceType.name()))
                        .SUBJECT(subjectTxt.getText())
                        .CATEGORY(Category.valueOf(category.name()))
                        .QUANTITY(Integer.parseInt(quantityTxt.getText()))
                        .ISBN(Integer.parseInt(isbnTxt.getText()))
                        .AUTHOR1(author1Txt.getText())
                        .EDITION(editionTxt.getText())
                        .CONTENT(contentTxt.getText())
                        .PUBLISHER(publisherTxt.getText())
                        .LANGUAGE(Language.valueOf(language.name()))
                        .SERIES(Integer.parseInt(seriesTxt.getText()))
                        .COST(Integer.parseInt(costTxt.getText()))
                        .AUTHOR2(author2Txt.getText())
                        .STATUS("New")
                        .KEYWORD(keywordTxt.getText())
                        .build();

                System.out.println(resource);


                ResourceBl.save(resource);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the book !");
                alert.showAndWait();



            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        updateBtn.setOnAction(event -> {
            try {
                ResourceType resourceType = (ResourceType) resourcetypeCmb.getSelectionModel().getSelectedItem();
                Category category = (Category) categoryCmb.getSelectionModel().getSelectedItem();
                Language language = (Language) languageCmb.getSelectionModel().getSelectedItem();
                Status status = (Status) statusCmb.getSelectionModel().getSelectedItem();
                Resource book = Resource
                        .builder()
                        .TITLE(titleTxt.getText())
                        .RESOURCE_TYPE(ResourceType.valueOf(resourceType.name()))
                        .SUBJECT(subjectTxt.getText())
                        .CATEGORY(Category.valueOf(category.name()))
                        .QUANTITY(Integer.parseInt(quantityTxt.getText()))
                        .ISBN(Integer.parseInt(isbnTxt.getText()))
                        .AUTHOR1(author1Txt.getText())
                        .EDITION(editionTxt.getText())
                        .CONTENT(contentTxt.getText())
                        .PUBLISHER(publisherTxt.getText())
                        .LANGUAGE(Language.valueOf(language.name()))
                        .SERIES(Integer.parseInt(seriesTxt.getText()))
                        .COST(Integer.parseInt(costTxt.getText()))
                        .AUTHOR2(author2Txt.getText())
                        .STATUS(String.valueOf(Status.valueOf(status.name())))
                        .KEYWORD(keywordTxt.getText())
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
            titleTxt.clear();
            subjectTxt.clear();
            quantityTxt.clear();
            isbnTxt.clear();
            author1Txt.clear();
            editionTxt.clear();
            contentTxt.clear();
            publisherTxt.clear();
            seriesTxt.clear();
            costTxt.clear();
            author2Txt.clear();
            keywordTxt.clear();
            resourcetypeCmb.getSelectionModel().clearSelection();
            categoryCmb.getSelectionModel().clearSelection();
            languageCmb.getSelectionModel().clearSelection();
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

    public void setUser(Resource resource) {

//        nationalIdTxt.setText(String.valueOf(member.getNationalID()));
//        firstnameTxt.setText(member.getFirstName());
//        lastnameTxt.setText(member.getLastName());
//        dateofbirthDate.setValue(member.getDateOfBirth());
//        phoneTxt.setText(member.getPhoneNumber());
//
//        if (member.getGender().name() == "Male") {
//            maleRdo.setSelected(true);
//        }
//        else{
//            femaleRdo.setSelected(true); }
//
//        if (member.isActive()) {
//            activeChk.setSelected(true);}
//        else{
//            activeChk.setSelected(false);
//        }
//
//        emailTxt.setText(member.getEmail());
//        addressoneTxt.setText(member.getAddressLine1());
//        addresstwoTxt.setText(member.getAddressLine2());
//        cityTxt.setText(member.getCity());
//        stateTxt.setText(member.getState());
//        postalcodeTxt.setText(member.getPostalcode());
//        countryTxt.setText(member.getCountry());
//        photoTxt.setText(member.getPhoto());
//        joinDate.setValue(member.getJoinDate());

    }








}
