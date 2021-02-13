package lk.ijse.royal_institute.bo.custom;

import lk.ijse.royal_institute.bo.SuperBO;
import lk.ijse.royal_institute.dto.CourseDTO;
import lk.ijse.royal_institute.dto.StudentDTO;

import java.util.List;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface CourseBO extends SuperBO {

    public boolean addcourse(CourseDTO courseDTO) throws Exception;

    String getLastId() throws Exception;

    List<CourseDTO> getAll() throws Exception;

    public boolean deletecourse(String id) throws Exception;

    public boolean updatecourse(CourseDTO courseDTO) throws Exception;

    CourseDTO search(String value) throws Exception;
}
