package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection = null;

    public DBConnection() {
    }

    public Connection getConnection() {
        String URL = "jdbc:sqlserver://JARVIS:1433;databaseName=QuanLyKhoanThu";
        String username = "sa";
        String password = "masteryi2K";
        try {
            this.connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return this.connection;
    }
}
