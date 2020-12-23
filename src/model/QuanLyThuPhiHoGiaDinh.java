package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLyThuPhiHoGiaDinh {
    private DBConnection dbConnection = new DBConnection();
    public Connection cnn;

    public QuanLyThuPhiHoGiaDinh() {
        this.cnn = this.dbConnection.getConnection();
    }

    public ArrayList<ThuPhiHoGiaDinh> selectThuPhiHoGiaDinh() throws SQLException {
        Statement stm = this.cnn.createStatement();
        String selQuery = "SELECT * FROM Thu_phi_ho_gia_dinh";
        ResultSet selSet = stm.executeQuery(selQuery);
        ArrayList<ThuPhiHoGiaDinh> selThuPhiHoGiaDinhList = new ArrayList<>();
        while (selSet.next()) {
            String maHoGiaDinh1 = selSet.getString("Ma_ho");
            String maPhi1 = selSet.getString("Ma_Phi");
            Integer soTienDaNop1 = selSet.getInt("So_tien_da_nop");
            Integer soTienConThieu = selSet.getInt("So_tien_con_thieu");
            LocalDate ngayNop = selSet.getDate("Ngay_nop").toLocalDate();
            ThuPhiHoGiaDinh b = new ThuPhiHoGiaDinh(maHoGiaDinh1, maPhi1, soTienDaNop1, soTienConThieu, ngayNop);
            selThuPhiHoGiaDinhList.add(b);
        }
        return selThuPhiHoGiaDinhList;
    }
}
