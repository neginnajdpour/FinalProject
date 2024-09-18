package mft.model.da;

import mft.model.entity.Gender;
import mft.model.entity.Member;
import mft.model.tools.JdbcProvider;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// save, edit, remove, findAll, findById, findByNameAndFamily, findByPhone,

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
        preparedStatement = connection.prepareStatement("INSERT INTO MEMBER(NationalID, FirstName , LastName , DateOfBirth , Gender , Active , PhoneNumber , Email , addressLine1 , addressLine2 , city , state , country , postalcode , Photo , JoinDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
        preparedStatement.setInt(1,member.getNationalID());
        preparedStatement.setString(2, member.getFirstName());
        preparedStatement.setString(3, member.getLastName());
        preparedStatement.setDate(4 , Date.valueOf(member.getDateOfBirth()));
        preparedStatement.setString(5, member.getGender().toString());
        preparedStatement.setBoolean(6, member.isActive());
        preparedStatement.setString(7, member.getPhoneNumber());
        preparedStatement.setString(8, member.getEmail());
        preparedStatement.setString(9, member.getAddressLine1());
        preparedStatement.setString(10, member.getAddressLine2());
        preparedStatement.setString(11, member.getCity());
        preparedStatement.setString(12, member.getState());
        preparedStatement.setString(13, member.getCountry());
        preparedStatement.setString(14, member.getPostalcode());
        preparedStatement.setString(15, member.getPhoto());
        preparedStatement.setDate(16, Date.valueOf(member.getJoinDate()));
        preparedStatement.executeUpdate();
    }

    public void delete(int NationalID) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM MEMBER WHERE NationalID = ?");
        preparedStatement.setInt(1, NationalID);
        preparedStatement.executeUpdate();
    }

    public void update(Member member) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE MEMBER SET FirstName = ? , LastName = ? , PhoneNumber = ? , Email = ? , addressLine1 = ? , addressLine2 = ? , city = ? , state = ? , country = ? , postalcode = ? , Photo = ? WHERE NationalID = ?");
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
        preparedStatement.setInt(12, member.getNationalID());
        preparedStatement.executeUpdate();
    }

    public Optional<Member> getMember(Integer NationalID) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM MEMBER WHERE NationalID = ?");
        preparedStatement.setInt(1, NationalID);
        resultSet = preparedStatement.executeQuery();
        Member member = new Member();
        if (resultSet.next()) {

            member.setNationalID(resultSet.getInt("NationalID"));
            member.setFirstName(resultSet.getString("FirstName"));
            member.setLastName(resultSet.getString("LastName"));
            member.setDateOfBirth(resultSet.getDate("DateOfBirth").toLocalDate());
            member.setGender(Gender.valueOf(resultSet.getString("Gender")));
            member.setActive(resultSet.getBoolean("Active"));
            member.setPhoneNumber(resultSet.getString("PhoneNumber"));
            member.setEmail(resultSet.getString("Email"));
            member.setAddressLine1(resultSet.getString("AddressLine1"));
            member.setAddressLine2(resultSet.getString("AddressLine2"));
            member.setCity(resultSet.getString("City"));
            member.setState(resultSet.getString("State"));
            member.setCountry(resultSet.getString("Country"));
            member.setPostalcode(resultSet.getString("Postalcode"));
            member.setPhoto(resultSet.getString("Photo"));
            member.setJoinDate(resultSet.getDate("JoinDate").toLocalDate());

        }
        return Optional.of(member);
    }

    public List<Member> getAllMembers(Integer NationalID) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM MEMBER WHERE NationalID = ?");
        preparedStatement.setInt(1, NationalID);
        resultSet = preparedStatement.executeQuery();
        List<Member> members = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member();
            member.setNationalID(resultSet.getInt("NationalID"));
            member.setFirstName(resultSet.getString("FirstName"));
            member.setLastName(resultSet.getString("LastName"));
            //member.setDateOfBirth(resultSet.getDate("DateOfBirth").toLocalDate());
            //member.setGender(Gender.valueOf(resultSet.getString("Gender")));
            //member.setActive(resultSet.getBoolean("Active"));
            member.setPhoneNumber(resultSet.getString("PhoneNumber"));
            member.setEmail(resultSet.getString("Email"));
            member.setAddressLine1(resultSet.getString("AddressLine1"));
            member.setAddressLine2(resultSet.getString("AddressLine2"));
            member.setCity(resultSet.getString("City"));
            member.setState(resultSet.getString("State"));
            member.setCountry(resultSet.getString("Country"));
            member.setPostalcode(resultSet.getString("Postalcode"));
            member.setPhoto(resultSet.getString("Photo"));
            //member.setJoinDate(resultSet.getDate("JoinDate").toLocalDate());
            members.add(member);
        }

        return members;
    }


    public List<Member> getAllMembers() throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM MEMBER");
        resultSet = preparedStatement.executeQuery();
        List<Member> members = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member();
            member.setNationalID(resultSet.getInt("NationalID"));
            member.setFirstName(resultSet.getString("FirstName"));
            member.setLastName(resultSet.getString("LastName"));
            member.setDateOfBirth(LocalDate.parse(resultSet.getString("DateOfBirth")));
            member.setGender(Gender.valueOf(resultSet.getString("Gender")));
            member.setActive(resultSet.getBoolean("Active"));
            member.setPhoneNumber(resultSet.getString("PhoneNumber"));
            member.setEmail(resultSet.getString("Email"));
            member.setAddressLine1(resultSet.getString("AddressLine1"));
            member.setAddressLine2(resultSet.getString("AddressLine2"));
            member.setCity(resultSet.getString("City"));
            member.setState(resultSet.getString("State"));
            member.setCountry(resultSet.getString("Country"));
            member.setPostalcode(resultSet.getString("Postalcode"));
            member.setPhoto(resultSet.getString("Photo"));
            member.setJoinDate(resultSet.getDate("JoinDate").toLocalDate());
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
