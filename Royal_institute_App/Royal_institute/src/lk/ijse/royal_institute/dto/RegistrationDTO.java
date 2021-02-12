package lk.ijse.royal_institute.dto;

import lk.ijse.royal_institute.entity.Course;
import lk.ijse.royal_institute.entity.Student;

import java.util.List;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class RegistrationDTO {
    private int  regNo;
    private String regDate;
    private double regFee;
    private String id;
    private String code;

    public RegistrationDTO(){

    }

    public RegistrationDTO(int regNo, String regDate, double regFee, String id, String code) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.id = id;
        this.code = code;
    }



    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", id='" + id + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
