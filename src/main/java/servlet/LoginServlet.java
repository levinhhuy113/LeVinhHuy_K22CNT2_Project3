package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DatabaseConnection;

// Servlet xử lý đăng nhập
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DatabaseConnection.getConnection();  // Hàm kết nối DB
            String sql = "SELECT * FROM lvh_users WHERE LVH_Username = ? AND LVH_PasswordHash = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // Cần mã hóa trước khi kiểm tra!

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Tạo session khi đăng nhập thành công
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", rs.getInt("LVH_RoleID"));

                // Chuyển hướng đến `hanghoa.jsp`
                response.sendRedirect("index.jsp");
            } else {
                response.getWriter().println("Sai tài khoản hoặc mật khẩu!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
