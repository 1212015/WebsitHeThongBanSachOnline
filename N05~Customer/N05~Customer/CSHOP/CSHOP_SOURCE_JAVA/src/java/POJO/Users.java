package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;


public class Users  implements java.io.Serializable {


     private int idUsers;
     private int userCategoryID;
     private int Status;
     private String email;
     private String password;
     private String firstName;
     private String lastName;
     private String gender;
     private Date birthday;
     private String phone;
     private String address;
     private int point;
     private Date dateAdded;
     private Date dateUpdated;
     private String birthday2;
     

    public Users() {
    }

	
    public Users(int idUsers, int userCategoryID, int Status, String email, String password, String firstName, String lastName, String gender, Date birthday, String phone, String address, int point, Date dateAdded, Date dateUpdated) {
        this.idUsers = idUsers;
        this.userCategoryID = userCategoryID;
        this.Status = Status;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.point = point;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idUsers
     */
    public int getIdUsers() {
        return idUsers;
    }

    /**
     * @param idUsers the idUsers to set
     */
    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    /**
     * @return the userCategoryID
     */
    public int getUserCategoryID() {
        return userCategoryID;
    }

    /**
     * @param userCategoryID the userCategoryID to set
     */
    public void setUserCategoryID(int userCategoryID) {
        this.userCategoryID = userCategoryID;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
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
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(int point) {
        this.point = point;
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
     * @return the birthday2
     */
    public String getBirthday2() {
        return birthday2;
    }

    /**
     * @param birthday2 the birthday2 to set
     */
    public void setBirthday2(String birthday2) {
        this.birthday2 = birthday2;
    }
   
}


