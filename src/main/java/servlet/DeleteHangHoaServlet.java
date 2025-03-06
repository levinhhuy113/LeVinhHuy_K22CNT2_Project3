package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HangHoaDAO;

@WebServlet("/deleteHangHoa")
public class DeleteHangHoaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maHang = Integer.parseInt(request.getParameter("maHang"));

        HangHoaDAO dao = new HangHoaDAO();
        if (dao.deleteHangHoa(maHang)) {
            response.sendRedirect("hanghoa"); // Quay lại trang danh sách sản phẩm
        } else {
            response.getWriter().println("Có lỗi khi xóa sản phẩm");
        }
    }
}

