<%-- 
    Document   : Add
    Created on : Dec 17, 2016, 10:41:09 AM
    Author     : MacBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thêm áo</h1>
        <form:form action="${action}" modelAttribute="clothes" enctype="multipart/form-data">
            <table>                
                <c:choose>
                    <c:when test="${type.equals('update')}">
                        <tr><td><form:input path="id" disabled="true"/></td></tr>
                        <form:hidden path="id" />
                </c:when>    
                <c:otherwise>
                    <tr><td><form:input path="id"/></td></tr>
                </c:otherwise>
                </c:choose>
                <tr><td><form:input path="name" /></td></tr>
                <tr><td><form:input type="file" name="imgUrl" path="imgUrl" /></td></tr>
                <tr><td><form:input path="desciption" /></td></tr>
                <tr><td><input type="submit" value="save"/></td></tr>

            </table>
        </form:form>
    </body>
</html>
