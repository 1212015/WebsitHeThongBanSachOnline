/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author LONGANH
 */
import java.util.Date;
public class TopicStatuses implements java.io.Serializable {
    private int ID_UserStatuses;
    private String Name;
    private Date DateAdded;
    private Date DateUpdated;
    
    public TopicStatuses(){
    }
    public TopicStatuses(int ID_UserStatuses, String Name, Date DateAdded, Date DateUpdated){
        this.ID_UserStatuses = ID_UserStatuses;
        this.Name=Name;
        this.DateAdded=DateAdded;
        this.DateUpdated=DateUpdated;
    }

    /**
     * @return the ID_UserStatuses
     */
    public int getID_UserStatuses() {
        return ID_UserStatuses;
    }

    /**
     * @param ID_UserStatuses the ID_UserStatuses to set
     */
    public void setID_UserStatuses(int ID_UserStatuses) {
        this.ID_UserStatuses = ID_UserStatuses;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the DateAdded
     */
    public Date getDateAdded() {
        return DateAdded;
    }

    /**
     * @param DateAdded the DateAdded to set
     */
    public void setDateAdded(Date DateAdded) {
        this.DateAdded = DateAdded;
    }

    /**
     * @return the DateUpdated
     */
    public Date getDateUpdated() {
        return DateUpdated;
    }

    /**
     * @param DateUpdated the DateUpdated to set
     */
    public void setDateUpdated(Date DateUpdated) {
        this.DateUpdated = DateUpdated;
    }
}
