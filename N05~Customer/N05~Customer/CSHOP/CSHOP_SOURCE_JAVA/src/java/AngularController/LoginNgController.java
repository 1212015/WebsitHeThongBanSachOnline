/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngularController;

import DAO.CookieUtil;
import DAO.ListUser;
import POJO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PQC
 */
@WebServlet(urlPatterns = {"/trangchu2"})
public class LoginNgController extends HttpServlet {

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
            out.println("<title>Servlet LoginNgController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginNgController at " + request.getContextPath() + "</h1>");
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
        boolean tmp = false;

        try {
            String email = request.getParameter("email");
            String psw = request.getParameter("password");

            ListUser l = new ListUser();
            tmp = l.Login(email, psw);
            if (tmp)// đăng nhập thành công
            {
                Users u = l.Get(email);
                String id = String.valueOf(u.getIdUsers());
                response.setContentType("text/html;charset=UTF-8");
                // cookie đăng nhập
                Cookie cookieIsAuth = CookieUtil.getCookie(request,"isAuth"); 
                cookieIsAuth.setMaxAge(2 * 60 * 60);
                cookieIsAuth.setValue("true");
                response.addCookie(cookieIsAuth);
                //cookie chưa id thông tin người dùng
                Cookie cookieUserId = CookieUtil.getCookie(request,"userid");
                cookieUserId.setMaxAge(2 * 60 * 60);
                cookieUserId.setValue(""+u.getIdUsers());
                response.addCookie(cookieUserId);
                //cookie chưa tên thông tin người dùng
                Cookie cookieUsername = CookieUtil.getCookie(request,"username");
                cookieUsername.setMaxAge(2 * 60 * 60);
                 cookieUsername.setValue(u.getEmail());
                response.addCookie(cookieUsername);
                //
               boolean tmp1= (boolean) request.getSession().getAttribute("dathang");
               if(tmp1==true)
               {// chuyển tới đặt hàng
                   response.sendRedirect("dathang");
               }
               else
               {
                    // chuyển về trang chủ
               response.sendRedirect("trangchu");
               }
               

            } else {
                Cookie cookieIsAuth = CookieUtil.getCookie(request,"isAuth" );
                cookieIsAuth.setMaxAge(2 * 60 * 60);
                cookieIsAuth.setValue("false");
                response.addCookie(cookieIsAuth);
                request.getSession().setAttribute("loi", "Tên đăng nhập hoặc mật khẩu sai!");
                response.sendRedirect("/CSHOP_SOURCE_JAVA/dangnhap");
            }
        } catch (SQLException ex) {
            //
            Cookie cookieIsAuth = CookieUtil.getCookie(request,"isAuth" );
            cookieIsAuth.setValue("false");
            cookieIsAuth.setMaxAge(2 * 60 * 60);
            response.addCookie(cookieIsAuth);
            //
            Logger.getLogger(LoginNgController.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute("loi", "Tên đăng nhập hoặc mật khẩu sai!");
            response.sendRedirect("/CSHOP_SOURCE_JAVA/dangnhap");
        }

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
