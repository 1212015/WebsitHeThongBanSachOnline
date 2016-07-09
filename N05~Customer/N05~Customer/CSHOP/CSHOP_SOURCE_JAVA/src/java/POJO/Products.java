package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;

public class Products  implements java.io.Serializable {


     private int idProducts;
     private int categoriesRootID;
     private int categoriesSubID;
     private int Status;
     private String name;
     private int price;
     private String image;
     private String detail;
     private String shortDetail;
     private String barCode;
     private String title;
     private String author;
     private String artist;
     private String year;
     private String company;
     private String publisher;
     private String size;
     private String pages;
     private String location;
     private int quantity;
     private int count;
     private Date dateAdded;
     private Date dateUpdated;
     private int discount;

    public Products() {
    }

	
    public Products(int idProducts, int categoriesRootID, int categoriesSubID, int Status, String name, int price, String detail, String shortDetail, String barCode, String title, String company, String location, int quantity, int count, Date dateAdded, Date dateUpdated) {
        this.idProducts = idProducts;
        this.categoriesRootID = categoriesRootID;
        this.categoriesSubID = categoriesSubID;
        this.Status = Status;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.shortDetail = shortDetail;
        this.barCode = barCode;
        this.title = title;
        this.company = company;
        this.location = location;
        this.quantity = quantity;
        this.count = count;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idProducts
     */
    public int getIdProducts() {
        return idProducts;
    }

    /**
     * @param idProducts the idProducts to set
     */
    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    /**
     * @return the categoriesRootID
     */
    public int getCategoriesRootID() {
        return categoriesRootID;
    }

    /**
     * @param categoriesRootID the categoriesRootID to set
     */
    public void setCategoriesRootID(int categoriesRootID) {
        this.categoriesRootID = categoriesRootID;
    }

    /**
     * @return the categoriesSubID
     */
    public int getCategoriesSubID() {
        return categoriesSubID;
    }

    /**
     * @param categoriesSubID the categoriesSubID to set
     */
    public void setCategoriesSubID(int categoriesSubID) {
        this.categoriesSubID = categoriesSubID;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the shortDetail
     */
    public String getShortDetail() {
        return shortDetail;
    }

    /**
     * @param shortDetail the shortDetail to set
     */
    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }

    /**
     * @return the barCode
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * @param barCode the barCode to set
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
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
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the pages
     */
    public String getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
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
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
   
}


