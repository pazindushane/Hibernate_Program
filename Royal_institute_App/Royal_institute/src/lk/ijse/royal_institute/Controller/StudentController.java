package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.royal_institute.bo.BOFactory;
import lk.ijse.royal_institute.bo.BOType;
import lk.ijse.royal_institute.bo.custom.StudentBO;
import lk.ijse.royal_institute.bo.custom.impl.StudentBOimpl;
import lk.ijse.royal_institute.dto.StudentDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Pazindu Shane On 2/8/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class StudentController {
    public JFXButton closeBtn;
    public JFXButton BackBtn;
    public JFXRadioButton rabMale;
    public JFXRadioButton rabFemale;
    public JFXButton BtnAdd;
    public JFXTextField TxtStudeID;
    public JFXTextField TxtStuName;
    public JFXTextField TxtAddress;
    public JFXTextField TxtTele;
    public JFXTextField TxtDOB;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnSearch;
    public JFXButton btnViewAll;


    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TableColumn<StudentDTO, String> clmSID;

    @FXML
    private TableColumn<StudentDTO, String> clmName;

    @FXML
    private TableColumn<StudentDTO, String> clmAddress;

    @FXML
    private TableColumn<StudentDTO, String> clmContact;

    @FXML
    private TableColumn<StudentDTO, String> clmDOB;

    @FXML
    private TableColumn<StudentDTO, String> clmGender;


    StudentBOimpl studentBOimpl = BOFactory.getInstance().getBO(BOType.STUDENT);


    public void initialize() {

        generateStuId();
    }


    public void AddOnAction(ActionEvent actionEvent) {

        String id = TxtStudeID.getText();
        String name = TxtStuName.getText();
        String address = TxtAddress.getText();
        String tele = TxtTele.getText();
        String dob = TxtDOB.getText();
        String gender = rabMale.getText();
        if (rabFemale.isSelected()) gender = rabFemale.getText();
        StudentDTO studentDTO = new StudentDTO(id,name,address,tele,dob,gender);
        try {
            boolean added=studentBOimpl.addstudent(studentDTO);
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Added").showAndWait();
                clear();
                getAllItems();
                generateStuId();
                TxtStuName.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Stage primaryStage= (Stage) BackBtn.getScene().getWindow();
        primaryStage.close();
    }


    public void clear(){

        TxtStudeID.clear();
        TxtStuName.clear();
        TxtAddress.clear();
        TxtTele.clear();
        TxtDOB.clear();
    }


    private void generateStuId() {

        try {
            String lastId = studentBOimpl.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                TxtStudeID.setText("S00"+newId);
            }else if (newId < 100) {
                TxtStudeID.setText("S0"+newId);
            }else {
                TxtStudeID.setText("S"+newId);
            }
        } catch (Exception e) {
            TxtStudeID.setText("S001");
        }
    }


    private void setTblItemCellValue() {

        clmSID.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("id"));
        clmName.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("contact"));
        clmDOB.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("dob"));
        clmGender.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("gender"));
    }


    private void getAllItems() {

        try {
            List<StudentDTO> itemList = studentBOimpl.getAll();
            ObservableList<StudentDTO> list = FXCollections.observableArrayList();
            list.addAll(itemList);
            tblStudent.setItems(list);
            setTblItemCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void DeleteOnAction(ActionEvent actionEvent) {

        String id=TxtStudeID.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Meyawa Delete Karanna onamada..?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                studentBOimpl.deletestudent(id);
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!", ButtonType.OK).show();

            }
            getAllItems();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Not Deleted!",ButtonType.OK).show();
            e.printStackTrace();
        }
    }


    public void UpdateOnAction(ActionEvent actionEvent) {

        String id = TxtStudeID.getText();
        String name = TxtStuName.getText();
        String address = TxtAddress.getText();
        String tele = TxtTele.getText();
        String dob = TxtDOB.getText();
        String gender = rabMale.getText();
        if (rabFemale.isSelected()) gender = rabFemale.getText();
        StudentDTO studentDTO = new StudentDTO(id,name,address,tele,dob,gender);
        try {
            boolean deleted=studentBOimpl.updatestudent(studentDTO);
            if (deleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Successfully Updated").showAndWait();
                clear();
                getAllItems();
                generateStuId();
                TxtStuName.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO customer = studentBOimpl.search(TxtStudeID.getText());
            ObservableList<StudentDTO> list = FXCollections.observableArrayList();
            list.add(customer);
            tblStudent.setItems(list);
            setTblItemCellValue();
        }  catch (Exception e) {

        }
    }

    public void ViewOnAction(ActionEvent actionEvent) {
        getAllItems();
    }
}

