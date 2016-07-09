package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

public class OrderDetails  implements java.io.Serializable {


     private int idOrderDetails;
     private int orderID;
     private int productID;
     private int quantity;
     private int price;
     private Date dateAdded;
     private Date dateUpdated;
     
     private String dateAdded2;
     private String dateUpdated2;
     private String name;
     private String publisher;
      private double discount;
      private int discountID;// loại tài khoản giảm giá
    
     private int total;
    public OrderDetails() {
    }

    public OrderDetails(int idOrderDetails, int orderID, int productID, int quantity, int price, Date dateAdded, Date dateUpdated) {
       this.idOrderDetails = idOrderDetails;
       this.orderID = orderID;
       this.productID = productID;
       this.quantity = quantity;
       this.price = price;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idOrderDetails
     */
    public int getIdOrderDetails() {
        return idOrderDetails;
    }

    /**
     * @param idOrderDetails the idOrderDetails to set
     */
    public void setIdOrderDetails(int idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
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

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
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
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
   
     
}


