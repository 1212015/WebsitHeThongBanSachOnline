/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ListBookShelve;
import DAO.ListOrder;
import DAO.ListProduct;
import POJO.BookShelves;
import POJO.OrderDetails;
import POJO.Orders;
import POJO.Products;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LONGANH
 */
@WebServlet(urlPatterns = { "/themvaogiasach" })
public class AddBookCartController extends HttpServlet {

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
            out.println("<title>Servlet AddBookCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBookCartController at " + request.getContextPath() + "</h1>");
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
        try {
           
            ListBookShelve l= new ListBookShelve();
            //mã productid sản phẩm thêm vào
            String productid= request.getParameter("id");
            int id= Integer.parseInt(productid);
            String iduser1= request.getParameter("iduser");
            int iduser= Integer.parseInt(iduser1);
            ListProduct lp= new ListProduct();
            Products p= lp.Get(id);
            // tạo thong tin 
            BookShelves b= new BookShelves();
            b.setID_Products(id);
            b.setID_Users(iduser);
            b.setName_Products(p.getName());
            b.setPrice_Products(p.getPrice());
            // thêm vào mảng tạm
            l.AddBookShelve(b);
            //chuyển đến giá sách
          
            response.sendRedirect("/CSHOP_SOURCE_JAVA/giasach");
        } catch (SQLException ex) {
            Logger.getLogger(AddBookCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
