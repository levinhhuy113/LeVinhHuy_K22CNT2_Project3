package dao;

import model.NhapKho;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhapKhoDAO {

    // Thêm phiếu nhập kho
    public boolean themPhieuNhap(NhapKho nhapKho) {
        String sql = "INSERT INTO LVH_NHAPKHO (LVH_NgayNhap, LVH_MaHang, LVH_SoLuongNhap, LVH_GiaNhap, LVH_MaNCC) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, nhapKho.getNgayNhap() != null ? Date.valueOf(nhapKho.getNgayNhap()) : null);
            stmt.setInt(2, nhapKho.getMaHang());
            stmt.setInt(3, nhapKho.getSoLuongNhap());
            stmt.setBigDecimal(4, nhapKho.getGiaNhap());
            stmt.setInt(5, nhapKho.getMaNCC());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi thêm phiếu nhập!");
        }
        return false;
    }

    // Lấy danh sách phiếu nhập kho
    public List<NhapKho> layDanhSachPhieuNhap() {
        List<NhapKho> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM LVH_NHAPKHO";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                NhapKho nk = new NhapKho(
                    rs.getInt("LVH_MaPhieuNhap"),
                    rs.getDate("LVH_NgayNhap").toLocalDate(),
                    rs.getInt("LVH_MaHang"),
                    rs.getInt("LVH_SoLuongNhap"),
                    rs.getBigDecimal("LVH_GiaNhap"),
                    rs.getInt("LVH_MaNCC")
                );
                danhSach.add(nk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn CSDL!");
        }
        return danhSach;
    }

    // Xóa phiếu nhập kho
    public boolean xoaNhapKho(int maPhieuNhap) {
        String sql = "DELETE FROM LVH_NHAPKHO WHERE LVH_MaPhieuNhap = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maPhieuNhap);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi xóa phiếu nhập!");
        }
        return false;
    }

 // Sửa phương thức sửa phiếu nhập kho trong DAO
    public boolean suaNhapKho(NhapKho nhapKho) {
        String sql = "UPDATE LVH_NHAPKHO SET LVH_NgayNhap = ?, LVH_MaHang = ?, LVH_SoLuongNhap = ?, LVH_GiaNhap = ?, LVH_MaNCC = ? WHERE LVH_MaPhieuNhap = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(nhapKho.getNgayNhap())); // Không cần kiểm tra null nữa
            stmt.setInt(2, nhapKho.getMaHang());
            stmt.setInt(3, nhapKho.getSoLuongNhap());
            stmt.setBigDecimal(4, nhapKho.getGiaNhap());
            stmt.setInt(5, nhapKho.getMaNCC());
            stmt.setInt(6, nhapKho.getMaPhieuNhap());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi sửa phiếu nhập!");
        }
        return false;
    }



    // Lấy phiếu nhập kho theo ID
    public NhapKho getNhapKhoById(int maPhieuNhap) {
        NhapKho nhapKho = null;
        String sql = "SELECT * FROM LVH_NHAPKHO WHERE LVH_MaPhieuNhap = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maPhieuNhap);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nhapKho = new NhapKho(
                    rs.getInt("LVH_MaPhieuNhap"),
                    rs.getDate("LVH_NgayNhap").toLocalDate(),
                    rs.getInt("LVH_MaHang"),
                    rs.getInt("LVH_SoLuongNhap"),
                    rs.getBigDecimal("LVH_GiaNhap"),
                    rs.getInt("LVH_MaNCC")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn phiếu nhập theo ID!");
        }
        return nhapKho;
    }
}
