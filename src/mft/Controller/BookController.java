package mft.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
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
    private TextField isbnTxt, titleTxt, editionTxt, authorTxt, publisherTxt, languageTxt, quantityTxt, descriptionTxt;


    @FXML
    private ComboBox resourcetypeCmb , categoryCmb;

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private TableColumn<Book, String> titleCol, authorCol, genreCol, publisherCol, publishedyearCol, editionCol,    copiesCol;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Genre genre : Genre.values()) {
            categoryCmb.getItems().add(genre);
        }

        refreshTbl();

    }

    public void refreshTbl() throws Exception {

        List<Book> bookList = BookBl.getAllBooks();
        ObservableList<Book> observableList = FXCollections.observableList(bookList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("GENRE"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHER"));
        publishedyearCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHED_YEAR"));
        editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));
        bookTbl.setItems(observableList);

    }
}
