package lk.ijse.royal_institute.bo.custom.impl;

import lk.ijse.royal_institute.bo.custom.CourseBO;
import lk.ijse.royal_institute.dao.DAOFactory;
import lk.ijse.royal_institute.dao.DAOType;
import lk.ijse.royal_institute.dao.custom.impl.CourseDAOimpl;
import lk.ijse.royal_institute.dto.CourseDTO;
import lk.ijse.royal_institute.entity.Course;
import lk.ijse.royal_institute.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class CourseBOimpl implements CourseBO {

    CourseDAOimpl courseDAOimpl = DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public boolean addcourse(CourseDTO courseDTO) throws Exception {
        return courseDAOimpl.add(new Course(courseDTO.getCode(),courseDTO.getCoursename(),courseDTO.getCoursetype(),courseDTO.getDuration()));
    }

    @Override
    public String getLastId() throws Exception {
        return courseDAOimpl.getLastID();
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<Course> all = courseDAOimpl.viewAll();
        List<CourseDTO> list = new ArrayList<>();
        for (Course course : all){
            list.add(new CourseDTO(course.getCode(),course.getCoursename(),course.getCoursetype(),course.getDuration()));
        }
        return list;
    }

    @Override
    public boolean deletecourse(String id) throws Exception {
        return courseDAOimpl.delete(id);
    }


    @Override
    public boolean updatecourse(CourseDTO courseDTO) throws Exception {
        return courseDAOimpl.update(new Course(courseDTO.getCode(),
                courseDTO.getCoursename(),
                courseDTO.getCoursetype(),
                courseDTO.getDuration()));
    }
}
