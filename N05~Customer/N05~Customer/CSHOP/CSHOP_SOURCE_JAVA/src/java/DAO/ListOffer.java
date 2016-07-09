/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.OfferDetails;
import POJO.Offers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PQC
 */
public class ListOffer {
    // danh sách khuyến mãi
   //danh sach khuyen mai
    public ArrayList<Offers> GetAllOffer() throws SQLException
    {
        ArrayList<Offers> o= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL =  "SELECT * FROM Offers  Order by DateAdded desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
                 Offers tmp= new Offers();
                  tmp.setDateAdded(rs.getDate("DateAdded"));
                 tmp.setDateUpdated(rs.getDate("DateUpdated"));
                 tmp.setName(rs.getString("Name"));
                 tmp.setEndDate(rs.getDate("EndDate"));
                 tmp.setIdOffers(rs.getInt("ID_Offers"));
                 tmp.setStartDate(rs.getDate("StartDate"));
                 tmp.setStatus(rs.getInt("Status"));
                 o.add(tmp);
            }
        
       } else {
            o = null;
        }
        return o;
    }
    // chi tiết một khuyến mãi
    public ArrayList<OfferDetails> GetOfferDetail(int id) throws SQLException
    {
       ArrayList<OfferDetails> a= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from OfferDetails where OfferID="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {      
               OfferDetails o= new OfferDetails();
               o.setDateAdded(rs.getDate("DateAdded"));
               o.setDateUpdated(rs.getDate("DateUpdated"));
               o.setIdOfferDetails(rs.getInt("ID_OfferDetails"));
               o.setOfferID(rs.getInt("OfferID"));
               o.setDiscount(rs.getFloat("Discount"));
               o.setProductID(rs.getInt("ProductID"));
               o.setUserCategoryID(rs.getInt("UserCategoryID"));
               a.add(o);
            }
        }
        return a;
    }
    // trạng thái của khuyến mãi
    public String GetOfferStatus(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from OfferStatuses where ID_OfferStatuses="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Name");             
            }
        }
        return u;
    }
}
