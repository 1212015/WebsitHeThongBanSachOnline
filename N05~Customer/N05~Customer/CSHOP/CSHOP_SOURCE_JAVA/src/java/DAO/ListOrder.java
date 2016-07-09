/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Orders;
import POJO.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PQC
 */
public class ListOrder {
    
    // lấy thông tin đơn hàng
    public  ArrayList<Orders> GetOrder(int id) throws SQLException
    {
        ArrayList< Orders> o= new  ArrayList<>();
      
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Orders where UserID="+id+" Order by DateAdded";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {                      
                Orders u= new Orders();
                u.setDateAdded(rs.getDate("DateAdded"));
                int ido=rs.getInt("ID_Orders");
                u.setIdOrders(ido);
                u.setUserID(TotalOneOrder(ido)); // tổng tiền
                int status=rs.getInt("Status");
                u.setShipPhone(GetOrderStatus(status));// tình trạng                  
              
                o.add(u);
            }
        }
        return o;
    }
    public int TotalOneOrder(int id) throws SQLException
    {
        int s=0;
         Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from OrderDetails where OrderID="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {     
              s+= rs.getInt("Price");
            }   
        }
        return s;
    }
    //lấy id Order dựa vào id User
    public int GetIdOrderbyIdUser(int id) throws SQLException
    {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 * " +
            "  FROM [OnlineSale].[dbo].[Orders]" +
            "  where UserID="+id +
            "  Order by DateAdded desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_Orders");
                break;
            }          
        }
        return n;
    }
    //thêm đơn hàng
     public boolean CreateOrder(Orders u) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();
        // tạo id cho user
        u.setIdOrders(Count()+1);
        //kiểm tra sự tồn tại của tài khoản
        if(IsExist(u.getIdOrders())==true)
            return false;
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Orders ON insert into Orders(DateAdded,DateUpdated,"
                    + "UserID,Status,ShipAddress,ShipName,ShipPhone,ShipDate,EmployeeID,DiscountID,ID_Orders)"
                    + " values(GETDATE(),GETDATE(),?,?,?,?,?,GETDATE(),1,?,?)  SET IDENTITY_INSERT Orders OFF ";
            PreparedStatement ps = con.prepareStatement(strSQL);
          
           
            ps.setInt(1,u.getUserID());
            ps.setInt(2,u.getStatus());               
            ps.setString(3, u.getShipAddress());
            ps.setString(4,u.getShipName());
            ps.setString(5,u.getShipPhone());
             
            ps.setInt(6,u.getDiscountID()); 
             ps.setInt(7,u.getIdOrders());  
           
           
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
    // sửa đơn hàng
      public boolean UpdateOrder(Orders u) throws SQLException
    {   
          //kiểm tra sự tồn tại của tài khoản
        if(IsExist(u.getIdOrders())==false)
            return false;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Orders ON "
                    + "UPDATE  Orders SET DateAdded=? ,DateUpdated=? ,"
                    + "DiscountID=? ,EmployeeID=? ,UserID=?,Status=? ,"
                    + "ShipAddress=? ,ShipName=? ,ShipPhone=? ,ShipDate=? WHERE ID_Orders= ? "
                    + "SET IDENTITY_INSERT Orders OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);   
            ps.setString(1,  u.getDateAdded2());
            ps.setString(2,  u.getDateUpdated2());   
            ps.setInt(3,u.getDiscountID());
            ps.setInt(4,u.getEmployeeID());
            ps.setInt(5,u.getUserID());
            ps.setInt(6,u.getStatus());               
            ps.setString(7, u.getShipAddress());
            ps.setString(8,u.getShipName());
            ps.setString(9,u.getShipPhone());             
            ps.setString(10,  u.getShipDate2());   
            ps.setInt(11,u.getIdOrders());
           boolean n= ps.execute();
           if(n)
               return true;
          
      }
        return false;
    }
    // hủy đơn hàng
    // kiểm tra đơn hàng có tồn tại hay chưa
    public boolean IsExist(int id) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Orders where  ID_Orders="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }          
        }
        return false;
    }
    // số đơn hàng hiện tại
    public int Count() throws SQLException {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 *" +
            "  FROM [OnlineSale].[dbo].[Orders] " +
            "  Order by ID_Orders desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_Orders");
                break;
            }
        }
     
        return n;
    }
    // đếm sô lượng dòng bảng OrderDetail hiện tại
     public int CountOrderDetail() throws SQLException {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 *" +
            "  FROM [OnlineSale].[dbo].[OrderDetails] " +
            "  Order by ID_OrderDetails desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_OrderDetails");
                break;
            }
        }
     
        return n;
    }
    //Mới viết, chưa test
    //xem chi tiết đơn đặt hàng
    public OrderDetails GetOrderDetails(int id) throws SQLException
    {
       OrderDetails o= new OrderDetails();
       
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from OrderDetails where ID_OrderDetails="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               o.setDateAdded(rs.getDate("DataAdded"));
               o.setDateUpdated(rs.getDate("DataUpdated"));
               o.setIdOrderDetails(rs.getInt("ID_OrderDetails"));
               o.setOrderID(rs.getInt("OrderID"));
               o.setPrice(rs.getInt("Price"));
               o.setProductID(rs.getInt("ProductID"));
               o.setQuantity(rs.getInt("Quantity"));
              
            }
        }
        return o;
    }
    //xem trạng thái đơn đặt hàng
    public String GetOrderStatus(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from OrderStatuses where ID_OrderStatuses="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Name");             
            }
        }
        return u;
    }
    // thêm chi tiết đơn hàng
    public boolean CreateOrderDetails(OrderDetails d) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();     
      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT OrderDetails ON "
                    + "insert into OrderDetails(ID_OrderDetails,OrderID,ProductID,Quantity,Price,DateAdded,DateUpdated) values" 
                    + " (?,?,?,?,?,GETDATE(),GETDATE()) "
                    + " SET IDENTITY_INSERT OrderDetails OFF ";
            PreparedStatement ps = con.prepareStatement(strSQL);
             ps.setInt(1,d.getIdOrderDetails());
            ps.setInt(2, d.getOrderID());
            ps.setInt(3, d.getProductID());
            ps.setInt(4, d.getQuantity());
            ps.setInt(5, d.getPrice());
           
           
            boolean n= ps.execute();
           if(n)
               return true;
        }
        return false;
    }
    // cập nhật chi tiết đơn hàng
     public boolean UpdateOrderDetails(OrderDetails d) throws SQLException
    {
       Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT OrderDetails ON "
                    + "UPDATE OrderDetails set OrderID=?,ProductID=?,Quantity=?,Price=?,DateAdded=?,DateUpdated=?" 
                    + " where ID_OrderDetails=? "
                    + " SET IDENTITY_INSERT OrderDetails OFF ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, d.getOrderID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getQuantity());
            ps.setInt(4, d.getPrice());
            ps.setString(5,d.getDateAdded2());
            ps.setString(6,d.getDateUpdated2());
            ps.setInt(7, d.getIdOrderDetails());
            boolean n= ps.execute();
           if(n)
               return true;
        }
        return false;
    }
    //xóa chi tiết đơn hàng
      public boolean DeleteOrderDetails(int id_detail) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "delete from OrderDetails where ID_OrderDetails="+id_detail;
            PreparedStatement ps = con.prepareStatement(strSQL);
            boolean n= ps.execute();
            if(n)
               return true;
        }
        return false;
    }
}
