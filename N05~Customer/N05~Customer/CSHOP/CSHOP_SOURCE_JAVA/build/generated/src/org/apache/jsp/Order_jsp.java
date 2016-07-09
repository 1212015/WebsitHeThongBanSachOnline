package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.CookieUtil;
import POJO.OrderDetails;
import java.util.ArrayList;

public final class Order_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    ArrayList<OrderDetails> tmp = (ArrayList<OrderDetails>) request.getSession().getAttribute("cart");
    Cookie cookie2 = CookieUtil.getCookie(request, "userid");
    int iduser = 0;
    if (cookie2.getValue().equals("") == false) {
        iduser = Integer.parseInt(cookie2.getValue());
    }
     Cookie cookie = CookieUtil.getCookie(request, "isAuth");
     boolean isauth;
     if( cookie.getValue().equals("false")||  cookie.getValue().equals(""))
        isauth= false;// chua dang nhap
     else
        isauth= true;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
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
      out.write("                            <li class='active'>Giỏ hàng</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!-- /.breadcrumb-inner -->\n");
      out.write("                </div><!-- /.container -->\n");
      out.write("            </div><!-- /.breadcrumb -->\n");
      out.write("            <div class=\"body-content outer-top-xs\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row inner-bottom-sm\">\n");
      out.write("                        <div class=\"shopping-cart\">\n");
      out.write("                            <div class=\"col-md-12 col-sm-12 shopping-cart-table \">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-bordered\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th class=\"cart-romove item\">Mã đơn hàng</th>\n");
      out.write("\n");
      out.write("                                                <th class=\"cart-product-name item\">Ngày đặt hàng</th>\n");
      out.write("\n");
      out.write("                                                <th class=\"cart-qty item\">Tổng tiền</th>\n");
      out.write("                                                <th class=\"cart-sub-total item\">Tình trạng</th>\n");
      out.write("                                              \n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead><!-- /thead -->\n");
      out.write("                                        <tfoot>\n");
      out.write("<!--                                            <tr>\n");
      out.write("                                                <td colspan=\"7\">\n");
      out.write("                                                    <div class=\"shopping-cart-btn\">\n");
      out.write("                                                        <span class=\"\">\n");
      out.write("\n");
      out.write("                                                            <a href=\"#\" class=\"btn btn-upper btn-primary pull-right outer-right-xs\">Tiếp tục mua hàng</a>\n");
      out.write("                                                        </span>\n");
      out.write("                                                    </div> /.shopping-cart-btn \n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>-->\n");
      out.write("                                        </tfoot>\n");
      out.write("                                        <tbody>         \n");
      out.write("                                       \n");
      out.write("                                        <tr ng-repeat=\"c in carts\">\n");
      out.write("                                            <td class=\"romove-item\" <a href=\"#\"  title=\"Xóa khỏi giỏ\" class=\"icon\"><i class=\"fa fa-trash-o\" ng-click=\"delete( c.productID)\"></i></a></td>\n");
      out.write("                                            <td class=\"cart-product-sub-total\"><span class=\"cart-sub-total-price\">{{c.price}} VND</span></td>\n");
      out.write("                                            <td class=\"cart-product-grand-total\"><span class=\"cart-grand-total-price\">{{c.total}} VND</span></td>\n");
      out.write("                                            <td class=\"romove-item\" ng-hide=\"");
      out.print(!isauth);
      out.write("\"> <a href=\"themvaogiasach?id={{c.productID}}&iduser=");
      out.print(iduser);
      out.write("\"  title=\"Thêm vào giá sách\" class=\"icon\"><i class=\"fa fa-shopping-cart\" ></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                       \n");
      out.write("                                    </tbody><!-- /tbody -->\n");
      out.write("                                </table><!-- /table -->\n");
      out.write("                            </div>\n");
      out.write("                        </div><!-- /.shopping-cart-table -->\t\t\t\t\n");
      out.write("                        <div class=\"col-md-4 col-sm-12 estimate-ship-tax\">\n");
      out.write("\n");
      out.write("                        </div><!-- /.estimate-ship-tax -->\n");
      out.write("                       \n");
      out.write("                        \n");
      out.write("                    </div><!-- /.shopping-cart -->\n");
      out.write("                </div> <!-- /.row -->\n");
      out.write("            </div><!-- /.container -->\n");
      out.write("        </div><!-- /.body-content -->\n");
      out.write("        <!-- ============================================================= FOOTER ============================================================= -->\n");
      out.write("        <!-- ============================================================= FOOTER ============================================================= -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("                    var app = angular.module('CartApp', ['angularUtils.directives.dirPagination']);\n");
      out.write("                    app.controller('CartCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {\n");
      out.write("\n");
      out.write("                            // tải danh sách giỏ hàng\n");
      out.write("                            $scope.loadCart= function()\n");
      out.write("                            {\n");
      out.write("                                $http({\n");
      out.write("                                    method: 'GET',\n");
      out.write("                                    url: 'ShoppingCartNgController'\n");
      out.write("                                }).success(function (data) {\n");
      out.write("                                     $scope.carts=data;\n");
      out.write("                                    \n");
      out.write("                                }).error(function (data) {\n");
      out.write("\n");
      out.write("                                });\n");
      out.write("                            };\n");
      out.write("                             $scope.loadCart();\n");
      out.write("                            //khởi tạo biến\n");
      out.write("                           $scope.init=function()\n");
      out.write("                           {\n");
      out.write("                               $http({\n");
      out.write("                                    method: 'GET',\n");
      out.write("                                    url: 'TotalCashNgController'\n");
      out.write("                                }).success(function (data) {\n");
      out.write("                                     $scope.tongtien=data;\n");
      out.write("                                    \n");
      out.write("                                }).error(function (data) {\n");
      out.write("\n");
      out.write("                                });\n");
      out.write("                           };\n");
      out.write("                           \n");
      out.write("                            // cập nhật số lượng sản phẩm\n");
      out.write("                            $scope.capnhatSL = function (id,p)\n");
      out.write("                            {\n");
      out.write("                                $http({\n");
      out.write("                                    method: 'GET',\n");
      out.write("                                    url: 'IncreaseQualityNgController?id='+id+\"&o=\"+p\n");
      out.write("                                }).success(function (data) {\n");
      out.write("                                     $scope.tongtien=data;\n");
      out.write("                                     $scope.loadCart();\n");
      out.write("                                }).error(function (data) {\n");
      out.write("\n");
      out.write("                                });\n");
      out.write("                            };\n");
      out.write("                            // xóa sản phẩm\n");
      out.write("                            $scope.delete= function(id)\n");
      out.write("                            {\n");
      out.write("                                $http({\n");
      out.write("                                    method: 'GET',\n");
      out.write("                                    url: 'DeleteProductCartNgController?id='+id\n");
      out.write("                                }).success(function (data) {\n");
      out.write("                                      $scope.loadCart();\n");
      out.write("                                    \n");
      out.write("                                }).error(function (data) {\n");
      out.write("                                    \n");
      out.write("                                });\n");
      out.write("                            };\n");
      out.write("                            \n");
      out.write("                        }]);\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
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
