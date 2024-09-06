package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mft.Model.bl.MemberBl;
import mft.Model.entity.Member;

import java.net.URL;
import java.util.ResourceBundle;


public class MemberController implements Initializable {

    @FXML
    private TextField firstnameTxt , lastnameTxt;

    @FXML
    private Button saveBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveBtn.setOnAction(event -> {
            Member member = new Member(firstnameTxt.getText(), lastnameTxt.getText());
            MemberBl.save();

        });

    }
}
