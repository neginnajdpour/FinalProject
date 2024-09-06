package mft.Model.da;

import com.mysql.cj.jdbc.JdbcConnection;
import mft.Model.entity.Member;
import mft.Model.tools.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDa implements AutoCloseable {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MemberDa() {}

    public MemberDa(Connection connection) {
        this.connection = connection;
    }

    public void save(Member member) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO MEMBER(FirstName , LastName , PhoneNumber , Email , addressLine1 , addressLine2 , city , state , country , postalcode , Photo ) VALUES (?,?,?,?,?,?,?,?,?,?,?) ");
        preparedStatement.setString(1, member.getFirstName());
        preparedStatement.setString(2, member.getLastName());
        preparedStatement.setString(3, member.getPhoneNumber());
        preparedStatement.setString(4, member.getEmail());
        preparedStatement.setString(5, member.getAddressLine1());
        preparedStatement.setString(6, member.getAddressLine2());
        preparedStatement.setString(7, member.getCity());
        preparedStatement.setString(8, member.getState());
        preparedStatement.setString(9, member.getCountry());
        preparedStatement.setString(10, member.getPostalcode());
        preparedStatement.setString(11, member.getPhoto());
        preparedStatement.executeUpdate();
    }

    public void delete(Member member) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM MEMBER WHERE MemberID = ?");
        preparedStatement.setString(1, member.getMemberID());
        preparedStatement.executeUpdate();
    }

    public void edit(Member member) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE MEMBER SET FirstName = ? , LastName = ? , PhoneNumber = ? , Email = ? , addressLine1 = ? , addressLine2 = ? , city = ? , state = ? , country = ? , postalcode = ? , Photo = ? WHERE MemberID = ?)");
        preparedStatement.setString(1, member.getFirstName());
        preparedStatement.setString(2, member.getLastName());
        preparedStatement.setString(3, member.getPhoneNumber());
        preparedStatement.setString(4, member.getEmail());
        preparedStatement.setString(5, member.getAddressLine1());
        preparedStatement.setString(6, member.getAddressLine2());
        preparedStatement.setString(7, member.getCity());
        preparedStatement.setString(8, member.getState());
        preparedStatement.setString(9, member.getCountry());
        preparedStatement.setString(10, member.getPostalcode());
        preparedStatement.setString(11, member.getPhoto());
        preparedStatement.setString(12, member.getMemberID());
        preparedStatement.executeUpdate();
    }

    public Optional<Member> getMember(int memberID) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM MEMBER WHERE MemberID = ?");
        preparedStatement.setInt(1, memberID);
        resultSet = preparedStatement.executeQuery();
        Member member = new Member();
        if (resultSet.next()) {

            member.setMemberID(resultSet.getString("MemberID"));
            member.setFirstName(resultSet.getString("FirstName"));
            member.setLastName(resultSet.getString("LastName"));
            member.setPhoneNumber(resultSet.getString("PhoneNumber"));
            member.setEmail(resultSet.getString("Email"));
            member.setAddressLine1(resultSet.getString("AddressLine1"));
            member.setAddressLine2(resultSet.getString("AddressLine2"));
            member.setCity(resultSet.getString("City"));
            member.setState(resultSet.getString("State"));
            member.setCountry(resultSet.getString("Country"));
            member.setPostalcode(resultSet.getString("Postalcode"));
            member.setPhoto(resultSet.getString("Photo"));

        }
        return Optional.of(member);
    }

    public List<Member> getAllMembers() throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM MEMBER");
        resultSet = preparedStatement.executeQuery();
        List<Member> members = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member();
            member.setMemberID(resultSet.getString("MemberID"));
            member.setFirstName(resultSet.getString("FirstName"));
            member.setLastName(resultSet.getString("LastName"));
            member.setPhoneNumber(resultSet.getString("PhoneNumber"));
            member.setEmail(resultSet.getString("Email"));
            member.setAddressLine1(resultSet.getString("AddressLine1"));
            member.setAddressLine2(resultSet.getString("AddressLine2"));
            member.setCity(resultSet.getString("City"));
            member.setState(resultSet.getString("State"));
            member.setCountry(resultSet.getString("Country"));
            member.setPostalcode(resultSet.getString("Postalcode"));
            members.add(member);
        }

        return members;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
