package lk.ijse.royal_institute.dao;

import lk.ijse.royal_institute.dao.custom.impl.*;
import lk.ijse.royal_institute.entity.Student;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOimpl();
            case COURSE :
                return (T) new CourseDAOimpl();
            case REGISTRATION:
                return (T) new RegistrationDAOimpl();
            case QUERY:
                return (T) new  QueryDAOimpl();
            case USER:
                return (T) new UserDAOimpl();
            default:
                return null;
        }
    }

}
