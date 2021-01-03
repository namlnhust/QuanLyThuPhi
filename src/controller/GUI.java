package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    static Stage window;
    static Parent root0;
    static Scene scene0;
    static Parent appRoot;
    static Scene appScene;

    public GUI() {
    };

    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            window.setTitle("Quản lý khoản thu");
            root0 = FXMLLoader.load(this.getClass().getResource("/view/GUILogin.fxml"));
            scene0 = new Scene(root0);
            window.setScene(scene0);
            window.show();
            appRoot = FXMLLoader.load(this.getClass().getResource("/view/GUI0.fxml"));
            appScene = new Scene(appRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
