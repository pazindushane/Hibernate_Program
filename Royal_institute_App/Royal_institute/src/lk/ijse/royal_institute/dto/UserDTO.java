package lk.ijse.royal_institute.dto;

/**
 * @author Pazindu Shane On 2/13/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public class UserDTO {

    private String UId;
    private String lname;
    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String UId, String lname, String username, String password) {
        this.UId = UId;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    public String getFname() {
        return UId;
    }

    public void setFname(String fname) {
        this.UId = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "UId='" + UId + '\'' +
                ", lname='" + lname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
