package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import mft.Model.bl.BookBl;
import mft.Model.bl.MemberBl;
import mft.Model.entity.Book;
import mft.Model.entity.Member;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookSearchController implements Initializable {

    @FXML
    private TextField titleTxt;

    @FXML
    private TableColumn<Book , String> titleCol , editionCol , authorCol, genreCol , publisherCol ;

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private Button searchBtn;



    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        searchBtn.setOnAction(event -> {

            String title = titleTxt.getText();

            try {
                refreshBookTbl(title);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });

    }


    public void refreshBookTbl(String bookTitle) throws Exception {
        List<Book> bookList = BookBl.getBooksByTitle(bookTitle);
        ObservableList<Book> observableList = FXCollections.observableList(bookList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("GENRE"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHER"));
        bookTbl.setItems(observableList);
    }
}
