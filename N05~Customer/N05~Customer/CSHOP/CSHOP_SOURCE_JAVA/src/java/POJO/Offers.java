package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;

public class Offers  implements java.io.Serializable {


     private int idOffers;
     private int Status;
     private String name;
     private Date startDate;
     private Date endDate;
     private Date dateAdded;
     private Date dateUpdated;
    

    public Offers() {
    }

	
    
    public Offers(int idOffers, int Status, String name, Date startDate, Date endDate, Date dateAdded, Date dateUpdated) {
       this.idOffers = idOffers;
       this.Status = Status;
       this.name = name;
       this.startDate = startDate;
       this.endDate = endDate;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
      
    }

    /**
     * @return the idOffers
     */
    public int getIdOffers() {
        return idOffers;
    }

    /**
     * @param idOffers the idOffers to set
     */
    public void setIdOffers(int idOffers) {
        this.idOffers = idOffers;
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
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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


