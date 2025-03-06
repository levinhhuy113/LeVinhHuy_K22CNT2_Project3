package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class XuatKho {
    private int maPhieuXuat;
    private LocalDate ngayXuat;
    private int maHang;
    private int soLuongXuat;
    private BigDecimal giaXuat;
    private String tenKhachHang;

    public XuatKho() {
    }

    public XuatKho(int maPhieuXuat, LocalDate ngayXuat, int maHang, int soLuongXuat, BigDecimal giaXuat, String tenKhachHang) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayXuat = ngayXuat;
        this.maHang = maHang;
        this.soLuongXuat = soLuongXuat;
        this.giaXuat = giaXuat;
        this.tenKhachHang = tenKhachHang;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public LocalDate getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDate ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public BigDecimal getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(BigDecimal giaXuat) {
        this.giaXuat = giaXuat;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}
