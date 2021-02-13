package lk.ijse.royal_institute.bo.custom;

import lk.ijse.royal_institute.bo.SuperBO;
import lk.ijse.royal_institute.dto.StudentDTO;
import lk.ijse.royal_institute.dto.UserDTO;

/**
 * @author Pazindu Shane On 2/13/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface UserBO extends SuperBO {
    UserDTO getUserDetails(String username, String password) throws Exception;

    void update(UserDTO userDTO) throws Exception;

    public boolean adduser(UserDTO userDTO) throws Exception;
}
