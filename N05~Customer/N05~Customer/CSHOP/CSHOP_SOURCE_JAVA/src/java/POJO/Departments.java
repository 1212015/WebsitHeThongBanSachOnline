package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;


public class Departments  implements java.io.Serializable {


     private int idDepartments;
     private String name;
     private String phone;
     private String location;
     private int managerID; 
     private Date dateAdded;
     private Date dateUpdated;
    

    public Departments() {
    }

	
    public Departments(int idDepartments, String name, String phone,int managerID, String location, Date dateAdded, Date dateUpdated) {
        this.idDepartments = idDepartments;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
        this.managerID= managerID;
    }

    /**
     * @return the idDepartments
     */
    public int getIdDepartments() {
        return idDepartments;
    }

    /**
     * @param idDepartments the idDepartments to set
     */
    public void setIdDepartments(int idDepartments) {
        this.idDepartments = idDepartments;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return the managerID
     */
    public int getManagerID() {
        return managerID;
    }

    /**
     * @param managerID the managerID to set
     */
    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    
     
}


