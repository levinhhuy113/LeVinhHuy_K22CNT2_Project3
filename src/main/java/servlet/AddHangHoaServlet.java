package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.HangHoaDAO;
import model.HangHoa;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
@WebServlet("/addHangHoa")  // <-- Đảm bảo đúng đường dẫn này

public class AddHangHoaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenHang = request.getParameter("tenHang");
        String loaiHang = request.getParameter("loaiHang");
        String donViTinh = request.getParameter("donViTinh");
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        int maNCC = Integer.parseInt(request.getParameter("maNCC"));

        // Lưu ảnh
        Part filePart = request.getPart("hinhAnh");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadDir = getServletContext().getRealPath("/") + "uploads";
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdir();
        }
        String filePath = "uploads/" + fileName;
        filePart.write(uploadDir + File.separator + fileName);

        // Tạo hàng hóa với đường dẫn ảnh
        HangHoa hangHoa = new HangHoa(0, tenHang, loaiHang, donViTinh, soLuongTon, filePath, maNCC);
        HangHoaDAO dao = new HangHoaDAO();

        if (dao.addHangHoa(hangHoa)) {
            response.sendRedirect("hanghoa"); // Quay lại danh sách
        } else {
            response.getWriter().println("Có lỗi khi thêm hàng hóa");
        }
    }
}
