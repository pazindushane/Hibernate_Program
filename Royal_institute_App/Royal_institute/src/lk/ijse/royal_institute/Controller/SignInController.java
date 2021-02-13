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
import lk.ijse.royal_institute.bo.custom.impl.UserBOimpl;
import lk.ijse.royal_institute.dto.StudentDTO;
import lk.ijse.royal_institute.dto.UserDTO;

import java.io.IOException;

/**
 * @author Pazindu Shane On 2/8/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class SignInController {

    public JFXButton loginbtn1;
    public JFXButton Signbtn2;
    public JFXButton closeBtn;
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXTextField txtConfirm;
    public JFXTextField txtLname;
    public JFXTextField txtFname;
    UserBOimpl userBOimpl = BOFactory.getInstance().getBO(BOType.USER);

    public void CloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void LoginOnAction1(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/login.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) loginbtn1.getScene().getWindow();
        primaryStage.close();

    }

    public void SignOnActon2(ActionEvent actionEvent) throws IOException {

        addsign();

//        Stage stage = new Stage();
//
//        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/login.fxml"))));
//        stage.setResizable(false);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.show();
//
//        Stage primaryStage= (Stage) Signbtn2.getScene().getWindow();
//        primaryStage.close();



    }

    public void addsign(){
        String fname = txtFname.getText();
        String lname = txtLname.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
//        String confirm = txtConfirm.getText();
        UserDTO studentDTO = new UserDTO(fname,lname,username,password);
        try {
            boolean added=userBOimpl.adduser(studentDTO);
            if (added){
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/login.fxml"))));
                stage.setResizable(false);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();

                Stage primaryStage= (Stage) loginbtn1.getScene().getWindow();
                primaryStage.close();
//                new Alert(Alert.AlertType.CONFIRMATION,"Student Added").showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
