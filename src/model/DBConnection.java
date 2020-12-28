package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection = null;

    public DBConnection() {
    }

    public Connection getConnection() {
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=project_cnpm";
        String username = "sa";
        String password = "powzxc2000@";
        try {
            this.connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return this.connection;
    }
}
