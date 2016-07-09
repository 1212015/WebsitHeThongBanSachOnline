/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AngularController.LoginNgController;
import DAO.CookieUtil;
import DAO.ListUser;
import POJO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/trangchu3"})
public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        Cookie cookieIsAuth = CookieUtil.getCookie(request, "isAuth");
        cookieIsAuth.setMaxAge(2 * 60 * 60);
        cookieIsAuth.setValue("false");
        response.addCookie(cookieIsAuth);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
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
        boolean tmp = false;
        request.setCharacterEncoding("UTF-8");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String matkhau = request.getParameter("matkhau");
        String xnmatkhau = request.getParameter("xnmatkhau");
        if (matkhau.equals(xnmatkhau) == false) {
            request.getSession().setAttribute("loidangky", "Mật khẩu và xác nhận mật khẩu không khớp!");
            response.sendRedirect("/CSHOP_SOURCE_JAVA/dangky");
        } else {
            try {
                ListUser l = new ListUser();
                Users u = new Users();
                u.setAddress(diachi);
                u.setEmail(email);
                u.setFirstName(ten);
                u.setLastName(ho);
                u.setPoint(0);
                u.setPhone(sdt);
                u.setGender("");// giới tính
                u.setStatus(1);// trạng thái active
                u.setUserCategoryID(1);// thành viên thường
                u.setPassword(matkhau);
                tmp = l.Create(u);
                if (tmp)// đăng nhập thành công
                {
                    Users u2 = l.Get(email);
                    String id = String.valueOf(u2.getIdUsers());

                    Cookie cookieIsAuth = CookieUtil.getCookie(request, "isAuth");
                    cookieIsAuth.setMaxAge(2 * 60 * 60);
                    cookieIsAuth.setValue("true");
                    response.addCookie(cookieIsAuth);
                    //cookie chưa id thông tin người dùng
                    Cookie cookieUserId = CookieUtil.getCookie(request, "userid");
                    cookieUserId.setMaxAge(2 * 60 * 60);
                    cookieUserId.setValue("" + u.getIdUsers());
                    response.addCookie(cookieUserId);
                    //
                    //cookie chưa tên thông tin người dùng
                    Cookie cookieUsername = CookieUtil.getCookie(request, "username");
                    cookieUsername.setMaxAge(2 * 60 * 60);
                    cookieUsername.setValue(u.getEmail());
                    response.addCookie(cookieUsername);
                   
                   
                    boolean tmp1= (boolean) request.getSession().getAttribute("dathang");
                    if(tmp1==true)
                    {// chuyển tới đặt hàng
                        response.sendRedirect("dathang");
                    }
                    else
                    {
                          response.sendRedirect("/CSHOP_SOURCE_JAVA/trangchu");
                    }

                } else {
                    Cookie cookieIsAuth = CookieUtil.getCookie(request, "isAuth");
                    cookieIsAuth.setMaxAge(2 * 60 * 60);
                    cookieIsAuth.setValue("false");
                    response.addCookie(cookieIsAuth);
                    request.getSession().setAttribute("loidangky", "Tên đăng nhập đã tồn tại!");
                    response.sendRedirect("/CSHOP_SOURCE_JAVA/dangky");
                }
            } catch (SQLException ex) {
                Cookie cookieIsAuth = CookieUtil.getCookie(request, "isAuth");
                cookieIsAuth.setMaxAge(2 * 60 * 60);
                cookieIsAuth.setValue("false");
                response.addCookie(cookieIsAuth);
                request.getSession().setAttribute("loidangky", "Đăng ký thất bại vui lòng nhập lại!");
                Logger.getLogger(LoginNgController.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("/CSHOP_SOURCE_JAVA/dangky");
            }

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
