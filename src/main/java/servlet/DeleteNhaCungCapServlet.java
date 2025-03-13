package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NhaCungCapDAO;

@WebServlet("/deleteNhaCungCap")
public class DeleteNhaCungCapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maNCC = Integer.parseInt(request.getParameter("maNCC"));
            nhaCungCapDAO.deleteNhaCungCap(maNCC);
            response.sendRedirect("NhaCungCapServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color: red;'>Lỗi khi xóa nhà cung cấp: " + e.getMessage() + "</h3>");
        }
    }
}
