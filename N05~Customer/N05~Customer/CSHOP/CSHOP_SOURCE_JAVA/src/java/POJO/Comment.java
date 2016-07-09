/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;



/**
 *
 * @author PQC
 */
public class Comment {
    private int Id_Product;
    private int Id_Users;
    private String Content;
    private String dateAdded;
    private String Id_Comment ;

    /**
     * @return the Id_Product
     */
    public int getId_Product() {
        return Id_Product;
    }

    /**
     * @param Id_Product the Id_Product to set
     */
    public void setId_Product(int Id_Product) {
        this.Id_Product = Id_Product;
    }

    /**
     * @return the Id_Users
     */
    public int getId_Users() {
        return Id_Users;
    }

    /**
     * @param Id_Users the Id_Users to set
     */
    public void setId_Users(int Id_Users) {
        this.Id_Users = Id_Users;
    }

    /**
     * @return the Content
     */
    public String getContent() {
        return Content;
    }

    /**
     * @param Content the Content to set
     */
    public void setContent(String Content) {
        this.Content = Content;
    }

    /**
     * @return the dateAdded
     */
    public String getDateAdded() {
        return dateAdded;
    }

    /**
     * @param dateAdded the dateAdded to set
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the Id_Comment
     */
    public String getId_Comment() {
        return Id_Comment;
    }

    /**
     * @param Id_Comment the Id_Comment to set
     */
    public void setId_Comment(String Id_Comment) {
        this.Id_Comment = Id_Comment;
    }

    
}
