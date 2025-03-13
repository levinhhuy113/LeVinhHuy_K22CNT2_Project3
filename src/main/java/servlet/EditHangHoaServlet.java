package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.HangHoaDAO;
import model.HangHoa;

@WebServlet("/editHangHoa")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class EditHangHoaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int maHang = Integer.parseInt(request.getParameter("maHang"));
        String tenHang = request.getParameter("tenHang");
        String loaiHang = request.getParameter("loaiHang");
        String donViTinh = request.getParameter("donViTinh");
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        int maNCC = Integer.parseInt(request.getParameter("maNCC"));

        Part filePart = request.getPart("hinhAnh");
        String fileName = filePart.getSubmittedFileName();
        String imagePath = null;

        HangHoaDAO dao = new HangHoaDAO();
        HangHoa existing = dao.getHangHoaById(maHang);

        if (fileName != null && !fileName.isEmpty()) {
            String uploadDir = getServletContext().getRealPath("/uploads");
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdir();
            }
            filePart.write(uploadDir + File.separator + fileName);
            imagePath = fileName; // Chỉ lưu tên file, không lưu đường dẫn đầy đủ
        } else {
            imagePath = existing.getHinhAnh(); // Giữ nguyên nếu không chọn ảnh mới
        }


        HangHoa hangHoa = new HangHoa(maHang, tenHang, loaiHang, donViTinh, soLuongTon, imagePath, maNCC);

        if (dao.updateHangHoa(hangHoa)) {
            response.sendRedirect("hanghoa");
        } else {
            response.getWriter().println("Có lỗi khi sửa hàng hóa");
        }
    }
}
