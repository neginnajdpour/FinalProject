package mft.Model.da;

import mft.Model.entity.Book;
import mft.Model.tools.JdbcProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        preparedStatement = connection.prepareStatement("INSERT INTO BOOK(TITLE , EDITION , AUTHOR , GENRE , PUBLISHER , PUBLSHED_YEAR , AVAILABLE_COPIES, BDESCRIPTION) VALUES (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,book.getTITLE());
        preparedStatement.setString(2, book.getEDITION());
        preparedStatement.setString(3,book.getAUTHOR());
        preparedStatement.setString(4, book.getGENRE());
        preparedStatement.setString(5, book.getPUBLISHER());
        preparedStatement.setString(6, book.getPUBLISHED_YEAR());
        preparedStatement.setInt(7,book.getAVAILABLE_COPIES());
        preparedStatement.setString(8, book.getBDESCRIPTION());
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
        preparedStatement = connection.prepareStatement("UPDATE BOOK SET TITLE = ? , EDITION = ? , AUTHOR = ? , GENRE = ? , PUBLISHER = ? , PUBLISHED_YEAR = ? , AVAILABLE_COPIES = ? , BDESCRIPTION = ? WHERE Book_Id = ?");
        preparedStatement.setString(1,book.getTITLE());
        preparedStatement.setString(2, book.getEDITION());
        preparedStatement.setString(3,book.getAUTHOR());
        preparedStatement.setString(4, book.getGENRE());
        preparedStatement.setString(5, book.getPUBLISHER());
        preparedStatement.setString(6, book.getPUBLISHED_YEAR());
        preparedStatement.setInt(7,book.getAVAILABLE_COPIES());
        preparedStatement.setString(8, book.getBDESCRIPTION());
        preparedStatement.setInt(9,book.getBOOK_ID());
        preparedStatement.executeUpdate();
    }

    public List<Book> getAllBooks() throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM BOOK");
        resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            Book book = Book
                    .builder()
                    .TITLE(resultSet.getString("TITLE"))
                    .EDITION(resultSet.getString("EDITION"))
                    .AUTHOR(resultSet.getString("AUTHOR"))
                    .GENRE(resultSet.getString("PUBLISHER"))
                    .PUBLISHED_YEAR(resultSet.getString("PUBLISHED_YEAR"))
                    .AVAILABLE_COPIES((resultSet.getInt("AVAILABLE_COPIES")))
                    .BDESCRIPTION(resultSet.getString("BDESCRIPTION"))
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
