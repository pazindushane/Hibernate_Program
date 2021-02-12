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
public class DashboardController {
    public JFXButton Coursebtn;
    public JFXButton addStudentbtn;
    public JFXButton regiterbtn;

    public void CourseOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CourseForm.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) Coursebtn.getScene().getWindow();
        primaryStage.close();



    }

    public void AddOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/StudentForm.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) addStudentbtn.getScene().getWindow();
        primaryStage.close();

    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/RegistrationForm.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage= (Stage) regiterbtn.getScene().getWindow();
        primaryStage.close();

    }
}
