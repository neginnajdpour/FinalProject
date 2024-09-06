package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mft.Model.bl.MemberBl;
import mft.Model.entity.Member;

import java.net.URL;
import java.util.ResourceBundle;


public class MemberController implements Initializable {

    @FXML
    private TextField firstnameTxt, lastnameTxt , phoneTxt , emailTxt , addressoneTxt , addresstwoTxt, cityTxt, stateTxt, postalcodeTxt, countryTxt, photoTxt;


    @FXML
    private Button saveBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        saveBtn.setOnAction(event -> {
            try {
            Member member = Member
                    .builder()
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
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

    }
}
