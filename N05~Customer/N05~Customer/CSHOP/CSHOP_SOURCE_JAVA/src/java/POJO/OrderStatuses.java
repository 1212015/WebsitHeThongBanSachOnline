package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;

public class OrderStatuses  implements java.io.Serializable {


     private int idOrderStatuses;
     private String name;
     private Date dateAdded;
     private Date dateUpdated;
   

    public OrderStatuses() {
    }

	
   
    public OrderStatuses(int idOrderStatuses, String name, Date dateAdded, Date dateUpdated) {
       this.idOrderStatuses = idOrderStatuses;
       this.name = name;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
       
    }

    /**
     * @return the idOrderStatuses
     */
    public int getIdOrderStatuses() {
        return idOrderStatuses;
    }

    /**
     * @param idOrderStatuses the idOrderStatuses to set
     */
    public void setIdOrderStatuses(int idOrderStatuses) {
        this.idOrderStatuses = idOrderStatuses;
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
   
    
}


