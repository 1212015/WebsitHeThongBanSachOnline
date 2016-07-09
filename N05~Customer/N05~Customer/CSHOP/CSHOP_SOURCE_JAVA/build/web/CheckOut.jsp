<%-- 
    Document   : CheckOut
    Created on : Jan 12, 2016, 1:15:56 PM
    Author     : PQC
--%>

<%@page import="POJO.Users"%>
<%@page import="DAO.ListUser"%>
<%@page import="DAO.CookieUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie cookie2 = CookieUtil.getCookie(request, "userid");
    int iduser = 0;
    if (cookie2.getValue().equals("") == false) {
        iduser = Integer.parseInt(cookie2.getValue());
    }
    ListUser l = new ListUser();
    Users u = l.GetbyId(iduser);
%>
<!DOCTYPE html>
<html lang="en" ng-app="NotifyApp" ng-controller="NotifyCtrl">
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
                                                    THÔNG TIN NGƯỜI NHẬN HÀNG
                                                </a>
                                            </h4>
                                        </div>
                                        <!-- panel-heading -->

                                        <div id="collapseOne" class="panel-collapse collapse in">
                                        <%
                                            if (u != null) {
                                        %>
                                        <!-- panel-body  -->
                                        <div class="panel-body">
                                            <div class="row">		
                                                <form class="register-form" role="form" action="NotifyController" method="GET">
                                                    <div class="form-group">
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Họ tên: <span>*</span></label>
                                                            <input type="text" name="hoten" value="<%= u.getLastName()%> <%=u.getFirstName()%>" class="form-control unicase-form-control text-input"  placeholder="Họ tên">
                                                        </div>
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Email: <span>*</span></label>
                                                            <input ng-hide="1 > 0" name="id" value="<%= iduser%>"></input>
                                                            <input type="email" name="email" value="<%=u.getEmail()%>" class="form-control unicase-form-control text-input"   placeholder="Địa chỉ email">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Địa chỉ giao hàng:<span>*</span></label>
                                                            <input type="text" name="diachi" value="<%= u.getAddress()%>" class="form-control unicase-form-control text-input" id="exampleInputPassword1" placeholder="Địa chỉ số nhà, quận/huyện, tỉnh/thành phố">
                                                        </div>
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Số điện thoại:<span>*</span></label>
                                                            <input type="text" name="sdt" value="<%=u.getPhone()%>" class="form-control unicase-form-control text-input" id="exampleInputPassword1" placeholder="Số điện thoại">
                                                        </div>

                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-md-12">
                                                            <h3>Tổng tiền sản phẩm: <span style="color: green">{{tongtien}} VND</span></h3>
                                                            <h3>Giảm giá: <span style="color: green ">{{giamgia}} VND</span></h3>
                                                            <h3>Thành tiền: <span style="color: green ">{{tongtien-giamgia}} VND</span></h3>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-1">

                                                            </br>
                                                            <button type="submit" class="btn-upper btn btn-primary checkout-page-button checkout-continue ">Đặt hàng</button>
                                                        </div>
                                                    </div>

                                                </form>
                                            </div>			
                                        </div>
                                        <!-- panel-body  -->
                                        <%}%>
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
                <script>
                    var app = angular.module('NotifyApp', ['angularUtils.directives.dirPagination']);
                    app.controller('NotifyCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)
                        {

                            $http({
                                method: 'GET',
                                url: 'TotalCashNgController'
                            }).success(function (data) {
                                $scope.tongtien = data;
                                $scope.giamgias();

                            }).error(function (data) {

                            });
                            $scope.giamgias = function (id)
                            {
                                $http({
                                    method: 'GET',
                                    url: 'GetDiscountPercentNgController?id=' +<%=iduser%>
                                }).success(function (data) {
                                    $scope.giamgia = data;

                                }).error(function (data) {

                                });
                            };

                        }]);

            </script>
    </body>
</html>