package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
    private static DBConnectionSingleton singleInstance = null;

    private String url =
            "jdbc:sqlite:/C:\\Users\\iulia\\OneDrive\\Desktop\\sqlite-tools-win32-x86-3350500\\usersdb.db";

    public Connection connection;

    private DBConnectionSingleton() throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    public static DBConnectionSingleton getInstance() throws SQLException {
        if (singleInstance == null)
            singleInstance = new DBConnectionSingleton();

        return singleInstance;
    }
}
