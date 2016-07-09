package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import POJO.Offers;
import POJO.OfferDetails;
import DAO.ListOffer;
import POJO.Products;
import POJO.Products;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import POJO.ProductCategoriesSub;
import POJO.ProductCategoriesRoot;
import java.util.ArrayList;
import DAO.ListProduct;

public final class Sale_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\"  >\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_header.jsp", out, false);
      out.write("\n");
      out.write("        <body class=\"cnt-home\">\n");
      out.write("            <!-- ============================================== HEADER ============================================== -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_menu.jsp", out, false);
      out.write("\n");
      out.write("            <!-- ============================================== HEADER : END ============================================== -->\n");
      out.write("            <div class=\"breadcrumb\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"breadcrumb-inner\">\n");
      out.write("                        <ul class=\"list-inline list-unstyled\">\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li class='active'>Khuyến mãi</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!-- /.breadcrumb-inner -->\n");
      out.write("                </div><!-- /.container -->\n");
      out.write("            </div><!-- /.breadcrumb -->\n");
      out.write("            <div class=\"body-content outer-top-bd\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"my-wishlist-page inner-bottom-sm\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 my-wishlist\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <a >111</a>                              \n");
      out.write("                            </div>\n");
      out.write("                        </div>\t\t\n");
      out.write("\n");
      out.write("                    </div>\t\t\n");
      out.write("\n");
      out.write("                </div>\t\t\n");
      out.write("\n");
      out.write("            </div>\t\t\n");
      out.write("\n");
      out.write("        </div>\t\t\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, false);
      out.write("\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
