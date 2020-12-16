package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLyKhoanPhi {
    private DBConnection dbConnection = new DBConnection();
    public Connection cnn;
    private QuanLyHoGiaDinh quanLyHoGiaDinh = new QuanLyHoGiaDinh();
    private ArrayList<HoGiaDinh> hoGiaDinhList = new ArrayList();

    public QuanLyKhoanPhi() {
        this.cnn = this.dbConnection.getConnection();
    }

    public ArrayList<KhoanPhi> selectKhoanPhi() throws SQLException {
        Statement stm = this.cnn.createStatement();
        String selQuery = "SELECT * FROM KhoanPhi";
        ResultSet selSet = stm.executeQuery(selQuery);
        ArrayList selKhoanPhiList = new ArrayList();
        hoGiaDinhList = quanLyHoGiaDinh.selectHoGiaDinh();
        int tongSoHoGiaDinh = hoGiaDinhList.size();
        while (selSet.next()) {
            String maPhi = selSet.getString("Ma_Phi");
            String tenPhi = selSet.getString("Ten_Phi");
            String loaiPhi = selSet.getString("Loai_Phi");
            Integer soTienCanThu = selSet.getInt("So_tien_can_thu");
            Integer soHoDaNop = 321;
            Integer soHoConThieu = 123;
            Integer tongSoTienDaThu = 123456;
            Integer soTienConThieu = 654321;
            LocalDate ngayTao = selSet.getDate("Ngay_khoi_tao").toLocalDate();
            LocalDate hanNop = selSet.getDate("Han_nop").toLocalDate();
            LocalDate capNhatLanCuoi = LocalDate.now();
            KhoanPhi b = new KhoanPhi(maPhi, tenPhi, loaiPhi, soTienCanThu, soHoDaNop, soHoConThieu, tongSoTienDaThu, soTienConThieu, ngayTao, hanNop, capNhatLanCuoi);
            selKhoanPhiList.add(b);
        }
        return selKhoanPhiList;
    }
}
