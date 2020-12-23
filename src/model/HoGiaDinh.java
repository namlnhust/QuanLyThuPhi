package model;

public class HoGiaDinh implements Comparable<HoGiaDinh> {
    private String maHoGiaDinh;
    private String tenChuHo;
    private String diaChi;
    private String soDienThoai;
    private Integer soNhanKhau;

    public HoGiaDinh(String maHoGiaDinh, String tenChuHo, String diaChi, String soDienThoai, Integer soNhanKhau) {
        this.maHoGiaDinh = maHoGiaDinh;
        this.tenChuHo = tenChuHo;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.soNhanKhau = soNhanKhau;
    }

    public HoGiaDinh(){
    }

    public String getMaHoGiaDinh() {
        return maHoGiaDinh;
    }

    public void setMaHoGiaDinh(String maHoGiaDinh) {
        this.maHoGiaDinh = maHoGiaDinh;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Integer getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(Integer soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
    }

    @Override
    public int compareTo(HoGiaDinh b) {
        return this.getMaHoGiaDinh().compareTo(b.getMaHoGiaDinh());
    }
}
