package servlet;

import dao.NhapKhoDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/XoaNhapKhoServlet")
public class XoaNhapKhoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int maPhieuNhap = Integer.parseInt(request.getParameter("maPhieuNhap"));
            NhapKhoDAO dao = new NhapKhoDAO();
            boolean result = dao.xoaNhapKho(maPhieuNhap);

            if (result) {
                response.sendRedirect("DanhSachNhapKho?success=true");
            } else {
                request.setAttribute("errorMessage", "Không thể xóa phiếu nhập!");
                request.getRequestDispatcher("danh_sach_nhap_kho.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("DanhSachNhapKho?error=true");
        }
    }
}
