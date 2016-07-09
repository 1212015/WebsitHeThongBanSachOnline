/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Cards;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LONGANH
 */
public class ListCard {
    
    //danh sách Cash
    
    public ArrayList<Cards> GetCards() throws SQLException
    {
        ArrayList<Cards> o= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Cards";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
                 Cards tmp= new Cards();
                 tmp.setDateAdded(rs.getDate("DateAdded"));
                 tmp.setDateUpdated(rs.getDate("DateUpdated"));
                 tmp.setPaymentID(rs.getInt("PaymentID"));
                 tmp.setCardNumber(rs.getString("CardNumber"));
                 tmp.setcSC(rs.getString("CSC"));
                 tmp.setExpiryDate(rs.getDate("ExpiryDate"));
                 o.add(tmp);
            }
        }
        return o;
    }
    
    //Chi tiết thông tin thẻ khách hàng
    public Cards GetCards(int id) throws SQLException
    {
       Cards o= new Cards();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Cards where PaymentID="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               
               o.setPaymentID(rs.getInt("PaymentID"));
               o.setCardNumber(rs.getString("CardNumber"));
               o.setcSC(rs.getString("CSC"));
               o.setExpiryDate(rs.getDate("ExpiryDate"));
               o.setDateAdded(rs.getDate("DateAdded"));
               o.setDateUpdated(rs.getDate("DateUpdated"));
            }
        }
        return o;
    }
}
