package lk.ijse.royal_institute.bo.custom;

import lk.ijse.royal_institute.bo.SuperBO;
import lk.ijse.royal_institute.dto.StudentDTO;

import java.util.List;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface StudentBO extends SuperBO {

    public boolean addstudent(StudentDTO studentDTO) throws Exception;

    String getLastId() throws Exception;

    List<StudentDTO> getAll() throws Exception;

    public boolean deletestudent(String id) throws Exception;

    public boolean updatestudent(StudentDTO studentDTO) throws Exception;

    StudentDTO search(String value) throws Exception;

}
