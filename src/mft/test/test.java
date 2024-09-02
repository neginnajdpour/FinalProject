package mft.test;

import mft.Model.bl.ProfileBl;
import mft.Model.entity.Profile;
import mft.Model.tools.JdbcProvider;


import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        JdbcProvider jdbcProvider = new JdbcProvider();
//        System.out.println("Connecting to database...");
//        Connection connection = jdbcProvider.getConnection();

//        Profile profile = new Profile();
//        profile = ProfileBl.getProfile("nn","123");
//        profile.toString();

        Profile profile = new Profile();
        try {
            profile = ProfileBl.getProfile("nn","123");
            System.out.println(profile.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
