package mft.test;

import mft.Model.bl.ResourceBl;
import mft.Model.entity.Resource;
import mft.Model.tools.JdbcProvider;


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

        Resource resource = Resource
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
        System.out.println(resource.toString());
        ResourceBl.save(resource);

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
