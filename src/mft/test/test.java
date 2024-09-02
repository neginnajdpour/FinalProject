package mft.test;

import mft.Model.bl.BookBl;
import mft.Model.bl.ProfileBl;
import mft.Model.entity.Book;
import mft.Model.entity.Profile;
import mft.Model.tools.JdbcProvider;


import java.sql.SQLException;
import java.util.Optional;

public class test {
    public static <List> void main(String[] args) throws Exception {
        JdbcProvider jdbcProvider = new JdbcProvider();
//        System.out.println("Connecting to database...");
//        Connection connection = jdbcProvider.getConnection();

//        Profile profile = new Profile();
//        profile = ProfileBl.getProfile("nn","123");
//        profile.toString();

//        Profile profile = new Profile();
//        try {
//            profile = ProfileBl.getProfile("nn","123");
//            System.out.println(profile.toString());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        Book book = Book.builder().TITLE("prgramming with java").AUTHOR("deitel & deitel").AVAILABLE_COPIES(1).EDITION("forth").GENRE("educational").build();
//        System.out.println(book.toString());
//        BookBl.save(book);

//          Book book = Book.builder().TITLE("prgramming with java").build();
//          System.out.println(book.toString());
//          BookBl.delete(book);

//        Book book = Book.builder().TITLE("prgramming with c++").AUTHOR("deitel & deitel").AVAILABLE_COPIES(1).EDITION("forth").GENRE("educational").BOOK_ID(2).build();
//        System.out.println(book.toString());
//        BookBl.update(book);

        List optionalList = (List) BookBl.getAllBooks();
        System.out.println(optionalList.toString());














    }
}
