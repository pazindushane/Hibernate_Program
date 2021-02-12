package lk.ijse.royal_institute.dao.custom.impl;

import lk.ijse.royal_institute.dao.custom.QueryDAO;
import lk.ijse.royal_institute.entity.Course;
import lk.ijse.royal_institute.entity.Student;
import lk.ijse.royal_institute.entity.SuperEntity;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class QueryDAOimpl implements QueryDAO {

    @Override
    public Student getStudent(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.beginTransaction();
        Student student=session.find(Student.class,id);
        session.getTransaction().commit();
        return student;
    }

    @Override
    public Course getCourse(String code) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.beginTransaction();
        Course course=session.find(Course.class,code);
        session.getTransaction().commit();
        return course;
    }

    @Override
    public boolean add(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Serializable serializable) throws Exception {
        return false;
    }



    @Override
    public boolean update(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public SuperEntity search(SuperEntity entity) throws Exception {
        return null;
    }



    @Override
    public List viewAll() throws Exception {
        return null;
    }
}
