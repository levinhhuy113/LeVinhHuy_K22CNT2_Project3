package model;

public class HangHoa {
    private int maHang;
    private String tenHang;
    private String loaiHang;
    private String donViTinh;
    private int soLuongTon;
    private String hinhAnh;
    private int maNCC;

    // Constructor
    public HangHoa(int maHang, String tenHang, String loaiHang, String donViTinh, int soLuongTon, String hinhAnh, int maNCC) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.donViTinh = donViTinh;
        this.soLuongTon = soLuongTon;
        this.hinhAnh = hinhAnh;
        this.maNCC = maNCC;
    }

    // Getters và Setters
    public int getMaHang() { return maHang; }
    public void setMaHang(int maHang) { this.maHang = maHang; }

    public String getTenHang() { return tenHang; }
    public void setTenHang(String tenHang) { this.tenHang = tenHang; }

    public String getLoaiHang() { return loaiHang; }
    public void setLoaiHang(String loaiHang) { this.loaiHang = loaiHang; }

    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { this.donViTinh = donViTinh; }

    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }

    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }

    public int getMaNCC() { return maNCC; }
    public void setMaNCC(int maNCC) { this.maNCC = maNCC; }
}
