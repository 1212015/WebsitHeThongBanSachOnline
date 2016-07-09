package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DetailSale_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\" ng-app=\"SalerApp\" ng-controller=\"SaleCtrl\" >\n");
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
      out.write("                            <li class='active'>Chi tiết KM</li>\n");
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
      out.write("                                    <table class=\"table table-bordered\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th class=\"cart-product-name item\">Tên sản phẩm</th>\n");
      out.write("                                                <th class=\"cart-qty item\">Loại sản phẩm</th>\n");
      out.write("                                                <th class=\"cart-sub-total item\">Giảm giá</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead><!-- /thead -->\n");
      out.write("                                        \n");
      out.write("                                        <tbody>         \n");
      out.write("\n");
      out.write("                                            <tr ng-repeat=\"c in carts\">\n");
      out.write("                                                <td class=\"romove-item\" <a href=\"#\"  title=\"Xóa khỏi giỏ\" class=\"icon\"><i class=\"fa fa-trash-o\" ng-click=\"delete(c.productID)\"></i></a></td>\n");
      out.write("                                                <td class=\"cart-product-grand-total\"><span class=\"cart-grand-total-price\">VND</span></td>\n");
      out.write("                                                <td class=\"romove-item\"> <a href=\"#\"  title=\"Thêm vào giá sách\" class=\"icon\"><i class=\"fa fa-shopping-cart\" ></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("\n");
      out.write("                                    </tbody><!-- /tbody -->\n");
      out.write("                                </table><!-- /table -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\t\t\n");
      out.write("                    </div>\t\t\n");
      out.write("                </div>\t\t\n");
      out.write("            </div>\t\t\n");
      out.write("        </div>\t\t\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("                    var app = angular.module('SalerApp', ['angularUtils.directives.dirPagination']);\n");
      out.write("                    app.controller('SaleCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)\n");
      out.write("                        {\n");
      out.write("                            $http({\n");
      out.write("                                method: 'GET',\n");
      out.write("                                url: 'LoadSaleNgController'\n");
      out.write("                            }).success(function (data) {\n");
      out.write("                                $scope.sales = data;\n");
      out.write("\n");
      out.write("                            }).error(function (data) {\n");
      out.write("\n");
      out.write("                            });\n");
      out.write("                        }]);\n");
      out.write("\n");
      out.write("        </script>\n");
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
