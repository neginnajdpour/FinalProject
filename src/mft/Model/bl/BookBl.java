package mft.Model.bl;

import mft.Model.da.BookDa;
import mft.Model.entity.Book;

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
}
