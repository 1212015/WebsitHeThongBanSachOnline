<%-- 
    Document   : Profile
    Created on : Jan 14, 2016, 7:20:05 AM
    Author     : LONGANH
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
<html lang="en" ng-app="ProfileApp" ng-controller="ProfileCtrl">
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
                            <li class='active'>Thông Tin Cá Nhân</li>
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
                                                    THÔNG TIN KHÁCH HÀNG
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
                                                <form class="register-form" role="form" action="ProfileController" method="post">
                                                    <div class="form-group">
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Họ: <span>*</span></label>
                                                            <input type="text" name="ho" value="<%= u.getLastName()%>" class="form-control unicase-form-control text-input"  placeholder="Họ">
                                                        </div>
                                                        <div class="col-md-6">
                                                            <label class="info-title"  >Tên: <span>*</span></label>
                                                            <input type="text" name="ten" value="<%=u.getFirstName()%>" class="form-control unicase-form-control text-input"  placeholder="tên">
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-6">
                                                                <label class="info-title"  >Email: <span>*</span></label>
                                                                <!--<input class="hiden" name="id" value="<%= iduser%>"></input>-->
                                                                <input type="email" name="email" value="<%=u.getEmail()%>" class="form-control unicase-form-control text-input"   placeholder="Địa chỉ email">
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="info-title"  >Địa chỉ:<span>*</span></label>
                                                                <input type="text" name="diachi" value="<%= u.getAddress()%>" class="form-control unicase-form-control text-input" id="exampleInputPassword1" placeholder="Địa chỉ số nhà, quận/huyện, tỉnh/thành phố">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-6">
                                                                <label class="info-title"  >Giới tính: <span>*</span></label>
                                                                <input type="text" name="gioitinh" value="<%=u.getGender()%>" class="form-control unicase-form-control text-input"   placeholder="Nam hoặc Nữ">
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="info-title"  >Số điện thoại:<span>*</span></label>
                                                                <input type="text" name="sdt" value="<%=u.getPhone()%>" class="form-control unicase-form-control text-input" id="exampleInputPassword1" placeholder="Số điện thoại">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">

                                                            <div class="col-md-6">
                                                                <label class="hidden"  >ID <span>*</span></label>
                                                                <input value="<%=iduser%>" type="text" name="iduser" class="hidden"  >
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="info-title"  >Ngày sinh: <span>*</span></label>
                                                                <input type="date" name="ngaysinh" value="<%=u.getBirthday()%>" class="form-control unicase-form-control text-input"   placeholder="Địa chỉ email">
                                                            </div>
                                                            <div class="col-md-6">
                                                                </br>
                                                                <button type="submit" class="btn-upper btn btn-primary checkout-page-button checkout-continue ">Cập nhập</button>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                </form>
                                                <form class="register-form" role="form" action="doimatkhau" method="get">
                                                            <div class="col-md-6">
                                                                </br>
                                                                <button type="submit"  class="btn-upper btn btn-primary checkout-page-button checkout-continue ">Đổi mật khẩu</button>
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
    </body>
</html>