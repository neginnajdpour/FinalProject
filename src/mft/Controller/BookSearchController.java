package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

    @FXML
    private TextField titleTxt;

    @FXML
    private Button searchBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBtn.setOnAction(event -> {
            String title = titleTxt.getText();

        });

    }
}
