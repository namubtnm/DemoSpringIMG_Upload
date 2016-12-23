<%-- 
    Document   : Display
    Created on : Dec 17, 2016, 9:37:01 AM
    Author     : MacBook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="new">add </a>
        <table>
            <c:forEach var="item" items="${lst}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.imgUrl}</td>
                    <td><img src="<c:url value="/imgs/${item.imgUrl}" />" alt="" width="100" height="80"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
