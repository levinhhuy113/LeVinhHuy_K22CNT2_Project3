package servlet;

import dao.XuatKhoDAO;
import model.XuatKho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach-xuat-kho")
public class DanhSachXuatKhoServlet extends HttpServlet {
    private XuatKhoDAO xuatKhoDAO;

    @Override
    public void init() {
        xuatKhoDAO = new XuatKhoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<XuatKho> danhSachXuatKho = xuatKhoDAO.layDanhSachPhieuXuat();
        request.setAttribute("danhSachXuatKho", danhSachXuatKho);
        request.getRequestDispatcher("danh_sach_xuat_kho.jsp").forward(request, response);
    }
}
