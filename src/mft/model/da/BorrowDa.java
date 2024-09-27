package mft.model.da;

// save(borrow), edit, returnResource, remove, findAll, findByMemberId, findByResourceId, findReturnedResource, findNotReturnedResource

import mft.model.entity.Borrow;
import mft.model.entity.Member;
import mft.model.entity.Resource;
import mft.model.tools.JdbcProvider;

import java.sql.*;

public class BorrowDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public BorrowDa() {}
    public BorrowDa(Connection connection) {
        this.connection = connection;
    }

    public void save(Borrow borrow) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO Borrow VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1,borrow.getMember().getNationalID());
        preparedStatement.setInt(2,borrow.getResource().getRESOURCE_ID());
        preparedStatement.setDate(3,Date.valueOf(String.valueOf(borrow.getIssueDate())));
        preparedStatement.setDate(4,Date.valueOf(String.valueOf(borrow.getDueDate())));
        preparedStatement.executeUpdate();
    }

    @Override
    public void close() throws Exception{
        connection.close();
        preparedStatement.close();
        resultSet.close();
    }
}
