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
	private QuanLyThuPhiHoGiaDinh quanLyThuPhiHoGiaDinh = new QuanLyThuPhiHoGiaDinh();
	private ArrayList<HoGiaDinh> hoGiaDinhList = new ArrayList<>();
	private ArrayList<ThuPhiHoGiaDinh> thuPhiHoGiaDinhList = new ArrayList<>();

	public QuanLyKhoanPhi() {
		this.cnn = this.dbConnection.getConnection();
	}

	public ArrayList<KhoanPhi> selectKhoanPhi() throws SQLException {
		Statement stm = this.cnn.createStatement();
		String selQuery = "SELECT * FROM KhoanPhi";
		ResultSet selSet = stm.executeQuery(selQuery);
		ArrayList<KhoanPhi> selKhoanPhiList = new ArrayList<>();
		hoGiaDinhList = quanLyHoGiaDinh.selectHoGiaDinh();
		thuPhiHoGiaDinhList = quanLyThuPhiHoGiaDinh.selectThuPhiHoGiaDinh();
		while (selSet.next()) {
			String maPhi = selSet.getString("Ma_Phi");
			String tenPhi = selSet.getString("Ten_Phi");
			String loaiPhi = selSet.getString("Loai_Phi");
			Integer soTienCanThu = selSet.getInt("So_tien_can_thu");
			int soHoDaNop = 0, soHoConThieu = hoGiaDinhList.size(), tongSoTienDaThu = 0, soTienConThieu = 0;
			int n1 = thuPhiHoGiaDinhList.size();
			System.out.println(n1);
			for (int i = 0; i < n1; i++) {
				ThuPhiHoGiaDinh tp = thuPhiHoGiaDinhList.get(i);
				if (tp.getMaPhi().equals(maPhi)) {
					tongSoTienDaThu += tp.getSoTienDaNop();
					if (tp.getSoTienConThieu() == 0 && tp.getSoTienDaNop() > 0) {
						soHoDaNop++;
						soHoConThieu--;
					}
				}
			}
			System.out.println(tongSoTienDaThu);
			soTienConThieu = hoGiaDinhList.size() * soTienCanThu - tongSoTienDaThu;
			System.out.println(soTienConThieu);
			LocalDate ngayTao = selSet.getDate("Ngay_khoi_tao").toLocalDate();
			LocalDate hanNop = selSet.getDate("Han_nop").toLocalDate();
			LocalDate capNhatLanCuoi = LocalDate.now();
			KhoanPhi b = new KhoanPhi(maPhi, tenPhi, loaiPhi, soTienCanThu, soHoDaNop, soHoConThieu, tongSoTienDaThu,
					soTienConThieu, ngayTao, hanNop, capNhatLanCuoi);
			selKhoanPhiList.add(b);
		}
		return selKhoanPhiList;
	}

	// Insert into table KhoanPhi tmp, return true/false
	// Try catch
	public boolean addKhoanPhi(KhoanPhi tmp) {
		try {
			Statement stm = this.cnn.createStatement();
			String selQuery = "insert into KhoanPhi values('" + tmp.getMaPhi() + "', N'" + tmp.getTenPhi() + "', '"
					+ tmp.getLoaiPhi() + "', " + String.valueOf(tmp.getSoTienCanThu()) + ", '" + tmp.getNgayTao()
					+ "', '" + tmp.getHanNop() + "') ";
			stm.execute(selQuery);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// Delete KhoanPhi tmp WHERE MaPhi=tmp.getMaPhi(), return true/false
	// Try catch
	public boolean deleteKhoanPhi(KhoanPhi tmp) {
		try {
			Statement stm = this.cnn.createStatement();
			String selQuery = "delete from KhoanPhi where Ma_Phi='" + tmp.getMaPhi() + "'";
			stm.execute(selQuery);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean updateKhoanPhi(KhoanPhi tmp) {
		try {
			Statement stm = this.cnn.createStatement();
			String selQuery = "update KhoanPhi set Ten_Phi=N'" + tmp.getTenPhi() + "', Loai_Phi='" + tmp.getLoaiPhi()
					+ "', So_tien_can_thu= " + String.valueOf(tmp.getSoTienCanThu()) + ", Ngay_khoi_tao='"
					+ tmp.getNgayTao() + "', Han_nop='" + tmp.getHanNop() + "' where Ma_Phi='" + tmp.getMaPhi() + "'";
			stm.execute(selQuery);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}