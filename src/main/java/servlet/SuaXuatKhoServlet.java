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

@WebServlet("/SuaXuatKho")
public class SuaXuatKhoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maPhieuXuat = Integer.parseInt(request.getParameter("maPhieuXuat"));
        XuatKhoDAO dao = new XuatKhoDAO();
        XuatKho xuatKho = dao.layXuatKhoByMa(maPhieuXuat);
        
        request.setAttribute("xuatKho", xuatKho);
        request.getRequestDispatcher("sua-xuat-kho.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maPhieuXuat = Integer.parseInt(request.getParameter("maPhieuXuat"));
        LocalDate ngayXuat = LocalDate.parse(request.getParameter("ngayXuat"));
        int maHang = Integer.parseInt(request.getParameter("maHang"));
        int soLuongXuat = Integer.parseInt(request.getParameter("soLuongXuat"));
        BigDecimal giaXuat = new BigDecimal(request.getParameter("giaXuat"));
        String tenKhachHang = request.getParameter("tenKhachHang");

        XuatKho xuatKho = new XuatKho(maPhieuXuat, ngayXuat, maHang, soLuongXuat, giaXuat, tenKhachHang);
        XuatKhoDAO dao = new XuatKhoDAO();

        if (dao.suaPhieuXuat(xuatKho)) {
            response.sendRedirect("danh-sach-xuat-kho");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
