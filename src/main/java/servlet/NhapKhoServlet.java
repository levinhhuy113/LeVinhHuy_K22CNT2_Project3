package servlet;

import dao.NhapKhoDAO;
import model.NhapKho;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NhapKhoServlet")
public class NhapKhoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int maHang = Integer.parseInt(request.getParameter("maHang"));
            int maNCC = Integer.parseInt(request.getParameter("maNCC"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            BigDecimal giaNhap = new BigDecimal(request.getParameter("giaNhap"));
            LocalDate ngayNhap = LocalDate.parse(request.getParameter("ngayNhap"));

            NhapKho nhapKho = new NhapKho();
            nhapKho.setNgayNhap(ngayNhap);
            nhapKho.setMaHang(maHang);
            nhapKho.setSoLuongNhap(soLuong);
            nhapKho.setGiaNhap(giaNhap);
            nhapKho.setMaNCC(maNCC);

            NhapKhoDAO dao = new NhapKhoDAO();
            boolean result = dao.themPhieuNhap(nhapKho);

            if (result) {
                response.sendRedirect("DanhSachNhapKho?success=true");
            } else {
                request.setAttribute("errorMessage", "Không thể thêm phiếu nhập!");
                request.getRequestDispatcher("nhap_kho.jsp").forward(request, response);
            }
	
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("DanhSachNhapKho?error=true");
        }
    }
}
