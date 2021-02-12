package lk.ijse.royal_institute.dto;

/**
 * @author Pazindu Shane On 2/10/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class CourseDTO {
    private String code;
    private String coursename;
    private String coursetype;
    private String duration;

    public CourseDTO(String code, String coursename, String coursetype, String duration) {
        this.code = code;
        this.coursename = coursename;
        this.coursetype = coursetype;
        this.duration = duration;
    }

    public CourseDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "code='" + code + '\'' +
                ", coursename='" + coursename + '\'' +
                ", coursetype='" + coursetype + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
