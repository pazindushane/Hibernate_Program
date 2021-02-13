package lk.ijse.royal_institute.bo.custom.impl;

import lk.ijse.royal_institute.bo.custom.StudentBO;
import lk.ijse.royal_institute.dao.DAOFactory;
import lk.ijse.royal_institute.dao.DAOType;
import lk.ijse.royal_institute.dao.custom.impl.StudentDAOimpl;
import lk.ijse.royal_institute.dto.StudentDTO;
import lk.ijse.royal_institute.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class StudentBOimpl implements StudentBO {

    StudentDAOimpl studentDAOimp = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean addstudent(StudentDTO studentDTO) throws Exception {
        return studentDAOimp.add(new Student(studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public String getLastId() throws Exception {
        return studentDAOimp.getLastID();
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<Student> all = studentDAOimp.viewAll();
        List<StudentDTO> list = new ArrayList<>();
        for (Student student : all){
            list.add(new StudentDTO(student.getId(),student.getName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender()));
        }
        return list;
    }

    @Override
    public boolean deletestudent(String id) throws Exception {
        return studentDAOimp.delete(id);
    }



    @Override
    public boolean updatestudent(StudentDTO studentDTO) throws Exception {

        return studentDAOimp.update(new Student(studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public StudentDTO search(String value) throws Exception {
        Student cust = studentDAOimp.search(value);
        return new StudentDTO(cust.getId(), cust.getName(), cust.getAddress(),cust.getContact(),cust.getDob(),cust.getGender());
    }


    private Student makeStudent(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getAddress(),
                studentDTO.getContact(), studentDTO.getDob(), studentDTO.getGender());
    }

    private StudentDTO makeStudentDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getAddress(),
                student.getContact(), student.getDob(), student.getGender());
    }
}
