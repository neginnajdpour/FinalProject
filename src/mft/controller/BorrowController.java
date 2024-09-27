package mft.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mft.model.bl.MemberBl;
import mft.model.bl.ResourceBl;
import mft.model.entity.Member;
import mft.model.entity.Resource;

import java.net.URL;
import java.util.ResourceBundle;

public class BorrowController implements Initializable {

    @FXML
    private TextField nationalIdTxt , resourceIdTxt;

    @FXML
    private DatePicker curDateTxt , dueDateTxt;

    @FXML
    private Button issueBtn, clearBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        issueBtn.setOnAction(e -> {

            try {
                Member member = new Member();
                member = MemberBl.getMember(Integer.valueOf(nationalIdTxt.getText()));

                Resource resource = new Resource();
                resource = ResourceBl.getResourcesByISBN(Integer.valueOf(resourceIdTxt.getText()))



            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
