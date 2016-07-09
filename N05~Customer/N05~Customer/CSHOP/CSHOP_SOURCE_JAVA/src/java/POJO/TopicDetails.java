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
public class TopicDetails implements java.io.Serializable {
    private int ID_TopicDetails;
    private int TopicID;
    private String Detail;
    private String ShortDetail;
    private Date DateAdded;
    private Date DateUpdated;
    
    
    public TopicDetails(){
    }
    public TopicDetails(int ID_TopicDetails,int TopicID,String Detail, String ShortDetail, Date DateAdded, Date DateUpdated){
        this.ID_TopicDetails= ID_TopicDetails;
        this.TopicID=TopicID;
        this.Detail=Detail;
        this.ShortDetail=ShortDetail;
        this.DateAdded=DateAdded;
        this.DateUpdated=DateUpdated;
        
    }
    /**
     * @return the ID_TopicDetails
     */
    public int getID_TopicDetails() {
        return ID_TopicDetails;
    }

    /**
     * @param ID_TopicDetails the ID_TopicDetails to set
     */
    public void setID_TopicDetails(int ID_TopicDetails) {
        this.ID_TopicDetails = ID_TopicDetails;
    }

    /**
     * @return the TopicID
     */
    public int getTopicID() {
        return TopicID;
    }

    /**
     * @param TopicID the TopicID to set
     */
    public void setTopicID(int TopicID) {
        this.TopicID = TopicID;
    }

    /**
     * @return the Detail
     */
    public String getDetail() {
        return Detail;
    }

    /**
     * @param Detail the Detail to set
     */
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    /**
     * @return the ShortDetail
     */
    public String getShortDetail() {
        return ShortDetail;
    }

    /**
     * @param ShortDetail the ShortDetail to set
     */
    public void setShortDetail(String ShortDetail) {
        this.ShortDetail = ShortDetail;
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
