package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;

public class PaymentMethods  implements java.io.Serializable {


     private int idPaymentMethods;
     private String name;
     private Date dateAdded;
     private Date dateUpdated;
   

    public PaymentMethods() {
    }

	
   
    public PaymentMethods(int idPaymentMethods, String name, Date dateAdded, Date dateUpdated) {
       this.idPaymentMethods = idPaymentMethods;
       this.name = name;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
      
    }

    /**
     * @return the idPaymentMethods
     */
    public int getIdPaymentMethods() {
        return idPaymentMethods;
    }

    /**
     * @param idPaymentMethods the idPaymentMethods to set
     */
    public void setIdPaymentMethods(int idPaymentMethods) {
        this.idPaymentMethods = idPaymentMethods;
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


