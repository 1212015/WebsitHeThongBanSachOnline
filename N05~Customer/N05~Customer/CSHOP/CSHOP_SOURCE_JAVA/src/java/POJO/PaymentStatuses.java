package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;

public class PaymentStatuses  implements java.io.Serializable {


     private int idPaymentStatuses;
     private String name;
     private Date dateAdded;
     private Date dateUpdated;
   

    public PaymentStatuses() {
    }

	
   
    public PaymentStatuses(int idPaymentStatuses, String name, Date dateAdded, Date dateUpdated) {
       this.idPaymentStatuses = idPaymentStatuses;
       this.name = name;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
      
    }

    /**
     * @return the idPaymentStatuses
     */
    public int getIdPaymentStatuses() {
        return idPaymentStatuses;
    }

    /**
     * @param idPaymentStatuses the idPaymentStatuses to set
     */
    public void setIdPaymentStatuses(int idPaymentStatuses) {
        this.idPaymentStatuses = idPaymentStatuses;
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


