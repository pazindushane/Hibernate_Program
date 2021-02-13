package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.royal_institute.bo.BOFactory;
import lk.ijse.royal_institute.bo.BOType;
import lk.ijse.royal_institute.bo.custom.impl.CourseBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.RegistrationBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.StudentBOimpl;
import lk.ijse.royal_institute.dto.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Pazindu Shane On 2/8/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class RegistrationFormController {
    public JFXButton closeBtn;
    public JFXButton BackBtn;

    public JFXTextField txtRegFee;
    public JFXTextField TxtStudeID;
    public JFXTextField txtCode;
    public JFXTextField txtRegno;
    public JFXButton btnAdd;
    public JFXButton btnCart;
    public JFXComboBox cmbId;
    public JFXDatePicker txtRegDate;
    public JFXComboBox CmbCourse;


    @FXML
    private TableView<RegistrationDTO> tblCourse;

    @FXML
    private TableColumn<RegistrationDTO, Integer> clmRegNo;

    @FXML
    private TableColumn<RegistrationDTO, String> clmRegDate;

    @FXML
    private TableColumn<RegistrationDTO, Double> clmRegFee;

    @FXML
    private TableColumn<RegistrationDTO, String> clmStuId;

    @FXML
    private TableColumn<RegistrationDTO, String> clmCourseCode;




    RegistrationBOimpl registrationBOimpl = BOFactory.getInstance().getBO(BOType.REGISTRATION);
    StudentBOimpl studentBOimpl =BOFactory.getInstance().getBO(BOType.STUDENT);
    CourseBOimpl courseBOimpl = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize() {
        addValuesToCmbStudent();
        addValuesToCmbCourse();
    }

    public void CloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void BAckOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/Dashboard.fxml"))));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Stage primaryStage = (Stage) BackBtn.getScene().getWindow();
        primaryStage.close();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        int rid= Integer.parseInt(txtRegno.getText());
        String regDate=txtRegDate.getValue().toString();
        double studentFee= Double.parseDouble(txtRegFee.getText());
        String id =cmbId.getSelectionModel().getSelectedItem().toString();
        String cid=CmbCourse.getSelectionModel().getSelectedItem().toString();

        RegistrationDTO registrationDTO=new RegistrationDTO(rid,regDate,studentFee,id,cid);
        try {
            boolean isAdded= registrationBOimpl.addregistration(registrationDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !", ButtonType.OK).show();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }
    }

    private void generateRegId() {

        try {
            String lastId = registrationBOimpl.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                txtRegno.setText("R00"+newId);
            }else if (newId < 100) {
                txtRegno.setText("R0"+newId);
            }else {
                txtRegno.setText("R"+newId);
            }
        } catch (Exception e) {
            txtRegno.setText("R001");
        }
    }



    private void setTblProgramCellValue() {
        clmRegNo.setCellValueFactory(new PropertyValueFactory<RegistrationDTO, Integer>("regNo"));
        clmRegDate.setCellValueFactory(new PropertyValueFactory<RegistrationDTO, String>("regDate"));
        clmRegFee.setCellValueFactory(new PropertyValueFactory<RegistrationDTO, Double>("regFee"));
        clmCourseCode.setCellValueFactory(new PropertyValueFactory<RegistrationDTO, String>("code"));
        clmStuId.setCellValueFactory(new PropertyValueFactory<RegistrationDTO, String>("Id"));
    }

//    private void getAllItems() {
//
//        try {
//            List<RegistrationDTO> itemList = registrationBOimpl.getAll();
//            ObservableList<RegistrationDTO> list = FXCollections.observableArrayList();
//            list.addAll(itemList);
//            tblCourse.setItems(list);
//            setTblProgramCellValue();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void addValuesToCmbStudent() {
        try {
            cmbId.getItems().clear();
            List<StudentDTO> list = studentBOimpl.getAll();
            for (StudentDTO studentDTO : list) {
                cmbId.getItems().add(studentDTO.getId());

            }
        } catch (Exception e) {
        }
    }

    private void addValuesToCmbCourse() {
        try {
            CmbCourse.getItems().clear();
            List<CourseDTO> list = courseBOimpl.getAll();
            for (CourseDTO courseDTO : list) {
                CmbCourse.getItems().add(courseDTO.getCode());

            }
        } catch (Exception e) {
        }
    }



    public void cmbIdOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO student = studentBOimpl.search(cmbId.getSelectionModel().getSelectedItem().toString());
            TxtStudeID.setText(student.getId());

        } catch (Exception ex) {
        }
    }

    public void tblCartOnMouseClicked(MouseEvent mouseEvent) {
    }
}
