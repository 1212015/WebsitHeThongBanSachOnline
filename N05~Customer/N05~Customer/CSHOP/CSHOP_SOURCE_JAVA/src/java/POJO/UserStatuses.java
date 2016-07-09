package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;

public class UserStatuses  implements java.io.Serializable {


     private int idUserStatuses;
     private String name;
     private Date dateAdded;
     private Date dateUpdated;
   

    public UserStatuses() {
    }

	
    public UserStatuses(int idUserStatuses, String name, Date dateAdded, Date dateUpdated) {
        this.idUserStatuses = idUserStatuses;
        this.name = name;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idUserStatuses
     */
    public int getIdUserStatuses() {
        return idUserStatuses;
    }

    /**
     * @param idUserStatuses the idUserStatuses to set
     */
    public void setIdUserStatuses(int idUserStatuses) {
        this.idUserStatuses = idUserStatuses;
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


