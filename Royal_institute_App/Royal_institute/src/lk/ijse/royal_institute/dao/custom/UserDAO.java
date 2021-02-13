package lk.ijse.royal_institute.dao.custom;

import lk.ijse.royal_institute.dao.SuperDAO;
import lk.ijse.royal_institute.entity.Student;
import lk.ijse.royal_institute.entity.User;

/**
 * @author Pazindu Shane On 2/13/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface UserDAO extends SuperDAO<User,String> {
    User getUserDetails(String username, String password) throws Exception;
}
