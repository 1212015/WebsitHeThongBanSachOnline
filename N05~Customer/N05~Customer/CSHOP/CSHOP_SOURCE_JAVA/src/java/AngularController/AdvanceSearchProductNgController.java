/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngularController;

import DAO.ListProduct;
import POJO.Products;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AdvanceSearchProductNgController extends HttpServlet {

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
            out.println("<title>Servlet AdvanceSearchProductNgController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdvanceSearchProductNgController at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        
        String tt1 = request.getParameter("tt");
        int tt = Integer.parseInt(tt1);
        String tc1 = request.getParameter("tc");
        int tc = Integer.parseInt(tc1);
        String bca = request.getParameter("bca");
        String nxb = request.getParameter("nxb");

        ListProduct lp = new ListProduct();
        String sql = "select * from Products ";
        ArrayList<Products> p = null;
        if (nxb.equals("0") == false) {
            sql += " where Publisher like N'%" + nxb + "%' ";
            if (bca.equals("0") == false) {
                sql += " and Name like N'" + bca + "%'";
            }
            if (tc != 0) {
                sql += " and Price<=" + tc;
            }
            if (tt != 0) {
                sql += " and Price>=" + tt;
            }
        } else {
        if (bca.equals("0") == false) 
        {
             sql += " where Name like N'" + bca + "%'";
              if (nxb.equals("0") == false) {
                  sql += " and Publisher like N'%" + nxb + "%' ";
              }
            if (tc != 0) {
                sql += " and Price<=" + tc;
            }
            if (tt != 0) {
                sql += " and Price>=" + tt;
            }
        } 
        else {
        if (tc != 0) 
        {
             sql += " where Price<=" + tc;
             if (tt != 0) {
                sql += " and Price>=" + tt;
            }
             if (nxb.equals("0") == false) {
                  sql += " and Publisher like N'%" + nxb + "%' ";
              }
              if (bca.equals("0") == false) {
                sql += " and Name like N'" + bca + "%'";
            }
        } 
        else {
        if (tt != 0) 
        {
             sql += " where Price>=" + tt;
             if (tc != 0) {
                sql += " and Price<=" + tc;
            }
            if (nxb.equals("0") == false) {
                  sql += " and Publisher like N'%" + nxb + "%' ";
              }
              if (bca.equals("0") == false) {
                sql += " and Name like N'" + bca + "%'";
            }
        }
        }
        }
        }
        try {
            p= lp.AdvanceSearch(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceSearchProductNgController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String json = new Gson().toJson(p);
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
