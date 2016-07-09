<%-- 
    Document   : Register
    Created on : Jan 10, 2016, 1:03:09 PM
    Author     : PQC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en" ng-app="RegisterApp" ng-controller="RegisterCtrl">
    <jsp:include page="_header.jsp"></jsp:include>
        <body class="cnt-home">
            <!-- ============================================== HEADER ============================================== -->
        <jsp:include page="_menu.jsp"></jsp:include>
            <div class="breadcrumb">
                <div class="container">
                    <div class="breadcrumb-inner">
                        <ul class="list-inline list-unstyled">
                            <li><a href="#">Home</a></li>
                            <li class='active'>Đăng ký</li>
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
                                <h4 class="checkout-subtitle">Tạo tài khoản</h4>
                                <!--                                <p class="text title-tag-line">Create your own Unicase account.</p>-->
                                <form class="register-form outer-top-xs" role="form" name="form1" action="trangchu3" method="post" novalidate>
                                    <div class="form-group">
                                        <div class="col-md-6">
                                            <label class="info-title"   >Họ : <span>*</span></label>
                                            <input required ng-model="ho"  name="ho" type="text" class="form-control unicase-form-control text-input"  >
                                            <span style="color:red" ng-show=" form1.ho.$invalid">
                                                <span ng-show="form1.ho.$error.required">Họ là bắt buộc.</span>
                                            </span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="info-title"   >Tên: <span>*</span></label>
                                            <input required ng-model="ten" name="ten" type="text" class="form-control unicase-form-control text-input"  >
                                            <span style="color:red" ng-show=" form1.ten.$invalid">
                                                <span ng-show="form1.ten.$error.required">Tên là bắt buộc.</span>
                                            </span>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-6">
                                            <label class="info-title"  >Email <span>*</span></label>
                                            <input required ng-model="email"  type="email" name="email" class="form-control unicase-form-control text-input"  >
                                            <span style="color:red" ng-show=" form1.email.$invalid">
                                                <span ng-show="form1.email.$error.required">Email là bắt buộc.</span></br>
                                                <span ng-show="form1.email.$error.email">Email không đúng định dạng.</span>
                                            </span>
                                            </span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="info-title"  >SĐT<span>*</span></label>
                                            <input required ng-model="sdt"  type="text" name="sdt" class="form-control unicase-form-control text-input"  >
                                            <span style="color:red" ng-show=" form1.sdt.$invalid">
                                                <span ng-show="form1.sdt.$error.required">Số điện thoại là bắt buộc.</span>
                                            </span>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label class="info-title"  >Địa chỉ <span>*</span></label>
                                            <input required  ng-model="diachi" type="text" name="diachi" class="form-control unicase-form-control text-input"  >
                                             <span style="color:red" ng-show=" form1.diachi.$invalid">
                                                <span ng-show="form1.diachi.$error.required">Địa chỉ là bắt buộc.</span>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-6">
                                            <label class="info-title"  >Mật khẩu <span>*</span></label>
                                            <input required ng-model="matkhau"  type="password" name="matkhau" class="form-control unicase-form-control text-input"  >
                                             <span style="color:red" ng-show="  form1.matkhau.$invalid">
                                                <span ng-show="form1.matkhau.$error.required">Mật khẩu là bắt buộc.</span>
                                            </span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="info-title"  >Xác nhận mật khẩu <span>*</span></label>
                                            <input required ng-model="xnmatkhau"  type="password" name="xnmatkhau" class="form-control unicase-form-control text-input"  >
                                             <span style="color:red" ng-show="  form1.xnmatkhau.$invalid">
                                                <span ng-show="form1.xnmatkhau.$error.required">Xác nhận mật khẩu là bắt buộc.</span>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            </br>
                                            <button type="submit" ng-disabled="form1.ten.$invalid || form1.ho.$invalid ||  form1.email.$invalid || 
form1.sdt.$invalid || form1.diachi.$invalid || form1.matkhau.$invalid || form1.xnmatkhau.$invalid" class="btn-upper btn btn-primary checkout-page-button">Đăng ký</button>
                                        </div>
                                    </div>
                                        </br>
                                        <%  if(request.getSession().getAttribute("loidangky")!=null) {%>
                                        <span ><%= request.getSession().getAttribute("loidangky") %></span>
                                        <% } %>
                                </form>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="2TZ73GFNRA7RA">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>

                            </div>	
                            <!-- create a new account -->
                            <div class="col-md-3 col-sm-3"></div>
                        </div><!-- /.row -->
                    </div><!-- /.sigin-in-->
                </div><!-- /.body-content -->
            <jsp:include page="_footer.jsp"></jsp:include>
            <script>
                var app = angular.module('RegisterApp', ['angularUtils.directives.dirPagination']);
                app.controller('RegisterCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)
                    {
                        
                        // thực hiện đăng ký
                        $scope.register = function ()
                        {

                        };
                    }]);

            </script>
    </body>
</html>
