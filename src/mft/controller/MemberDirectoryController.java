package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.model.bl.MemberBl;
import mft.model.entity.Member;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberDirectoryController implements Initializable {

    @FXML
    private TableView<Member> memberTbl;

    @FXML
    private TableColumn<Member, String> firstnameCol, lastnameCol, phonenumberCol, emailCol, addressCol;


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Member> memberList = MemberBl.getAllMembers();
        refreshMemberTbl(memberList);

    }

    @SneakyThrows
    public void refreshMemberTbl(List<Member> memberList) {

        ObservableList<Member> observableList = FXCollections.observableList(memberList);
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("AddressLine1"));
        memberTbl.setItems(observableList);

    }
}
