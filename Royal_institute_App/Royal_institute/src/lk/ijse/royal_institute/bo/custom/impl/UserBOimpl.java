package lk.ijse.royal_institute.bo.custom.impl;

import lk.ijse.royal_institute.bo.custom.UserBO;
import lk.ijse.royal_institute.dao.DAOFactory;
import lk.ijse.royal_institute.dao.DAOType;
import lk.ijse.royal_institute.dao.custom.UserDAO;
import lk.ijse.royal_institute.dao.custom.impl.UserDAOimpl;
import lk.ijse.royal_institute.dto.UserDTO;
import lk.ijse.royal_institute.entity.Student;
import lk.ijse.royal_institute.entity.User;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;

/**
 * @author Pazindu Shane On 2/13/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class UserBOimpl implements UserBO {

    UserDAOimpl userDAOimpl = DAOFactory.getInstance().getDAO(DAOType.USER);


    @Override
    public UserDTO getUserDetails(String username, String password) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        userDAOimpl.setSession(session);
        session.getTransaction().begin();

        UserDTO userDTO = null;
        try {
            User user = userDAOimpl.getUserDetails(username, password);
            userDTO = new UserDTO(user.getFname(), user.getLname(), user.getUsername(), user.getPassword());
            session.getTransaction().commit();
        } catch (Throwable t) {
            session.getTransaction().rollback();
            throw t;
        } finally {
            session.close();
        }

        return userDTO;
    }

    @Override
    public void update(UserDTO userDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        userDAOimpl.setSession(session);
        session.getTransaction().begin();

        try {
            userDAOimpl.update(new User(userDTO.getFname(), userDTO.getLname(), userDTO.getUsername(), userDTO.getPassword()));
            session.getTransaction().commit();
        } catch (Throwable t) {
            session.getTransaction().rollback();
            throw t;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean adduser(UserDTO userDTO) throws Exception {
        return userDAOimpl.add(new User(userDTO.getFname(),
                userDTO.getLname(),
                userDTO.getUsername(),
                userDTO.getPassword()));
    }

    @Override
    public boolean updateuser(UserDTO userDTO) throws Exception {
        return userDAOimpl.update(new User(userDTO.getFname(),
                userDTO.getLname(),
                userDTO.getUsername(),
                userDTO.getPassword()));
    }
}
