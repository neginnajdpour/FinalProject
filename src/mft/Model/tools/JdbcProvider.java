package mft.Model.tools;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcProvider {
    //Singleton
    private static JdbcProvider instance;
    private static BasicDataSource basicDataSource = new BasicDataSource();

    public JdbcProvider() {}

    public static JdbcProvider getInstance() {
        if (instance == null) {
            instance = new JdbcProvider();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/mft");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Negin@09143148516");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);

        return basicDataSource.getConnection();
    }
}
