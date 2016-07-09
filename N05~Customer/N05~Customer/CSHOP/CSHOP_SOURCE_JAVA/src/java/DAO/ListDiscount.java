/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Discounts;
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
public class ListDiscount {
    
    //lấy danh sách khách hàng giảm giá
    public ArrayList<Discounts> GetDiscounts() throws SQLException
    {
        ArrayList<Discounts> o= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Discounts";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
                 Discounts tmp= new Discounts();
                 tmp.setDateAdded(rs.getDate("DateAdded"));
                 tmp.setDateUpdated(rs.getDate("DateUpdated"));
                 tmp.setIdDiscounts(rs.getInt("ID_Discounts"));
                 tmp.setUserCategoryID(rs.getInt(("UserCategoryID")));
                 tmp.setDiscount(rs.getFloat("Discount"));
                 o.add(tmp);
            }
        }
        return o;
    }
    

   
    //lấy thông tin khách hàng giảm giá cụ thể
    public Discounts GetDiscounts(int id) throws SQLException
    {
   
        
        Discounts u= new Discounts();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Discounts where ID_Discounts="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {                            
               u.setIdDiscounts(rs.getInt("ID_Discount"));
               u.setUserCategoryID(rs.getInt(("UserCategoryID")));
               u.setDiscount(rs.getFloat("Discount"));
               u.setDateAdded(rs.getDate("DateAdded"));
               u.setDateUpdated(rs.getDate("DateUpdated"));
            }
        }
        return u;
    }
    
}
