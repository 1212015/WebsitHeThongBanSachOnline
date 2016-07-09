package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;

public class UserCategories  implements java.io.Serializable {


     private int idUserCategories;
     private String name;
     private int minPoint;
     private Date dateAdded;
     private Date dateUpdated;
    
    public UserCategories() {
    }

	
    public UserCategories(int idUserCategories, String name, int minPoint, Date dateAdded, Date dateUpdated) {
        this.idUserCategories = idUserCategories;
        this.name = name;
        this.minPoint = minPoint;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idUserCategories
     */
    public int getIdUserCategories() {
        return idUserCategories;
    }

    /**
     * @param idUserCategories the idUserCategories to set
     */
    public void setIdUserCategories(int idUserCategories) {
        this.idUserCategories = idUserCategories;
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
     * @return the minPoint
     */
    public int getMinPoint() {
        return minPoint;
    }

    /**
     * @param minPoint the minPoint to set
     */
    public void setMinPoint(int minPoint) {
        this.minPoint = minPoint;
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


