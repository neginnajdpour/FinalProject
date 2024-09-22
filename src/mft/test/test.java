package mft.test;

import mft.model.bl.ResourceBl;
import mft.model.tools.JdbcProvider;


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
//
//        Resource resource = Resource
//                .builder()
//                .ISBN("123456789")
//                .RESOURCE_TYPE("book")
//                .TITLE("prgramming with java")
//                .EDITION("forth")
//                .AUTHOR("deitel & deitel")
//                .CATEGORY("educational")
//                .PUBLISHER("EDIT")
//                .LANGUAGE("persian")
//                .QUANTITY(1)
//                .DESCRIPTION("ASDSAKDHAS")
//                .build();
//        System.out.println(resource.toString());
//        ResourceBl.save(resource);

//          Book book = Book.builder().TITLE("prgramming with java").build();
//          System.out.println(book.toString());
//          BookBl.delete(book);

//        Resource book = Resource
//                .builder()
//                //.RESOURCE_ID(Integer.parseInt("1"))
//                .ISBN("456")
//                .RESOURCE_TYPE("Book")
//                .TITLE("titleTxt.getText()")
//                .EDITION("six")
//                .AUTHOR("authorTxt.getText()")
//                .CATEGORY("Category.Classic")
//                .PUBLISHER("publisherTxt.getText()")
//                .LANGUAGE("English")
//                .QUANTITY(Integer.parseInt("1"))
//                .DESCRIPTION("descriptionTxt.getText()")
//                .build();
//
//        ResourceBl.update(book);


//        java.util.List<Book> optionalList = BookBl.getAllBooks();
//        for(Book leave : optionalList) System.out.println(leave);

//        Member member = new Member();
//        member = MemberBl.getMember(1);
//        System.out.println(member.toString());

//        java.util.List<Member> optionalList = MemberBl.getAllMembers();
//        for(Member leave : optionalList) System.out.println(leave);

        ResourceBl.delete(123456789);

        System.out.println(ResourceBl.getResourceById(1));


    }
}
