/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.UserCategories;
import POJO.UserStatuses;
import POJO.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PQC
 */
public class ListUser {
    //kiểm tra đăng nhập
    public boolean Login(String email, String pass) throws SQLException
    {
       
        boolean tmp=false;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM Users where Email = '"+email+"' and Password='"+pass+"'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            int n=0;
            while(rs.next())
            {
                n++;
            }
            if(n==1)
                tmp=true;
        }
        return tmp;
    }
    //lấy thông tin user dựa vào email
    public Users Get(String email) throws SQLException
    {
        Users u= new Users();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users where Email = '"+email+"'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                u.setIdUsers(rs.getInt("ID_Users"));
                u.setAddress(rs.getString("Address"));
                u.setBirthday(rs.getDate("Birthday"));
                u.setDateAdded(rs.getDate("DateAdded"));
                u.setDateUpdated(rs.getDate("DateUpdated"));
                u.setEmail(rs.getString("Email"));
                u.setFirstName(rs.getString("FirstName"));
                u.setGender(rs.getString("Gender"));
                u.setIdUsers(rs.getInt("ID_Users"));
                u.setLastName(rs.getString("LastName"));
                u.setPassword(rs.getString("Password"));
                u.setPhone(rs.getString("Phone"));
                u.setPoint(rs.getInt("Point"));
                u.setStatus(rs.getInt("Status"));
                u.setUserCategoryID(rs.getInt("Category"));
            }
        }
        return u;
    }
    // //lấy thông tin user dựa vào ID_Users
    public Users GetbyId(int id) throws SQLException
    {
        Users u= new Users();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users where ID_Users = "+id+"";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                u.setIdUsers(rs.getInt("ID_Users"));
                u.setAddress(rs.getString("Address"));
                u.setBirthday(rs.getDate("Birthday"));
                u.setDateAdded(rs.getDate("DateAdded"));
                u.setDateUpdated(rs.getDate("DateUpdated"));
                u.setEmail(rs.getString("Email"));
                u.setFirstName(rs.getString("FirstName"));
                u.setGender(rs.getString("Gender"));
                u.setIdUsers(rs.getInt("ID_Users"));
                u.setLastName(rs.getString("LastName"));
                u.setPassword(rs.getString("Password"));
                u.setPhone(rs.getString("Phone"));
                u.setPoint(rs.getInt("Point"));
                u.setStatus(rs.getInt("Status"));
                u.setUserCategoryID(rs.getInt("Category"));
            }
        }
        return u;
    }
    //tạo tài khoản mới
    public boolean Create(Users u) throws SQLException
    {
        boolean tmp= false;
        Connection con= DatabaseHelper.getConnection();
        // tạo id cho user
        u.setIdUsers(Count()+1);
        //kiểm tra sự tồn tại của tài khoản
        if(IsExist(u.getEmail())==true)
            tmp= false;
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Users ON insert into Users(ID_Users,Email,Password,FirstName,"
                    + "LastName,Gender,Birthday,Phone,Address,Status,Point,Category,DateAdded,DateUpdated)"
                    + " values(?,?,?,?,?,?,GETDATE(),?,?,?,?,?,GETDATE(),GETDATE())  SET IDENTITY_INSERT Users OFF ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            
            ps.setInt(1, u.getIdUsers());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getFirstName());
            ps.setString(5,u.getLastName());
            ps.setString(6,u.getGender());
         
            ps.setString(7,u.getPhone());
            ps.setString(8,u.getAddress());
            ps.setInt(9, u.getStatus());
            ps.setInt(10, u.getPoint());
            ps.setInt(11, u.getUserCategoryID());
            
           ps.execute();
           tmp= true;
          
        }
        return tmp;
    }
  
    // xóa tài khoản
    public boolean StatusUser(String email ,int status) throws SQLException
    {
          //kiểm tra sự tồn tại của tài khoản
        if(IsExist(email)==false)
            return false;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Users ON "
                    + " update  Users set Status=? where Email=?) "
                    + "SET IDENTITY_INSERT Users OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);         
            ps.setInt(1,status);
            ps.setString(2,email);
            int n= ps.executeUpdate();
            if(n==1)
               return true;
           
        }
        return false;
    }
    // kiểm tra id_users có tồn tại hay chưa
    public boolean IsExist(String email) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users where Email = '"+email+"'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }          
        }
        return false;
    }
    // lấy số lượng user hiện có
    public int Count() throws SQLException
    {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n++;
            }
        }
        return n;
    }
    //HÀM MỚI THÊM
    // bảng trạng thái của tài khoản
    public ArrayList<UserStatuses> GetUserStatus() throws SQLException
    {
        ArrayList<UserStatuses> u= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from UserStatuses";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
               UserStatuses tmp= new UserStatuses();
               tmp.setDateAdded(rs.getDate("DateAdded"));
               tmp.setDateUpdated(rs.getDate("DateUpdated"));
               tmp.setName(rs.getString("Name"));
               tmp.setIdUserStatuses(rs.getInt("ID_UserStatuses"));
               u.add(tmp);
            }
        }
        return u;
    }
    // trạng thái của một tài khoản
     public String GetUserStatus(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from UserStatuses where ID_UserStatuses="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Name");             
            }
        }
        return u;
    }
    // danh sách phân loại tài khoản
     public ArrayList<UserCategories> GetUserCategory() throws SQLException
    {
        ArrayList<UserCategories> u= new ArrayList<>();
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from UserCategories";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
               UserCategories tmp= new UserCategories();
               tmp.setIdUserCategories(rs.getInt("ID_UserCategories"));
               tmp.setMinPoint(rs.getInt("MinPoint"));
               tmp.setDateAdded(rs.getDate("DateAdded"));
               tmp.setDateUpdated(rs.getDate("DateUpdated"));
               tmp.setName(rs.getString("Name"));
               u.add(tmp);
            }
        }
        return u;
    }
     // loại tài khoản một tài khoản
      public String GetUserCategory(int id) throws SQLException
    {
        String u="";
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from UserCategories where ID_UserCategories="+id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               u=rs.getString("Name");             
            }
        }
        return u;
    }
      public int GetDiscountPercentByID(int id) throws SQLException
      {
          int n=0;
          Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "Select * from Discounts " +
                "  where UserCategoryID in " +
                "  (Select Category from Users where ID_Users="+id+")";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {             
               n=rs.getInt("Discount");
            }
        }
        return n;
      }
      //
      // cập nhật thông tin tài khoản theo mã khách hàng 
    public boolean Update(Users u) throws SQLException
    {   
          //kiểm tra sự tồn tại của tài khoản
        if(IsExist(u.getEmail())==false)
            return false;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Users ON "
                    + "UPDATE  Users SET  FirstName= ?, LastName= ?"
                    + " , Gender= ? , Birthday= ?" + " , Phone= ?"+ " , Address= ?"
                    + " , DateUpdated= GETDATE()"+ " WHERE ID_Users= ? "
                    + "SET IDENTITY_INSERT Users OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);   
           
            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getBirthday2());
            ps.setString(5, u.getPhone());
            ps.setString(6, u.getAddress());
            ps.setInt(7, u.getIdUsers());        
           boolean n= ps.execute();
           if(n)
               return true;
          
      }
        return false;
    }

// kiểm tra cập nhật mật khẩu theo mã khách hàng 
    public boolean CheckUpdatePassword(Users u) throws SQLException
    {   
          //kiểm tra sự tồn tại của tài khoản
        
       Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users where ID_Users = "+u.getIdUsers()+"and Password ='"+u.getPassword()+"'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }          
        }
        return false;
    }
    //  cập nhật mật khẩu theo mã khách hàng 
    public boolean UpdatePassword(Users u) throws SQLException
    {   
          Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SET IDENTITY_INSERT Users ON "
                    + "UPDATE  Users SET  Password= ?"
                    + " , DateUpdated= GETDATE()"+ " WHERE ID_Users= ? "
                    + "SET IDENTITY_INSERT Users OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);   
           
            ps.setString(1, u.getPassword());
            ps.setInt(2, u.getIdUsers());
                  
           boolean n= ps.execute();
           if(n)
               return true;
          
      }
        return false;
    }
//lấy mật khẩu khách hàng
    public String GetMatKhau(Users u) throws SQLException
    {   
          Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select Password from Users where Email = '"+u.getEmail()+"'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                String n=rs.getString("Password");
                return n;
            }  
            return null;
        }
        return null;
    }

//kiểm tra email đã tồn tại hay chưa:
    public boolean IsExistEmail(String email) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "select * from Users where Email = '"+email+"'";
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
