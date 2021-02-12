package lk.ijse.royal_institute.dao.custom;

import lk.ijse.royal_institute.dao.SuperDAO;
import lk.ijse.royal_institute.entity.Course;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface CourseDAO extends SuperDAO<Course, String> {

    String getLastID() throws Exception;


}
