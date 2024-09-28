package mft.model.da;

// save(borrow), edit, returnResource, remove, findAll, findByMemberId, findByResourceId, findReturnedResource, findNotReturnedResource

import mft.model.bl.MemberBl;
import mft.model.bl.ResourceBl;
import mft.model.entity.Borrow;
import mft.model.entity.Member;
import mft.model.entity.Resource;
import mft.model.tools.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        preparedStatement = connection.prepareStatement("INSERT INTO Borrow(NationalId,ResourceId,issue_date,return_date) VALUES (?,?,?,?)");
        preparedStatement.setInt(1,borrow.getMember().getNationalID());
        preparedStatement.setInt(2,borrow.getResource().getRESOURCE_ID());
        preparedStatement.setDate(3,Date.valueOf(borrow.getIssueDate()));
        preparedStatement.setDate(4,Date.valueOf(borrow.getDueDate()));
        preparedStatement.executeUpdate();
    }

    public List<Borrow> getBorrowed() throws Exception {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM Borrow");
        resultSet = preparedStatement.executeQuery();
        List<Borrow> borrowList = new ArrayList<>();
        while (resultSet.next()) {
            Borrow borrow = new Borrow();
            borrow.setMember(MemberBl.getMember(resultSet.getInt("NationalId")));
            borrow.setResource(ResourceBl.getResourceById(resultSet.getInt("ResourceId")));
            borrow.setIssueDate(resultSet.getDate("issue_date").toLocalDate());
            borrow.setDueDate(resultSet.getDate("return_date").toLocalDate());
            borrowList.add(borrow);
        }
        return borrowList;
    }



    @Override
    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
