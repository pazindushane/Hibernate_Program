package lk.ijse.royal_institute.dao.custom;

import lk.ijse.royal_institute.dao.SuperDAO;
import lk.ijse.royal_institute.entity.Student;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface StudentDAO extends SuperDAO<Student ,String> {

    String getLastID() throws Exception;
}
