package dao;

import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public boolean checkLogin(String username, String password) {
        String query = "SELECT * FROM lvh_users WHERE LVH_Username = ? AND LVH_Password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // Nếu có mã hóa, hãy sử dụng thuật toán tương ứng

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Trả về true nếu có user
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
