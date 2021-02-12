package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author Pazindu Shane On 2/8/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class SignInController {

    public JFXButton loginbtn1;
    public JFXButton Signbtn2;
    public JFXButton closeBtn;

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

        Stage stage = new Stage();

        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/login.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) Signbtn2.getScene().getWindow();
        primaryStage.close();



    }
}
