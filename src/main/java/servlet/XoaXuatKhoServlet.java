package servlet;

import dao.XuatKhoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/XoaXuatKho")
public class XoaXuatKhoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maPhieuXuat = Integer.parseInt(request.getParameter("maPhieuXuat"));
        XuatKhoDAO dao = new XuatKhoDAO();

        if (dao.xoaPhieuXuat(maPhieuXuat)) {
            response.sendRedirect("danh-sach-xuat-kho");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
