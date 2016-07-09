<%-- 
    Document   : GiaSachjsp
    Created on : Jan 12, 2016, 5:16:39 AM
    Author     : LONGANH
--%>
<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.ProductCategoriesSub"%>
<%@page import="POJO.ProductCategoriesRoot"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie cookie2 = CookieUtil.getCookie(request, "userid");
    int iduser = 0;
    if (cookie2.getValue().equals("") == false) {
        iduser = Integer.parseInt(cookie2.getValue());
    }

%>
<!DOCTYPE html>
<html lang="en" ng-app="BookCartApp" ng-controller="BookCartCtrl" ng-nit="init()">
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>

            <!-- ============================================== HEADER : END ============================================== -->
            <!-- ============================================== HEADER : END ============================================== -->
            <div class="breadcrumb">
                <div class="container">
                    <div class="breadcrumb-inner">
                        <ul class="list-inline list-unstyled">
                            <li><a href="#">Home</a></li>
                            <li class='active'>Giá Sách</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-xs">
                <div class='container'>
                    <div class="homepage-container">
                        <div class='row outer-bottom-sm'>
                            <div class='col-md-3 sidebar'>
                            <%                                ListProduct p = new ListProduct();
                                ArrayList<ProductCategoriesRoot> pc = p.ProductRoot();
                            %>
                            <!-- ================================== TOP NAVIGATION ================================== -->
                            <div class="side-menu animate-dropdown outer-bottom-xs">
                                <div class="head"><i class="icon fa fa-align-justify fa-fw"></i>Phân loại riêng</div>
                                <nav class="yamm megamenu-horizontal" >
                                    <ul class="nav">

                                        <ul class="nav">
                                            <li role="presentation"><a role="menuitem"  href="#" ng-click="taigiasach(<%=iduser%>)" ><i class="icon fa fa-heart"></i>Giá sách</a></li>
                                            <li class="dropdown menu-item" ng-repeat="c1 in classifyown">
                                                <a href="#" ng-click="loadClassifyOwnDetails(c1.ID_Classify)">
                                                    <i  class="icon fa fa-book">                                      
                                                    </i>
                                                    {{c1.Name_Classify}}
                                                </a>

                                            </li><!-- /.menu-item -->

                                            <li role="presentation"><a role="menuitem"  href="#" data-toggle="modal" data-target="#myModal"><i class="icon fa fa-plus"></i>Thêm phân loại</a></li>
                                            <!-- Modal -->
                                            <div class="modal fade" id="myModal" role="dialog">
                                                <div class="modal-dialog">

                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Thêm phân loại riêng</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="row">		
                                                                <form class="register-form" role="form" ng-submit="addClassifyOwn(<%=iduser%>)">
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label class="info-title"  >Tên phân loại riêng: <span>*</span></label>
                                                                            <input type="text" name="ten" ng-model="tenplr"  class="form-control unicase-form-control text-input"  placeholder="Nhập tên">
                                                                        </div>

                                                                    </div>

                                                                    <div class="form-group">
                                                                        <div class="col-md-1">
                                                                            </br>
                                                                            <button type="submit"   class="btn-upper btn btn-primary " >Tạo</button>
                                                                        </div>
                                                                    </div>

                                                                </form>
                                                            </div>	
                                                        </div>
                                                        <div class="modal-footer">

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
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
                                <button class="btn btn-primary" ng-hide="!plr == 1" type="button" ng-click="deleteClasssifyDetail(idclass)">Xóa Phân Loại Riêng</button>
                                <input type="text" class="form-control" ng-model="searchString" placeholder="Nhập tên sách muốn tìm kiếm" />
                            </div>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane active" id="grid-container">
                                    <div class="category-product  inner-top-vs">
                                        <div class="row">

                                            <div class="col-sm-6 col-md-4" dir-paginate="s in sanphams|itemsPerPage:3" >
                                                <div class="products">

                                                    <div class="product">
                                                        <div class="product-image">
                                                            <div class="image">
                                                                <a href="chitietsanpham?id={{s.ID_Products}}"><img src="assets/images/fashion-products/1.jpg" alt=""></a>
                                                            </div><!-- /.image -->
                                                            <div class="tag new"><span>new</span></div>
                                                        </div><!-- /.product-image -->


                                                        <div class="product-info text-left">
                                                            <h3 class="name"><a href="chitietsanpham?id={{s.ID_Products}}">{{s.Name_Products}}</a></h3>
                                                            <div class="rating rateit-small"></div>
                                                            <div class="description"></div>
                                                            <div class="product-price">
                                                                <span class="price"><t>
                                                                        {{s.Price_Products}} VND
                                                                </span>
                                                                <!--                                                                    <span class="price-before-discount">$ 800</span>-->

                                                            </div><!-- /.product-price -->

                                                        </div><!-- /.product-info -->
                                                        <div class="cart clearfix animate-effect">
                                                            <div class="action">
                                                                <!--thêm vào giỏ hàng và thêm vào phân loại riêng-->  
                                                                <div class="col-md-4">
                                                                    <button class="btn btn-primary" type="button"><a href="themvaogio?id={{s.ID_Products}}">Vào Giỏ</a></button>
                                                                </div>

                                                                <div class="col-md-4" ng-hide="{{plr == 1}}">
                                                                    <ul class="categories-filter animate-dropdown">
                                                                        <li class="dropdown">
                                                                            <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" type="button">Phân loại</button>
                                                                            <ul class="dropdown-menu" role="menu">      
                                                                                <li role="presentation" ng-repeat="c2 in classifyown"><a role="menuitem" href="#"  ng-click="addBookToClasssify(s.ID_Products, c2.ID_Classify)" >{{c2.Name_Classify}}</a></li>                                                                                                         </li>
                                                                    </ul>
                                                                </div>
                                                                <div class="col-md-4" ng-hide="{{plr == 1}}">
                                                                    <button class="btn btn-primary" type="button" ng-click="delBookcart(s.ID_Products)">Xóa</button>
                                                                </div>

                                                                <div class="col-md-4" ng-hide="{{!plr == 1}}">
                                                                    <button class="btn btn-primary" type="button" ng-click="deleteBookInClassify(s.ID_Products)">Xóa</button>
                                                                </div>

                                                            </div><!-- /.action -->
                                                        </div><!-- /.cart -->
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

                            </div><!-- /.search-result-container -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container -->
            </div><!-- /.container -->
        </div><!-- /.body-content -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <jsp:include page="_footer.jsp"></jsp:include>
            <script>
                var app = angular.module('BookCartApp', ['angularUtils.directives.dirPagination']);
                
                app.controller('BookCartCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {
                        $scope.init = function ()
                        {

                            $scope.idclass = 0;
                        };
                        //load sản phẩm
                        $scope.taigiasach = function (id)
                        {
                            $http({
                                method: 'GET',
                                url: 'LoadBookCartNgController?iduser=' + id
                            }).success(function (data) {
                                $scope.plr = 0;
                                $scope.sanphams = data;

                            }).error(function (data) {

                            });
                        };
                        $scope.taigiasach(<%=iduser%>);
                        //xóa sản phẩm khỏi giá sách
                        $scope.delBookcart = function (id)
                        {
                            $http({
                                method: 'GET',
                                url: "DeleteBookCartNgController?id=" + id + "&iduser=" +<%=iduser%>
                            }).success(function (data) {
                                $scope.taigiasach(<%=iduser%>);

                            }).error(function (data) {

                            });
                        };
                        // tải danh sách tên phân loại riêng
                        $scope.loadClassifyOwn = function (id)
                        {
                            $http({
                                method: 'GET',
                                url: 'LoadClassifyOwnNgController?id=' + id
                            }).success(function (data) {
                                $scope.classifyown = data;

                            }).error(function (data) {

                            });
                        };
                        // thêm tên phân loại riêng
                        $scope.addClassifyOwn = function (id)
                        {
                            $http({
                                method: 'GET',
                                url: 'AddClassifyOwnNgController?id=' + id + "&noidung=" + $scope.tenplr
                            }).success(function (data) {

                                $scope.loadClassifyOwn(id);
                            }).error(function (data) {

                            });
                        };
                        //xóa phân loại riêng
                        $scope.loadClassifyOwn(<%=iduser%>);
                        // đưa sách vào chi tiết phân loại riêng
                        $scope.addBookToClasssify = function (id, idclass)
                        {
                            $http({
                                method: 'GET',
                                url: 'AddBookToClassifyOwnNgController?id=' + id + "&idclass=" + idclass + "&iduser=" +<%=iduser%>
                            }).success(function (data) {
                                $scope.taigiasach(<%=iduser%>);
                            }).error(function (data) {

                            });
                        };
                        //xóa sách trong phân loại riêng
                        $scope.deleteBookInClassify = function (id)//////////////////////////////////////////////
                        {
                            $http({
                                method: 'GET',
                                url: "DeleteBookFromClassifyOwnNgController?id=" + id + "&idclass=" + $scope.idclass + "&iduser=" +<%=iduser%>
                            }).success(function (data) {
                                $scope.loadClassifyOwnDetails($scope.idclass);
                            }).error(function (data) {

                            });
                        };
                        // lấy danh sách sách trong 1 phân loại riêng
                        $scope.loadClassifyOwnDetails = function (idclass)
                        {
                            $scope.idclass = idclass;
                            $http({
                                method: 'GET',
                                url: "LoadClassifyOwnDetailsNgController?idclass=" + idclass + "&iduser=" +<%=iduser%>
                            }).success(function (data) {
                                $scope.plr = 1;
                                $scope.sanphams = data;
                            }).error(function (data) {

                            });
                        };
                        // xóa toạn bộ chi tiết một phân loại riêng của user
                        $scope.deleteClasssifyDetail = function (idclass)
                        {
                            $http({
                                method: 'GET',
                                url: "DeleteAllClassifyOwnDetailsNgController?idclass=" + idclass + "&iduser=" +<%=iduser%>
                            }).success(function (data) {
                                $scope.loadClassifyOwn(<%=iduser%>);
                                $scope.taigiasach(<%=iduser%>);
                            }).error(function (data) {

                            });
                        };
                        //tìm kiếm thường
                    $scope.Search = function ()
                    {
                        $http({
                            method: 'GET',
                            url: "SearchProductNgController?lsp=" + $scope.lsp + "&q=" + $scope.q
                        }).success(function (data) {
                             $window.sessionStorage.setItem("datasearch", angular.toJson(data, false));
                               $window.sessionStorage.setItem("search", angular.toJson(true, false));
                        }).error(function (data) {

                        });
                    };
                    }]);

        </script>          
    </body>
</html>
