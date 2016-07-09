<%-- 
    Document   : _menu
    Created on : Dec 25, 2015, 1:23:26 PM
    Author     : PQC
--%>

<%@page import="DAO.CookieUtil"%>
<%@page import="POJO.Users"%>
<%@page import="POJO.ProductCategoriesRoot"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListProduct p = new ListProduct();
    ArrayList<ProductCategoriesRoot> pc = p.ProductRoot();
    Cookie cookie = CookieUtil.getCookie(request, "isAuth");
    Cookie cookie2 = CookieUtil.getCookie(request, "username");
%>

<header class="header-style-1 header-style-3" class="jumbotron">
    <!-- ============================================== TOP MENU ============================================== -->
    <div class="top-bar animate-dropdown">
        <div class="container">
            <div class="header-top-inner">
                <div class="cnt-account">
                    <ul class="list-unstyled">

                        <li><a href="giohang"><i class="icon fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                        <!--                        <li><a href="checkout.html"><i class="icon fa fa-key"></i>Đặt hàng</a></li>-->
                        <%  if (cookie.getValue().equals("false") || cookie.getValue().equals("")) { %>                                    
                        <li><a href="dangnhap"><i class="icon fa fa-sign-in"></i>Đăng nhập</a></li>
                        <li><a href="dangky"><i class="fa fa-pencil-square-o"></i> Đăng ký</a></li>
                            <% } %>
                            <%  if (cookie.getValue().equals("true")) {%> 
                        <li><a href="giasach"><i class="icon fa fa-heart"></i>Giá sách</a></li>
                        <li><a href="thongtintaikhoan"><i class="icon fa fa-user"></i>Tài khoản</a></li>
                        <li><a href="dangxuat"><i class="icon fa fa-sign-out"></i>Đăng xuất</a></li>
                        <li><a href="#"><i class="icon fa fa-user"></i>Xin chào <%= cookie2.getValue()%>!</a></li>
                            <% } %>
                    </ul>
                </div><!-- /.cnt-account -->
                <!-- /.cnt-cart -->
                <div class="clearfix"></div>
            </div><!-- /.header-top-inner -->
        </div><!-- /.container -->
    </div><!-- /.header-top -->
    <!-- ============================================== TOP MENU : END ============================================== -->
    <div class="main-header" >
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
                    <div class="logo">
                        <a href="trangchu">

                            <img src="assets/images/logo2.png" alt="">
                        </a>
                    </div><!-- /.logo -->
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 top-search-holder">
                    <div class="contact-row">
                        <div class="phone inline">
                            <i class="icon fa fa-phone"></i> (000) 888 888 868
                        </div>
                        <div class="contact inline">
                            <i class="icon fa fa-envelope"></i> bookstore@gmail.com
                        </div>
                    </div><!-- /.contact-row -->
                    <div class="search-area">
                        <form action="timkiem" method="GET">
                            <div class="control-group">
                                <div class="col-md-3">
                                    <select class="form-control" name="lsp">
                                        <option value="0"  class="active">Tất cả</option>
                                        <%
                                            for (ProductCategoriesRoot pc1 : pc) {
                                        %>
                                        <option value="<%= pc1.getIdProductCategoriesRoot() %>">  <%= pc1.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-7">
                                    <input class="form-control" placeholder="Tìm kiếm..." id="country" name="q"/>
                                    <script>
                                        $("#country").autocomplete("getdata.jsp");
                                    </script>
                                </div>
                                <div class="col-md-2">
                                    <button type="submit" class="form-control fa fa-search"></button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div><!-- /.top-search-holder -->
                <div class="col-xs-12 col-sm-12 col-md-3 animate-dropdown top-cart-row">

                    <!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->
                </div><!-- /.top-cart-row -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </div><!-- /.main-header -->
    <!-- ============================================== NAVBAR ============================================== -->
    <div class="header-nav animate-dropdown">
        <div class="container">
            <div class="yamm navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button data-target="#mc-horizontal-menu-collapse" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="nav-bg-class">
                    <div class="navbar-collapse collapse" id="mc-horizontal-menu-collapse">
                        <div class="nav-outer">
                            <ul class="nav navbar-nav">
                                <li class="active dropdown yamm-fw">
                                    <a href="trangchu">TRANG CHỦ</a>

                                </li>
                                <li class="dropdown yamm">
                                    <a href="#" data-hover="dropdown" class="dropdown-toggle" data-toggle="dropdown">SÁCH</a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <div class="yamm-content">
                                                <div class="row">
                                                    <div class='col-sm-12'>
                                                        <div class="col-xs-12 col-sm-12 col-md-12">
                                                            <ul class="links">
                                                                <%

                                                                    for (ProductCategoriesRoot pc1 : pc) {
                                                                %>
                                                                <li><a href="danhsachsanpham?id=<%= pc1.getIdProductCategoriesRoot()%>"><%= pc1.getName()%></a></li>
                                                                    <%
                                                                        }
                                                                    %>                                                                      
                                                            </ul>
                                                        </div><!-- /.col -->
                                                        <!-- /.col -->
                                                    </div>
                                                </div><!-- /.row -->
                                            </div><!-- /.yamm-content -->
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown">

                                    <a href="khuyenmai">
                                        Khuyến mãi
                                        <!--                                        <span class="menu-label hot-menu hidden-xs">new</span>-->
                                    </a>
                                </li>
                                <li class="dropdown " ng-hide="<%=!cookie.getValue().equals("true")%>">

                                    <a href="donhang">
                                        Đơn hàng
                                        <!--                                        <span class="menu-label new-menu hidden-xs">hot</span>-->
                                    </a>
                                </li>
                                <!--                                <li class="dropdown hidden-sm">
                                                                    <a href="category.html">GIẢM GIÁ</a>
                                                                </li>-->
                                <li class="dropdown">
                                    <a href="lienhe">LIÊN HỆ</a>
                                </li>



                            </ul><!-- /.navbar-nav -->
                            <div class="clearfix"></div>
                        </div><!-- /.nav-outer -->
                    </div><!-- /.navbar-collapse -->

                </div><!-- /.nav-bg-class -->
            </div><!-- /.navbar-default -->
        </div><!-- /.container-class -->
    </div><!-- /.header-nav -->
    <!-- ============================================== NAVBAR : END ============================================== -->
</header>