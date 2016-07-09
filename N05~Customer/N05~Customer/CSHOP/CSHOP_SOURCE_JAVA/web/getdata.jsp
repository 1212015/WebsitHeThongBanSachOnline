<%-- 
    Document   : getdata
    Created on : Jan 14, 2016, 1:36:22 PM
    Author     : PQC
--%>

<%@page import="DAO.SearchUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SearchUtil db = new  SearchUtil();
 
    String query = request.getParameter("q");
     
    List<String> countries = db.getData(query);
 
    Iterator<String> iterator = countries.iterator();
    while(iterator.hasNext()) {
        String country = (String)iterator.next();
        out.println(country);
    }
%>