package lk.ijse.royal_institute.dao.custom;

import lk.ijse.royal_institute.dao.SuperDAO;
import lk.ijse.royal_institute.entity.Course;
import lk.ijse.royal_institute.entity.Student;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface QueryDAO extends SuperDAO {

    public Student getStudent(String id)throws Exception;
    public Course getCourse(String code)throws Exception;

}
