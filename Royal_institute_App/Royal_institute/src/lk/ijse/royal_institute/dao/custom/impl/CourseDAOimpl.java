package lk.ijse.royal_institute.dao.custom.impl;

import lk.ijse.royal_institute.dao.custom.CourseDAO;
import lk.ijse.royal_institute.entity.Course;
import lk.ijse.royal_institute.entity.Student;
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
public class CourseDAOimpl implements CourseDAO {

    private Session session;
    private Transaction transaction;

    @Override
    public String getLastID() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT code FROM course ORDER BY code DESC LIMIT 1");
        String id =sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }


    @Override
    public boolean add(Course entity) throws Exception {
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

        session.createNativeQuery("delete from Course where code='"+s+"'",Course.class).executeUpdate();

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public Course search(Course entity) throws Exception {
        try {

            session = FactoryConfiguration.getInstance().getSession();

            transaction = session.beginTransaction();

            Course course=session.find(Course.class, entity.getCode());

            session.getTransaction().commit();

            return course;

        }catch (Exception exception){

        }
        return null;
    }


    @Override
    public List<Course> viewAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course");
        List<Course> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
