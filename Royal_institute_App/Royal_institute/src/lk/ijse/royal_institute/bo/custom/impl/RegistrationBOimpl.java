package lk.ijse.royal_institute.bo.custom.impl;

import lk.ijse.royal_institute.bo.custom.RegistrationBO;
import lk.ijse.royal_institute.dao.DAOFactory;
import lk.ijse.royal_institute.dao.DAOType;
import lk.ijse.royal_institute.dao.custom.impl.CourseDAOimpl;
import lk.ijse.royal_institute.dao.custom.impl.QueryDAOimpl;
import lk.ijse.royal_institute.dao.custom.impl.RegistrationDAOimpl;
import lk.ijse.royal_institute.dao.custom.impl.StudentDAOimpl;
import lk.ijse.royal_institute.dto.RegistrationDTO;
import lk.ijse.royal_institute.entity.*;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class RegistrationBOimpl implements RegistrationBO {

    StudentDAOimpl studentDAOimpl = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    CourseDAOimpl courseDAOimpl = DAOFactory.getInstance().getDAO(DAOType.COURSE);
    RegistrationDAOimpl registrationDAOimpl = DAOFactory.getInstance().getDAO(DAOType.REGISTRATION);
    QueryDAOimpl queryDAOimpl = DAOFactory.getInstance().getDAO(DAOType.QUERY);

    @Override
    public boolean addregistration(RegistrationDTO registrationDTO) throws Exception {
        Student id=queryDAOimpl.getStudent(registrationDTO.getId());
        Course cid=queryDAOimpl.getCourse(registrationDTO.getCode());
        return registrationDAOimpl.add(new Registration(registrationDTO.getRegNo(),registrationDTO.getRegDate(),
                registrationDTO.getRegFee(),id,cid));
    }

    @Override
    public String getLastId() throws Exception {
        return registrationDAOimpl.getLastID();
    }

    @Override
    public boolean getAll() throws Exception {
        return false;
    }

    @Override
    public boolean deleteregisterd(RegistrationDTO registrationDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateregisterd(RegistrationDTO registrationDTO) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO search(String value) throws Exception {
        return null;
    }
}
