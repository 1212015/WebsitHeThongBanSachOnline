<%-- 
    Document   : DetailSale
    Created on : Jan 13, 2016, 11:15:43 PM
    Author     : PQC
--%>
<%@page import="POJO.Products"%>
<%@page import="DAO.ListProduct"%>
<%@page import="DAO.ListOffer"%>
<%@page import="POJO.OfferDetails"%>
<%@page import="java.util.ArrayList"%>
<%
    ListProduct lp = new ListProduct();
    ListOffer l = new ListOffer();
    String id1 = request.getParameter("id");
    int id = Integer.parseInt(id1);
    ArrayList<OfferDetails> a = null;
    try {
        a = l.GetOfferDetail(id);
    } catch (Exception e) {

    }


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en"  >
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
                            <li class='active'>Chi tiết KM</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-bd">
                <div class="container">
                    <div class="my-wishlist-page inner-bottom-sm">
                        <div class="row">
                            <div class="col-md-12  shopping-cart-table"
                                 <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th class="cart-product-name item">Tên sản phẩm</th>
                                                <th class="cart-product-name item">Nhà xuất bản</th>
                                                <th class="cart-sub-total item">Giảm giá</th>
                                            </tr>
                                        </thead><!-- /thead -->

                                        <tbody>         
                                        <%                                                for (OfferDetails m : a) {
                                                Products p = lp.Get(m.getProductID());
                                        %>
                                        <tr >
                                            <td class="romove-item" ><a href="chitietsanpham?id=<%=m.getProductID() %>"><%= p.getName() %></a></td>
                                            <td class="romove-item" ><%= p.getPublisher() %></td>

                                            <td class="romove-item" ><%= m.getDiscount()%>%</td>

                                        </tr>
                                        <%}%>
                                    </tbody><!-- /tbody -->
                                </table><!-- /table -->
                            </div>
                        </div>		
                    </div>		
                </div>		
            </div>		
        </div>		
        <jsp:include page="_footer.jsp"></jsp:include>
       
    </body>
</html>
