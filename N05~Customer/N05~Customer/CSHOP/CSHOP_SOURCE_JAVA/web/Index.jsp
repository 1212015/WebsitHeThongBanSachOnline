<%-- 
Document   : Index
Created on : Dec 16, 2015, 9:38:40 AM
Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.Users"%>
<%@page import="DAO.ListUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="POJO.Products"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListProduct p = new ListProduct();
    Cookie cookie2 = CookieUtil.getCookie(request, "userid");
    int iduser = 0;
    if (cookie2.getValue().equals("") == false) {
        iduser = Integer.parseInt(cookie2.getValue());
    }
    Cookie cookie = CookieUtil.getCookie(request, "isAuth");
    boolean isauth;
    if (cookie.getValue().equals("false") || cookie.getValue().equals("")) {
        isauth = false;// chua dang nhap
    } else {
        isauth = true;
    }
    int n = 0;
%>
<!DOCTYPE html>
<html lang="en" ng-app="IndexApp" ng-controller="IndexCtrl">
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>

            <!-- ============================================== HEADER : END ============================================== -->
            <div class="body-content" id="top-banner-and-menu" class="jumbotron">
                <!-- ========================================== SECTION – HERO ========================================= -->

                <div id="hero" class="home-page-slider4">
                    <div id="owl-main" class="owl-carousel silder4 owl-inner-nav owl-ui-sm">

                        <div class="item" style="background-image: url(assets/images/sliders/1.jpg);">
                            <div class="container-fluid">
                                <div class="caption vertical-center text-left">
                                    <div class="big-text fadeInDown-1">
                                        <span class="highlight">Sách</span> chào ngày mới
                                    </div>

                                    <div class="excerpt m-t-20 fadeInDown-2 hidden-xs">


                                    </div>

                                </div><!-- /.caption -->
                            </div><!-- /.container-fluid -->
                        </div><!-- /.item -->

                        <div class="item" style="background-image: url(assets/images/sliders/2.jpg);">
                            <div class="container-fluid">
                                <div class="caption vertical-center text-left">
                                    <div class="big-text fadeInDown-1">
                                        Sách <span class="highlight">thư giản</span> 
                                    </div>

                                    <div class="excerpt m-t-20 fadeInDown-2 hidden-xs">


                                    </div>

                                </div><!-- /.caption -->
                            </div><!-- /.container-fluid -->
                        </div><!-- /.item -->

                        <div class="item" style="background-image: url(assets/images/sliders/3.jpg);">
                            <div class="container-fluid">
                                <div class="caption vertical-center text-left">
                                    <div class="big-text fadeInDown-1">
                                        Sách mới <span class="highlight">mỗi ngày</span> cho bạn
                                    </div>

                                    <div class="excerpt m-t-20 fadeInDown-2 hidden-xs">


                                    </div>

                                </div><!-- /.caption -->
                            </div><!-- /.container-fluid -->
                        </div><!-- /.item -->

                        <div class="item" style="background-image: url(assets/images/sliders/4.jpg);">
                            <div class="container-fluid">
                                <div class="caption vertical-center text-left">
                                    <div class="big-text fadeInDown-1">
                                        Kho sách <span class="highlight">đa dạng</span> thể loại
                                    </div>

                                    <div class="excerpt m-t-20 fadeInDown-2 hidden-xs">


                                    </div>

                                </div><!-- /.caption -->
                            </div><!-- /.container-fluid -->
                        </div><!-- /.item -->


                    </div><!-- /.owl-carousel -->
                    <div class="customNavigation">
                        <div class="container">

                            <div class="controls clearfix hidden-xs">
                                <a href="#" data-target=".silder4" class="btn btn-primary pull-left owl-prev"><i class="fa fa-angle-left"></i></a>
                                <a href="#" data-target=".silder4" class="btn btn-primary pull-right owl-next"><i class="fa fa-angle-right"></i></a>
                            </div><!-- /.controls -->

                        </div>
                    </div>
                </div>

                <!-- ========================================= SECTION – HERO : END ========================================= -->	<div class="container">

                    <!-- ============================================== WIDE PRODUCTS ============================================== -->
                    <div class="wide-banners wow fadeInUp new-banner inner-bottom-20">
                        <div class="row">

                            <div class="col-md-4">
                                <div class="wide-banner cnt-strip">
                                    <div class="image">
                                        <img class="img-responsive" data-echo="assets/images/banners/8.jpg" src="assets/images/blank.gif" alt="">
                                    </div>	
                                    <div class="strip">
                                        <div class="strip-inner">

                                            <h5 class="white text-right"><span>Mua 2 tặng 1</span></h5>

                                        </div>	
                                    </div>
                                </div><!-- /.wide-banner -->
                            </div><!-- /.col -->

                            <div class="col-md-4">
                                <div class="wide-banner cnt-strip">
                                    <div class="image">
                                        <img class="img-responsive" data-echo="assets/images/banners/9.jpg" src="assets/images/blank.gif" alt="">
                                    </div>	
                                    <div class="strip">
                                        <div class="strip-inner text-center">

                                            <h5 class="white text-right"><span>Tiết kiêmk 30%</span></h5>
                                        </div>	
                                    </div>
                                </div><!-- /.wide-banner -->
                            </div><!-- /.col -->

                            <div class="col-md-4">
                                <div class="wide-banner cnt-strip">
                                    <div class="image">
                                        <img class="img-responsive" data-echo="assets/images/banners/10.jpg" src="assets/images/blank.gif" alt="">
                                    </div>	
                                    <div class="strip">
                                        <div class="strip-inner text-center">

                                            <h5 class="white text-right"><span>Chỉ từ 95k</span></h5>
                                        </div>	
                                    </div>
                                </div><!-- /.wide-banner -->
                            </div><!-- /.col -->



                        </div><!-- /.row -->
                    </div><!-- /.wide-banners -->

                    <!-- ============================================== WIDE PRODUCTS : END ============================================== -->
                    <!-- ============================================== BÁN CHẠY ============================================== -->
                    <!-- ============================================== BÁN CHẠY ============================================== -->
                    <!-- ============================================== BÁN CHẠY ============================================== -->

                    <section class="section seller-product wow fadeInUp">
                        <h3 class="section-title">BÁN CHẠY</h3>
                        <div class="row outer-top-xs">
                        <%
                            ArrayList<Products> tmp = p.Top6BestSellerBook();
                            for (Products pr1 : tmp) {
                        %>
                        <div class="col-md-4 col-sm-6">
                            <div class="products">

                                <div class="product">
                                    <div class="product-micro">
                                        <div class="row product-micro-row">
                                            <div class="col col-xs-6">
                                                <div class="product-image">
                                                    <div class="image">
                                                        <a href="chitietsanpham?id=<%= pr1.getIdProducts()%>" data-lightbox="image-1" data-title="Chi tiết">
                                                            <img  src="assets/images/products/md1.jpg" alt="">
                                                            <div class="zoom-overlay"></div>
                                                             <div class="tag hot" ><span>H</span></div>
                                                        </a>
                                                    </div><!-- /.image -->
                                                </div><!-- /.product-image -->
                                            </div><!-- /.col -->
                                            <div class="col col-xs-6">
                                                <div class="product-info">
                                                    <h3 class="name"><a href="#">  <%= pr1.getName()%></a></h3>
                                                    <div class="rating rateit-small"></div>
                                                    <div class="product-price">

                                                        <%
                                                            n = p.GetDiscountByID(pr1.getIdProducts());
                                                            if (n == 0) 
                                                            {
                                                        %>
                                                        <span class="price">
                                                            <%=pr1.getPrice() %> VND
                                                        </span>

                                                        <% }  %>
                                                         <% if(n>0)
                                                         {
                                                        %>
                                                        <span class="price">
                                                            <%=pr1.getPrice() * (1 - (n * 1.0 / 100)) %>VND
                                                        </span>
                                                        <span class="price-before-discount"> <%=pr1.getPrice() %>VND</span>
                                                        <%}%>
                                                       
                                                    </div><!-- /.product-price -->
                                                    <h4 class="name"><%= pr1.getAuthor()%></h4>
                                                    <div class="action m-t-10"><a method="post" href="themvaogio?id=<%= pr1.getIdProducts()%>" class="lnk btn btn-primary">Thêm vào giỏ</a></div>
                                                    <div class="action m-t-10" ng-hide="<%=!isauth%>"><a  href="themvaogiasach?id=<%= pr1.getIdProducts()%>&iduser=<%=iduser%>" class="lnk btn btn-primary">Thêm vào giá</a></div>
                                                    <div class="action m-t-10"><a href="chitietsanpham?id=<%= pr1.getIdProducts()%>" class="lnk btn btn-primary">Chi tiết</a></div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.product-micro-row -->
                                    </div><!-- /.product-micro -->
                                </div>

                            </div>
                        </div>
                        <%
                            }
                        %>

                    </div>

                </section>
                <!-- ==============================================BÁN CHẠY : END ============================================== -->

                <!--================================================= SÁCH MỚI-->

                <!-- ============================================== SCROLL TABS ============================================== -->
                <div id="product-tabs-slider" class="scroll-tabs outer-top-vs wow fadeInUp">
                    <div class="more-info-tab clearfix ">
                        <h3 class="new-product-title pull-left">SÁCH MỚI</h3>
<!--                        <ul class="nav nav-tabs nav-tab-line pull-right" id="new-products-1">
                            <li class="active"><a href="#all" data-toggle="tab">Tất cả</a></li>
                            <li><a href="#smartphone" data-toggle="tab">Tuần</a></li>
                            <li><a href="#laptop" data-toggle="tab">Tháng</a></li>
                            <li><a href="#apple" data-toggle="tab">Năm</a></li>
                        </ul> /.nav-tabs -->
                    </div>

                    <div class="tab-content outer-top-xs">
                        <div class="tab-pane in active" id="all">			
                            <div class="product-slider">
                                <div class="owl-carousel home-owl-carousel custom-carousel owl-theme" data-item="5">
                                    <%
                                        ArrayList<Products> tmp1 = p.Top5RecentSellerBook();
                                        for (Products pr1 : tmp1) {
                                    %>
                                    <div class="item item-carousel">
                                        <div class="products">

                                            <div class="product">		
                                                <div class="product-image">
                                                    <div class="image">
                                                        <a href="chitietsanpham?id=<%= pr1.getIdProducts()%>"><img  src="assets/images/blank.gif" data-echo="assets/images/products/h2-6.jpg" alt=""></a>
                                                    </div><!-- /.image -->			
                                                    <%
                                                        n = p.GetDiscountByID(pr1.getIdProducts());
                                                         
                                                    %>
                                                    <div class="tag new"><span>M</span></div> 
                                                    
                                                </div><!-- /.product-image -->


                                                <div class="product-info text-left">
                                                    <h3 class="name"><a href="chitietsanpham?id=<%= pr1.getIdProducts()%>"><%= pr1.getName()%></a></h3>
                                                    <div class="rating rateit-small"></div>
                                                    <div class="description"></div>

                                                    <div class="product-price">	
                                                        <%
                                                            
                                                            if (n == 0) 
                                                            {
                                                        %>
                                                        <span class="price">
                                                            <%=pr1.getPrice() %> VND
                                                        </span>

                                                        <% }  %>
                                                         <% if(n>0)
                                                         {
                                                        %>
                                                        <span class="price">
                                                            <%=pr1.getPrice() * (1 - (n * 1.0 / 100)) %>VND
                                                        </span>
                                                        <span class="price-before-discount"> <%=pr1.getPrice() %>VND</span>
                                                        <%}%>

                                                    </div><!-- /.product-price -->
                                                    <h4 class="name">  <%= pr1.getAuthor()%></h4>
                                                </div><!-- /.product-info -->
                                                <div class="cart clearfix animate-effect">
                                                    <div class="action">
                                                        <ul class="list-unstyled">
                                                            <li class="add-cart-button btn-group">
                                                              
                                                                <button class="btn btn-primary" type="button"> <a method="post" href="themvaogio?id=<%= pr1.getIdProducts()%>"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a></button>

                                                            </li>

                                                            <li class="lnk wishlist">
                                                                <a class="add-to-cart" ng-hide="<%=!isauth%>" href="themvaogiasach?id=<%= pr1.getIdProducts()%>&iduser=<%=iduser%>" title="Giá sách">
                                                                    <i class="icon fa fa-heart"></i>
                                                                </a>
                                                            </li>

                                                            <li class="lnk">
                                                                <a class="add-to-cart" href="chitietsanpham?id=<%= pr1.getIdProducts()%>" title="Chi tiết">
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
                            </div><!-- /.product-slider -->
                        </div><!-- /.tab-pane -->



                    </div><!-- /.tab-content -->
                </div><!-- /.scroll-tabs -->
                <!-- ============================================== SCROLL TABS : END ============================================== -->
                <!-- ============================================== SÁCH SẮP PHÁT HÀNH========================================== -->
                <!-- ===================================================== SÁCH SẮP PHÁT HÀNH============================================== --> 

                <!-- ============================================== NHÀ XUẤT BẢN ============================================== -->
                <div id="brands-carousel" class="logo-slider wow fadeInUp">

                    <h3 class="section-title">NHÀ XUẤT BẢN</h3>
                    <div class="logo-slider-inner">	
                        <div id="brand-slider" class="owl-carousel brand-slider custom-carousel owl-theme">
                            <div class="item m-t-15">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand1.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item m-t-10">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand2.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand3.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand4.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand5.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand6.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand7.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand8.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand1.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->

                            <div class="item">
                                <a href="#" class="image">
                                    <img data-echo="assets/images/brands/brand2.jpg" src="assets/images/blank.gif" alt="">
                                </a>	
                            </div><!--/.item-->
                        </div><!-- /.owl-carousel #logo-slider -->
                    </div><!-- /.logo-slider-inner -->

                </div><!-- /.logo-slider -->
                <!-- ==============================================  NHÀ XUẤT BẢN : END ============================================== -->	


            </div><!-- /.container -->
        </div><!-- /#top-banner-and-menu -->
        <!-- ============================================================= FOOTER ============================================================= -->
        <jsp:include page="_footer.jsp"></jsp:include>
        <script>
            var app = angular.module('IndexApp', ['angularUtils.directives.dirPagination']);
            app.controller('IndexCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)
                {

                }]);

        </script>
    </body>
</html>
