package mft.Model.da;

import mft.Model.entity.Profile;
import mft.Model.tools.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProfileDa implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProfileDa() {

    }



    public void remove(String username) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE profile_tbl SET ACTIVE = 0  WHERE username = ?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }

    public Optional<Profile> getProfile(String username , String password) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        String sql = "SELECT * FROM PROFILE_TBL WHERE USERNAME = ? AND PASSWORD = ? AND ACTIVE = 1";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();
        Optional<Profile> optionalProfile = Optional.empty();

        if (resultSet.next()) {
            Profile profile = new Profile();
            profile.setUsername(resultSet.getString("username"));
            profile.setPassword(resultSet.getString("password"));
            profile.setName(resultSet.getString("name"));
            profile.setFamily(resultSet.getString("family"));
            profile.setActive(resultSet.getInt("active"));
            System.out.println("DA : " + profile);
            optionalProfile = Optional.of(profile);
        }
        return optionalProfile;
    }





    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
