package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    public DBConnection dbConnection = new DBConnection();
    public Connection cnn;

    public ControllerLogin() {
        this.cnn = this.dbConnection.getConnection();
    }

    @FXML
    private TextField acc = new TextField();
    @FXML
    private PasswordField pass = new PasswordField();
    @FXML
    private Label wrong = new Label();
    @FXML
    private ImageView image = new ImageView();

    public void initialize(URL location, ResourceBundle resources) {
        wrong.setVisible(false);
    }

    public void login() {
        String acc = this.acc.getText();
        String pass = this.pass.getText();
        ResultSet resultSet;
        try {
            Statement stm = this.cnn.createStatement();
            String query = "SELECT * FROM dbo.Account";
            resultSet = stm.executeQuery(query);
            boolean authen = false;
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(acc)) {
                    if (resultSet.getString(2).equals(pass))
                        authen = true;
                }
            }
            if (authen == true) {
                showApp();
            }
            else {
                wrong.setVisible(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void showApp() {
        GUI.window.setScene(GUI.appScene);
        GUI.window.show();
    }

}
