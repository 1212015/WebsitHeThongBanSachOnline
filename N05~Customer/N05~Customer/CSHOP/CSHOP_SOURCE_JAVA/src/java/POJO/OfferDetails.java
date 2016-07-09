package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

public class OfferDetails  implements java.io.Serializable {


     private int idOfferDetails;
     private int offerID;
     private int productID;
     private int userCategoryID;
     private double discount;
     private Date dateAdded;
     private Date dateUpdated;
    
     
    public OfferDetails() {
    }

    public OfferDetails(int idOfferDetails, int offerID, int productID,int userCategoryID, double discount, Date dateAdded, Date dateUpdated) {
       this.idOfferDetails = idOfferDetails;
       this.offerID = offerID;
       this.productID = productID; 
       this.userCategoryID= userCategoryID;
       this.discount = discount;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idOfferDetails
     */
    public int getIdOfferDetails() {
        return idOfferDetails;
    }

    /**
     * @param idOfferDetails the idOfferDetails to set
     */
    public void setIdOfferDetails(int idOfferDetails) {
        this.idOfferDetails = idOfferDetails;
    }

    /**
     * @return the offerID
     */
    public int getOfferID() {
        return offerID;
    }

    /**
     * @param offerID the offerID to set
     */
    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
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
    public void setDiscount(double discount) {
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


