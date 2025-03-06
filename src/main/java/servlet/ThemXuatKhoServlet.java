package servlet;

import dao.XuatKhoDAO;
import model.XuatKho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/xuatkho/them")
public class ThemXuatKhoServlet extends HttpServlet {
    private XuatKhoDAO xuatKhoDAO = new XuatKhoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy dữ liệu từ request
            LocalDate ngayXuat = LocalDate.parse(request.getParameter("ngayXuat"));
            int maHang = Integer.parseInt(request.getParameter("maHang"));
            int soLuongXuat = Integer.parseInt(request.getParameter("soLuongXuat"));
            BigDecimal giaXuat = new BigDecimal(request.getParameter("giaXuat"));
            String tenKhachHang = request.getParameter("tenKhachHang");

            // Tạo đối tượng phiếu xuất
            XuatKho xk = new XuatKho(0, ngayXuat, maHang, soLuongXuat, giaXuat, tenKhachHang);

            // Thêm vào cơ sở dữ liệu
            boolean themThanhCong = xuatKhoDAO.themPhieuXuat(xk);

            if (themThanhCong) {
            	response.sendRedirect(request.getContextPath() + "/danh-sach-xuat-kho");


            } else {
                request.setAttribute("error", "Lỗi khi thêm phiếu xuất kho!");
                request.getRequestDispatcher("/WEB-INF/views/xuat_kho.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Dữ liệu không hợp lệ!");
            request.getRequestDispatcher("/WEB-INF/views/xuat_kho.jsp").forward(request, response);
        }
    }
}
