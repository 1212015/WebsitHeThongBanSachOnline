<%-- 
    Document   : ShoppingCart
    Created on : Dec 20, 2015, 4:46:12 PM
    Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.Products"%>
<%@page import="DAO.ListProduct"%>
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
<html lang="en" ng-app="CartApp" ng-controller="CartCtrl">
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
                            <li class='active'>Giỏ hàng</li>
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
                                                <th class="cart-romove item">Xóa</th>

                                                <th class="cart-product-name item">Tên sản phẩm</th>

                                                <th class="cart-qty item">Số lượng</th>
                                                <th class="cart-sub-total item">Giá</th>
                                                <th class="cart-total last-item">Tổng tiền</th>
                                                <th class="" ng-hide="<%=!isauth%>">Thêm vào giá</th>
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
                                       
                                        <tr ng-repeat="c in carts">
                                            <td class="romove-item" <a href="#"  title="Xóa khỏi giỏ" class="icon"><i class="fa fa-trash-o" ng-click="delete( c.productID)"></i></a></td>

                                            <td class="cart-product-name-info">
                                                <h4 class='cart-product-description'><a href="#">{{c.name}}</a></h4>
                                                <div class="row">
                                                    <div class="col-sm-4">
                                                        <div class="rating rateit-small"></div>
                                                    </div>
                                                    <div class="col-sm-8">

                                                    </div>
                                                </div><!-- /.row -->
                                                <div class="cart-product-info">
                                                    <span class="product-imel">Mã sản phẩm:<span>{{ c.productID}}</span></span><br>
                                                    <span class="product-color">Nhà xuất bản:<span>{{ c.publisher}}</span></span>
                                                </div>
                                            </td>

                                            <td class="cart-product-quantity">
                                                <div class="cart-quantity" ng-init="init()">
                                                     
                                                    <div class="quant-input" >
                                                        <div class="arrows"   >
                                                            <div class="arrow plus gradient"  ng-click="capnhatSL( c.productID,'p')" >
                                                                <span class="ir"   >
                                                                    <a class="icon fa fa-sort-asc" ></a>

                                                                </span>
                                                            </div>
                                                            <div class="arrow minus gradient" ng-click="capnhatSL(c.productID,'m')">
                                                                <span class="ir">
                                                                    <a class="icon fa fa-sort-desc" ></a>
                                                                    
                                                                </span>
                                                            </div>
                                                        </div>
                                                        
                                                                    <input value="{{c.quantity}}"    type="text"  name="quality"  >

                                                    </div>
                                                        
                                                </div>
                                            </td>
                                            <td class="cart-product-sub-total"><span class="cart-sub-total-price">{{c.price}} VND</span></td>
                                            <td class="cart-product-grand-total"><span class="cart-grand-total-price">{{c.total}} VND</span></td>
                                            <td class="romove-item" ng-hide="<%=!isauth%>"> <a href="themvaogiasach?id={{c.productID}}&iduser=<%=iduser%>"  title="Thêm vào giá sách" class="icon"><i class="fa fa-shopping-cart" ></i></a></td>
                                        </tr>
                                       
                                    </tbody><!-- /tbody -->
                                </table><!-- /table -->
                            </div>
                        </div><!-- /.shopping-cart-table -->				
                        <div class="col-md-4 col-sm-12 estimate-ship-tax">

                        </div><!-- /.estimate-ship-tax -->
                        <div class="col-md-4 col-sm-12 estimate-ship-tax">
<!--                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>
                                            <span class="estimate-title">Giảm giá, khuyến mãi</span>
                                            <p>Vui lòng nhập mã coupon :</p>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <input type="text" class="form-control unicase-form-control text-input" placeholder="Mã coupon của bạn">
                                            </div>
                                            <div class="clearfix pull-right">
                                                <button type="submit" class="btn-upper btn btn-primary">Xác nhận</button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>-->
                        </div><!-- /.estimate-ship-tax -->
                        <div class="col-md-4 col-sm-12 cart-shopping-total">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>
                                            <div class="cart-sub-total">
                                                Tổng Tiền<span class="inner-left-md"></span>
                                            </div>
                                            
                                             <div class="cart-grand-total">
                                                {{tongtien}} VND<span class="inner-left-md"></span>
                                            </div>
                                                
                                        </th>
                                    </tr>
                                </thead><!-- /thead -->
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="cart-checkout-btn pull-right">
                                                <button type="submit" class="btn btn-primary"><a href="dathang">XÁC NHẬN VÀ TIẾP TỤC</a> </button>
                                                <span class="">Đi đến xác nhận địa chỉ</span>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody><!-- /tbody -->
                            </table><!-- /table -->
                        </div><!-- /.cart-shopping-total -->
                    </div><!-- /.shopping-cart -->
                </div> <!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /.body-content -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <jsp:include page="_footer.jsp"></jsp:include>
        <script>
                    var app = angular.module('CartApp', ['angularUtils.directives.dirPagination']);
                    app.controller('CartCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {

                            // tải danh sách giỏ hàng
                            $scope.loadCart= function()
                            {
                                $http({
                                    method: 'GET',
                                    url: 'ShoppingCartNgController'
                                }).success(function (data) {
                                     $scope.carts=data;
                                    
                                }).error(function (data) {

                                });
                            };
                             $scope.loadCart();
                            //khởi tạo biến
                           $scope.init=function()
                           {
                               $http({
                                    method: 'GET',
                                    url: 'TotalCashNgController'
                                }).success(function (data) {
                                     $scope.tongtien=data;
                                    
                                }).error(function (data) {

                                });
                           };
                           
                            // cập nhật số lượng sản phẩm
                            $scope.capnhatSL = function (id,p)
                            {
                                $http({
                                    method: 'GET',
                                    url: 'IncreaseQualityNgController?id='+id+"&o="+p
                                }).success(function (data) {
                                     $scope.tongtien=data;
                                     $scope.loadCart();
                                }).error(function (data) {

                                });
                            };
                            // xóa sản phẩm
                            $scope.delete= function(id)
                            {
                                $http({
                                    method: 'GET',
                                    url: 'DeleteProductCartNgController?id='+id
                                }).success(function (data) {
                                      $scope.loadCart();
                                    
                                }).error(function (data) {
                                    
                                });
                            };
                            
                        }]);

        </script>

    </body>
</html>
