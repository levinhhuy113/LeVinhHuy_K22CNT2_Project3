package utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/lvh_quanlykhohang";
    private static final String USER = "root";
    private static final String PASSWORD = "123456"; // Thay đổi theo cấu hình của bạn

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Lỗi tải driver JDBC!", e);
        }
    }
}
