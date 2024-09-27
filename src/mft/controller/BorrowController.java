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
import java.time.LocalDateTime;
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
                System.out.println(member.toString());

                Resource resource = new Resource();
                resource = ResourceBl.getResourcesByISBN(Integer.valueOf(resourceIdTxt.getText()));
                System.out.println(resource.toString());

                Borrow borrow = Borrow
                        .builder()
                        .member(member)
                        .resource(resource)
                        .issueDate(curDateTxt.getValue())
                        .dueDate(dueDateTxt.getValue())
                        .build();



                BorrowBl.save(borrow);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully issued the resource !");
                alert.showAndWait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
