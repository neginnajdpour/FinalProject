package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mft.model.bl.BorrowBl;
import mft.model.bl.MemberBl;
import mft.model.bl.ResourceBl;
import mft.model.entity.Borrow;
import mft.model.entity.Gender;
import mft.model.entity.Member;
import mft.model.entity.Resource;

import java.sql.SQLException;
import java.time.LocalDate;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class BorrowController implements Initializable {

    @FXML
    private TextField nationalIdTxt ,isbnTxt , nameTxt , resourceIdTxt , titleTxt ;

    @FXML
    private DatePicker curDateTxt , dueDateTxt;

    @FXML
    private Button nationalIdSearchBtn , isbnSearchBtn , issueBtn, clearBtn;

    @FXML
    private TableView<Borrow> borrowTbl;

    @FXML
    private TableColumn<Borrow,String> memberCol , isbnCol , resourceCol , fromDateCol , dueDateCol;



    private Member member;
    private Resource resource;
    private Borrow borrow;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        curDateTxt.setValue(LocalDate.now());

        nationalIdSearchBtn.setOnAction(event -> {
            try {
                member = MemberBl.getMember(Integer.valueOf(nationalIdTxt.getText()));
                nameTxt.setText(member.getFirstName() + " " + member.getLastName());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        isbnSearchBtn.setOnAction(event -> {
            try {
                resource = ResourceBl.getResourcesByISBN(Integer.valueOf(isbnTxt.getText()));
                resourceIdTxt.setText(String.valueOf(resource.getRESOURCE_ID()));
                titleTxt.setText(String.valueOf(resource.getTITLE()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });



        issueBtn.setOnAction(event -> {
            try {
                Borrow borrow = Borrow
                        .builder()
                        .member(member)
                        .resource(resource)
                        .issueDate(curDateTxt.getValue())
                        .dueDate(dueDateTxt.getValue())
                        .build();

                BorrowBl.save(borrow);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully issued the resource !");
                alert.showAndWait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });

        clearBtn.setOnAction(event -> {
            nationalIdTxt.clear();
            isbnTxt.clear();
            nameTxt.clear();
            resourceIdTxt.clear();
            titleTxt.clear();
            curDateTxt.setValue(null);
            dueDateTxt.setValue(null);
        });

    }

    public void refreshBorrowTbl(List<Borrow> borrowList) throws Exception {
        ObservableList<Resource> observableList = FXCollections.observableList(bookList);
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        languageCol.setCellValueFactory(new PropertyValueFactory<>("LANGUAGE"));
        resourceTbl.setItems(observableList);
    }
}
