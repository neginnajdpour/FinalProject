package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
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
    private TableColumn<Book , String> titleCol , editionCol , authorCol, genreCol , publisherCol ;

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private Button searchBtn;


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        refreshTbl();


//        searchBtn.setOnAction(event -> {
//            try {
//                String title = titleTxt.getText();
//                List<Book> books = new ArrayList<>();
//                books = BookBl.getBooksByTitle(title);
//                ObservableList observableList = FXCollections.observableList(books);
//                titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("TITLE"));
//                editionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("EDITION"));
//                authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("AUTHOR"));
//                genreCol.setCellValueFactory(new PropertyValueFactory<Book, String>("GENRE"));
//                publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("PUBLISHER"));
//                bookTbl.setItems(observableList);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });

    }


    public void refreshTbl() throws Exception {
        List<Book> books = new ArrayList<>();
        books = BookBl.getAllBooks();
        ObservableList observableList = FXCollections.observableList(books);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
//        editionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("EDITION"));
//        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("AUTHOR"));
//        genreCol.setCellValueFactory(new PropertyValueFactory<Book, String>("GENRE"));
//        publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("PUBLISHER"));
        bookTbl.setItems(observableList);
    }
}
