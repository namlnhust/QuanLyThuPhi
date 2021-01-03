package controller;

import model.HoGiaDinh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLyHoGiaDinh {
    public DBConnection dbConnection = new DBConnection();
    public Connection cnn;

    public QuanLyHoGiaDinh() {
        this.cnn = this.dbConnection.getConnection();
    }

    public ArrayList<HoGiaDinh> selectHoGiaDinh() throws SQLException {
        Statement stm = this.cnn.createStatement();
        String selQuery = "SELECT * FROM ho_gia_dinh";
        ResultSet selSet = stm.executeQuery(selQuery);
        ArrayList<HoGiaDinh> selHoGiaDinhList = new ArrayList<HoGiaDinh>();
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

    public boolean addHoGiaDinh(HoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "insert into ho_gia_dinh values('" + tmp.getMaHoGiaDinh() + "', N'" + tmp.getTenChuHo() + "', N'"
                    + tmp.getDiaChi() + "', '" + tmp.getSoDienThoai() + "', " + tmp.getSoNhanKhau() + ") ";
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean deleteHoGiaDinh(HoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "delete from ho_gia_dinh where Ma_ho='" + tmp.getMaHoGiaDinh() + "'";
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean updateHoGiaDinh(HoGiaDinh tmp) {
        try {
            Statement stm = this.cnn.createStatement();
            String selQuery = "update ho_gia_dinh set Ma_ho='" + tmp.getMaHoGiaDinh() + "', Ten_chu_ho=N'" + tmp.getTenChuHo() + "', Dia_chi=N'"
                    + tmp.getDiaChi() + "', Dien_thoai='" + tmp.getSoDienThoai() + "', So_nhan_khau=" + tmp.getSoNhanKhau() + " where Ma_ho='" + tmp.getMaHoGiaDinh() + "'";
            System.out.println(selQuery);
            stm.execute(selQuery);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    
    public HoGiaDinh getHoGiaDinh(String Ma_ho) {
		HoGiaDinh hgd= new HoGiaDinh();
		try {
			Statement stm = this.cnn.createStatement();
			String selQuery = "select * from ho_gia_dinh where Ma_ho='"+Ma_ho+"'";
			ResultSet rs= stm.executeQuery(selQuery);
			while (rs.next()) {
				hgd.setMaHoGiaDinh(rs.getString("Ma_ho"));
				hgd.setTenChuHo(rs.getString("Ten_chu_ho"));
				hgd.setDiaChi(rs.getString("Dia_chi"));
				hgd.setSoDienThoai(rs.getString("Dien_thoai"));
				hgd.setSoNhanKhau(rs.getInt("So_nhan_khau"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hgd;
	}

}
