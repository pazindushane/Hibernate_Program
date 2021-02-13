package lk.ijse.royal_institute.dao.custom.impl;

import lk.ijse.royal_institute.dao.custom.RegistrationDAO;
import lk.ijse.royal_institute.entity.Registration;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class RegistrationDAOimpl implements RegistrationDAO {

    private Session session;
    private Transaction transaction;

    @Override
    public String getLastID() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT regNo FROM registration ORDER BY regNo DESC LIMIT 1");
        String id =sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public boolean add(Registration entity) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }


    @Override
    public boolean delete(String s) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.createNativeQuery("delete from Registration where regNo='"+s+"'", Registration.class).executeUpdate();

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public Registration search(String s) throws Exception {
        return null;
    }





    @Override
    public List<Registration> viewAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Registration");
        List<Registration> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void setSession(Session session) {

    }
}
