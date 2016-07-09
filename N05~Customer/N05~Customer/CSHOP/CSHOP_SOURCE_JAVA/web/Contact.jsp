<%-- 
    Document   : Contact
    Created on : Jan 14, 2016, 10:54:31 AM
    Author     : LONGANH
--%>

<%@page import="POJO.Users"%>
<%@page import="DAO.ListUser"%>
<%@page import="DAO.CookieUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     Cookie cookie = CookieUtil.getCookie(request, "isAuth");
      boolean tmp=cookie.getValue().equals("false");
      Cookie cookie2 = CookieUtil.getCookie(request, "userid");
       int iduser=0;
       String email1="";
      
      if(tmp==false)
      {
        String iduser1 = cookie2.getValue();
        iduser = Integer.parseInt(iduser1);
        ListUser lu = new ListUser();
        email1= lu.GetbyId(iduser).getEmail();
      }
      
%>
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
                            <li class='active'>Liên hệ</li>
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
                                <h4 class="checkout-subtitle">Gửi thắc mắc</h4>
                                <!--                                <p class="text title-tag-line">Create your own Unicase account.</p>-->
                                <form class="register-form outer-top-xs" role="form" name="form1" action="lienhe" method="post" novalidate>
                                    <div class="form-group">
                                        
                                        <div class="col-md-6">
                                            <label class="info-title"   >Tiêu đề: <span>*</span></label>
                                            <input   name="tieude" type="text" class="form-control unicase-form-control text-input"  >
                                            
                                        </div>

                                    </div>
                                    <div class="form-group" >
                                        <div class="col-md-6">
                                            <label class="info-title"  >Email <span>*</span></label>
                                            <input value="<%=email1 %>" type="email" name="email" class="form-control unicase-form-control text-input"  >
                                            
                                        </div>
                                        <div class="col-md-6">
                                            <label class="hidden"  >ID <span>*</span></label>
                                            <input value="<%=iduser %>" type="text" name="iduser" class="hidden"  >
                                            
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label class="info-title"  >Nội dung: <span>*</span></label>
                                            <input style="height: 200px" type="text" name="noidung" class="form-control unicase-form-control text-input"  >
                                            
                                        </div>
                                        
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            </br>
                                            <button type="submit"  class="btn-upper btn btn-primary checkout-page-button">Gửi</button>
                                        </div>
                                    </div>
                                        </br>
                                        <%  if(request.getSession().getAttribute("loinoidung")!=null) {%>
                                        <span ><%= request.getSession().getAttribute("loinoidung") %></span>
                                        <% } %>
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
