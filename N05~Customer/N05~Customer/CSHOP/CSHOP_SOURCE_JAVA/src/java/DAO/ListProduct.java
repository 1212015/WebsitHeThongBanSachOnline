/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ProductCategoriesRoot;
import POJO.ProductCategoriesSub;
import POJO.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PQC
 */
public class ListProduct {

    
    // lấy toàn bộ danh sách sản phẩm
    public ArrayList<Products> GetAll(int id) throws SQLException {
        ArrayList<Products> al = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * FROM Products where CategoryRID=" + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products l = new Products();
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
                al.add(l);
            }

        } else {
            al = null;
        }
        return al;
    }

    // lấy thông tin một sản phẩm dựa vào ID
    public Products Get(int id) throws SQLException {
        Products l = new Products();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * FROM Products where ID_Products = " + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
            }
            return l;
        }

        return null;
    }

    //cập nhật thông tin sản phẩm
    public boolean UpdateCout(int id, int countview) throws SQLException {
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SET IDENTITY_INSERT Products ON "
                    + "UPDATE  Products SET Count= ? WHERE ID_Products= ? "
                    + "SET IDENTITY_INSERT Products OFF";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, countview);
            ps.setInt(2, id);
            boolean n = ps.execute();
            if (n) {
                return true;
            }

        }
        return false;
    }

    // tìm kiếm sản phẩm
    public ArrayList<Products> Search(String keyword,int lsp) throws SQLException {
        ArrayList<Products> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL="";
            if(lsp==0)
                strSQL = "SELECT * from Products where  Name like N'%" + keyword + "%' ";
            else
                strSQL = "SELECT * from Products where  Name like N'%" + keyword + "%' and CategoryRID="+lsp;
                   
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products l = new Products();
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                   int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
                p.add(l);
            }
            return p;
        }
        return null;
    }

    //HÀM MỚI THÊM
    // danh sách sản phẩm gốc Ví dụ SmartPhone
    public ArrayList<ProductCategoriesRoot> ProductRoot() throws SQLException {
        ArrayList<ProductCategoriesRoot> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * from ProductCategoriesRoot ";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategoriesRoot tmp = new ProductCategoriesRoot();
                tmp.setDateAdded(rs.getDate("DateAdded"));
                tmp.setDateUpdated(rs.getDate("DateUpdated"));
                tmp.setIdProductCategoriesRoot(rs.getInt("ID_ProductCategoriesRoot"));
                tmp.setName(rs.getString("Name"));
                p.add(tmp);
            }
        } else {
            return null;
        }
        return p;
    }

    //danh sách sản phảm con Ví dụ SamSung, Apple
    public ArrayList<ProductCategoriesSub> GetProductSub(int idR) throws SQLException {
        ArrayList<ProductCategoriesSub> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * from ProductCategoriesSub where RID=" + idR;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategoriesSub tmp = new ProductCategoriesSub();
                tmp.setDateAdded(rs.getDate("DateAdded"));
                tmp.setDateUpdated(rs.getDate("DateUpdated"));
                tmp.setDetail(rs.getString("Detail"));
                tmp.setIdProductCategoriesSub(rs.getInt("ID_ProductCategoriesSub"));
                tmp.setName(rs.getString("Name"));
                tmp.setImage(rs.getString("Image"));
                tmp.setProductCategoriesRootID(rs.getInt("RID"));
                tmp.setShortDetail(rs.getString("ShortDetail"));
                p.add(tmp);

            }

        } else {
            return null;
        }
        return p;
    }

    // danh sách 5 sách bán chạy nhất
    public ArrayList<Products> Top6BestSellerBook() throws SQLException {
        ArrayList<Products> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT  [ProductID],[Quantity] "
                    + "FROM [OnlineSale].[dbo].[OrderDetails] "
                    + "ORDER BY [Quantity] desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            // mảng danh sách sản phẩm bán chạy
            ArrayList<Integer> tmp = new ArrayList<>();
            while (rs.next()) {

                int i = rs.getInt("ProductID");
                if (tmp.contains(i) == false) {
                    tmp.add(i);
                }
                if (tmp.size() == 6)// nếu đủ 5 sản phẩm thì dừng
                {
                    break;
                }

            }
            // lấy thông tin sản phẩm
            for (int i : tmp) {
                p.add(Get(i));
            }
        }
        return p;
    }

    // danh sách 5 sách mới bán
    public ArrayList<Products> Top5RecentSellerBook() throws SQLException {
        ArrayList<Products> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = " SELECT TOP 5 * "
                    + "  FROM [OnlineSale].[dbo].[Products] "
                    + "  ORDER BY [DateAdded] desc";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products l = new Products();
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
                p.add(l);
            }

        }
        return p;
    }
    // lấy tình trạng sản phẩm dựa vào id

    public String StatusOfProduct(int id) throws SQLException {
        String s = "";
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT * FROM ProductStatuses where ID_ProductStatuses=" + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = rs.getString("Name");
            }
        }
        return s;
    }
    // danh sách sản phẩm liên quan 

    public ArrayList<Products> GetRelateBook(int rid, int sid) throws SQLException {
        ArrayList<Products> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "SELECT TOP 5 *"
                    + " FROM [OnlineSale].[dbo].[Products]"
                    + " Where  [CategoryRID] =" + rid + "and [CategorySID]= " + sid;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products l = new Products();
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                   int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
                p.add(l);
            }

        }
        return p;
    }
// lấy toàn bộ tên sản phẩm
    public List<String> GetAllData() throws SQLException
    {
        ArrayList<String> l=  new ArrayList<>();
         Connection con = DatabaseHelper.getConnection();
        if (con != null) 
        {
            String strSQL = "SELECT * FROM Products Order by Name asc " ;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(rs.getString("Name"));
            }
        }
        return l;
    
    }
    // lấy toàn bộ tên nhà xuất bản
    public ArrayList<Products> GetAllPublisher() throws SQLException
    {
        ArrayList<Products> l=  new ArrayList<>();
         Connection con = DatabaseHelper.getConnection();
        if (con != null) 
        {
            String strSQL = "SELECT  distinct [Publisher] " +
            "FROM [OnlineSale].[dbo].[Products] " +
            "Order by [Publisher] asc " ;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products p= new Products();
                p.setPublisher(rs.getString("Publisher"));
                l.add(p);
            }
        }
        return l;
    
    }
    // tìm kiếm sản phẩm
    public ArrayList<Products> AdvanceSearch(String strSQL) throws SQLException {
        ArrayList<Products> p = new ArrayList<>();
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
                               
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products l = new Products();
                l.setIdProducts(rs.getInt("ID_Products"));
                l.setName(rs.getString("Name"));
                l.setPrice(rs.getInt("Price"));
                l.setCategoriesRootID(rs.getInt("CategoryRID"));
                l.setCategoriesSubID(rs.getInt("CategorySID"));
                l.setImage(rs.getString("Image"));
                l.setStatus(rs.getInt("Status"));
                l.setDetail(rs.getString("Detail"));
                l.setShortDetail(rs.getString("ShortDetail"));
                l.setBarCode(rs.getString("BarCode"));
                l.setTitle(rs.getString("Title"));
                l.setAuthor(rs.getString("Author"));
                l.setArtist(rs.getString("Artist"));
                l.setYear(rs.getString("Year"));
                l.setCompany(rs.getString("Company"));
                l.setPublisher(rs.getString("Publisher"));
                l.setSize(rs.getString("Size"));
                l.setPages(rs.getString("Pages"));
                l.setLocation(rs.getString("Location"));
                l.setQuantity(rs.getInt("Quantity"));
                l.setCount(rs.getInt("Count"));
                l.setDateAdded(rs.getDate("DateAdded"));
                l.setDateUpdated(rs.getDate("DateUpdated"));
                int n= GetDiscountByID(l.getIdProducts());
                l.setDiscount(n);
                p.add(l);
            }
            return p;
        }
        return null;
    }
   // lấy phần trăm khuyến mãi của sản phẩm
    public int GetDiscountByID(int id) throws SQLException
    {
        int n=0;
        Connection con = DatabaseHelper.getConnection();
        if (con != null) {
            String strSQL = "Select * FROM [OnlineSale].[dbo].[OfferDetails] " +
            "  where [OfferID] in ( Select [ID_Offers] from [OnlineSale].[dbo].[Offers] " +
            "  where [EndDate]>=GETDATE() and GETDATE()>=[StartDate]) and [ProductID]=" + id;
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n= (int)rs.getInt("Discount");
            }
        }
        return n;
    }
}
