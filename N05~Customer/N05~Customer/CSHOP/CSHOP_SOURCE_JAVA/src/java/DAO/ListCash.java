/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Cash;
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
public class ListCash {
    
    //danh sách Cash
    
    public ArrayList<Cash> GetCash() throws SQLException
    {
        ArrayList<Cash> o= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Cash";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
                 Cash tmp= new Cash();
                 tmp.setDateAdded(rs.getDate("DateAdded"));
                 tmp.setDateUpdated(rs.getDate("DateUpdated"));
                 tmp.setPaymentID(rs.getInt("PaymentID"));
                 tmp.setAddress(rs.getString("Address"));
                 o.add(tmp);
            }
        }
        return o;
    }
   
    
    
    //Xem địa chỉ giao hàng
    public String GetCash(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Cash where PaymentID="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Address");             
            }
        }
        return u;
    }
    
}
