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
import utils.DatabaseConnection;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("message", "Mật khẩu nhập lại không khớp!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            
            // Kiểm tra username đã tồn tại chưa
            String checkUsernameSQL = "SELECT * FROM lvh_users WHERE LVH_Username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkUsernameSQL);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                request.setAttribute("message", "Tên đăng nhập đã tồn tại!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Thêm user vào database (Không mã hóa mật khẩu)
            String insertSQL = "INSERT INTO lvh_users (LVH_Username, LVH_Email, LVH_FullName, LVH_PasswordHash, LVH_RoleID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, fullname);
            stmt.setString(4, password); // Lưu mật khẩu trực tiếp
            stmt.setInt(5, 2); // Mặc định role là user thường

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
            	response.sendRedirect("login.jsp?successMessage=" + java.net.URLEncoder.encode("Đăng ký thành công!", "UTF-8"));

            } else {
                request.setAttribute("message", "Đăng ký thất bại, thử lại sau!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Lỗi hệ thống, vui lòng thử lại!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
