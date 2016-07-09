/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.BookShelves;
import POJO.ClassifyOwn;
import POJO.ClassifyOwnDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PQC
 */
public class ListBookShelve {
    // đếm số lượng trong bảng ClassifyOwn
    public int CoutClassifyOwn() throws SQLException
    {
       int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT TOP 1 *" +
            "  FROM  ClassifyOwn " +
            "  Order by ID_Classify desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("ID_Classify");
                break;
            }
        }
     
        return n;
    }
     // lấy toàn bộ danh mục phân loại riêng
    public ArrayList<ClassifyOwn> GetAllClassifyOwn(int id) throws SQLException 
    {
        ArrayList<ClassifyOwn> al= new ArrayList<>();       
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM ClassifyOwn where ID_Users="+id+" Order by Name_Classify asc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
              ClassifyOwn c= new ClassifyOwn();
              c.setID_Classify(rs.getInt("ID_Classify"));
              c.setID_Users(rs.getInt("ID_Users"));
              c.setName_Classify(rs.getString("Name_Classify"));
              al.add(c);
            }
        }
        return al;
    }
    //tạo tên phân loại riêng
     public boolean AddClassifyOwn(ClassifyOwn b) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
      
        if(con!=null)
        {
            String strSQL = "insert into ClassifyOwn(ID_Users,Name_Classify,ID_Classify)"
                    + " values("+b.getID_Users()+",N'"+b.getName_Classify()+"',"+b.getID_Classify()+")";
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
    // xóa tên phân loại riêng
      public boolean DeleteClassifyOwn(int iduser, int idclass) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
   
        if(con!=null)
        {
            String strSQL = " Delete from [OnlineSale].[dbo].[ClassifyOwn] "
                    + " where ID_Users=?  and ID_Classify=? ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, iduser);
            ps.setInt(2, idclass);
            
             boolean n= ps.execute();
            if(n)
                return true;
          
        }
        return false;
    }
    //thêm sách vào Bookshelve
    public boolean AddBookShelve(BookShelves b) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
        if(CheckBookShelve(b.getID_Products(),b.getID_Users()))
            return false;
        if(con!=null)
        {
            String strSQL = "insert into BookShelves(ID_Users,ID_Products,Name_Products,Price_Products)"
                    + " values("+b.getID_Users()+","+b.getID_Products()+",N'"+b.getName_Products()+"',"+b.getPrice_Products()+")";
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
    //kiểm tra sách đã tồn tại hya chưa
    public boolean CheckBookShelve(int idproduct, int iduser) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
       boolean tmp= false;
        if(con!=null)
        {
            String strSQL = "select * from BookShelves where ID_Users="+iduser+" and ID_Products="+idproduct;
                  
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                tmp= true;
                break;
            }
          
        }
        return tmp;
    }
    //đếm số lượng dòng trong Bookshelve
   public ArrayList<BookShelves> GetAllBookShelve(int id) throws SQLException
   {
       ArrayList<BookShelves> al= new ArrayList<>();
       Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM BookShelves where ID_Users="+id+" Order by Name_Products asc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
              BookShelves c= new BookShelves();
              c.setID_Products(rs.getInt("ID_Products"));
              c.setID_Users(rs.getInt("ID_Users"));
              c.setName_Products(rs.getString("Name_Products"));
              c.setPrice_Products(rs.getInt("Price_Products"));
              al.add(c);
            }
        }
        return al;
   }
    //xóa sách khỏi Bookshelve
      public boolean DeleteBookShelve(int iduser, int idproduct) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
        if(CheckBookShelve(idproduct,iduser)==false)
            return false;
        if(con!=null)
        {
            String strSQL = " Delete from [OnlineSale].[dbo].[BookShelves] "
                    + " where ID_Users=?  and ID_Products=?  ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, iduser);
            ps.setInt(2, idproduct);
            
             boolean n= ps.execute();
            if(n)
                return true;
          
        }
        return false;
    }
    //thêm sách vào chi tiết phân loại riêng
       public boolean AddClassifyOwnDetails(ClassifyOwnDetails b) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
       if(CheckClassifyOwnDetails(b.getID_Products(),b.getID_Users(),b.getPrice_Products()))
           return false;
        if(con!=null)
        {
            String strSQL = "insert into ClassifyOwnDetails(ID_Users,ID_Products,Name_Products,Price_Products,ID_Classify)"
                    + " values("+b.getID_Users()+","+b.getID_Products()+",N'"+b.getName_Products()+"',"+b.getPrice_Products()+","+b.getID_Classify()+")";
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
       //kiểm tra sách đã tồn tại hya chưa
    public boolean CheckClassifyOwnDetails(int idproduct, int iduser,int idclass) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
       boolean tmp= false;
        if(con!=null)
        {
            String strSQL = "select * from ClassifyOwnDetails where ID_Users="+iduser+" and ID_Products="+idproduct+" and ID_Classify="+idclass;
                  
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                tmp= true;
                break;
            }
          
        }
        return tmp;
    }
    //xóa sách khỏi chi tiết phân loại riêng
      public boolean DeleteClassifyOwnDetails(int iduser, int idproduct, int idclass) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
   
        if(con!=null)
        {
            String strSQL = " Delete from [OnlineSale].[dbo].[ClassifyOwnDetails] "
                    + " where ID_Users=?  and ID_Products=? and ID_Classify=? ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, iduser);
            ps.setInt(2, idproduct);
            ps.setInt(3, idclass);
            
             boolean n= ps.execute();
            if(n)
                return true;
          
        }
        return false;
    }
       // lấy danh sách sách trong 1 phân loại riêng
      public ArrayList<ClassifyOwnDetails> GetAllClassifyOwnDetails(int iduser, int idclass) throws SQLException
      {
           ArrayList<ClassifyOwnDetails> al= new ArrayList<>();
       Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM ClassifyOwnDetails where ID_Users="+iduser+" and ID_Classify="+idclass
                    +" Order by Name_Products asc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
              ClassifyOwnDetails c= new ClassifyOwnDetails();
              c.setID_Classify(rs.getInt("ID_Classify"));
              c.setID_Products(rs.getInt("ID_Products"));
              c.setID_Users(rs.getInt("ID_Users"));
              c.setName_Products(rs.getString("Name_Products"));
              c.setPrice_Products(rs.getInt("Price_Products"));
              al.add(c);
            }
        }
        return al;
      }
      // xóa toàn bộ phân loại riêng
       public boolean DeleteAllClassifyOwnDetails(int iduser,  int idclass) throws SQLException
    {
         Connection con= DatabaseHelper.getConnection();
   
        if(con!=null)
        {
            String strSQL = " Delete from [OnlineSale].[dbo].[ClassifyOwnDetails] "
                    + " where ID_Users=?  and ID_Classify=? ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, iduser);
           
            ps.setInt(2, idclass);
            
             boolean n= ps.execute();
            if(n)
                return true;
          
        }
        return false;
    }
}
