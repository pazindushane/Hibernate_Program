package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.royal_institute.bo.BOFactory;
import lk.ijse.royal_institute.bo.BOType;
import lk.ijse.royal_institute.bo.custom.impl.CourseBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.UserBOimpl;
import lk.ijse.royal_institute.dto.CourseDTO;
import lk.ijse.royal_institute.dto.UserDTO;

import java.io.IOException;

/**
 * @author Pazindu Shane On 2/14/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class ResetPasswordController {
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXButton BtnReset;
    public JFXTextField txtConfirm;
    public JFXTextField txtLname;
    public JFXTextField txtFname;
    public JFXButton BtnLogin;

    UserBOimpl userBOimpl = BOFactory.getInstance().getBO(BOType.USER);

    public void ResetOnAction(ActionEvent actionEvent) {
        String Uid = txtFname.getText();
        String Fullname = txtLname.getText();
        String Username = txtUsername.getText();
        String Password = txtPassword.getText();

        UserDTO userDTO = new UserDTO(Uid,Fullname,Username,Password);

        try {
            boolean added=userBOimpl.updateuser(userDTO);
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION,"User Reset Successfull").showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/login.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) BtnLogin.getScene().getWindow();
        primaryStage.close();
    }

    public void CloseOnAction(ActionEvent actionEvent) {

        System.exit(0);
    }
}
