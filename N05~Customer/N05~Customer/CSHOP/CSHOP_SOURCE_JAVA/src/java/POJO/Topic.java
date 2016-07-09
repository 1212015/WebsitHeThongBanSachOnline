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

public class Topic implements java.io.Serializable {
    
    private int ID_Topic;
    private int UserID;
    private int Status;
    private Date DateAdded;
    private Date DateUpdated;

    public Topic (){
    }
    
    public Topic(int ID_Topic, int UserID, int Status, Date DateAdded, Date DateUpdated ){
        this.ID_Topic= ID_Topic;
        this.UserID= UserID;
        this.Status= Status;
        this.DateAdded= DateAdded;
        this.DateUpdated= DateUpdated;
        
    }
    /**
     * @return the ID_Topic
     */
    public int getID_Topic() {
        return ID_Topic;
    }
    
    /**
     * @param ID_Topic the ID_Topic to set
     */
    public void setID_Topic(int ID_Topic) {
        this.ID_Topic = ID_Topic;
    }

    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
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
