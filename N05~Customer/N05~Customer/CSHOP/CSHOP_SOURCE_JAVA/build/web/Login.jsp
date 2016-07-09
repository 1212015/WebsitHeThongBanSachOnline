<%-- 
    Document   : Login
    Created on : Jan 8, 2016, 2:32:08 PM
    Author     : PQC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en" ng-app="LoginLogoutApp" ng-controller="LoginLogoutCtrl">
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>
            <div class="breadcrumb">
                <div class="container">
                    <div class="breadcrumb-inner">
                        <ul class="list-inline list-unstyled">
                            <li><a href="#">Home</a></li>
                            <li class='active'>Đăng nhập</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->

            <div class="body-content outer-top-bd">
                <div class="container">
                    <div class="sign-in-page inner-bottom-sm">
                        <div class="row">
                            <div class="col-md-3 col-sm-3"></div>
                            <!-- Sign-in -->			
                            <div class="col-md-6 col-sm-6 sign-in">
                                <h4 class="">Đăng nhập</h4>
                                <form class="register-form outer-top-xs" role="form" name="form" action="trangchu2" method="post" novalidate ng-init="init()">
                                    <div class="form-group">
                                        <label class="info-title" >Địa chỉ email: <span>*</span></label>
                                        <input required ng-model="emaildn" name="email" type="email" class="form-control unicase-form-control text-input"  >
                                        <span style="color:red" ng-show=" form.email.$invalid">
                                            <span ng-show="form.email.$error.required">Email là bắt buộc.</span></br>
                                            <span ng-show="form.email.$error.email">Email không đúng định dạng.</span>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                        <label class="info-title" >Mật khẩu <span>*</span></label>
                                        <input required ng-model="pwddn" name="password" type="password" class="form-control unicase-form-control text-input" >
                                        <span style="color:red" ng-show=" form.password.$invalid">
                                            <span ng-show="form.password.$error.required">Mật khẩu là bắt buộc.</span></br>
                                        </span
                                        </br>
                                        <%  if(request.getSession().getAttribute("loi")!=null) {%>
                                        <span ><%= request.getSession().getAttribute("loi") %></span>
                                        <% } %>
                                    </div>
                                    <div class="radio outer-xs">
<!--                                        <label class="checkbox">
                                            <input type="checkbox" name="optionsRadios" id="optionsRadios2" value="true">Nhớ tài khoản!
                                        </label >-->
                                        </br>
                                        <a href="quenmatkhau" class="forgot-password pull-left">Quên mật khẩu?</a>
                                    </div>
                                    <button type="submit" ng-disabled=" form.password.$invalid ||form.email.$invalid" class="btn-upper btn btn-primary checkout-page-button">Đăng nhập</button>
                                </form>					
                            </div>
                            <!-- Sign-in -->
                            <div class="col-md-3 col-sm-3"></div>
                        </div><!-- /.row -->
                    </div><!-- /.sigin-in-->
                </div><!-- /.body-content -->
            <jsp:include page="_footer.jsp"></jsp:include>
            <script>
                var app = angular.module('LoginLogoutApp', ['angularUtils.directives.dirPagination']);
                app.controller('LoginLogoutCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)
                    {
                        $scope.init= function()
                        {
                          $scope.errordn=null;  
                        };
                        //thực hiện đăng nhập
                        $scope.login = function ()
                        {
                           $http({
                         method: 'POST',
                         url: 'LoginNgController',
                          headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
                         data: 'email='+$scope.emaildn+"&password="+ $scope.pwddn
                         
                        }).success(function (data) {
                            if(data===false)
                              $scope.errordn="Tên đăng nhập hoặc mật khẩu sai!";  
                            
                        }).error(function (data) {
                            $scope.errordn="Tên đăng nhập hoặc mật khẩu sai!";  
                        });
                        };
                        
                    }]);

            </script>
    </body>
</html>