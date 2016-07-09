/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ListOrder;
import DAO.ListPayment;
import POJO.OrderDetails;
import POJO.Orders;
import DAO.ListUser;
import DAO.SendMail;
import POJO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/thongbao"})
public class NotifyController extends HttpServlet {

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
            out.println("<title>Servlet NotifyController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotifyController at " + request.getContextPath() + "</h1>");
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
        ListOrder l= new  ListOrder();
        //
         request.setCharacterEncoding("UTF-8");
          String hoten= request.getParameter("hoten");
          String id1= request.getParameter("id");
          int id= Integer.parseInt(id1);//iduser
          String diachi= request.getParameter("diachi");
          String sdt= request.getParameter("sdt");
          
        //ghi thông tin vào bảng Order
        ListUser lu= new ListUser();
        Users u1=null;
        try {
            u1= lu.GetbyId(id);
        } catch (SQLException ex) {
            Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        Orders u= new Orders();
        u.setShipAddress(diachi);
        u.setShipPhone(sdt);
        u.setUserID(id);
        u.setShipName(hoten);
        u.setStatus(2);// trạng thái đơn hàng
        u.setDiscountID(u1.getUserCategoryID());// loại tài khoản giảm giá
        try {
            l.CreateOrder(u);
        } catch (SQLException ex) {
            Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ghi thông tin vào bảng Order Detail
        int n=0;//id order
        try {
            
             n=l.GetIdOrderbyIdUser(id);
             
        } catch (SQLException ex) {
            Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ArrayList<OrderDetails> tmp = (ArrayList<OrderDetails>) request.getSession().getAttribute("cart");
        for(OrderDetails od1: tmp )
        {
            od1.setOrderID(n);
            try {
                int sl=l.CountOrderDetail()+1;// mã id của OrderDetail
                od1.setIdOrderDetails(sl);
                l.CreateOrderDetails(od1);
            } catch (SQLException ex) {
                Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // ghi thông tin vào bảng Payment
        ListPayment lp2= new ListPayment();
        try {
            lp2.Create(n);
        } catch (SQLException ex) {
            Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //gửi email 
         String to = u1.getEmail();
        String subject = "Don hang ";
          String message = "Cac san pham khach  hang "+hoten+" da mua. ";
        int k2=0;
        int tt=0;
        for(OrderDetails od1: tmp)
        {
            k2++;
            String ten= od1.getName();
            String gia= ""+od1.getPrice();
            String tongtien=""+ od1.getTotal();
            String sl=""+od1.getQuantity();
            String dh= k2+". "+ten+"_don gia: "+gia+"_so luong: "+sl+"_thanh tien: "+tongtien;
            message+=dh;
            tt+= od1.getTotal();
            
        }
        int n11=0;
        try {
             n11=lu.GetDiscountPercentByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(NotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
         double k=(n11*1.0/100);
         double tt2= tt*(1-k);
         int tt3= (int)tt2;
        message+="Tong gia tri don hang la: "+tt3;
        message+=" Don hang se duoc giao tai dia chi: "+diachi;

        SendMail.send(to, subject, message);
        //
        request.getSession().setAttribute("cart",null);
        //chuyển tới giao diện thông báo
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("Notify.jsp");
        rd.forward(request, response);
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
