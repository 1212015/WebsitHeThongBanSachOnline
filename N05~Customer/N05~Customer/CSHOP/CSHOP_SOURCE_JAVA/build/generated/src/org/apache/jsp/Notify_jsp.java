package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Notify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\" ng-app=\"CartApp\" ng-controller=\"CartCtrl\">\n");
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
      out.write("                            <li class='active'>Kiểm tra</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!-- /.breadcrumb-inner -->\n");
      out.write("                </div><!-- /.container -->\n");
      out.write("            </div><!-- /.breadcrumb -->\n");
      out.write("            <div class=\"body-content outer-top-bd\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"checkout-box inner-bottom-sm\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-1\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-10\">\n");
      out.write("                                <div class=\"panel-group checkout-steps\" id=\"accordion\">\n");
      out.write("                                    <!-- checkout-step-01  -->\n");
      out.write("                                    <div class=\"panel panel-default  \">\n");
      out.write("\n");
      out.write("                                        <!-- panel-heading -->\n");
      out.write("                                        <div class=\"panel-heading\">\n");
      out.write("                                            <h4 class=\"unicase-checkout-title\">\n");
      out.write("                                                <a data-toggle=\"collapse\" class=\"\" data-parent=\"#accordion\" href=\"#collapseOne\">\n");
      out.write("                                                    THÔNG BÁO\n");
      out.write("                                                </a>\n");
      out.write("                                            </h4>\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- panel-heading -->\n");
      out.write("\n");
      out.write("                                        <div id=\"collapseOne\" class=\"panel-collapse collapse in\">\n");
      out.write("\n");
      out.write("                                            <!-- panel-body  -->\n");
      out.write("                                            <div class=\"panel-body\">\n");
      out.write("                                                <div class=\"row\">\t\t\n");
      out.write("                                                    <form class=\"register-form\" role=\"form\">\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <p>Đặt hàng thành công. Vui lòng kiểm tra email để xác nhận đơn đặt hàng.</p>\n");
      out.write("                                                        </div>\n");
      out.write("                                                     \n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"col-md-1\">\n");
      out.write("                                                               \n");
      out.write("                                                                </br>\n");
      out.write("                                                                <button type=\"submit\" class=\"btn-upper btn btn-primary checkout-page-button checkout-continue \">Đặt hàng</button>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div>\t\t\t\n");
      out.write("                                            </div>\n");
      out.write("                                            <!-- panel-body  -->\n");
      out.write("\n");
      out.write("                                        </div><!-- row -->\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- checkout-step-01  -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div><!-- /.checkout-steps -->\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-1\">\n");
      out.write("                            </div>\n");
      out.write("                        </div><!-- /.row -->\n");
      out.write("                    </div><!-- /.checkout-box -->\n");
      out.write("                </div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
