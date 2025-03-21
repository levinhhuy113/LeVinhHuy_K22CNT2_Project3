package dao;

import model.HangHoa;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HangHoaDAO {
    public List<HangHoa> getAllHangHoa() {
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
        String query = "SELECT * FROM lvh_hanghoa";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HangHoa hangHoa = new HangHoa(
                    rs.getInt("LVH_MaHang"),
                    rs.getString("LVH_TenHang"),
                    rs.getString("LVH_LoaiHang"),
                    rs.getString("LVH_DonViTinh"),
                    rs.getInt("LVH_SoLuongTon"),
                    rs.getString("LVH_HinhAnh"),
                    rs.getInt("LVH_MaNCC")
                );
                danhSachHangHoa.add(hangHoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHangHoa;
    }

    public HangHoa getHangHoaById(int maHang) {
        HangHoa hangHoa = null;
        String query = "SELECT * FROM lvh_hanghoa WHERE LVH_MaHang = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maHang);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hangHoa = new HangHoa(
                        rs.getInt("LVH_MaHang"),
                        rs.getString("LVH_TenHang"),
                        rs.getString("LVH_LoaiHang"),
                        rs.getString("LVH_DonViTinh"),
                        rs.getInt("LVH_SoLuongTon"),
                        rs.getString("LVH_HinhAnh"),
                        rs.getInt("LVH_MaNCC")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangHoa;
    }

    public boolean addHangHoa(HangHoa hangHoa) {
        String query = "INSERT INTO lvh_hanghoa (LVH_TenHang, LVH_LoaiHang, LVH_DonViTinh, LVH_SoLuongTon, LVH_HinhAnh, LVH_MaNCC) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hangHoa.getTenHang());
            stmt.setString(2, hangHoa.getLoaiHang());
            stmt.setString(3, hangHoa.getDonViTinh());
            stmt.setInt(4, hangHoa.getSoLuongTon());
            stmt.setString(5, hangHoa.getHinhAnh());
            stmt.setInt(6, hangHoa.getMaNCC());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHangHoa(int maHang) {
        String query = "DELETE FROM lvh_hanghoa WHERE LVH_MaHang = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, maHang);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateHangHoa(HangHoa hangHoa) {
        String sql = "UPDATE lvh_hanghoa SET LVH_TenHang = ?, LVH_LoaiHang = ?, LVH_DonViTinh = ?, LVH_SoLuongTon = ?, LVH_HinhAnh = ?, LVH_MaNCC = ? WHERE LVH_MaHang = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, hangHoa.getTenHang());
            ps.setString(2, hangHoa.getLoaiHang());
            ps.setString(3, hangHoa.getDonViTinh());
            ps.setInt(4, hangHoa.getSoLuongTon());
            ps.setString(5, hangHoa.getHinhAnh());
            ps.setInt(6, hangHoa.getMaNCC());
            ps.setInt(7, hangHoa.getMaHang());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
