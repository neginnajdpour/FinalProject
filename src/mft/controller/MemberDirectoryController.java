package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Data;
import lombok.SneakyThrows;
import mft.model.bl.MemberBl;
import mft.model.entity.Member;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
    private TableColumn<Member, String>  firstnameCol, lastnameCol, genderCol, cityCol;

    @FXML
    private TableColumn<Member, String> dateofbirthCol, joindateCol;

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

        memberTbl.setOnMouseReleased(event -> {

            try {

                Member member = memberTbl.getSelectionModel().getSelectedItem();
                FormState.member = member;
                if (member != null) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/mft/view/Member.fxml" ));
                    Stage stage = new Stage();

                    stage.setScene(new Scene(loader.load()));
                    MemberController controller = loader.getController();
                    controller.setUser(member);
                    stage.show();
                }

            } catch (IOException e) {
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
        dateofbirthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("Gender"));        ;
        joindateCol.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("Active"));
        memberTbl.setItems(observableList);

    }
}
