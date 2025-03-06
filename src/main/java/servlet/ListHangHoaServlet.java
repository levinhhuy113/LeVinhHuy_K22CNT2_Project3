package servlet;

import dao.HangHoaDAO;
import model.HangHoa;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hanghoa")
public class ListHangHoaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HangHoaDAO hangHoaDAO = new HangHoaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HangHoa> danhSachHangHoa = hangHoaDAO.getAllHangHoa();
        request.setAttribute("danhSachHangHoa", danhSachHangHoa);
        request.getRequestDispatcher("hanghoa.jsp").forward(request, response);
    }
}
