package mft.Model.bl;

import mft.Model.da.BookDa;
import mft.Model.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static Book getBook(int bookId) throws Exception {
        Book book = new Book();
        try(BookDa bookDa = new BookDa()){
            book = bookDa.getBook(bookId).get();
        }
        return book;
    }

    public static List<Book> getBooksByTitle(String bookTitle) throws Exception {
        List<Book> books = new ArrayList<>();
        try(BookDa bookDa = new BookDa()){
            books = bookDa.getBooksByTitle(bookTitle);
        }
        return books;
    };



    public static List<Book>  getAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();

        try(BookDa bookDa = new BookDa()){
            books = bookDa.getAllBooks();
        }
//        List<Optional<Book>> optionalBooks  = books.stream()
//                .map((o) -> Optional.of(o)).collect(Collectors.toList());

        return books;
    }
}
