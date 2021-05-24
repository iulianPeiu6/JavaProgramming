package dbconn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionHikari {
    private static HikariConfig config;
    private static HikariDataSource dataSource;

    public DBConnectionHikari() {
        config = new HikariConfig();
        config.setJdbcUrl( "jdbc:sqlite:/C:\\Users\\iulia\\OneDrive\\Desktop\\sqlite-tools-win32-x86-3350500\\usersdb.db" );
        dataSource = new HikariDataSource( config );
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
