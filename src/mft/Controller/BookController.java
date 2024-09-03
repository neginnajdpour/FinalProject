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
    private TableColumn<Book, String> titleCol, authorCol, genreCol, publisherCol, publishedyearCol, editionCol,    copiesCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        for (Genre genre : Genre.values()) {
            genreCmb.getItems().add(genre);
        }


        try {
            refreshTbl();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void refreshTbl() throws Exception {
        List<Book> bookList = BookBl.getAllBooks();
        ObservableList<Book> books = FXCollections.observableList(bookList);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("TITLE"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("AUTHOR"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("GENRE"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHER"));
        publishedyearCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHED_YEAR"));


        //editionCol.setCellValueFactory(new PropertyValueFactory<>("EDITION"));

//
//        publisherCol.setCellValueFactory(new PropertyValueFactory<>("PUBLISHER"));
//        yearCol.setCellValueFactory(new PropertyValueFactory<>("YEAR"));
//        copiesCol.setCellValueFactory(new PropertyValueFactory<>("COPIES"));


        bookTbl.setItems(books);
    }
}
