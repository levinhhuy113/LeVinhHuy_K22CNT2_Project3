package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NhaCungCapDAO;
import model.NhaCungCap;

@WebServlet("/NhaCungCapServlet")
public class NhaCungCapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        try {
            List<NhaCungCap> danhSachNhaCungCap = nhaCungCapDAO.getAllNhaCungCap();
            request.setAttribute("danhSachNhaCungCap", danhSachNhaCungCap);
            request.getRequestDispatcher("nhacungcap.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color: red;'>Lỗi khi lấy danh sách nhà cung cấp: " + e.getMessage() + "</h3>");
        }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String tenNCC = request.getParameter("tenNCC");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");

            NhaCungCap ncc = new NhaCungCap(0, tenNCC, diaChi, soDienThoai);
            nhaCungCapDAO.addNhaCungCap(ncc);
            response.sendRedirect("NhaCungCapServlet");

        } else if ("update".equals(action)) {
            int maNCC = Integer.parseInt(request.getParameter("maNCC"));
            String tenNCC = request.getParameter("tenNCC");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");

            NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai);
            nhaCungCapDAO.updateNhaCungCap(ncc);
            response.sendRedirect("NhaCungCapServlet");
        } else if ("delete".equals(action)) {
            int maNCC = Integer.parseInt(request.getParameter("maNCC"));
            nhaCungCapDAO.deleteNhaCungCap(maNCC);
            response.sendRedirect("NhaCungCapServlet");
        }

    }
    
}

