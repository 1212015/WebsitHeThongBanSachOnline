package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;
public class Employees  implements java.io.Serializable {


     private int idEmployees;
     private String password;
     private String firstName;
     private String lastName;
     private String idno;
     private String gender;
     private Date birthday;
     private String phone;
     private String address;
     private String email;
     private int salary;
     private Date dateAdded;
     private Date dateUpdated;
     private int departmentID;
     private int gradeID;
   

    public Employees() {
    }

	
    public Employees(int idEmployees, Departments departments,  String password, String firstName, String lastName, String idno, String gender, Date birthday, String phone, String address, String email, int salary, Date dateAdded, Date dateUpdated,int departmentID, int gradeID) {
        this.idEmployees = idEmployees;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idno = idno;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.salary = salary;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
        this.departmentID= departmentID;
        this.gradeID= gradeID;
    }

    /**
     * @return the idEmployees
     */
    public int getIdEmployees() {
        return idEmployees;
    }

    /**
     * @param idEmployees the idEmployees to set
     */
    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the idno
     */
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the dateAdded
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * @param dateAdded the dateAdded to set
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the dateUpdated
     */
    public Date getDateUpdated() {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the departmentID
     */
    public int getDepartmentID() {
        return departmentID;
    }

    /**
     * @param departmentID the departmentID to set
     */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    /**
     * @return the gradeID
     */
    public int getGradeID() {
        return gradeID;
    }

    /**
     * @param gradeID the gradeID to set
     */
    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
   
}


