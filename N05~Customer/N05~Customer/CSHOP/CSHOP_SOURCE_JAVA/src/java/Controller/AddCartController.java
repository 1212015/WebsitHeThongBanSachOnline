/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ListOrder;
import DAO.ListProduct;
import POJO.OrderDetails;
import POJO.Orders;
import POJO.Products;
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
 * @author PQC
 */
@WebServlet(urlPatterns = { "/themvaogio" })
public class AddCartController extends HttpServlet {

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
            out.println("<title>Servlet AddCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCartController at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        try {
             // lấy ngày tháng năm hiện tại
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();
            String d1=dateFormat.format(date);
            
            //mã productid sản phẩm thêm vào
            String productid= request.getParameter("id");
            int id= Integer.parseInt(productid);
            ListProduct lp= new ListProduct();
            Products p= lp.Get(id);
            // tạo thong tin orderdetail
            OrderDetails od= new OrderDetails();
            od.setProductID(id);
          
            od.setQuantity(1);
            od.setIdOrderDetails(id);// khóa chính
            od.setDateAdded2(d1);
            od.setDateUpdated2(d1);
            od.setName(p.getName());// thêm tên sách
            od.setPublisher(p.getPublisher());// thêm nhà xuất bản
            od.setDiscount(p.getDiscount());
            double k=1-(p.getDiscount()*1.0/100);
            double m= p.getPrice()*k ;
            od.setPrice((int)m);
            od.setTotal((int)m);
           
           // thêm vào mảng tạm
           ArrayList<OrderDetails> tmp= (ArrayList<OrderDetails>) request.getSession().getAttribute("cart"); 
          
           if(IsExist(tmp,id)==false)// nếu sản phẩm chưa được thêm vô
                tmp.add(od);
          
           request.getSession().setAttribute("cart", tmp); 

            //chuyển đến giỏ hàng
//             response.setContentType("text/html;charset=UTF-8");
//            RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
//            rd.forward(request, response); 
              response.sendRedirect("/CSHOP_SOURCE_JAVA/giohang");
        } catch (SQLException ex) {
            Logger.getLogger(AddCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private boolean IsExist( ArrayList<OrderDetails> tmp, int id)
    {
        boolean b= false;
        for(OrderDetails o : tmp)
        {
            if(o.getProductID()==id)
            {
                b= true;
                break;
            }
        }
        return b;
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
