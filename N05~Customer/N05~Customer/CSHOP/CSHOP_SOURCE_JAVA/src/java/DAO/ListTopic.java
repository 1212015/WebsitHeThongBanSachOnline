/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.Topic;
import POJO.TopicDetails;
import POJO.TopicStatuses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LONGANH
 */


public class ListTopic {
    
    // lấy toàn bộ danh sách các thắc mắc
    public ArrayList<Topic> GetAllTopic(int id) throws SQLException {
        ArrayList<Topic> al = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * FROM Topic where CategoryRID=" + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Topic l = new Topic();
                l.setID_Topic(rs.getInt("ID_Topic"));
                l.setUserID(rs.getInt("UserID"));
                l.setStatus(rs.getInt("Status"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                al.add(l);
            }

        } else {
            al = null;
        }
        return al;
    }
    
    // lấy toàn bộ danh sách chi tiết thắc mắc
    public ArrayList<TopicDetails> GetAllTopicDetails(int id) throws SQLException {
        ArrayList<TopicDetails> al = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * FROM TopicDetails where CategoryRID=" + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TopicDetails l = new TopicDetails();
                l.setID_TopicDetails(rs.getInt("ID_TopicDetails"));
                l.setTopicID(rs.getInt("TopicID"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                al.add(l);
            }

        } else {
            al = null;
        }
        return al;
    }
    
    //lấy IDTopic từ 
    public int ReturnIDTopic() throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();
        // tạo id cho TopicDetails
        Topic u=new Topic();
        int i=CountTopic();
        //kiểm tra sự tồn tại của Topic
        //if(IsExistTopic(u1.getID_Topic())==true)
           // return false;
        if(con!=null)
        {
            return i;
           
        }
        return 0;
    }
    //thêm mới topicdetail
    public boolean CreateTopicDetails(TopicDetails u) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();
        // tạo id cho TopicDetails
        u.setID_TopicDetails(Count()+1);
       
        //kiểm tra sự tồn tại của TopicDetails
        if(IsExist(u.getTopicID())==true)
            return false;
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT TopicDetails ON insert into TopicDetails(DateAdded,DateUpdated,"
                    + "ID_TopicDetails,TopicID,Detail,ShortDetail)"
                    + " values(GETDATE(),GETDATE(),?,?,?,?) SET IDENTITY_INSERT TopicDetails OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1,u.getID_TopicDetails());
            ps.setInt(2,u.getTopicID());
            ps.setString(3, u.getDetail());
            ps.setString(4,u.getShortDetail());
     
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
    
    //tạo mới một topic
    
    public boolean CreateTopic(Topic u1) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();
        // tạo id cho TopicDetails
        
        u1.setID_Topic(CountTopic()+1);
        //kiểm tra sự tồn tại của Topic
        //if(IsExistTopic(u1.getID_Topic())==true)
           // return false;
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Topic ON insert into Topic(ID_Topic,UserID,Status,"
                    + "DateAdded,DateUpdated)"
                    + " values(?,?,1,GETDATE(),GETDATE()) SET IDENTITY_INSERT Topic OFF";
            PreparedStatement ps1 = con.prepareStatement(strSQL);
            
            ps1.setInt(1, u1.getID_Topic());
            ps1.setInt(2, u1.getUserID());
            
         boolean n= ps1.execute();
           if(n)
               return true;
          
        }
        return false;
    }
    
    // số toppicdetails hiện tại
    public int Count() throws SQLException {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 *" +
            "  FROM [OnlineSale].[dbo].[TopicDetails] " +
            "  Order by ID_TopicDetails desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_TopicDetails");
                break;
            }
        }
     
        return n;
    }
    // số toppicdetails hiện tại
    public int CountTopic() throws SQLException {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 *" +
            "  FROM [OnlineSale].[dbo].[Topic] " +
            "  Order by ID_Topic desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_Topic");
                break;
            }
        }
     
        return n;
    }
     //kiểm tra xem topicdetails này đã tồn tại hay chưa
    public boolean IsExist(int id) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from TopicDetails where  ID_TopicDetails="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }          
        }
        return false;
    }
    //kiểm tra xem topic này đã tồn tại hay chưa
    public boolean IsExistTopic(int id) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from TopicDetails where  ID_Topic="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }          
        }
        return false;
    }
    
}
