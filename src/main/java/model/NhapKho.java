package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NhapKho {

    private int maPhieuNhap;
    private LocalDate ngayNhap;
    private int maHang;
    private int soLuongNhap;
    private BigDecimal giaNhap;
    private int maNCC; // Đổi maNCC thành int thay vì String

    // Constructor mặc định
    public NhapKho() {}

    // Constructor với các tham số
    public NhapKho(int maPhieuNhap, LocalDate ngayNhap, int maHang, int soLuongNhap, BigDecimal giaNhap, int maNCC) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
        this.giaNhap = giaNhap;
        this.maNCC = maNCC; // Sửa lại kiểu dữ liệu cho maNCC là int
    }

    // Getter and Setter
    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }
}
