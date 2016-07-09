package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

public class ProductCategoriesSub  implements java.io.Serializable {


     private int idProductCategoriesSub;
     private int productCategoriesRootID;
     private String name;
     private String detail;
     private String shortDetail;
     private String image;
     private Date dateAdded;
     private Date dateUpdated;
     

    public ProductCategoriesSub() {
    }

	
    public ProductCategoriesSub(int idProductCategoriesSub, int productCategoriesRoot, String name, String detail, String shortDetail, Date dateAdded, Date dateUpdated) {
        this.idProductCategoriesSub = idProductCategoriesSub;
        this.productCategoriesRootID = productCategoriesRoot;
        this.name = name;
        this.detail = detail;
        this.shortDetail = shortDetail;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the idProductCategoriesSub
     */
    public int getIdProductCategoriesSub() {
        return idProductCategoriesSub;
    }

    /**
     * @param idProductCategoriesSub the idProductCategoriesSub to set
     */
    public void setIdProductCategoriesSub(int idProductCategoriesSub) {
        this.idProductCategoriesSub = idProductCategoriesSub;
    }

    /**
     * @return the productCategoriesRootID
     */
    public int getProductCategoriesRootID() {
        return productCategoriesRootID;
    }

    /**
     * @param productCategoriesRootID the productCategoriesRootID to set
     */
    public void setProductCategoriesRootID(int productCategoriesRootID) {
        this.productCategoriesRootID = productCategoriesRootID;
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


