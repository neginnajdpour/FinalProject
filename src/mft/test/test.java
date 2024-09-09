package mft.test;

import mft.Model.bl.BookBl;
import mft.Model.bl.MemberBl;
import mft.Model.bl.ProfileBl;
import mft.Model.da.MemberDa;
import mft.Model.entity.Book;
import mft.Model.entity.Member;
import mft.Model.entity.Profile;
import mft.Model.tools.JdbcProvider;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

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

        Book book = Book
                .builder()
                .ISBN("456")
                .RESOURCE_TYPE("book")
                .TITLE("prgramming with java")
                .EDITION("forth")
                .AUTHOR("deitel & deitel")
                .CATEGORY("educational")
                .PUBLISHER("EDIT")
                .LANGUAGE("persian")
                .QUANTITY(1)
                .DESCRIPTION("ASDSAKDHAS")
                .build();
        System.out.println(book.toString());
        BookBl.save(book);

//          Book book = Book.builder().TITLE("prgramming with java").build();
//          System.out.println(book.toString());
//          BookBl.delete(book);

//        Book book = Book.builder().TITLE("prgramming with c++").AUTHOR("deitel & deitel").AVAILABLE_COPIES(1).EDITION("forth").GENRE("educational").BOOK_ID(2).build();
//        System.out.println(book.toString());
//        BookBl.update(book);

//        java.util.List<Book> optionalList = BookBl.getAllBooks();
//        for(Book leave : optionalList) System.out.println(leave);

//        Member member = new Member();
//        member = MemberBl.getMember(1);
//        System.out.println(member.toString());

//        java.util.List<Member> optionalList = MemberBl.getAllMembers();
//        for(Member leave : optionalList) System.out.println(leave);



    }
}
