<%-- 
    Document   : Notify
    Created on : Jan 12, 2016, 2:15:21 PM
    Author     : PQC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <li class='active'>Kiểm tra</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-bd">
                <div class="container">
                    <div class="checkout-box inner-bottom-sm">
                        <div class="row">
                            <div class="col-md-1">
                            </div>
                            <div class="col-md-10">
                                <div class="panel-group checkout-steps" id="accordion">
                                    <!-- checkout-step-01  -->
                                    <div class="panel panel-default  ">

                                        <!-- panel-heading -->
                                        <div class="panel-heading">
                                            <h4 class="unicase-checkout-title">
                                                <a data-toggle="collapse" class="" data-parent="#accordion" href="#collapseOne">
                                                    THÔNG BÁO
                                                </a>
                                            </h4>
                                        </div>
                                        <!-- panel-heading -->

                                        <div id="collapseOne" class="panel-collapse collapse in">

                                            <!-- panel-body  -->
                                            <div class="panel-body">
                                                <div class="row">		
                                                    <form class="register-form" role="form">
                                                        <div class="form-group">
                                                            <h3>Đặt hàng thành công. Vui lòng kiểm tra email để xác nhận đơn đặt hàng.</h3>
                                                        </div>
                                                     
                                                        <div class="form-group">
                                                            <div class="col-md-4">
                                                            </div>
                                                            <div class="col-md-1">
                                                               
                                                                </br>
                                                                <button type="submit" class="btn-upper btn btn-primary checkout-page-button checkout-continue "><a href="trangchu2"> Trang chủ</a></button>
                                                            </div>
                                                        </div>

                                                    </form>
                                                </div>			
                                            </div>
                                            <!-- panel-body  -->

                                        </div><!-- row -->
                                    </div>
                                    <!-- checkout-step-01  -->


                                </div><!-- /.checkout-steps -->
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div><!-- /.row -->
                    </div><!-- /.checkout-box -->
                </div>
            <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
