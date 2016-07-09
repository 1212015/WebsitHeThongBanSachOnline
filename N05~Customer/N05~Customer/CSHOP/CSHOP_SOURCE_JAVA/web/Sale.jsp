<%-- 
    Document   : Sale
    Created on : Jan 13, 2016, 1:38:11 PM
    Author     : LONGANH
--%>
<%@page import="POJO.Offers"%>
<%@page import="POJO.OfferDetails"%>
<%@page import="DAO.ListOffer"%>
<%@page import="POJO.Products"%>
<%@page import="POJO.Products"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="POJO.ProductCategoriesSub"%>
<%@page import="POJO.ProductCategoriesRoot"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ListProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en" ng-app="SalerApp" ng-controller="SaleCtrl" >
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
                            <li class='active'>Khuyến mãi</li>
                        </ul>
                    </div><!-- /.breadcrumb-inner -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb -->
            <div class="body-content outer-top-bd">
                <div class="container">
                    <div class="my-wishlist-page inner-bottom-sm">
                        <div class="row">
                            <div class="col-md-12 my-wishlist">
                                <div class="table-responsive">
                                    <h3 dir-paginate="s in sales|itemsPerPage:10">
                                        {{s.idOffers}}.<a href="chitietkhuyenmai?id={{s.idOffers}}"> {{s.name}}-Bắt đầu từ {{s.startDate}} đến {{s.endDate}}</a> 
                                    </h3>

                                </div>
                                <div class="clearfix filters-container">
                                    <div class="text-center">
                                        <dir-pagination-controls max-size="5"
                                                                 direction-links="true"
                                                                 boundary-links="true">
                                        </dir-pagination-controls>
                                    </div><!-- /.text-right -->
                                </div>
                            </div>		

                        </div>		

                    </div>		

                </div>		

            </div>		
        <jsp:include page="_footer.jsp"></jsp:include>
        <script>
                    var app = angular.module('SalerApp', ['angularUtils.directives.dirPagination']);
                    app.controller('SaleCtrl', ['$scope', '$location', '$window', '$http', function ($scope, $location, $window, $http)
                        {
                            $http({
                                method: 'GET',
                                url: 'LoadSaleNgController'
                            }).success(function (data) {
                                $scope.sales = data;

                            }).error(function (data) {

                            });
                        }]);

        </script>
    </body>
</html>