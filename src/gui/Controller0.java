package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;

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
    private TextField txfMaHoGiaDinh1 = new TextField();
    @FXML
    private TextField txfMaPhi1 = new TextField();
    @FXML
    private TextField txfSoTienDaNop1 = new TextField();
    @FXML
    private DatePicker dpkNgayNop1 = new DatePicker();

    public Controller0() {
    }

    private ArrayList<KhoanPhi> danhSachKhoanPhi;
    private ObservableList<KhoanPhi> khoanPhiList = FXCollections.observableArrayList();
    private QuanLyKhoanPhi quanLyKhoanPhi = new QuanLyKhoanPhi();
    private KhoanPhi khoanPhiChinh = new KhoanPhi();

    private ArrayList<HoGiaDinh> danhSachHoGiaDinh;
    private ObservableList<HoGiaDinh> hoGiaDinhList = FXCollections.observableArrayList();
    private QuanLyHoGiaDinh quanLyHoGiaDinh = new QuanLyHoGiaDinh();
    private HoGiaDinh hoGiaDinhChinh = new HoGiaDinh();

    private ArrayList<HoGiaDinh> danhSachThuPhiHoGiaDinh;
    private ObservableList<ThuPhiHoGiaDinh> thuPhiHoGiaDinhList = FXCollections.observableArrayList();
    private QuanLyThuPhiHoGiaDinh quanLyThuPhiHoGiaDinh = new QuanLyThuPhiHoGiaDinh();
    private ThuPhiHoGiaDinh ThuPhiHoGiaDinhChinh = new ThuPhiHoGiaDinh();


//    public void search() {
//        bookSearchList.clear();
//        String keyword = bookKeyword.getText();
//        for (int i = 0; i < bookList.size(); i++) {
//            Book tmp = bookList.get(i);
//            if (tmp.getMaSach().contains(keyword) || tmp.getTenSach().contains(keyword)
//                    || tmp.getTacGia().contains(keyword) || tmp.getNhaXB().contains(keyword)
//                    || String.valueOf(tmp.getNamXB()).contains(keyword)
//                    || String.valueOf(tmp.getDonGia()).contains(keyword)
//                    || tmp.getGioiThieu().contains(keyword))
//                bookSearchList.add(tmp);
//        }
//        if (bookSearchList.isEmpty()) {
//            (new Controller0()).setAlert("Không tìm thấy kết quả nào!");
//            updateBookTable();
//        } else {
//            Collections.sort(bookSearchList);
//            maSach.setCellValueFactory(new PropertyValueFactory("maSach"));
//            tenSach.setCellValueFactory(new PropertyValueFactory("tenSach"));
//            tacGia.setCellValueFactory(new PropertyValueFactory("tacGia"));
//            nhaXB.setCellValueFactory(new PropertyValueFactory("nhaXB"));
//            namXB.setCellValueFactory(new PropertyValueFactory("namXB"));
//            donGia.setCellValueFactory(new PropertyValueFactory("donGia"));
//            gioiThieu.setCellValueFactory(new PropertyValueFactory("gioiThieu"));
//            tableViewBook.setItems(this.bookSearchList);
//        }
//        bookKeyword.setText("");
//    }

//    public void themKhoanPhi() {
//        KhoanPhi tmp = getBookInfo();
//        if (bookManager.addBook(tmp)) {
//            bookList.add(tmp);
//            tableViewBook.setItems(bookList);
//            updateBookTable();
//            clearBookInfo();
//            (new Controller0()).setAlert("Thêm thành công!");
//        } else
//            (new Controller0()).setAlert("Thêm thất bại! Mời kiểm tra lại dữ liệu!");
//    }

//    public void updateBook() {
//        Book tmp = getBookInfo();
//        if (bookManager.updateBook(tmp)) {
//            int i = 0;
//            while (!bookList.get(i).getMaSach().equals(tmp.getMaSach()))
//                i++;
//            bookList.set(i, tmp);
//            updateBookTable();
//            clearBookInfo();
//            (new Controller0()).setAlert("Sửa thành công!");
//        } else
//            (new Controller0()).setAlert("Sửa thất bại");
//    }

//    public void deleteBook() {
//        boolean choice = (new Controller0()).setConfirm("Bạn có chắc chắn muốn xóa không?");
//        if (choice) {
//            if (bookManager.deleteBook(mainBook)) {
//                for (int i = 0; i < bookList.size(); i++) {
//                    if (bookList.get(i).getMaSach().equals(mainBook.getMaSach()))
//                        bookList.remove(i);
//                }
//                updateBookTable();
//                clearBookInfo();
//                (new Controller0()).setAlert("Xóa thành công!");
//            } else
//                (new Controller0()).setAlert("Xóa thất bại! Mời kiểm tra lại!");
//        }
//    }

//    public void cancelBook() {
//        clearBookInfo();
//    }

    public void getSelectedKhoanPhi() {
        tableViewKhoanPhi.setOnMouseClicked(e -> {
            khoanPhiChinh = tableViewKhoanPhi.getSelectionModel().getSelectedItem();
            txfMaPhi.setText(khoanPhiChinh.getMaPhi());
            txfTenPhi.setText(khoanPhiChinh.getTenPhi());
            txfSoTienCanThu.setText(String.valueOf(khoanPhiChinh.getSoTienCanThu()));
            dpkHanNop.setValue(khoanPhiChinh.getHanNop());
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
        maHoGiaDinh1.setCellValueFactory(new PropertyValueFactory("maHoGiaDinh1"));
        maPhi1.setCellValueFactory(new PropertyValueFactory("maPhi1"));
        soTienDaNop1.setCellValueFactory(new PropertyValueFactory("soTienDaNop1"));
        soTienConThieu1.setCellValueFactory(new PropertyValueFactory("soTienConThieu1"));
        ngayNop1.setCellValueFactory(new PropertyValueFactory("ngayNop1"));
        tableViewThuPhiHoGiaDinh.setItems(this.thuPhiHoGiaDinhList);
    }

//    KhoanPhi getKhoanPhi() {
//        String ma_phi = txfMaPhi.getText();
//        String ten_phi = txfTenPhi.getText();
//        Integer so_tien_can_thu = Integer.parseInt(txfSoTienCanThu.getText());
//        LocalDate han_nop = dpkHanNop.getValue();
//        KhoanPhi tmp = new KhoanPhi(ma_sach, ten_sach, tac_gia, nha_xuat_ban, nam_xuat_ban, don_gia, gioi_thieu);
//        updateBookTable();
//        return tmp;
//    }

//    void clearKhoanPhiInfo() {
//        txfMaPhi.setText("");
//        txfTenPhi.setText("");
//        txfSoTienCanThu.setText("");
//        dpkHanNop.setValue(LocalDate.now());
//        updateKhoanPhiTable();
//    }

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

//    public void getBookFileURL() {
//        File selectedFile = fileChooser.showOpenDialog(GUI.window);
//        bookManager.bookFileURL = selectedFile.getAbsolutePath();
//        insertBookByFile();
//    }

//    public void insertBookByFile() {
//        ArrayList<Book> insertList = bookManager.insertBookByFile();
//        boolean res = true;
//        int n = insertList.size();
//        for (int i = 0; i < n; i++) {
//            Book b = insertList.get(i);
//            res = res && bookManager.addBook(b);
//            if (res == false) {
//                (new Controller0()).setAlert("Nhập file thất bại!");
//                return;
//            }
//            bookList.add(b);
//            tableViewBook.setItems(bookList);
//            updateBookTable();
//        }
//        if (res == true)
//            (new Controller0()).setAlert("Nhập file thành công!");
//        else
//            (new Controller0()).setAlert("Nhập file thất bại!");
//    }

//    public void exportListingFile() {
//        try {
//            File bookDataFile = new File(bookManager.saverURL + "//bookData.txt");
//            FileWriter bookDataWriter = new FileWriter(bookDataFile.getAbsolutePath());
//            bookDataWriter.write("-- Thống kê các loại sách trong thư viện --\n");
//            bookDataWriter.write("Mã sách\tTên sách\tTác giả\tNhà xuất bản\tNăm xuất bản\tĐơn giá\tGiới thiệu\n");
//            int n = bookList.size();
//            for (int i = 0; i < n; i++) {
//                bookDataWriter.write(bookList.get(i).getMaSach() + "\t" + bookList.get(i).getTenSach() + "\t"
//                        + bookList.get(i).getTacGia() + "\t" + bookList.get(i).getNhaXB() + "\t"
//                        + bookList.get(i).getNamXB() + "\t" + bookList.get(i).getDonGia() + "\t"
//                        + bookList.get(i).getGioiThieu() + "\n");
//            }
//            bookDataWriter.close();
//            (new Controller0()).setAlert("Xuất dữ liệu thành công!");
//        } catch (IOException e) {
//            (new Controller0()).setAlert("Xuất dữ liệu thất bại!");
//            e.printStackTrace();
//        }
//    }

//    public void listData() {
//        boolean sel = (new Controller0()).setConfirm("Chọn nơi lưu!");
//        if (sel) {
//            File selectedDirectory = directoryChooser.showDialog(GUI.window);
//            bookManager.saverURL = selectedDirectory.getAbsolutePath();
//            exportListingFile();
//        }
//    }
}
