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


    public boolean addThuPhiHoGiaDinh(ThuPhiHoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "insert into Thu_phi_ho_gia_dinh values('" + tmp.getMaHoGiaDinh() + "', '" + tmp.getMaPhi() + "', "
                    + tmp.getSoTienDaNop() + ", " + tmp.getSoTienConThieu() + ", '" + tmp.getNgayNop()
                    + "')";
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean deleteThuPhiHoGiaDinh(ThuPhiHoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "delete from Thu_phi_ho_gia_dinh where Ma_ho='"+tmp.getMaHoGiaDinh()+"' and Ma_Phi='"+tmp.getMaPhi()+"'";
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean updateThuPhiHoGiaDinh(ThuPhiHoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "update Thu_phi_ho_gia_dinh set Ma_ho='" + tmp.getMaHoGiaDinh() + "', Ma_Phi=N'" + tmp.getMaPhi() + "', So_tien_da_nop="
                    + tmp.getSoTienDaNop() + ", So_tien_con_thieu=" + tmp.getSoTienConThieu() + ", Ngay_nop='" + tmp.getNgayNop()
                    + "'";
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }


}
