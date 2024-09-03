package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mft.Model.bl.BookBl;
import mft.Model.entity.Genre;
import mft.Model.entity.Book;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    @FXML
    private TextField titleTxt;

    @FXML
    private TextField editionTxt;

    @FXML
    private TextField authorTxt;

    @FXML
    private TextField publisherTxt;

    @FXML
    private TextField yearTxt;

    @FXML
    private TextField copiesTxt;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private ComboBox genreCmb;

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private TableColumn<Book, String> titleCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        for (Genre genre : Genre.values()) {
            genreCmb.getItems().add(genre);
        }


        try {
            refreshTbl(BookBl.getAllBooks());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void refreshTbl(List<Book> bookList){

        ObservableList<Book> books = FXCollections.observableList(bookList);

        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));

        bookTbl.setItems(books);
    }
}
