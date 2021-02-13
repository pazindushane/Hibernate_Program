package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.royal_institute.bo.BOFactory;
import lk.ijse.royal_institute.bo.BOType;
import lk.ijse.royal_institute.bo.custom.impl.UserBOimpl;
import lk.ijse.royal_institute.dto.UserDTO;

import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pazindu Shane On 2/7/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class loginController {

    public JFXButton LoginBtn;
    public JFXButton Signbtn1;
    public JFXButton closeBtn;
    public ImageView imgOpenEye;
    public ImageView imgCloseEye;
    public JFXPasswordField txtPassword;
    public JFXTextField txtShowPw;
    public static UserDTO user;
    public JFXTextField txtUsername;

    UserBOimpl userBOimpl = BOFactory.getInstance().getBO(BOType.USER);


    public void initialize() {
        imgOpenEye.setVisible(false);
        txtShowPw.setVisible(false);
    }

    public boolean checkRegEx(String pattern, String text) {
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(text);
        return matcher.matches();
    }

    public void CloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void SignOnAction1(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/SignIn.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) Signbtn1.getScene().getWindow();
        primaryStage.close();

    }

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {

        if (txtUsername.getText().length() > 0 && txtPassword.getText().length() > 0) {
            if (checkRegEx("^[A-z0-9]{1,}$", txtUsername.getText())) {
                if (checkRegEx("^[A-z0-9]{1,}$", txtPassword.getText())) {
                    login();
                }else {
                    txtPassword.setFocusColor(Paint.valueOf("red"));
                    txtPassword.requestFocus();
                }
            }else {
                txtUsername.setFocusColor(Paint.valueOf("red"));
                txtUsername.requestFocus();
            }

        } else {
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid Username or Password").showAndWait();
        }

//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Dashboard.fxml"))));
//        stage.setResizable(false);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.show();
//
//        Stage primaryStage= (Stage) LoginBtn.getScene().getWindow();
//        primaryStage.close();
    }

    public void Showpassword(MouseEvent mouseEvent) {
        imgCloseEye.setVisible(false);
        imgOpenEye.setVisible(true);
        txtPassword.setVisible(false);
        txtShowPw.setVisible(true);
        txtShowPw.setText(txtPassword.getText());
    }

    public void hidepassword(MouseEvent mouseEvent) {
        imgCloseEye.setVisible(true);
        imgOpenEye.setVisible(false);
        txtPassword.setVisible(true);
        txtShowPw.setVisible(false);
    }

    private void login() {
        try {

            user = userBOimpl.getUserDetails(txtUsername.getText(), txtPassword.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Dashboard.fxml"))));
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

            Stage primaryStage= (Stage) LoginBtn.getScene().getWindow();
            primaryStage.close();

        } catch (Exception e) {
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid").showAndWait();
        }
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
//        if (checkRegEx("^[A-z0-9]{1,}$", txtPassword.getText())) {
//            txtUsername.requestFocus();
//        }else {
//            txtPassword.setFocusColor(Paint.valueOf("red"));
//            txtUsername.requestFocus();
//        }
    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {
//        if (checkRegEx("^[A-z0-9]{1,}$", txtUsername.getText())) {
//            txtPassword.requestFocus();
//        }else {
//
//            txtUsername.setFocusColor(Paint.valueOf("red"));
//            txtUsername.requestFocus();
//        }
    }

}
