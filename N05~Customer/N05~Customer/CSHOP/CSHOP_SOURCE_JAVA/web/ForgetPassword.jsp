<%-- 
    Document   : ForgetPassword
    Created on : Jan 15, 2016, 3:07:42 PM
    Author     : LONGANH
--%>

<%@page import="POJO.Users"%>
<%@page import="DAO.ListUser"%>
<%@page import="DAO.CookieUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en" >
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>
            <div class="breadcrumb">
                <div class="container">
                    <div class="breadcrumb-inner">
                        <ul class="list-inline list-unstyled">
                            <li><a href="#">Home</a></li>
                            <li class='active'>Quên mật khẩu</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->

            <div class="body-content outer-top-bd">
                <div class="container">
                    <div class="sign-in-page inner-bottom-sm">
                        <div class="row">
                            <div class="col-md-3 col-sm-3"></div>
                            <!-- create a new account -->
                            <div class="col-md-6 col-sm-6 create-new-account">
                                <h4 class="checkout-subtitle">Quên mật khẩu</h4>
                                <!--                                <p class="text title-tag-line">Create your own Unicase account.</p>-->
                                <form class="register-form outer-top-xs" role="form" name="form1" action="quenmatkhau" method="post" novalidate>
                                    <div class="form-group">
                                        
                                       

                                    </div>
                                    <div class="form-group" >
                                        <div class="col-md-6">
                                            <label class="info-title"  >Email <span>*</span></label>
                                            <input  type="email" name="email" class="form-control unicase-form-control text-input"  >
                                            
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            </br>
                                            <button type="submit"  class="btn-upper btn btn-primary checkout-page-button">Gửi</button>
                                        </div>
                                    </div>
                                        </br>
                                        
                                </form>

                            </div>	
                            <!-- create a new account -->
                            <div class="col-md-3 col-sm-3"></div>
                        </div><!-- /.row -->
                    </div><!-- /.sigin-in-->
                </div><!-- /.body-content -->
            <jsp:include page="_footer.jsp"></jsp:include>
           
    </body>
</html>
