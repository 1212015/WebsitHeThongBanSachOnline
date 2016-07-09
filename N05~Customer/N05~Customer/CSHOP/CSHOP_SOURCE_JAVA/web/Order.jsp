<%-- 
    Document   : Order
    Created on : Jan 15, 2016, 7:08:41 PM
    Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.OrderDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
%>
<!DOCTYPE html>
<html lang="en" ng-app="OrderApp" ng-controller="OrderCtrl">
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>
            <!-- ============================================== HEADER : END ============================================== -->
            <div class="breadcrumb">
                <div class="container">
                    <div class="breadcrumb-inner">
                        <ul class="list-inline list-unstyled">
                            <li><a href="#">Home</a></li>
                            <li class='active'>Đơn hàng</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-xs">
                <div class="container">
                    <div class="row inner-bottom-sm">
                        <div class="shopping-cart">
                            <div class="col-md-12 col-sm-12 shopping-cart-table ">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th class="cart-romove item">Mã đơn hàng</th>

                                                <th class="cart-product-name item">Ngày đặt hàng</th>

                                                <th class="cart-qty item">Tổng tiền</th>
                                                <th class="cart-sub-total item">Tình trạng</th>
                                              
                                            </tr>
                                        </thead><!-- /thead -->
                                        <tfoot>
<!--                                            <tr>
                                                <td colspan="7">
                                                    <div class="shopping-cart-btn">
                                                        <span class="">

                                                            <a href="#" class="btn btn-upper btn-primary pull-right outer-right-xs">Tiếp tục mua hàng</a>
                                                        </span>
                                                    </div> /.shopping-cart-btn 
                                                </td>
                                            </tr>-->
                                        </tfoot>
                                        <tbody>         
                                       
                                        <tr dir-paginate="c in orders|itemsPerPage:6">
                                            <td class="romove-item"><h4>{{c.idOrders}}</h4> </td>
                                            <td class="romove-item"><h4>{{c.dateAdded}}</h4></td>
                                            <td class="romove-item"><h4>{{c.userID}} VND</h4></td>
                                            <td class="romove-item"><h4>{{c.shipPhone}}</h4></td>
                                        </tr>
                                       
                                    </tbody><!-- /tbody -->
                                    
                                </table><!-- /table -->
                                <div class="clearfix filters-container">
                                <div class="text-center">
                                    <dir-pagination-controls max-size="5"
                                                             direction-links="true"
                                                             boundary-links="true">
                                    </dir-pagination-controls>
                                </div><!-- /.text-right -->
                            </div><!-- /.filters-container -->
                            </div>
                        </div><!-- /.shopping-cart-table -->				
                        <div class="col-md-4 col-sm-12 estimate-ship-tax">

                        </div><!-- /.estimate-ship-tax -->
                       
                        
                    </div><!-- /.shopping-cart -->
                </div> <!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /.body-content -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <jsp:include page="_footer.jsp"></jsp:include>
        <script>
                    var app = angular.module('OrderApp', ['angularUtils.directives.dirPagination']);
                    app.controller('OrderCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {

                            // tải danh sách giỏ hàng
                            $scope.loadOrder= function()
                            {
                                $http({
                                    method: 'GET',
                                    url: 'LoadOrderNgController?id='+<%=iduser%>
                                }).success(function (data) {
                                     $scope.orders=data;
                                    
                                }).error(function (data) {

                                });
                            };
                             $scope.loadOrder();
                           
                            
                        }]);

        </script>

    </body>
</html>