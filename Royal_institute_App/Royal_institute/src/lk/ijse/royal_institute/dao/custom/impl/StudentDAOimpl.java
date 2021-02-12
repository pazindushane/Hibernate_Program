package lk.ijse.royal_institute.dao.custom.impl;

import lk.ijse.royal_institute.dao.custom.StudentDAO;
import lk.ijse.royal_institute.entity.Student;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class StudentDAOimpl implements StudentDAO {
    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Student entity) throws Exception {
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

        session.createNativeQuery("delete from Student where id='"+s+"'",Student.class).executeUpdate();

        transaction.commit();

        session.close();

        return true;
    }


    @Override
    public boolean update(Student entity) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public Student search(Student entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            session.beginTransaction();
            Student student=session.find(Student.class, entity.getId());
            session.getTransaction().commit();
            return student;
        }catch (Exception exception){

        }
        return null;
    }



    @Override
    public List<Student> viewAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Student");
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getLastID() throws Exception {
         session = FactoryConfiguration.getInstance().getSession();
         transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT id FROM student ORDER BY id DESC LIMIT 1");
        String id =sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }
}
