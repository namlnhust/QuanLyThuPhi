package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLyHoGiaDinh {
    private DBConnection dbConnection = new DBConnection();
    public Connection cnn;

    public QuanLyHoGiaDinh() {
        this.cnn = this.dbConnection.getConnection();
    }

    public ArrayList<HoGiaDinh> selectHoGiaDinh() throws SQLException {
        Statement stm = this.cnn.createStatement();
        String selQuery = "SELECT * FROM ho_gia_dinh";
        ResultSet selSet = stm.executeQuery(selQuery);
        ArrayList selHoGiaDinhList = new ArrayList();
        while (selSet.next()) {
            String maHoGiaDinh = selSet.getString("Ma_ho");
            String tenChuHo = selSet.getString("Ten_chu_ho");
            String diaChi = selSet.getString("Dia_chi");
            String soDienThoai = selSet.getString("Dien_thoai");
            Integer soNhanKhau = selSet.getInt("So_nhan_khau");
            HoGiaDinh b = new HoGiaDinh(maHoGiaDinh, tenChuHo, diaChi, soDienThoai, soNhanKhau);
            selHoGiaDinhList.add(b);
        }
        return selHoGiaDinhList;
    }
}
