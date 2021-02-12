package lk.ijse.royal_institute.bo.custom;

import lk.ijse.royal_institute.bo.SuperBO;
import lk.ijse.royal_institute.dto.RegistrationDTO;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface RegistrationBO extends SuperBO {
    public boolean addregistration(RegistrationDTO registrationDTO) throws Exception;

    String getLastId() throws Exception;

    boolean getAll() throws Exception;

    public boolean deleteregisterd(RegistrationDTO registrationDTO) throws Exception;

    public boolean updateregisterd(RegistrationDTO registrationDTO) throws Exception;

    RegistrationDTO search(String value) throws Exception;
}
