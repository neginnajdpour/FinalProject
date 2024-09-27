package mft.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import mft.model.bl.BorrowBl;
import mft.model.bl.MemberBl;
import mft.model.bl.ResourceBl;
import mft.model.entity.Borrow;
import mft.model.entity.Gender;
import mft.model.entity.Member;
import mft.model.entity.Resource;
import java.time.LocalDate;

import java.net.URL;
import java.util.Date;
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


        curDateTxt.setValue(LocalDate.now());

        issueBtn.setOnAction(event -> {
            try {

                Member member = new Member();
                member = MemberBl.getMember(Integer.valueOf(nationalIdTxt.getText()));

                Resource resource = new Resource();
                resource = ResourceBl.getResourcesByISBN(Integer.valueOf(resourceIdTxt.getText()));

                Borrow borrow = Borrow
                        .builder()
                        .member(member)
                        .resource(resource)
                        .issueDate(curDateTxt.getValue().atStartOfDay())
                        .dueDate(dueDateTxt.getValue().atStartOfDay())
                        .build();

                BorrowBl.save(borrow);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully save the member !");
                alert.showAndWait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });


//        issueBtn.setOnAction(e -> {
//
//            try {
//
//
//
//
//                //RadioButton selectedRadioButton = (RadioButton) GenderToggle.getSelectedToggle();
//

//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });
    }
}
