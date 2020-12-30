package model;

import java.time.LocalDate;

public class ThuPhiHoGiaDinh {
    private String maHoGiaDinh;
    private String maPhi;
    private Integer soTienDaNop;
    private Integer soTienConThieu;
	private LocalDate ngayNop;

    public ThuPhiHoGiaDinh(String maHo, String maPhi, Integer soTienDaNop, Integer soTienConThieu, LocalDate ngayNop) {
        this.maHoGiaDinh = maHo;
        this.maPhi = maPhi;
        this.soTienDaNop = soTienDaNop;
        this.soTienConThieu = soTienConThieu;
        this.ngayNop = ngayNop;
    }

    public ThuPhiHoGiaDinh() {
    }

    public String getMaHoGiaDinh() {
        return maHoGiaDinh;
    }

    public void setMaHoGiaDinh(String maHoGiaDinh) {
        this.maHoGiaDinh = maHoGiaDinh;
    }

    public String getMaPhi() {
        return maPhi;
    }

    public void setMaPhi(String maPhi) {
        this.maPhi = maPhi;
    }

    public Integer getSoTienDaNop() {
        return soTienDaNop;
    }

    public void setSoTienDaNop(Integer soTienDaNop) {
        this.soTienDaNop = soTienDaNop;
    }

    public Integer getSoTienConThieu() {
        return soTienConThieu;
    }

    public void setSoTienConThieu(Integer soTienConThieu) {
        this.soTienConThieu = soTienConThieu;
    }
    
    public LocalDate getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(LocalDate ngayNop) {
        this.ngayNop = ngayNop;
    }
}
