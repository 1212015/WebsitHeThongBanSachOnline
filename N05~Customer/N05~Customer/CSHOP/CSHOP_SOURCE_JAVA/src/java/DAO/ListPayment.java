/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Payments;
import POJO.PaymentMethods;
import POJO.PaymentStatuses;
import POJO.Users;
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
public class ListPayment {
     // lấy số lượng user hiện có
    public int Count() throws SQLException
    {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = " select Top 1 * from Payments Order by ID_Payments desc  ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_Payments");
            }
        }
        return n;
    }
    // thêm phương thức paymet
     public boolean Create(int ido) throws SQLException
    {
        boolean tmp= false;
        Connection con= DatabaseHelper.getConnection();
      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Payments ON  "
                    + " insert into Payments(ID_Payments,OrderID,PaymentMethodID,Status,DateAdded,DateUpdated) "
                    + " values (?,?,1,1,GETDATE(),GETDATE()) " 
                    + "  SET IDENTITY_INSERT Payments OFF ";
            PreparedStatement ps = con.prepareStatement(strSQL);
             ps.setInt(1,  Count()+1);
            ps.setInt(2, ido);
         
            
           ps.execute();
           tmp= true;
          
        }
        return tmp;
    }
     // lấy toàn bộ danh sách sản phẩm
    public ArrayList<Payments> GetAll() throws SQLException 
    {
        ArrayList<Payments> al= new ArrayList<>();       
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM Payments";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                Payments l= new Payments();
                l.setIdPayments(rs.getInt("ID_"));
                l.setOrderID(rs.getInt("OrderID"));
                l.setPaymentMethodID(rs.getInt("PaymentMethodID"));
                l.setStatus(rs.getInt("Status"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                al.add(l);
            }
            
        }
        else
        {
                al=null;
        }
       return al;
    }
    
    //  trạng thái thanh toán
    public String GetPaymentStatuses(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from PaymentStatuses where ID_PaymentStatuses="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Name");             
            }
        }
        return u;
    }
    
    //phương thức thanh toán
   public String GetPaymentMethods(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from PaymentMethods where ID_PaymentMethods="+id;
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
