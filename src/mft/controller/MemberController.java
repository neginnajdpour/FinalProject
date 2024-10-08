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
import mft.model.bl.MemberBl;
import mft.model.entity.Gender;
import mft.model.entity.Member;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class MemberController implements Initializable {

    @FXML
    private TextField admissionTxt, nationalIdTxt, firstnameTxt, lastnameTxt, photoTxt, phoneTxt, emailTxt, addressoneTxt, addresstwoTxt, cityTxt, stateTxt, postalcodeTxt, countryTxt;

    @FXML
    private DatePicker dateofbirthDate , joinDate;

    @FXML
    private CheckBox activeChk;

    @FXML
    private RadioButton maleRdo , femaleRdo;

    @FXML
    private ToggleGroup GenderToggle;


    @FXML
    private Button saveBtn,updateBtn, deleteBtn, newBtn, closeBtn;




    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {




        saveBtn.setOnAction(event -> {

            try {
                RadioButton selectedRadioButton = (RadioButton) GenderToggle.getSelectedToggle();

            Member member = Member
                    .builder()
                    .nationalID(Integer.valueOf(nationalIdTxt.getText()))
                    .FirstName(firstnameTxt.getText())
                    .LastName(lastnameTxt.getText())
                    .dateOfBirth(dateofbirthDate.getValue())
                    .Gender(Gender.valueOf(selectedRadioButton.getText()))
                    .active(activeChk.isSelected())
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

        closeBtn.setOnAction(event -> {
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();
        });




        updateBtn.setOnAction(event -> {
            try {
                RadioButton selectedRadioButton = (RadioButton) GenderToggle.getSelectedToggle();
                Member member = Member
                        .builder()
                        .nationalID(Integer.valueOf(nationalIdTxt.getText()))
                        .FirstName(firstnameTxt.getText())
                        .LastName(lastnameTxt.getText())
                        .dateOfBirth(dateofbirthDate.getValue())
                        .Gender(Gender.valueOf(selectedRadioButton.getText()))
                        .active(activeChk.isSelected())
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


                MemberBl.update(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully update the member !");
                alert.showAndWait();
                ((Stage) (updateBtn.getScene().getWindow())).hide();

//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/mft/view/MemberDirectory.fxml" ));
//                Stage stage = new Stage();
//                stage.setScene(new Scene(loader.load()));
//                MemberDirectoryController controller = loader.getController();
//                controller.refreshMemberTbl(MemberBl.getAllMembers());
//                stage.show();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        deleteBtn.setOnAction(event -> {
            try {
                MemberBl.delete(Integer.valueOf(nationalIdTxt.getText()));
                Alert alert = new  Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully deleted the member !");
                alert.showAndWait();
                ((Stage) (deleteBtn.getScene().getWindow())).hide();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setUser(Member member) {

        nationalIdTxt.setText(String.valueOf(member.getNationalID()));
        firstnameTxt.setText(member.getFirstName());
        lastnameTxt.setText(member.getLastName());
        dateofbirthDate.setValue(member.getDateOfBirth());
        phoneTxt.setText(member.getPhoneNumber());

        if (member.getGender().name() == "Male") {
                maleRdo.setSelected(true);
        }
        else{
                femaleRdo.setSelected(true); }

        if (member.isActive()) {
            activeChk.setSelected(true);}
        else{
            activeChk.setSelected(false);
        }

        emailTxt.setText(member.getEmail());
        addressoneTxt.setText(member.getAddressLine1());
        addresstwoTxt.setText(member.getAddressLine2());
        cityTxt.setText(member.getCity());
        stateTxt.setText(member.getState());
        postalcodeTxt.setText(member.getPostalcode());
        countryTxt.setText(member.getCountry());
        photoTxt.setText(member.getPhoto());
        joinDate.setValue(member.getJoinDate());

    }


}
