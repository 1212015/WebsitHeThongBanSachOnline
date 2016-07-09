package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;



public class Discounts  implements java.io.Serializable {


     private int idDiscounts;
     private int userCategoryID;
     private float discount;
     private Date dateAdded;
     private Date dateUpdated;
    
    public Discounts() {
    }

	
    public Discounts(int idDiscounts, int userCategoryID, float discount, Date dateAdded, Date dateUpdated) {
       this.idDiscounts = idDiscounts;
       this.userCategoryID = userCategoryID;
       this.discount = discount;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
       
    }

    /**
     * @return the idDiscounts
     */
    public int getIdDiscounts() {
        return idDiscounts;
    }

    /**
     * @param idDiscounts the idDiscounts to set
     */
    public void setIdDiscounts(int idDiscounts) {
        this.idDiscounts = idDiscounts;
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
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(float discount) {
        this.discount = discount;
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


