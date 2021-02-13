package lk.ijse.royal_institute.Controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.royal_institute.bo.custom.impl.CourseBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.StudentBOimpl;
import lk.ijse.royal_institute.dto.CourseDTO;
import lk.ijse.royal_institute.dto.StudentDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Pazindu Shane On 2/8/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class CourseFormController {
    public JFXButton closeBtn;
    public JFXButton BackBtn;
    public JFXButton btnAdd;
    public JFXTextField txtCode;
    public JFXTextField txtCname;
    public JFXTextField txtCtype;
    public JFXTextField txtCduration;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnSearch;
    public JFXButton btnView;

    @FXML
    private TableView<CourseDTO> tblcourse;

    @FXML
    private TableColumn<CourseDTO, String> clmCoursecode;

    @FXML
    private TableColumn<CourseDTO, String> clmCoursename;

    @FXML
    private TableColumn<CourseDTO, String> clmCoursetype;

    @FXML
    private TableColumn<CourseDTO, String> clmDuration;

    CourseBOimpl courseBOimpl = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize() {

        generateCourseId();
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

    public void AddOnAction(ActionEvent actionEvent) {

        String code = txtCode.getText();
        String coursename = txtCname.getText();
        String coursetype = txtCtype.getText();
        String duration = txtCduration.getText();

        CourseDTO courseDTO = new CourseDTO(code,coursename,coursetype,duration);

        try {
            boolean added=courseBOimpl.addcourse(courseDTO);
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION,"Course Added").showAndWait();
                clear();
                getAllItems();
                generateCourseId();
                txtCname.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear(){

        txtCode.clear();
        txtCname.clear();
        txtCtype.clear();
        txtCduration.clear();

    }

    private void setTblItemCellValue() {
        clmCoursecode.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("code"));
        clmCoursename.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("coursename"));
        clmCoursetype.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("coursetype"));
        clmDuration.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("duration"));
    }

    private void getAllItems() {
        try {
            List<CourseDTO> itemList = courseBOimpl.getAll();
            ObservableList<CourseDTO> list = FXCollections.observableArrayList();
            list.addAll(itemList);
            tblcourse.setItems(list);
            setTblItemCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateCourseId() {
        try {
            String lastId = courseBOimpl.getLastId();
            int newId = Integer.parseInt(lastId.substring(1, 4))+1;
            if (newId < 10) {
                txtCode.setText("C00"+newId);
            }else if (newId < 100) {
                txtCode.setText("C0"+newId);
            }else {
                txtCode.setText("C"+newId);
            }
        } catch (Exception e) {
            txtCode.setText("C001");
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String coursename = txtCname.getText();
        String coursetype = txtCtype.getText();
        String duration = txtCduration.getText();

        CourseDTO courseDTO = new CourseDTO(code,coursename,coursetype,duration);

        try {
            boolean added=courseBOimpl.updatecourse(courseDTO);
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION,"Course Added").showAndWait();
                clear();
                getAllItems();
                generateCourseId();
                txtCname.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String cid=txtCode.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Meyawa Delete Karanna onamada..?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                courseBOimpl.deletecourse(cid);
                getAllItems();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {

        try {
            CourseDTO customer = courseBOimpl.search(txtCode.getText());
            ObservableList<CourseDTO> list = FXCollections.observableArrayList();
            list.add(customer);
            tblcourse.setItems(list);
            setTblItemCellValue();
        }  catch (Exception e) {

        }
    }

    public void ViewOnAction(ActionEvent actionEvent) {
        getAllItems();
    }
}
