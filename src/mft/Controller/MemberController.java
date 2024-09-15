package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.Model.bl.MemberBl;
import mft.Model.bl.ResourceBl;
import mft.Model.entity.Member;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MemberController implements Initializable {

    @FXML
    private TextField nationalIdTxt, firstnameTxt, lastnameTxt , phoneTxt , emailTxt , addressoneTxt , addresstwoTxt, cityTxt, stateTxt, postalcodeTxt, countryTxt, photoTxt;


    @FXML
    private Button saveBtn, editBtn, deleteBtn, newBtn;

    @FXML
    private TableView<Member> memberTbl;


    private TableColumn<Member, String> firstnameCol , lastnameCol , phonenumberCol, emailCol, addressCol;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        saveBtn.setOnAction(event -> {
            try {
            Member member = Member
                    .builder()
                    .NationalID(Integer.valueOf(nationalIdTxt.getText()))
                    .FirstName(firstnameTxt.getText())
                    .LastName(lastnameTxt.getText())
                    .PhoneNumber(phoneTxt.getText())
                    .Email(emailTxt.getText())
                    .AddressLine1(addressoneTxt.getText())
                    .AddressLine2(addresstwoTxt.getText())
                    .City(cityTxt.getText())
                    .State(stateTxt.getText())
                    .Postalcode(postalcodeTxt.getText())
                    .Country(countryTxt.getText())
                    .Photo(photoTxt.getText())
                    .build();


                MemberBl.save(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the member !");
                alert.showAndWait();

                List<Member> memberList = MemberBl.getAllMembers();
                refreshMemberTbl(memberList);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        editBtn.setOnAction(event -> {
            try {
                Member member = Member
                        .builder()
                        .NationalID(Integer.valueOf(nationalIdTxt.getText()))
                        .FirstName(firstnameTxt.getText())
                        .LastName(lastnameTxt.getText())
                        .PhoneNumber(phoneTxt.getText())
                        .Email(emailTxt.getText())
                        .AddressLine1(addressoneTxt.getText())
                        .AddressLine2(addresstwoTxt.getText())
                        .City(cityTxt.getText())
                        .State(stateTxt.getText())
                        .Postalcode(postalcodeTxt.getText())
                        .Country(countryTxt.getText())
                        .Photo(photoTxt.getText())
                        .build();


                MemberBl.update(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully update the member !");
                alert.showAndWait();

                List<Member> memberList = MemberBl.getAllMembers();
                refreshMemberTbl(memberList);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        deleteBtn.setOnAction(event -> {

            try {
                ResourceBl.delete(Integer.valueOf(nationalIdTxt.getText()));
                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully deleted the member !");
                alert.showAndWait();

                List<Member> memberList = MemberBl.getAllMembers();
                refreshMemberTbl(memberList);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        newBtn.setOnAction(event -> {


        });




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
