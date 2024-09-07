package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.Model.bl.MemberBl;
import mft.Model.entity.Book;
import mft.Model.entity.Member;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberListController implements Initializable {

    @FXML
    private TableColumn<Member, String> firstnameCol , lastnameCol , phonenumberCol, emailCol, addressCol;
     //       , emailCol;



    @FXML
    private TableView<Member> memberTbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        refreshTbl();

    }
    @SneakyThrows
    public void refreshTbl() {
       List<Member> memberList = MemberBl.getAllMembers();
       ObservableList<Member> observableList = FXCollections.observableList(memberList);
       firstnameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
       lastnameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
       phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
       emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
       addressCol.setCellValueFactory(new PropertyValueFactory<>("AddressLine1"));
       //addressCol.setCellValueFactory("hello");


       memberTbl.setItems(observableList);



    }
}
