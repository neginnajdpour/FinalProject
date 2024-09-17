package mft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.model.bl.MemberBl;
import mft.model.entity.Gender;
import mft.model.entity.Member;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class MemberController implements Initializable {

    @FXML
    private TextField nationalIdTxt, firstnameTxt, lastnameTxt, photoTxt, phoneTxt, emailTxt, addressoneTxt, addresstwoTxt, cityTxt, stateTxt, postalcodeTxt, countryTxt;

    @FXML
    private DatePicker dateofbirthDate , joinDate;

    @FXML
    private ChoiceBox activeChk;

    @FXML
    private RadioButton maleRdo , femaleRdo;

    @FXML
    private ToggleGroup GenderToggle;


    @FXML
    private Button saveBtn, updateBtn, deleteBtn, newBtn;




    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {







        saveBtn.setOnAction(event -> {

            try {
                RadioButton selectedRadioButton = (RadioButton) GenderToggle.getSelectedToggle();
                Gender gender = Gender.valueOf(selectedRadioButton.getText());


            Member member = Member
                    .builder()
                    .nationalID(Integer.valueOf(nationalIdTxt.getText()))
                    .FirstName(firstnameTxt.getText())
                    .LastName(lastnameTxt.getText())
                    .dateOfBirth(dateofbirthDate.getValue())
                    .Gender(Gender.valueOf(selectedRadioButton.getText()))
                    .active((Boolean) activeChk.getValue())
                    .PhoneNumber(phoneTxt.getText())
                    .Email(emailTxt.getText())
                    .AddressLine1(addressoneTxt.getText())
                    .AddressLine2(addresstwoTxt.getText())
                    .City(cityTxt.getText())
                    .State(stateTxt.getText())
                    .Country(countryTxt.getText())
                    .Postalcode(postalcodeTxt.getText())
                    .Photo(photoTxt.getText())
                    .JoinDate(joinDate.getValue())
                    .build();


                MemberBl.save(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the member !");
                alert.showAndWait();



            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
//
//        updateBtn.setOnAction(event -> {
//            try {
//                Member member = Member
//                        .builder()
//                        .nationalID(Integer.valueOf(nationalIdTxt.getText()))
//                        .FirstName(firstnameTxt.getText())
//                        .LastName(lastnameTxt.getText())
//                        .PhoneNumber(phoneTxt.getText())
//                        .Email(emailTxt.getText())
//                        .AddressLine1(addressoneTxt.getText())
//                        .AddressLine2(addresstwoTxt.getText())
//                        .City(cityTxt.getText())
//                        .State(stateTxt.getText())
//                        .Postalcode(postalcodeTxt.getText())
//                        .Country(countryTxt.getText())
//                        .Photo(photoTxt.getText())
//                        .build();
//
//
//                MemberBl.update(member);
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information");
//                alert.setHeaderText(null);
//                alert.setContentText("You have successfully update the member !");
//                alert.showAndWait();
//
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//
//        deleteBtn.setOnAction(event -> {
//
//            try {
//                MemberBl.delete(Integer.valueOf(nationalIdTxt.getText()));
//                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information");
//                alert.setHeaderText(null);
//                alert.setContentText("You have successfully deleted the member !");
//                alert.showAndWait();
//
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//
//        newBtn.setOnAction(event -> {
//            nationalIdTxt.clear();
//            firstnameTxt.clear();
//            lastnameTxt.clear();
//            phoneTxt.clear();
//            emailTxt.clear();
//            addressoneTxt.clear();
//            addresstwoTxt.clear();
//            cityTxt.clear();
//            stateTxt.clear();
//            postalcodeTxt.clear();
//            countryTxt.clear();
//            photoTxt.clear();
//        });

//        memberTbl.setOnMouseReleased(event -> {
//            Member member = memberTbl.getSelectionModel().getSelectedItem();
//            nationalIdTxt.setText(String.valueOf(member.getNationalID()));
//            firstnameTxt.setText(member.getFirstName());
//            lastnameTxt.setText(member.getLastName());
//            phoneTxt.setText(member.getPhoneNumber());
//            emailTxt.setText(member.getEmail());
//            addressoneTxt.setText(member.getAddressLine1());
//            addresstwoTxt.setText(member.getAddressLine2());
//            cityTxt.setText(member.getCity());
//            stateTxt.setText(member.getState());
//            postalcodeTxt.setText(member.getPostalcode());
//            countryTxt.setText(member.getCountry());
//            photoTxt.setText(member.getPhoto());
//        });






    }


}
