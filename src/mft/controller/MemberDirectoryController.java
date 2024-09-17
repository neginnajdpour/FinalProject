package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;
import lombok.SneakyThrows;
import mft.model.bl.MemberBl;
import mft.model.entity.Member;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberDirectoryController implements Initializable {

    @FXML
    private Button searchBtn;

    @FXML
    private TextField nationalIdTxt;

    @FXML
    private TableView<Member> memberTbl;

    @FXML
    private TableColumn<Member, Integer> nationalIdCol;

    @FXML
    private TableColumn<Member, String>  firstnameCol, lastnameCol, genderCol;

    @FXML
    private TableColumn<Member, Data> dateofbirthCol, joindateCol;

    @FXML
    private TableColumn<Member, Boolean> activeCol;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Member> memberList = MemberBl.getAllMembers();
        refreshMemberTbl(memberList);

        searchBtn.setOnAction(event -> {
            try {
                refreshMemberTbl(MemberBl.getAllMembers(Integer.parseInt(nationalIdTxt.getText())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }

    @SneakyThrows
    public void refreshMemberTbl(List<Member> memberList) {

        ObservableList<Member> observableList = FXCollections.observableList(memberList);
        nationalIdCol.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        dateofbirthCol.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
        joindateCol.setCellValueFactory(new PropertyValueFactory<>("Joindate"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("Active"));
        memberTbl.setItems(observableList);

    }
}
