package mft.Model.da;

import mft.Model.entity.Book;
import mft.Model.tools.JdbcProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        preparedStatement.setString(6, book.getPUBLSHED_YEAR());
        preparedStatement.setInt(7,book.getAVAILABLE_COPIES());
        preparedStatement.setString(8, book.getDESCRIPTION());
        preparedStatement.executeUpdate();
    }

    public void delete(Book book) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM BOOK WHERE TITLE = ?");
        preparedStatement.setString(1,book.getTITLE());
        preparedStatement.executeUpdate();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
