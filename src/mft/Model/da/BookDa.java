package mft.Model.da;

import mft.Model.entity.Book;
import mft.Model.tools.JdbcProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDa implements AutoCloseable {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public BookDa() {}
    public BookDa(Connection connection) {
        this.connection = connection;
    }
    public void save(Book book) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO BOOK( ISBN , RESOURCE_TYPE , TITLE , EDITION , AUTHOR , CATEGOTY , PUBLISHER , LANGUAGE , QUANTITY , BDESCRIPTION) VALUES (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getRESOURCE_TYPE());
        preparedStatement.setString(3,book.getTITLE());
        preparedStatement.setString(4, book.getEDITION());
        preparedStatement.setString(5,book.getAUTHOR());
        preparedStatement.setString(6, book.getCATEGORY());
        preparedStatement.setString(7, book.getPUBLISHER());
        preparedStatement.setString(8, book.getLANGUAGE());
        preparedStatement.setInt(9,book.getQUANTITY());
        preparedStatement.setString(10, book.getDESCRIPTION());
        preparedStatement.executeUpdate();
    }

    public void delete(Book book) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM BOOK WHERE TITLE = ?");
        preparedStatement.setString(1,book.getTITLE());
        preparedStatement.executeUpdate();
    }

    public void update(Book book) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE BOOK SET ISBN = ? ,RESOURCE_TYPE = ? , TITLE = ? , EDITION = ? , AUTHOR = ? , CATEGORY = ? , PUBLISHER = ? , LANGUAGE = ? , QUANTITY = ? , DESCRIPTION = ? WHERE Book_Id = ?");
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getRESOURCE_TYPE());
        preparedStatement.setString(3,book.getTITLE());
        preparedStatement.setString(4, book.getEDITION());
        preparedStatement.setString(5,book.getAUTHOR());
        preparedStatement.setString(6, book.getCATEGORY());
        preparedStatement.setString(7, book.getPUBLISHER());
        preparedStatement.setString(8, book.getLANGUAGE());
        preparedStatement.setInt(9,book.getQUANTITY());
        preparedStatement.setString(10, book.getDESCRIPTION());
        preparedStatement.setInt(11,book.getBOOK_ID());
        preparedStatement.executeUpdate();
    }

    public Optional<Book> getBook(int bookId) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM BOOK WHERE Book_Id = ?");
        preparedStatement.setInt(1,bookId);
        resultSet = preparedStatement.executeQuery();
        Book book = new Book();
        if(resultSet.next()) {
            book.setISBN(resultSet.getString("ISBN"));
            book.setRESOURCE_TYPE(resultSet.getString("RESOURCE_TYPE"));
            book.setTITLE(resultSet.getString("TITLE"));
            book.setEDITION(resultSet.getString("EDITION"));
            book.setAUTHOR(resultSet.getString("AUTHOR"));
            book.setCATEGORY(resultSet.getString("CATEGORY"));
            book.setPUBLISHER(resultSet.getString("PUBLISHER"));
            book.setLANGUAGE(resultSet.getString("LANGUAGE"));
            book.setQUANTITY(resultSet.getInt("QUANTITY"));
            book.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
            book.setBOOK_ID(resultSet.getInt("Book_Id"));
        }
        return Optional.of(book);
    }

    public List<Book> getBooksByTitle(String bookTitle) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM BOOK WHERE title like ? ");
        preparedStatement.setString(1, "%" + bookTitle + "%");
        resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();
        if(resultSet.next()) {
            Book book = new Book();
            book.setBOOK_ID(resultSet.getInt("Book_Id"));
            book.setISBN(resultSet.getString("ISBN"));
            book.setRESOURCE_TYPE(resultSet.getString("RESOURCE_TYPE"));
            book.setTITLE(resultSet.getString("TITLE"));
            book.setEDITION(resultSet.getString("EDITION"));
            book.setAUTHOR(resultSet.getString("AUTHOR"));
            book.setCATEGORY(resultSet.getString("CATEGORY"));
            book.setPUBLISHER(resultSet.getString("PUBLISHER"));
            book.setLANGUAGE(resultSet.getString("LANGUAGE"));
            book.setQUANTITY(resultSet.getInt("QUANTITY"));
            book.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
            books.add(book);
        }
        return books;
    }



    public List<Book> getAllBooks() throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM BOOK");
        resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            Book book = Book
                    .builder()
                    .ISBN(resultSet.getString("ISBN"))
                    .RESOURCE_TYPE(resultSet.getString("RESOURCE_TYPE"))
                    .TITLE(resultSet.getString("TITLE"))
                    .EDITION(resultSet.getString("EDITION"))
                    .AUTHOR(resultSet.getString("AUTHOR"))
                    .CATEGORY(resultSet.getString("CATEGORY"))
                    .PUBLISHER(resultSet.getString("PUBLISHER"))
                    .LANGUAGE(resultSet.getString("LANGUAGE"))
                    .QUANTITY(resultSet.getInt("QUANTITY"))
                    .DESCRIPTION(resultSet.getString("DESCRIPTION"))
                    .build();

            books.add(book);
        }

        return books;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
