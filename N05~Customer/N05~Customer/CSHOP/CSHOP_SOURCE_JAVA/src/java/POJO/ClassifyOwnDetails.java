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
public class ClassifyOwnDetails {

    private int ID_Classify;
    private int ID_Users;
    private int ID_Products;
    private String Name_Products;
    private int Price_Products;

    /**
     * @return the ID_Classify
     */
    public int getID_Classify() {
        return ID_Classify;
    }

    /**
     * @param ID_Classify the ID_Classify to set
     */
    public void setID_Classify(int ID_Classify) {
        this.ID_Classify = ID_Classify;
    }

    /**
     * @return the ID_Users
     */
    public int getID_Users() {
        return ID_Users;
    }

    /**
     * @param ID_Users the ID_Users to set
     */
    public void setID_Users(int ID_Users) {
        this.ID_Users = ID_Users;
    }

    /**
     * @return the ID_Products
     */
    public int getID_Products() {
        return ID_Products;
    }

    /**
     * @param ID_Products the ID_Products to set
     */
    public void setID_Products(int ID_Products) {
        this.ID_Products = ID_Products;
    }

    /**
     * @return the Name_Products
     */
    public String getName_Products() {
        return Name_Products;
    }

    /**
     * @param Name_Products the Name_Products to set
     */
    public void setName_Products(String Name_Products) {
        this.Name_Products = Name_Products;
    }

    /**
     * @return the Price_Products
     */
    public int getPrice_Products() {
        return Price_Products;
    }

    /**
     * @param Price_Products the Price_Products to set
     */
    public void setPrice_Products(int Price_Products) {
        this.Price_Products = Price_Products;
    }
}
