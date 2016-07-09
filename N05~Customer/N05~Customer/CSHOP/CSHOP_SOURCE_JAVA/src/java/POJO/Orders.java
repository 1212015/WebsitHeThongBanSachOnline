package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Orders  implements java.io.Serializable {


     private int idOrders;
     private int discountID;
     private int employeeID;
     private int Status;
     private int userID;
     private String shipName;
     private String shipAddress;
     private String shipPhone;
     private Date shipDate;
     private Date dateAdded;
     private Date dateUpdated;
      private String shipDate2;
     private String dateAdded2;
     private String dateUpdated2;
    

    public Orders() {
    }

    public Orders(int idOrders, int discounts, int employees, int orderStatuses, int userID, String shipName, String shipAddress, String shipPhone, Date shipDate, Date dateAdded, Date dateUpdated) {
       this.idOrders = idOrders;
       this.discountID = discounts;
       this.employeeID = employees;
       this.Status = orderStatuses;
       this.userID = userID;
       this.shipName = shipName;
       this.shipAddress = shipAddress;
       this.shipPhone = shipPhone;
       this.shipDate = shipDate;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
       
    }

    /**
     * @return the idOrders
     */
    public int getIdOrders() {
        return idOrders;
    }

    /**
     * @param idOrders the idOrders to set
     */
    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    /**
     * @return the discountID
     */
    public int getDiscountID() {
        return discountID;
    }

    /**
     * @param discountID the discountID to set
     */
    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * @param shipName the shipName to set
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     * @return the shipAddress
     */
    public String getShipAddress() {
        return shipAddress;
    }

    /**
     * @param shipAddress the shipAddress to set
     */
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    /**
     * @return the shipPhone
     */
    public String getShipPhone() {
        return shipPhone;
    }

    /**
     * @param shipPhone the shipPhone to set
     */
    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    /**
     * @return the shipDate
     */
    public Date getShipDate() {
        return shipDate;
    }

    /**
     * @param shipDate the shipDate to set
     */
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
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
     * @return the shipDate2
     */
    public String getShipDate2() {
        return shipDate2;
    }

    /**
     * @param shipDate2 the shipDate2 to set
     */
    public void setShipDate2(String shipDate2) {
        this.shipDate2 = shipDate2;
    }

    /**
     * @return the dateAdded2
     */
    public String getDateAdded2() {
        return dateAdded2;
    }

    /**
     * @param dateAdded2 the dateAdded2 to set
     */
    public void setDateAdded2(String dateAdded2) {
        this.dateAdded2 = dateAdded2;
    }

    /**
     * @return the dateUpdated2
     */
    public String getDateUpdated2() {
        return dateUpdated2;
    }

    /**
     * @param dateUpdated2 the dateUpdated2 to set
     */
    public void setDateUpdated2(String dateUpdated2) {
        this.dateUpdated2 = dateUpdated2;
    }
   
}


               