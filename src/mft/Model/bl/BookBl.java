package mft.Model.bl;

import mft.Model.da.BookDa;
import mft.Model.entity.Book;

import java.util.ArrayList;

public class BookBl {

    public static void save(Book book) throws Exception {

        try(BookDa bookDa = new BookDa()){
            bookDa.save(book);
        }
    }

    public static void delete(Book book) throws Exception {
        try(BookDa bookDa = new BookDa()){
            bookDa.delete(book);
        }
    }

    public static void update(Book book) throws Exception {
        try(BookDa bookDa = new BookDa()){
            bookDa.update(book);
        }
    }

    public static Book findById(int id) throws Exception {
        try(BookDa bookDa = new BookDa()){

        }
        return null;
    }
    public static ArrayList<Book> getAllBooks() throws Exception {
        try(BookDa bookDa = new BookDa()){
            return (ArrayList<Book>) bookDa.getAllBooks();
        }
    }
}
