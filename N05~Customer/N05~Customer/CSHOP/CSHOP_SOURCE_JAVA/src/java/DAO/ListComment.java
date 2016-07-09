/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Comment;
import POJO.Products;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author PQC
 */
public class ListComment {
    // lấy thông tin một sản phẩm dựa vào ID
    public ArrayList<Comment> Get(int id) throws SQLException 
    {
        ArrayList<Comment> al= new ArrayList<>();       
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM Comment where ID_Product="+id+" Order by DateAdded";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
              Comment c= new Comment();
              c.setId_Users(rs.getInt("ID_Users"));
              c.setContent(rs.getString("Content"));
              c.setId_Product(rs.getInt("ID_Product"));      
              c.setId_Comment(rs.getString("ID_Comment"));
              c.setDateAdded(rs.getString("dateAdded"));
               
              al.add(c);
            }
        }
        return al;
    }
     //tạo bình luận mới
    public boolean Create(Comment c) throws SQLException
    {
        Connection con= DatabaseHelper.getConnection();
      
        if(con!=null)
        {
            String strSQL = "insert into Comment(ID_Users,ID_Product,Content,dateAdded,ID_Comment)"
                    + " values("+c.getId_Users()+","+c.getId_Product()+",N'"+c.getContent()+"','"+c.getDateAdded()+"',"+c.getId_Comment()+")";
            PreparedStatement ps = con.prepareStatement(strSQL);
           
         boolean n= ps.execute();
           if(n)
               return true;
          
        }
        return false;
    }
     //xoá bình luận 
    public boolean Delete(int ID_Users,String ID_Comment,int ID_Product) throws SQLException, ParseException
    {
         Connection con= DatabaseHelper.getConnection();
   
        if(con!=null)
        {
            String strSQL = " Delete from [OnlineSale].[dbo].[Comment] "
                    + " where ID_Users=? and ID_Comment=? and ID_Product=?  ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, ID_Users);
            ps.setString(2, ID_Comment);
            ps.setInt(3, ID_Product);
            
             boolean n= ps.execute();
            if(n)
                return true;
          
        }
        return false;
    }
    // lây số lượng comment
    public int Count(int ID_Users,int ID_Product) throws SQLException
    {
        int n=0;
        Connection con= DatabaseHelper.getConnection();      
        if(con!=null)
        {
            String strSQL = "SELECT * FROM Comment where ID_Product="+ID_Product+" and ID_Users="+ID_Users;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                n++;
            }
        }
        return n;
    }
}
