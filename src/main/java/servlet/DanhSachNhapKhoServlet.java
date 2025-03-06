package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NhapKhoDAO;
import model.NhapKho;

@WebServlet("/DanhSachNhapKho")
public class DanhSachNhapKhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhapKhoDAO nhapKhoDAO; // Biến DAO

    @Override
    public void init() throws ServletException {
        nhapKhoDAO = new NhapKhoDAO(); // ⚠️ Bổ sung khởi tạo DAO tại đây
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhapKho> danhSachNhapKho = nhapKhoDAO.layDanhSachPhieuNhap();

        // Debug: In ra console để kiểm tra dữ liệu lấy từ database
        if (danhSachNhapKho != null) {
            for (NhapKho nk : danhSachNhapKho) {
                System.out.println(nk.getMaPhieuNhap() + " - " + nk.getNgayNhap() + " - " + nk.getMaHang());
            }
        } else {
            System.out.println("Không có dữ liệu phiếu nhập!");
        }

        request.setAttribute("danhSachNhapKho", danhSachNhapKho);
        request.getRequestDispatcher("danh_sach_nhap_kho.jsp").forward(request, response);
    }
}
