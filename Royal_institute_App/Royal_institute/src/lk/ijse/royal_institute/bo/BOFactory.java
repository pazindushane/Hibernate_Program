package lk.ijse.royal_institute.bo;

import lk.ijse.royal_institute.bo.custom.StudentBO;
import lk.ijse.royal_institute.bo.custom.impl.CourseBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.RegistrationBOimpl;
import lk.ijse.royal_institute.bo.custom.impl.StudentBOimpl;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory==null) ? boFactory=new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOimpl();
            case COURSE:
                return (T) new CourseBOimpl();
            case REGISTRATION:
                return (T) new RegistrationBOimpl();
            default:
                return null;
        }
    }
}
