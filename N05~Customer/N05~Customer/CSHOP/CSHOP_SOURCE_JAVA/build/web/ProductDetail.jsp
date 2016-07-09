<%-- 
    Document   : ProductDetail
    Created on : Dec 20, 2015, 4:44:45 PM
    Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="POJO.Users"%>
<%@page import="DAO.ListUser"%>
<%@page import="POJO.Comment"%>
<%@page import="DAO.ListComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="POJO.Products"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    // lấy thông tin sản phẩm
    ListProduct l = new ListProduct();

    ListUser lc2 = new ListUser();
    String status = "";
    Products p = null;
    Users u = null;
    Cookie cookie = CookieUtil.getCookie(request, "username");
    Cookie cookie2 = CookieUtil.getCookie(request, "userid");
    Cookie cookie3 = CookieUtil.getCookie(request, "isAuth");
    int id = 0;
    int iduser = 0;
    if (cookie2.getValue().equals("") == false) {
        iduser = Integer.parseInt(cookie2.getValue());
    }
    boolean isauth = cookie3.getValue().equals("true");// biến xác định đăng nhập hay chưa
    try {
        String id_product = (String) request.getParameter("id");
        // lấy thông tin sản phẩm
        id = Integer.parseInt(id_product);
        p = l.Get(id);
        // trạng thái sản phẩm
        status = l.StatusOfProduct(id);
    } catch (SQLException ex) {
        Logger.getLogger("DetailController").log(Level.SEVERE, null, ex.toString());
    }
    int n=0;
%>
<!DOCTYPE html>
<html lang="en" ng-app="ProductDetailApp" ng-controller="ProductDetailCtrl">
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
                            <li><a href="#">Sách</a></li>
                            <li class='active'><%= p.getName()%></li>
                    </ul>
                </div><!-- /.breadcrumb-inner -->
            </div><!-- /.container -->
        </div><!-- /.breadcrumb -->
        <div class="body-content outer-top-xs">
            <div class='container'>
                <div class='row single-product outer-bottom-sm '>

                    <div class='col-md-12'>
                        <div class="row  wow fadeInUp">
                            <div class="col-xs-12 col-sm-6 col-md-5 gallery-holder">
                                <div class="product-item-holder size-big single-product-gallery small-gallery">
                                    <div id="owl-single-product">
                                        <div class="single-product-gallery-item" id="slide1">
                                            <a data-lightbox="image-1" data-title="Gallery" href="assets/images/single-product/1.jpg">
                                                <img class="img-responsive" alt="" src="assets/images/blank.gif" data-echo="assets/images/single-product/1.jpg" />
                                            </a>
                                        </div><!-- /.single-product-gallery-item -->
                                        <!-- /.single-product-gallery-item -->
                                    </div><!-- /.single-product-slider -->


                                </div><!-- /.single-product-gallery -->
                            </div><!-- /.gallery-holder -->
                            <div class='col-sm-6 col-md-7 product-info-block'>
                                <div class="product-info">
                                    <h1 class="name"><%= p.getName()%></h1>

                                    <div class="rating-reviews m-t-20">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <div class="rating rateit-small"></div>
                                            </div>
                                            <div class="col-sm-8">
                                                <div class="reviews">
                                                    <a href="#" class="lnk">(Bình luận)</a>
                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.rating-reviews -->
                                    <div class="stock-container info-container m-t-10">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <div class="stock-box">
                                                    <span class="label">Tình trạng :</span>
                                                </div>
                                            </div>
                                            <div class="col-sm-9">
                                                <div class="stock-box">
                                                    <span class="value"><%= status%></span>
                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.stock-container -->
                                    <div class="description-container m-t-20">
                                        <%= p.getShortDetail()%>
                                    </div><!-- /.description-container -->
                                    <div class="price-container info-container m-t-20">
                                        <div class="row">

                                            <div class="col-sm-6">
                                                <div class="price-box">
                                                    <span class="price"><%= p.getPrice()%>VND</span>
                                                    <!--<span class="price-strike">$900.00</span>-->
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="favorite-button m-t-10">
                                                    <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="Wishlist" href="#">
                                                        <i class="fa fa-heart"></i>
                                                    </a>
                                                    <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="Add to Compare" href="#">
                                                        <i class="fa fa-retweet"></i>
                                                    </a>
                                                    <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="E-mail" href="#">
                                                        <i class="fa fa-envelope"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.price-container -->
                                    <div class="quantity-container info-container">
                                        <div class="row">


                                            <div class="col-sm-7">
                                                <a method="post" href="themvaogio?id=<%= id%>" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> THÊM VÀO GIỎ</a>
                                            </div>
                                            <div class="col-sm-2">

                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.quantity-container -->



                                </div><!-- /.product-info -->
                            </div><!-- /.col-sm-7 -->
                        </div><!-- /.row -->

                        <div class="product-tabs inner-bottom-xs  wow fadeInUp">
                            <div class="row">
                                <div class="col-sm-3">
                                    <ul id="product-tabs" class="nav nav-tabs nav-tab-cell">
                                        <li class="active"><a data-toggle="tab" href="#description">MÔ TẢ</a></li>
                                        <li><a data-toggle="tab" href="#review">BÌNH LUẬN</a></li>

                                    </ul><!-- /.nav-tabs #product-tabs -->
                                </div>
                                <div class="col-sm-9">
                                    <div class="tab-content">

                                        <div id="description" class="tab-pane in active">
                                            <div class="product-tab">
                                                <p class="text"><%= p.getDetail()%></p>
                                            </div>
                                        </div><!-- /.tab-pane -->
                                        <div id="review" class="tab-pane">
                                            <div class="product-tab">

                                                <div class="product-reviews">
                                                    <h4 class="title">Bình luận của khách hàng</h4>
                                                    <div class="reviews">
                                                        <div class="review" > 
                                                            <div dir-paginate="c in comments|itemsPerPage:3"> 
                                                                <div class="review-title"><i class="fa fa-calendar"></i><span>{{c.dateAdded}}</span></span></div>
                                                                <div class="text">{{c.Content}}</div>

                                                                <div class="review-title"  ><i class="fa fa-pencil-square-o" ng-init="getname(c.Id_Users)"></i> <span > {{hoten2}}</span> 
                                                                    <% if (isauth) {%>
                                                                    <a href="#" ng-hide="{{c.Id_Users !=<%= iduser%>}}" ng-click="deleteComment(c.Id_Users, c.Id_Comment)" >  Xóa</a>
                                                                    <%}%>
                                                                </div>
                                                                </br>
                                                            </div>
                                                        </div>

                                                    </div><!-- /.reviews -->
                                                    <div class="clearfix filters-container">
                                                        <div class="text-center">
                                                            <dir-pagination-controls max-size="5"
                                                                                     direction-links="true"
                                                                                     boundary-links="true">
                                                            </dir-pagination-controls>
                                                        </div><!-- /.text-right -->
                                                    </div><!-- /.filters-container -->
                                                </div><!-- /.product-reviews -->

                                                <%  if (isauth) {%>                                    
                                                <div class="product-add-review">
                                                    <h4 class="title">Bình luận của bạn</h4>                                                
                                                    <div class="review-form">
                                                        <div class="form-container">
                                                            <form role="form" class="cnt-form" ng-submit="addComment()" >
                                                                <div class="row">
                                                                    <div class="col-sm-12">

                                                                    </div>
                                                                    <div class="col-md-12">
<!--                                                                        <input type="hidden" ng-model="Id_Users"  value="<%= p.getIdProducts()%>" />-->
                                                                        <div class="form-group">
                                                                            <label for="exampleInputReview">Lời bình <span class="astk">*</span></label>
                                                                            <textarea class="form-control txt txt-review" ng-model="Content" rows="4" placeholder="Nhập bình luận"></textarea>
                                                                        </div><!-- /.form-group -->
                                                                    </div>
                                                                </div><!-- /.row -->

                                                                <div class="action text-right">
                                                                    <button class="btn btn-primary btn-upper"  type="submit">GỬI</button>
                                                                </div><!-- /.action -->
                                                            </form><!-- /.cnt-form -->
                                                        </div><!-- /.form-container -->
                                                    </div><!-- /.review-form -->
                                                </div><!-- /.product-add-review -->
                                                <% } %>


                                            </div><!-- /.product-tab -->
                                        </div><!-- /.tab-pane -->

                                    </div><!-- /.tab-content -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div><!-- /.product-tabs -->
                        <!-- ============================================== UPSELL PRODUCTS ============================================== -->
                        <section class="section featured-product wow fadeInUp">
                            <h3 class="section-title">Sách liên quan</h3>
                            <div class="owl-carousel home-owl-carousel upsell-product  owl-theme outer-top-xs">
                                <%
                                    int rid = p.getCategoriesRootID();
                                    int sid = p.getCategoriesSubID();
                                    ArrayList<Products> lp1 = l.GetRelateBook(rid, sid);
                                    for (Products p2 : lp1) {
                                %>
                                <div class="item item-carousel">
                                    <div class="products">

                                        <div class="product">
                                            <div class="product-image">
                                                <div class="image">
                                                    <a href="detail.html"><img src="assets/images/blank.gif" data-echo="assets/images/products/4.jpg" alt=""></a>
                                                </div><!-- /.image -->
                                                <div class="tag sale"><span>sale</span></div>
                                            </div><!-- /.product-image -->


                                            <div class="product-info text-left">
                                                <h3 class="name"><a href="detail.html"><%= p2.getName()%></a></h3>
                                                <div class="rating rateit-small"></div>
                                                <div class="description"></div>
                                                <div class="product-price">	
                                                        <%
                                                              n = l.GetDiscountByID(p2.getIdProducts());
                                                            if (n == 0) 
                                                            {
                                                        %>
                                                        <span class="price">
                                                            <%=p2.getPrice() %> VND
                                                        </span>

                                                        <% }  %>
                                                         <% if(n>0)
                                                         {
                                                        %>
                                                        <span class="price">
                                                            <%=p2.getPrice() * (1 - (n * 1.0 / 100)) %>VND
                                                        </span>
                                                        <span class="price-before-discount"> <%=p2.getPrice() %>VND</span>
                                                        <%}%>

                                                    </div><!-- /.product-price -->
                                                    <h4 class="name">  <%=p2.getAuthor()%></h4>

                                            </div><!-- /.product-info -->
                                            <div class="cart clearfix animate-effect">
                                                <div class="action">
                                                    <ul class="list-unstyled">
                                                        <li class="add-cart-button btn-group">
                                                              
                                                                <button class="btn btn-primary" type="button"> <a method="post" href="themvaogio?id=<%= p2.getIdProducts()%>"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a></button>

                                                            </li>

                                                      <li class="lnk wishlist">
                                                                <a class="add-to-cart" ng-hide="<%=!isauth%>" href="themvaogiasach?id=<%= p2.getIdProducts()%>&iduser=<%=iduser%>" title="Giá sách">
                                                                    <i class="icon fa fa-heart"></i>
                                                                </a>
                                                            </li>
                                                        <li class="lnk">
                                                            <a class="add-to-cart" href="chitietsanpham?id=<%= p2.getIdProducts()%>" title="Chi tiết">
                                                                <i class="fa fa-retweet"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div><!-- /.action -->
                                            </div><!-- /.cart -->
                                        </div><!-- /.product -->

                                    </div><!-- /.products -->
                                </div><!-- /.item -->
                                <% }%>
                            </div><!-- /.home-owl-carousel -->
                        </section><!-- /.section -->
                        <!-- ============================================== UPSELL PRODUCTS : END ============================================== -->

                    </div><!-- /.col -->
                    <div class="clearfix"></div>
                </div><!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /.body-content -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <jsp:include page="_footer.jsp"></jsp:include>
            <script>
                var app = angular.module('ProductDetailApp', ['angularUtils.directives.dirPagination']);
                app.controller('ProductDetailCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http) {
                        $scope.loadComment = function ()
                        {
                            $http({
                                method: 'GET',
                                url: 'LoadCommentNgController?id=' +<%= id%>
                            }).success(function (data) {
                                $scope.comments = data;

                            }).error(function (data) {

                            });
                        };
                        $scope.loadComment();
                        // them binh luan
                        $scope.addComment = function ()
                        {
                            $scope.c =
                                    {
                                        "Id_Product": <%=id%>,
                                        "Id_Users": <%= iduser%>,
                                        "Content": $scope.Content,
                                        "dateAdded": "Dec 8, 2015",
                                        "dateAdded2": "12/08/2015 00:00:00",
                                        "Id_Comment": 1
                                    }
                            $http({
                                method: 'POST',
                                url: 'AddCommentNgController',
                                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
                                data: 'idproduct=' +<%=id%> + '&iduser=' + <%= iduser%> + "&content=" + $scope.Content

                            }).success(function (data) {
                                $scope.Content = "";
                                $scope.loadComment();
                            }).error(function (data) {

                            });
                        };
                        // xoa binh luan
                        $scope.deleteComment = function (iduser, idcomment)
                        {
                            $http({
                                method: 'GET',
                                url: "DeleteCommentNgController?idproduct=" +<%= id%> + "&iduser=" + iduser + "&idcomment=" + idcomment
                            }).success(function (data) {
                                $scope.loadComment();
                            }).error(function (data) {

                            });
                        };
                        //lấy họ tên
                        $scope.getname = function (id)
                        {
                            $http({
                                method: 'GET',
                                url: "GetNameNgController?id=" + id
                            }).success(function (data) {
                                $scope.hoten2 = data;
                            }).error(function (data) {

                            });
                        };
                        // ẩn bình luận
                        $scope.hidenComment = function (id1, id2)
                        {
                            if (id1.equal(id2) == true)
                                return {id: true}
                            return {id: false}
                        };
                        // tang view
                        $http({
                            method: 'GET',
                            url: "IncreaseViewNgController?id=" +<%= id%>
                        }).success(function (data) {

                        }).error(function (data) {

                        });
                        //
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