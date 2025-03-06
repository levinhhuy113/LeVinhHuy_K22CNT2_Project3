package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;
import utils.DatabaseConnection;

public class NhaCungCapDAO {
    private Connection conn;

    public NhaCungCapDAO() {
        try {
            this.conn = DatabaseConnection.getConnection();
            if (this.conn == null) {
                throw new SQLException("Kết nối cơ sở dữ liệu thất bại!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi khởi tạo kết nối trong NhaCungCapDAO");
            e.printStackTrace();
        }
    }

    public List<NhaCungCap> getAllNhaCungCap() throws SQLException {
        if (this.conn == null) {
            throw new SQLException("Kết nối đến cơ sở dữ liệu không hợp lệ!");
        }
        
        List<NhaCungCap> nccList = new ArrayList<>();
        String query = "SELECT * FROM lvh_NHACUNGCAP";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int maNCC = rs.getInt("lvh_MaNCC");
                String tenNCC = rs.getString("lvh_TenNCC");
                String diaChi = rs.getString("lvh_DiaChi");
                String soDienThoai = rs.getString("lvh_SoDienThoai");
                nccList.add(new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai));
            }
        }
        return nccList;
    }

    public NhaCungCap getNhaCungCapById(int maNCC) {
        String sql = "SELECT * FROM lvh_NHACUNGCAP WHERE lvh_MaNCC = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNCC);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new NhaCungCap(
                    rs.getInt("lvh_MaNCC"),
                    rs.getString("lvh_TenNCC"),
                    rs.getString("lvh_DiaChi"),
                    rs.getString("lvh_SoDienThoai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNhaCungCap(NhaCungCap ncc) {
        String sql = "INSERT INTO lvh_NHACUNGCAP (lvh_TenNCC, lvh_DiaChi, lvh_SoDienThoai) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getSoDienThoai());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNhaCungCap(NhaCungCap ncc) {
        String sql = "UPDATE lvh_NHACUNGCAP SET lvh_TenNCC=?, lvh_DiaChi=?, lvh_SoDienThoai=? WHERE lvh_MaNCC=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getSoDienThoai());
            stmt.setInt(4, ncc.getMaNCC());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteNhaCungCap(int maNCC) {
        String sql = "DELETE FROM lvh_NHACUNGCAP WHERE lvh_MaNCC=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNCC);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
