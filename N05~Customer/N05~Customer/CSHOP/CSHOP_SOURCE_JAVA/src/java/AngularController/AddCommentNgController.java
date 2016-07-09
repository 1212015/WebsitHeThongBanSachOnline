/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngularController;

import DAO.ListComment;
import POJO.Comment;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AddCommentNgController extends HttpServlet {

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
            out.println("<title>Servlet AddComemntNgController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddComemntNgController at " + request.getContextPath() + "</h1>");
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

        boolean tmp = false;
        try {
            ListComment l = new ListComment();
            // lấy nội dung
           
            //lấy thông tin
            String content = request.getParameter("content");
            String id_product1 = request.getParameter("idproduct");
            int id_product = Integer.parseInt(id_product1);
            String id_user1 =  request.getParameter("iduser");
            int id_user= Integer.parseInt(id_user1);

           
            //

            //tạo đối tượng comment
            Comment c = new Comment();
            c.setContent(content);
          
            c.setId_Product(id_product);
            c.setId_Users(id_user);
           

            //định dạng ngày tháng năm
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();
            String d1 = dateFormat.format(date);
             c.setDateAdded(d1);
            //tạo id bình luận
             DateFormat dateFormat2 = new SimpleDateFormat("MMddyyyyHHmmss");
             String d2 = dateFormat2.format(date);
             c.setId_Comment(d2);
            //thực hiện comment
            l.Create(c);

            tmp = true;
        } catch (SQLException ex) {
            Logger.getLogger(AddCommentNgController.class.getName()).log(Level.SEVERE, null, ex.toString());
        }
        String json = new Gson().toJson(tmp);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(json);

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
