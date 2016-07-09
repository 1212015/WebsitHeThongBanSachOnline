<%-- 
    Document   : Product
    Created on : Dec 20, 2015, 4:42:56 PM
    Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.Products"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="POJO.ProductCategoriesSub"%>
<%@page import="POJO.ProductCategoriesRoot"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListProduct p = new ListProduct();
    ArrayList<ProductCategoriesRoot> pc = p.ProductRoot();
    String id_sproduct = (String) request.getParameter("id");
    int id = Integer.parseInt(id_sproduct);
    Cookie cookie = CookieUtil.getCookie(request, "isAuth");
    boolean isauth;
    if (cookie.getValue().equals("false") || cookie.getValue().equals("")) {
        isauth = false;// chua dang nhap
    } else {
        isauth = true;
    }

%>
<!DOCTYPE html>
<html lang="en" ng-app="myapp" ng-controller="ProductCtrl">
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
                            <li class='active'>Sách</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-xs">
                <div class='container'>
                    <div class="homepage-container">

                        <div class='row outer-bottom-sm'>
                            <div class='col-md-3 sidebar'>
                                <!-- ================================== TOP NAVIGATION ================================== -->
                                <div class="side-menu animate-dropdown outer-bottom-xs">
                                    <div class="head"><i class="icon fa fa-align-justify fa-fw"></i>Danh mục</div>
                                    <nav class="yamm megamenu-horizontal" role="navigation">
                                        <ul class="nav">
                                        <%                                            for (ProductCategoriesRoot pc1 : pc) {
                                        %>
                                        <li class="dropdown menu-item">
                                            <a href="danhsachsanpham?id=<%= pc1.getIdProductCategoriesRoot()%>" class="dropdown-toggle" ><i class="icon fa fa-desktop fa-fw"></i><%= pc1.getName()%></a>

                                        </li><!-- /.menu-item -->
                                        <%
                                            }
                                        %>

                                    </ul><!-- /.nav -->
                                </nav><!-- /.megamenu-horizontal -->
                            </div><!-- /.side-menu -->
                            <!-- ================================== TOP NAVIGATION : END ================================== -->

                        </div>
                        <!-- /.sidebar 111111111111111-->
                        <div class='col-md-9'>
                            <!-- ========================================== SECTION – HERO ========================================= -->
                            <!-- ========================================= SECTION – HERO : END ========================================= -->
                            <div class="search-result-container">
                                <form role="form" ng-submit="advanceSearch()">
                                    <div class="col-md-3">
                                        <p>Tên nhà xuất bản</p>
                                        <select class="form-control" ng-model="nxb" ng-init="nxb=0">
                                            <option value="0" >Tất cả</option>
                                            <option ng-repeat="n in nxbs" ng-value="{{n.publisher}}">{{n.publisher}}</option>
                                            
                                        </select>
                                    </div>
                                    <div class="col-md-2">
                                        <p>Chữ cái bắt đầu</p>
                                        <select class="form-control" ng-model="bca" ng-init="bca=0">
                                            <option value="0" class="active">Tất cả</option>
                                            <option value="A" >A</option>
                                            <option value="Ă">Ă</option>
                                            <option value="Â">Â</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <option value="Đ">Đ</option>
                                            <option value="E">E</option>
                                             <option value="F">F</option>
                                            <option value="Ê">Ê</option>
                                            <option value="G">G</option>
                                            <option value="H">H</option>
                                            <option value="I">I</option>
                                            <option value="J">J</option>
                                            <option value="K">K</option>
                                            <option value="L">L</option>
                                            <option value="M">M</option>
                                            <option value="N">N</option>
                                            <option value="O">O</option>
                                            <option value="Ô">Ô</option>
                                            <option value="Ơ">Ơ</option>
                                            <option value="P">P</option>
                                            <option value="Q">Q</option>
                                            <option value="R">R</option>
                                            <option value="S">S</option>
                                            <option value="T">T</option>
                                            <option value="U">U</option>
                                            <option value="Ư">Ư</option>
                                            <option value="V">V</option>
                                            <option value="X">X</option>
                                            <option value="Y">Y</option>
                                            <option value="Y">W</option>
                                            
                                             <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            

                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <p>Số tiền thấp nhất</p>
                                        <select class="form-control" ng-model="tt" ng-init="tt=0">
                                            <option value="0" class="active">Tất cả</option>
                                            <option value="10000" >10.000 VND</option>
                                            <option value="50000" >50.000 VND</option>
                                            <option value="100000" >100.000 VND</option>
                                            <option value="150000" >150.000 VND</option>
                                            <option value="200000" >200.000 VND</option>
                                            <option value="250000" >250.000 VND</option>
                                            <option value="300000" >300.000 VND</option>

                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <p>Số tiền cao nhất</p>
                                        <select class="form-control" ng-model="tc" ng-init="tc=0">
                                            <option value="0" class="active">Tất cả</option>
                                            <option value="50000" >50.000 VND</option>
                                            <option value="100000" >100.000 VND</option>
                                            <option value="150000" >150.000 VND</option>
                                            <option value="200000" >200.000 VND</option>
                                            <option value="250000" >250.000 VND</option>
                                            <option value="300000" >300.000 VND</option>
                                            <option value="400000" >400.000 VND</option>
                                            <option value="500000" >500.000 VND</option>
                                          
                                        </select>
                                    </div>
                                    <div class="col-md-1">
                                        <p>Tìm</p>
                                        <button type="submit" class="form-control fa fa-search"></button>
                                    </div>
                                </form>
                                </br>
                                </br>
                                </br>
                            </div>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane active" id="grid-container">
                                    <div class="category-product  inner-top-vs">
                                        <div class="row">                               
                                            <div class="col-sm-6 col-md-4" dir-paginate="p in products|itemsPerPage:6">
                                                <div class="products">
                                                    <div class="product">
                                                        <div class="product-image">
                                                            <div class="image">
                                                                <a href="chitietsanpham?id={{p.idProducts}}"><img src="assets/images/fashion-products/1.jpg" alt=""></a>
                                                            </div><!-- /.image -->
                                                            <div class="tag normal" ng-hide="!p.discount == 0"><span></span></div>
                                                            <div class="tag sale" ng-hide="p.discount == 0"><span>G</span></div>
                                                        </div><!-- /.product-image -->


                                                        <div class="product-info text-left">
                                                            <h3 class="name"><a href="chitietsanpham?id={{p.idProducts}}">{{p.name}}</a></h3>
                                                            <div class="rating rateit-small"></div>
                                                            <div class="description"></div>
                                                             <div class="product-price" ng-hide="!p.discount == 0">
                                                                <span class="price">
                                                                    {{p.price}} VND
                                                                </span>
                                                               
                                                            </div><!-- /.product-price -->
                                                            <div class="product-price" ng-hide="p.discount == 0">
                                                                <span class="price">
                                                                    {{p.price * (1 - (1.0 * p.discount) / 100)}} VND
                                                                </span>
                                                               
                                                            </div><!-- /.product-price -->
                                                             <h5 class="name">{{p.author}}</h5>
                                                        </div><!-- /.product-info -->
                                                        <div class="cart clearfix ">
                                                            <div class="action">
                                                                <ul class="list-unstyled">
                                                                    <li class="add-cart-button btn-group">
<!--                                                                        <button class="btn btn-primary icon" data-toggle="dropdown" type="button">
                                                                            <i class="fa fa-shopping-cart"></i>													
                                                                        </button>-->
                                                                        <button class="btn btn-primary" type="button"> <a method="post" href="themvaogio?id={{p.idProducts}}"><i class="fa fa-shopping-cart"></i>	Thêm vào giỏ</a></button>

                                                                    </li>

                                                                    <li class="lnk wishlist" ng-hide="<%=!isauth%>">
                                                                        <a class="add-to-cart" href="#" title="Giá sách">
                                                                            <i class="icon fa fa-heart"></i>
                                                                        </a>
                                                                    </li>

                                                                    <li class="lnk">
                                                                        <a class="add-to-cart" href="chitietsanpham?id={{p.idProducts}}" title="Chi tiết">
                                                                            <i class="fa fa-retweet"></i>
                                                                        </a>
                                                                    </li>

                                                                </ul>
                                                            </div><!-- /.action -->
                                                        </div><!-- /.cart -->
                                                        </br>
                                                    </div><!-- /.product -->
                                                </div><!-- /.products -->
                                            </div><!-- /.item -->                                               
                                        </div><!-- /.row -->
                                    </div><!-- /.category-product -->

                                </div><!-- /.tab-pane -->
                            </div><!-- /.tab-content -->
                            <div class="clearfix filters-container">
                                <div class="text-center">
                                    <dir-pagination-controls max-size="5"
                                                             direction-links="true"
                                                             boundary-links="true">
                                    </dir-pagination-controls>
                                </div><!-- /.text-right -->
                            </div><!-- /.filters-container -->
                        </div><!-- /.search-result-container -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /.container -->
    </div><!-- /.body-content -->
    <!-- ============================================================= FOOTER ============================================================= -->
    <!-- ============================================================= FOOTER ============================================================= -->
    <jsp:include page="_footer.jsp"></jsp:include>
        <!-- ============================================================= FOOTER : END============================================================= -->
        <script>

            var app = angular.module('myapp', ['angularUtils.directives.dirPagination']);
            app.controller('ProductCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {
                    $http({
                        method: 'GET',
                        url: 'ProductNgController?id=' +<%= id%>
                    }).success(function (data) {
                        $scope.products = data;
                    }).error(function (data) {

                    });
                     $http({
                        method: 'GET',
                        url: 'LoadPublisherNgController' 
                    }).success(function (data) {
                        $scope.nxbs = data;
                    }).error(function (data) {

                    });
                    // tìm kiếm nâng cao
                    $scope.advanceSearch = function ()
                    {
                        $http({
                            method: 'GET',
                            url: "AdvanceSearchProductNgController?nxb="+$scope.nxb+"&bca="+$scope.bca+"&tt="+$scope.tt+"&tc="+$scope.tc
                        }).success(function (data) {
                            $scope.products = data;
                        }).error(function (data) {

                        });
                    };
                    //tìm kiếm thường
//                    $scope.Search=function()
//                    {
//                        $http({
//                            method: 'GET',
//                            url: "SearchProductNgController?lsp="+$scope.lsp+"&q="+$scope.q
//                        }).success(function (data) {
//                            $scope.products = data;
//                        }).error(function (data) {
//
//                        });
//                    };
                }]);
    </script>

</body>
</html>
