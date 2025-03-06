package dao;

import model.XuatKho;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XuatKhoDAO {

    // Thêm phiếu xuất kho
    public boolean themPhieuXuat(XuatKho xuatKho) {
        String sql = "INSERT INTO LVH_XUATKHO (LVH_NgayXuat, LVH_MaHang, LVH_SoLuongXuat, LVH_GiaXuat, LVH_TenKhachHang) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(xuatKho.getNgayXuat()));
            stmt.setInt(2, xuatKho.getMaHang());
            stmt.setInt(3, xuatKho.getSoLuongXuat());
            stmt.setBigDecimal(4, xuatKho.getGiaXuat());
            stmt.setString(5, xuatKho.getTenKhachHang());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi thêm phiếu xuất!");
        }
        return false;
    }
    public XuatKho layXuatKhoByMa(int maPhieuXuat) {
        String sql = "SELECT * FROM LVH_XUATKHO WHERE LVH_MaPhieuXuat = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maPhieuXuat);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new XuatKho(
                        rs.getInt("LVH_MaPhieuXuat"),
                        rs.getDate("LVH_NgayXuat").toLocalDate(),
                        rs.getInt("LVH_MaHang"),
                        rs.getInt("LVH_SoLuongXuat"),
                        rs.getBigDecimal("LVH_GiaXuat"),
                        rs.getString("LVH_TenKhachHang")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi lấy phiếu xuất kho theo mã!");
        }
        return null; // Trả về null nếu không tìm thấy phiếu xuất
    }

    public boolean suaPhieuXuat(XuatKho xuatKho) {
        String sql = "UPDATE LVH_XUATKHO SET LVH_NgayXuat = ?, LVH_MaHang = ?, LVH_SoLuongXuat = ?, LVH_GiaXuat = ?, LVH_TenKhachHang = ? WHERE LVH_MaPhieuXuat = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(xuatKho.getNgayXuat()));
            stmt.setInt(2, xuatKho.getMaHang());
            stmt.setInt(3, xuatKho.getSoLuongXuat());
            stmt.setBigDecimal(4, xuatKho.getGiaXuat());
            stmt.setString(5, xuatKho.getTenKhachHang());
            stmt.setInt(6, xuatKho.getMaPhieuXuat());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi sửa phiếu xuất!");
        }
        return false;
    }
    public boolean xoaPhieuXuat(int maPhieuXuat) {
        String sql = "DELETE FROM LVH_XUATKHO WHERE LVH_MaPhieuXuat = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maPhieuXuat);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa phiếu xuất!");
        }
        return false;
    }



    // Lấy danh sách phiếu xuất kho
    public List<XuatKho> layDanhSachPhieuXuat() {
        List<XuatKho> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM LVH_XUATKHO ORDER BY LVH_NgayXuat DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                XuatKho xk = new XuatKho(
                    rs.getInt("LVH_MaPhieuXuat"),
                    rs.getDate("LVH_NgayXuat").toLocalDate(),
                    rs.getInt("LVH_MaHang"),
                    rs.getInt("LVH_SoLuongXuat"),
                    rs.getBigDecimal("LVH_GiaXuat"),
                    rs.getString("LVH_TenKhachHang")
                );
                danhSach.add(xk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn danh sách phiếu xuất!");
        }
        return danhSach;
    }
}
