package lab.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement;instanceName=SQL2014";
        con = DriverManager.getConnection(url, "sa", "LanAnh0202");
        return con;
    }
}
