package model;

import java.time.LocalDate;

public class KhoanPhi implements Comparable<KhoanPhi> {
    private String maPhi;
    private String tenPhi;
    private String loaiPhi;
    private Integer soTienCanThu;
    private Integer soHoDaNop;
    private Integer soHoConThieu;
    private Integer tongSoTienDaThu;
    private Integer soTienConThieu;
    private LocalDate ngayTao;
    private LocalDate hanNop;
    private LocalDate capNhatLanCuoi;

    public KhoanPhi(String maPhi, String tenPhi, String loaiPhi, Integer soTienCanThu, Integer soHoDaNop, Integer soHoConThieu, Integer tongSoTienCanThu, Integer soTienConThieu, LocalDate ngayTao, LocalDate hanNop, LocalDate capNhatLanCuoi) {
        this.maPhi = maPhi;
        this.tenPhi = tenPhi;
        this.loaiPhi = loaiPhi;
        this.soTienCanThu = soTienCanThu;
        this.soHoDaNop = soHoDaNop;
        this.soHoConThieu = soHoConThieu;
        this.tongSoTienDaThu = tongSoTienCanThu;
        this.soTienConThieu = soTienConThieu;
        this.ngayTao = ngayTao;
        this.hanNop = hanNop;
        this.capNhatLanCuoi = capNhatLanCuoi;
    }

    public KhoanPhi() {
    }

    public String getMaPhi() {
        return maPhi;
    }

    public void setMaPhi(String maPhi) {
        this.maPhi = maPhi;
    }

    public String getTenPhi() {
        return tenPhi;
    }

    public void setTenPhi(String tenPhi) {
        this.tenPhi = tenPhi;
    }

    public String getLoaiPhi() {
        return loaiPhi;
    }

    public void setLoaiPhi(String loaiPhi) {
        this.loaiPhi = loaiPhi;
    }


    public Integer getSoTienCanThu() {
        return soTienCanThu;
    }

    public void setSoTienCanThu(Integer soTienCanThu) {
        this.soTienCanThu = soTienCanThu;
    }

    public Integer getSoHoDaNop() {
        return soHoDaNop;
    }

    public void setSoHoDaNop(Integer soHoDaNop) {
        this.soHoDaNop = soHoDaNop;
    }

    public Integer getSoHoConThieu() {
        return soHoConThieu;
    }

    public void setSoHoConThieu(Integer soHoConThieu) {
        this.soHoConThieu = soHoConThieu;
    }

    public Integer getTongSoTienDaThu() {
        return tongSoTienDaThu;
    }

    public void setTongSoTienDaThu(Integer tongSoTienDaThu) {
        this.tongSoTienDaThu = tongSoTienDaThu;
    }

    public Integer getSoTienConThieu() {
        return soTienConThieu;
    }

    public void setSoTienConThieu(Integer soTienConThieu) {
        this.soTienConThieu = soTienConThieu;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDate getHanNop() {
        return hanNop;
    }

    public void setHanNop(LocalDate hanNop) {
        this.hanNop = hanNop;
    }

    public LocalDate getCapNhatLanCuoi() {
        return capNhatLanCuoi;
    }

    public void setCapNhatLanCuoi(LocalDate capNhatLanCuoi) {
        this.capNhatLanCuoi = capNhatLanCuoi;
    }

    @Override
    public int compareTo(KhoanPhi b) {
        return this.getMaPhi().compareTo(b.getMaPhi());
    }
}
