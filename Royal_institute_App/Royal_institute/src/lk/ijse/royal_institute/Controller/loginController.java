package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author Pazindu Shane On 2/7/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class loginController {

    public JFXButton LoginBtn;
    public JFXButton Signbtn1;
    public JFXButton closeBtn;

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

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Dashboard.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) LoginBtn.getScene().getWindow();
        primaryStage.close();
    }
}
