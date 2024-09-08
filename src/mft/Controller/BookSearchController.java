package mft.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mft.Model.bl.BookBl;
import mft.Model.entity.Book;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

    @FXML
    private TextField titleTxt;

    @FXML
    private Button searchBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBtn.setOnAction(event -> {
            try {
                String title = titleTxt.getText();
                List<Book> books = new ArrayList<>();
                books = BookBl.getBooksByTitle(title);




            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

    }
}
