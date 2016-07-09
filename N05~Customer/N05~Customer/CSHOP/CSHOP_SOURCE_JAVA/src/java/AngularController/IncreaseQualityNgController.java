/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngularController;

import POJO.OrderDetails;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PQC
 */
//@WebServlet(urlPatterns = {"/capnhatsoluonggiohang"})
public class IncreaseQualityNgController extends HttpServlet {

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
            out.println("<title>Servlet IncreaseQualityNgController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IncreaseQualityNgController at " + request.getContextPath() + "</h1>");
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
        String id1 = request.getParameter("id");
        String o = request.getParameter("o");
        int id = Integer.parseInt(id1);
       
         int n=0;
        ArrayList<OrderDetails> tmp = (ArrayList<OrderDetails>) request.getSession().getAttribute("cart");
        //OrderDetails o1= new OrderDetails();
        for(int i=0;i< tmp.size();i++)
        {
           if(tmp.get(i).getProductID()==id)
           {
//               o1.setDateAdded(tmp.get(i).getDateAdded());
//               o1.setDateAdded2(tmp.get(i).getDateAdded2());
//               o1.setDateUpdated(tmp.get(i).getDateUpdated());
//               o1.setDateUpdated2(tmp.get(i).getDateUpdated2());
//               o1.setIdOrderDetails(tmp.get(i).getIdOrderDetails());
//               o1.setOrderID(tmp.get(i).getOrderID());
//               o1.setPrice(tmp.get(i).getPrice());
//               o1.setProductID(tmp.get(i).getProductID());
               int sl=tmp.get(i).getQuantity();
               if(o.equals("p")==true)
               {
                   sl++;
               }
               else
                  if(o.equals("m")==true)
               {
                   if(sl>0)
                       sl--;
               }
               
               tmp.get(i).setQuantity(sl);
               tmp.get(i).setTotal(sl*tmp.get(i).getPrice());
              n=i;
               break;
           }
        }
       // tmp.remove(n);
        //tmp.add(o1);
        int k=0;
        int x=0;
        int n1=0;
         for(int i=0;i< tmp.size();i++)
        {
             k=tmp.get(i).getQuantity();
             x=tmp.get(i).getPrice()*k;
             n1+=x;
        }
        
        String json = new Gson().toJson(n1);
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
