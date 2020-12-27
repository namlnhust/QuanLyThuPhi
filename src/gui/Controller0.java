package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Controller0 implements Initializable {
    @FXML
    private TableView<KhoanPhi> tableViewKhoanPhi = new TableView();
    @FXML
    private TableView<HoGiaDinh> tableViewHoGiaDinh = new TableView();
    @FXML
    private TableView<ThuPhiHoGiaDinh> tableViewThuPhiHoGiaDinh = new TableView();

    @FXML
    private TableColumn<KhoanPhi, String> maPhi = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> tenPhi = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> loaiPhi = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soTienCanThu = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soHoDaNop = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soHoConThieu = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> tongSoTienDaThu = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soTienConThieu = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, LocalDate> ngayTao = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, LocalDate> hanNop = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, LocalDate> capNhatLanCuoi = new TableColumn();

    @FXML
    private TableColumn<KhoanPhi, String> maHoGiaDinh = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> tenChuHo = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> diaChi = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> soDienThoai = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soNhanKhau = new TableColumn();

    @FXML
    private TableColumn<KhoanPhi, String> maHoGiaDinh1 = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, String> maPhi1 = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soTienDaNop1 = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, Integer> soTienConThieu1 = new TableColumn();
    @FXML
    private TableColumn<KhoanPhi, LocalDate> ngayNop1 = new TableColumn();

    @FXML
    private TextField txfMaPhi = new TextField();
    @FXML
    private TextField txfTenPhi = new TextField();
    @FXML
    private TextField txfSoTienCanThu = new TextField();
    @FXML
    private TextField txfLoaiPhi = new TextField();
    @FXML
    private TextField khoanPhiKeyword = new TextField();
    @FXML
    private DatePicker dpkHanNop = new DatePicker();

    @FXML
    private TextField txfMaHoGiaDinh = new TextField();
    @FXML
    private TextField txfTenHoGiaDinh = new TextField();
    @FXML
    private TextField txfDiaChi = new TextField();
    @FXML
    private TextField txfSoDienThoai = new TextField();
    @FXML
    private TextField txfSoNhanKhau = new TextField();
    @FXML
    private TextField hoGiaDinhKeyword = new TextField();

    @FXML
    private TextField txfMaHoGiaDinh1 = new TextField();
    @FXML
    private TextField txfMaPhi1 = new TextField();
    @FXML
    private TextField txfSoTienDaNop1 = new TextField();
    @FXML
    private TextField thuPhiHoGiaDinhKeyword = new TextField();
    @FXML
    private DatePicker dpkNgayNop1 = new DatePicker();

    public Controller0() {
    }

    void setAlert(String mess) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(mess);
        alert.showAndWait();
    }

    boolean setConfirm(String mess) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText(null);
        alert.setContentText(mess);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            return true;
        else
            return false;
    }

    private ArrayList<KhoanPhi> danhSachKhoanPhi;
    private ObservableList<KhoanPhi> khoanPhiList = FXCollections.observableArrayList();
    private QuanLyKhoanPhi quanLyKhoanPhi = new QuanLyKhoanPhi();
    private KhoanPhi khoanPhiChinh = new KhoanPhi();
    private ArrayList<KhoanPhi> khoanPhiSearchList = new ArrayList<>();

    private ArrayList<HoGiaDinh> danhSachHoGiaDinh;
    private ObservableList<HoGiaDinh> hoGiaDinhList = FXCollections.observableArrayList();
    private QuanLyHoGiaDinh quanLyHoGiaDinh = new QuanLyHoGiaDinh();
    private HoGiaDinh hoGiaDinhChinh = new HoGiaDinh();
    private ArrayList<HoGiaDinh> hoGiaDinhSearchList = new ArrayList<>();

    private ArrayList<ThuPhiHoGiaDinh> danhSachThuPhiHoGiaDinh;
    private ObservableList<ThuPhiHoGiaDinh> thuPhiHoGiaDinhList = FXCollections.observableArrayList();
    private QuanLyThuPhiHoGiaDinh quanLyThuPhiHoGiaDinh = new QuanLyThuPhiHoGiaDinh();
    private ThuPhiHoGiaDinh thuPhiHoGiaDinhChinh = new ThuPhiHoGiaDinh();
    private ArrayList<ThuPhiHoGiaDinh> thuPhiHoGiaDinhSearchList = new ArrayList<>();

    KhoanPhi getKhoanPhi() {
        String ma_phi = txfMaPhi.getText();
        String ten_phi = txfTenPhi.getText();
        String loai_phi = txfLoaiPhi.getText();
        Integer so_tien_can_thu = Integer.parseInt(txfSoTienCanThu.getText());
        LocalDate han_nop = dpkHanNop.getValue();
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int n1 = thuPhiHoGiaDinhList.size();
        for (int i = 0; i < n1; i++) {
            ThuPhiHoGiaDinh tp = thuPhiHoGiaDinhList.get(i);
            if (tp.getMaPhi().equals(ma_phi)) {
                count3 += tp.getSoTienDaNop();
                count4 += tp.getSoTienConThieu();
                if (tp.getSoTienConThieu() == 0 && tp.getSoTienDaNop() > 0) count1++;
                if (tp.getSoTienConThieu() > 0) count2++;
                break;
            }
        }
        KhoanPhi tmp = new KhoanPhi(ma_phi, ten_phi, loai_phi, so_tien_can_thu, count1, count2, count3, count4, LocalDate.now(), han_nop, LocalDate.now());
        updateKhoanPhiTable();
        return tmp;
    }

    public void searchKhoanPhi() {
        khoanPhiSearchList.clear();
        String keyword = khoanPhiKeyword.getText();
        for (int i = 0; i < khoanPhiList.size(); i++) {
            KhoanPhi tmp = khoanPhiList.get(i);
            if (tmp.getMaPhi().contains(keyword) || tmp.getTenPhi().contains(keyword)
                    || tmp.getLoaiPhi().contains(keyword))
                khoanPhiSearchList.add(tmp);
        }
        if (khoanPhiSearchList.isEmpty())
            (new Controller0()).setAlert("Không tìm thấy kết quả nào!");
        tableViewKhoanPhi.setItems(FXCollections.observableList(khoanPhiSearchList));
        khoanPhiKeyword.setText("");
    }

    public void themKhoanPhi() {
        KhoanPhi tmp = getKhoanPhi();
        if (quanLyKhoanPhi.addKhoanPhi(tmp)) {
            khoanPhiList.add(tmp);
            updateKhoanPhiTable();
            clearKhoanPhiInfo();
            (new Controller0()).setAlert("Thêm thành công!");
        } else
            (new Controller0()).setAlert("Thêm thất bại! Mời kiểm tra lại dữ liệu!");
    }

    public void deleteKhoanPhi() {
        boolean choice = (new Controller0()).setConfirm("Bạn có chắc chắn muốn xóa không?");
        if (choice) {
            if (quanLyKhoanPhi.deleteKhoanPhi(khoanPhiChinh)) {
                for (int i = 0; i < khoanPhiList.size(); i++) {
                    if (khoanPhiList.get(i).getMaPhi().equals(khoanPhiChinh.getMaPhi()))
                        khoanPhiList.remove(i);
                }
                updateKhoanPhiTable();
                clearKhoanPhiInfo();
                (new Controller0()).setAlert("Xóa thành công!");
            } else
                (new Controller0()).setAlert("Xóa thất bại! Mời kiểm tra lại!");
        }
    }

    public void updateKhoanPhi() {
        KhoanPhi tmp = getKhoanPhi();
        if (quanLyKhoanPhi.updateKhoanPhi(tmp)) {
            int i = 0;
            while (!khoanPhiList.get(i).getMaPhi().equals(tmp.getMaPhi()))
                i++;
            khoanPhiList.set(i, tmp);
            clearKhoanPhiInfo();
            (new Controller0()).setAlert("Sửa thành công!");
        } else
            (new Controller0()).setAlert("Sửa thất bại");
    }

    void clearKhoanPhiInfo() {
        txfMaPhi.setText("");
        txfTenPhi.setText("");
        txfSoTienCanThu.setText("");
        txfLoaiPhi.setText("");
        dpkHanNop.setValue(null);
        updateKhoanPhiTable();
    }

    public void cancelKhoanPhi() {
        clearKhoanPhiInfo();
    }

    public HoGiaDinh getHoGiaDinh() {
        String ma_ho_gia_dinh = txfMaHoGiaDinh.getText();
        String ten_chu_ho = txfTenHoGiaDinh.getText();
        String dia_chi = txfDiaChi.getText();
        String so_dien_thoai = txfSoDienThoai.getText();
        Integer so_nhan_khau = Integer.parseInt(txfSoNhanKhau.getText());
        HoGiaDinh tmp = new HoGiaDinh(ma_ho_gia_dinh, ten_chu_ho, dia_chi, so_dien_thoai, so_nhan_khau);
        return tmp;
    }

    public void searchHoGiaDinh() {
        hoGiaDinhSearchList.clear();
        String keyword = hoGiaDinhKeyword.getText();
        for (int i = 0; i < hoGiaDinhList.size(); i++) {
            HoGiaDinh tmp = hoGiaDinhList.get(i);
            if (tmp.getMaHoGiaDinh().contains(keyword) || tmp.getTenChuHo().contains(keyword)
                    || tmp.getDiaChi().contains(keyword) || tmp.getSoDienThoai().contains(keyword))
                hoGiaDinhSearchList.add(tmp);
        }
        if (hoGiaDinhSearchList.isEmpty())
            (new Controller0()).setAlert("Không tìm thấy kết quả nào!");
        tableViewHoGiaDinh.setItems(FXCollections.observableList(hoGiaDinhSearchList));
        hoGiaDinhKeyword.setText("");
    }

    public void themHoGiaDinh() {
        HoGiaDinh tmp = getHoGiaDinh();
        if (quanLyHoGiaDinh.addHoGiaDinh(tmp)) {
            hoGiaDinhList.add(tmp);
            updateHoGiaDinhTable();
            clearHoGiaDinhInfo();
            (new Controller0()).setAlert("Thêm thành công!");
        } else
            (new Controller0()).setAlert("Thêm thất bại! Mời kiểm tra lại dữ liệu!");
    }

    public void deleteHoGiaDinh() {
        boolean choice = (new Controller0()).setConfirm("Bạn có chắc chắn muốn xóa không?");
        if (choice) {
            if (quanLyHoGiaDinh.deleteHoGiaDinh(hoGiaDinhChinh)) {
                for (int i = 0; i < hoGiaDinhList.size(); i++) {
                    if (hoGiaDinhList.get(i).getMaHoGiaDinh().equals(hoGiaDinhChinh.getMaHoGiaDinh()))
                        hoGiaDinhList.remove(i);
                }
                updateHoGiaDinhTable();
                clearHoGiaDinhInfo();
                (new Controller0()).setAlert("Xóa thành công!");
            } else
                (new Controller0()).setAlert("Xóa thất bại! Mời kiểm tra lại!");
        }
    }

    public void updateHoGiaDinh() {
        HoGiaDinh tmp = getHoGiaDinh();
        if (quanLyHoGiaDinh.updateHoGiaDinh(tmp)) {
            int i = 0;
            while (!hoGiaDinhList.get(i).getMaHoGiaDinh().equals(tmp.getMaHoGiaDinh()))
                i++;
            hoGiaDinhList.set(i, tmp);
            clearHoGiaDinhInfo();
            (new Controller0()).setAlert("Sửa thành công!");
        } else
            (new Controller0()).setAlert("Sửa thất bại");
    }

    void clearHoGiaDinhInfo() {
        txfMaHoGiaDinh.setText("");
        txfTenHoGiaDinh.setText("");
        txfDiaChi.setText("");
        txfSoDienThoai.setText("");
        txfSoNhanKhau.setText("");
        updateHoGiaDinhTable();
    }

    public void cancelHoGiaDinh() {
        clearKhoanPhiInfo();
    }

    public ThuPhiHoGiaDinh getThuPhiHoGiaDinh() {

//        String ma_ho_1 = txfMaHoGiaDinh1.getText();
//        String ma_phi_1 = txfMaPhi1.getText();
//        Integer so_tien_da_nop = Integer.parseInt(txfSoTienDaNop1.getText());
//        Integer so_tien_con_thieu =
        ThuPhiHoGiaDinh tmp = new ThuPhiHoGiaDinh();
        return tmp;
    }

    public void searchThuPhiHoGiaDinh() {
        thuPhiHoGiaDinhSearchList.clear();
        String keyword = thuPhiHoGiaDinhKeyword.getText();
        for (int i = 0; i < thuPhiHoGiaDinhList.size(); i++) {
            ThuPhiHoGiaDinh tmp = thuPhiHoGiaDinhList.get(i);
            if (tmp.getMaHoGiaDinh().contains(keyword) || tmp.getMaPhi().contains(keyword))
                thuPhiHoGiaDinhSearchList.add(tmp);
        }
        if (thuPhiHoGiaDinhSearchList.isEmpty())
            (new Controller0()).setAlert("Không tìm thấy kết quả nào!");
        tableViewThuPhiHoGiaDinh.setItems(FXCollections.observableList(thuPhiHoGiaDinhSearchList));
        thuPhiHoGiaDinhKeyword.setText("");
    }

    public void themThuPhiHoGiaDinh() {
        ThuPhiHoGiaDinh tmp = getThuPhiHoGiaDinh();
        if (quanLyThuPhiHoGiaDinh.addThuPhiHoGiaDinh(tmp)) {
            thuPhiHoGiaDinhList.add(tmp);
            updateThuPhiHoGiaDinhTable();
            clearThuPhiHoGiaDinhInfo();
            (new Controller0()).setAlert("Thêm thành công!");
        } else
            (new Controller0()).setAlert("Thêm thất bại! Mời kiểm tra lại dữ liệu!");
    }

    public void deleteThuPhiHoGiaDinh() {
        boolean choice = (new Controller0()).setConfirm("Bạn có chắc chắn muốn xóa không?");
        if (choice) {
            if (quanLyThuPhiHoGiaDinh.deleteThuPhiHoGiaDinh(thuPhiHoGiaDinhChinh)) {
                for (int i = 0; i < thuPhiHoGiaDinhList.size(); i++) {
                    if (thuPhiHoGiaDinhList.get(i).getMaHoGiaDinh().equals(thuPhiHoGiaDinhChinh.getMaHoGiaDinh()) &&
                        thuPhiHoGiaDinhList.get(i).getMaPhi().equals(thuPhiHoGiaDinhChinh.getMaPhi()))
                        thuPhiHoGiaDinhList.remove(i);
                }
                updateThuPhiHoGiaDinhTable();
                clearThuPhiHoGiaDinhInfo();
                (new Controller0()).setAlert("Xóa thành công!");
            } else
                (new Controller0()).setAlert("Xóa thất bại! Mời kiểm tra lại!");
        }
    }

    public void updateThuPhiHoGiaDinh() {
        ThuPhiHoGiaDinh tmp = getThuPhiHoGiaDinh();
        if (quanLyThuPhiHoGiaDinh.updateThuPhiHoGiaDinh(tmp)) {
            int i = 0;
            while (!thuPhiHoGiaDinhList.get(i).getMaHoGiaDinh().equals(tmp.getMaHoGiaDinh()) ||
                    !thuPhiHoGiaDinhList.get(i).getMaHoGiaDinh().equals(tmp.getMaHoGiaDinh()))
                i++;
            thuPhiHoGiaDinhList.set(i, tmp);
            clearThuPhiHoGiaDinhInfo();
            (new Controller0()).setAlert("Sửa thành công!");
        } else
            (new Controller0()).setAlert("Sửa thất bại");
    }

    void clearThuPhiHoGiaDinhInfo() {
        txfMaHoGiaDinh1.setText("");
        txfMaPhi1.setText("");
        txfSoTienDaNop1.setText("");
        dpkNgayNop1.setValue(null);
        updateHoGiaDinhTable();
    }

    public void cancelThuPhiHoGiaDinh() {
        clearThuPhiHoGiaDinhInfo();
    }

    public void getSelectedKhoanPhi() {
        tableViewKhoanPhi.setOnMouseClicked(e -> {
            khoanPhiChinh = tableViewKhoanPhi.getSelectionModel().getSelectedItem();
            txfMaPhi.setText(khoanPhiChinh.getMaPhi());
            txfTenPhi.setText(khoanPhiChinh.getTenPhi());
            txfSoTienCanThu.setText(String.valueOf(khoanPhiChinh.getSoTienCanThu()));
            dpkHanNop.setValue(khoanPhiChinh.getHanNop());
            txfLoaiPhi.setText(khoanPhiChinh.getLoaiPhi());
        });
    }

    public void getSelectedHoGiaDinh() {
        tableViewHoGiaDinh.setOnMouseClicked(e -> {
            hoGiaDinhChinh = tableViewHoGiaDinh.getSelectionModel().getSelectedItem();
            txfMaHoGiaDinh.setText(hoGiaDinhChinh.getMaHoGiaDinh());
            txfTenHoGiaDinh.setText(hoGiaDinhChinh.getTenChuHo());
            txfDiaChi.setText(hoGiaDinhChinh.getDiaChi());
            txfSoDienThoai.setText(hoGiaDinhChinh.getSoDienThoai());
            txfSoNhanKhau.setText(String.valueOf(hoGiaDinhChinh.getSoNhanKhau()));
        });
    }

    public void getSelectedThuPhiHoGiaDinh() {
        tableViewThuPhiHoGiaDinh.setOnMouseClicked(e -> {
            ThuPhiHoGiaDinh ThuPhiHoGiaDinhChinh = tableViewThuPhiHoGiaDinh.getSelectionModel().getSelectedItem();
            txfMaHoGiaDinh1.setText(ThuPhiHoGiaDinhChinh.getMaHoGiaDinh());
            txfMaPhi1.setText(ThuPhiHoGiaDinhChinh.getMaPhi());
            txfSoTienDaNop1.setText(String.valueOf(ThuPhiHoGiaDinhChinh.getSoTienDaNop()));
            dpkNgayNop1.setValue(ThuPhiHoGiaDinhChinh.getNgayNop());
        });
    }

    void updateKhoanPhiTable() {
        Collections.sort(khoanPhiList);
        maPhi.setCellValueFactory(new PropertyValueFactory("maPhi"));
        tenPhi.setCellValueFactory(new PropertyValueFactory("tenPhi"));
        loaiPhi.setCellValueFactory(new PropertyValueFactory("loaiPhi"));
        soTienCanThu.setCellValueFactory(new PropertyValueFactory("soTienCanThu"));
        soHoDaNop.setCellValueFactory(new PropertyValueFactory("soHoDaNop"));
        soHoConThieu.setCellValueFactory(new PropertyValueFactory("soHoConThieu"));
        tongSoTienDaThu.setCellValueFactory(new PropertyValueFactory("tongSoTienDaThu"));
        soTienConThieu.setCellValueFactory(new PropertyValueFactory("soTienConThieu"));
        ngayTao.setCellValueFactory(new PropertyValueFactory("ngayTao"));
        hanNop.setCellValueFactory(new PropertyValueFactory("hanNop"));
        capNhatLanCuoi.setCellValueFactory(new PropertyValueFactory("capNhatLanCuoi"));
        tableViewKhoanPhi.setItems(this.khoanPhiList);
    }

    void updateHoGiaDinhTable() {
        Collections.sort(hoGiaDinhList);
        maHoGiaDinh.setCellValueFactory(new PropertyValueFactory("maHoGiaDinh"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory("tenChuHo"));
        diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
        soDienThoai.setCellValueFactory(new PropertyValueFactory("soDienThoai"));
        soNhanKhau.setCellValueFactory(new PropertyValueFactory("soNhanKhau"));
        tableViewHoGiaDinh.setItems(this.hoGiaDinhList);
    }

    void updateThuPhiHoGiaDinhTable() {
        maHoGiaDinh1.setCellValueFactory(new PropertyValueFactory("maHoGiaDinh"));
        maPhi1.setCellValueFactory(new PropertyValueFactory("maPhi"));
        soTienDaNop1.setCellValueFactory(new PropertyValueFactory("soTienDaNop"));
        soTienConThieu1.setCellValueFactory(new PropertyValueFactory("soTienConThieu"));
        ngayNop1.setCellValueFactory(new PropertyValueFactory("ngayNop"));
        tableViewThuPhiHoGiaDinh.setItems(this.thuPhiHoGiaDinhList);
    }

    public void initialize(URL location, ResourceBundle resources) {
        Iterator var3;
        try {
            danhSachKhoanPhi = quanLyKhoanPhi.selectKhoanPhi();
            var3 = danhSachKhoanPhi.iterator();
            while (var3.hasNext()) {
                KhoanPhi b = (KhoanPhi) var3.next();
                khoanPhiList.add(b);
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
        updateKhoanPhiTable();
        getSelectedKhoanPhi();

        Iterator var4;
        try {
            danhSachHoGiaDinh = quanLyHoGiaDinh.selectHoGiaDinh();
            var4 = danhSachHoGiaDinh.iterator();
            while (var4.hasNext()) {
                HoGiaDinh b = (HoGiaDinh) var4.next();
                hoGiaDinhList.add(b);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }
        updateHoGiaDinhTable();
        getSelectedHoGiaDinh();

        Iterator var5;
        try {
            danhSachThuPhiHoGiaDinh = quanLyThuPhiHoGiaDinh.selectThuPhiHoGiaDinh();
            var5 = danhSachThuPhiHoGiaDinh.iterator();
            while (var5.hasNext()) {
                ThuPhiHoGiaDinh b = (ThuPhiHoGiaDinh) var5.next();
                thuPhiHoGiaDinhList.add(b);
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        }
        updateThuPhiHoGiaDinhTable();
        getSelectedThuPhiHoGiaDinh();
    }
}
