/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngularController;

import Controller.AddBookCartController;
import DAO.ListBookShelve;
import DAO.ListProduct;
import POJO.BookShelves;
import POJO.ClassifyOwnDetails;
import POJO.Products;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PQC
 */
public class AddBookToClassifyOwnNgController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddBookToClassifyOwnNgController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBookToClassifyOwnNgController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean tmp= true;
       try {
           
            ListBookShelve l= new ListBookShelve();
            //mã productid sản phẩm thêm vào
            String productid= request.getParameter("id");
            int id = Integer.parseInt(productid);
            String iduser1= request.getParameter("iduser");
            int iduser= Integer.parseInt(iduser1);
            String idclass1= request.getParameter("idclass");
            int idclass= Integer.parseInt(idclass1);
            ListProduct lp= new ListProduct();
            
            Products p= lp.Get(id);
            // tạo thong tin 
           ClassifyOwnDetails c= new ClassifyOwnDetails();
           c.setID_Classify(idclass);
           c.setID_Products(id);
           c.setID_Users(iduser);
           c.setName_Products(p.getName());
           c.setPrice_Products(p.getPrice());
            // thêm vào phân loại riêng
            l.AddClassifyOwnDetails(c);
            //xóa khỏi giá sách
            l.DeleteBookShelve(iduser, id);
            
            //chuyển đến giá sách
          
           
        } catch (SQLException ex) {
            tmp=false;
            Logger.getLogger(AddBookToClassifyOwnNgController.class.getName()).log(Level.SEVERE, null, ex);
        }
       String json = new Gson().toJson(tmp);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
