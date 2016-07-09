package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

public class Payments  implements java.io.Serializable {


     private int idPayments;
     private int orderID;
     private int paymentMethodID;
     private int Status;
     private Date dateAdded;
     private Date dateUpdated;

    public Payments() {
    }

    public Payments(int idPayments, int orders, int paymentMethods, int paymentStatuses, Date dateAdded, Date dateUpdated) {
       this.idPayments = idPayments;
       this.orderID = orders;
       this.paymentMethodID = paymentMethods;
       this.Status = paymentStatuses;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idPayments
     */
    public int getIdPayments() {
        return idPayments;
    }

    /**
     * @param idPayments the idPayments to set
     */
    public void setIdPayments(int idPayments) {
        this.idPayments = idPayments;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the paymentMethodID
     */
    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    /**
     * @param paymentMethodID the paymentMethodID to set
     */
    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
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


