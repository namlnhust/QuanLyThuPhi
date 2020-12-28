package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class GUI extends Application {
    static Stage window;
    static Parent root0;
    static Scene scene0;

    public GUI() {
    };

    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            window.setTitle("Quản lý khoản thu");
            URL url = new File("E:\\QuanLyThuPhi\\src\\gui\\GUI0.fxml").toURI().toURL();
            root0 = FXMLLoader.load(url);
            scene0 = new Scene(root0);
            window.setScene(scene0);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
