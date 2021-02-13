package lk.ijse.royal_institute.dao.custom.impl;

import lk.ijse.royal_institute.dao.custom.UserDAO;
import lk.ijse.royal_institute.entity.User;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Pazindu Shane On 2/13/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class UserDAOimpl implements UserDAO {

    private Transaction transaction;
    private SessionFactory sessionFactory;
    protected Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    @Override
    public User getUserDetails(String username, String password) throws Exception {
        Query query = session.createQuery("FROM User WHERE (username = ?1 AND password = ?2)");
        query.setParameter(1, username);
        query.setParameter(2, password);
        return (User) query.uniqueResult();
    }

    @Override
    public boolean add(User entity) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(User entity) throws Exception {
        return false;
    }

    @Override
    public User search(String s) throws Exception {
        return null;
    }

    @Override
    public List<User> viewAll() throws Exception {
        return null;
    }


}
