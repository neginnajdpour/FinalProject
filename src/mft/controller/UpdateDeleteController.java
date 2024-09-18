package mft.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import mft.model.entity.Member;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateDeleteController implements Initializable {

    @FXML
    private TextField nationalIdTxt;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nationalIdTxt.setText(String.valueOf(FormState.member.getNationalID()));
//        firstnameTxt.setText(member.getFirstName());
//        lastnameTxt.setText(member.getLastName());
//        dateofbirthDate.setValue(member.getDateOfBirth());
//        phoneTxt.setText(member.getPhoneNumber());
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

    public void setNationalIdTxt(Member member) {
        nationalIdTxt.setText(String.valueOf(member.getNationalID()));

    }
}
