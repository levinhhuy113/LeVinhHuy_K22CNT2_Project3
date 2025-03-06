package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HangHoaDAO;
import model.HangHoa;

@WebServlet("/editHangHoa")
public class EditHangHoaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maHang = Integer.parseInt(request.getParameter("maHang"));
        String tenHang = request.getParameter("tenHang");
        String loaiHang = request.getParameter("loaiHang");
        String donViTinh = request.getParameter("donViTinh");
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        int maNCC = Integer.parseInt(request.getParameter("maNCC"));

        HangHoa hangHoa = new HangHoa(maHang, tenHang, loaiHang, donViTinh, soLuongTon, null, maNCC);
        HangHoaDAO dao = new HangHoaDAO();

        if (dao.updateHangHoa(hangHoa)) {
            response.sendRedirect("hanghoa"); // Quay lại trang danh sách
        } else {
            response.getWriter().println("Có lỗi khi sửa hàng hóa");
        }
    }
}
