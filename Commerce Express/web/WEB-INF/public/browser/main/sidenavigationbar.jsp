<!DOCTYPE html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    
    <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
    <link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="jquery.dropdown.css" />
    <script type="text/javascript" src="jquery.dropdown.js"></script>
		
    <center>
        Select Category
        <c:forEach var="category" items="${categories}">
            <p>
                <a href="<%=request.getContextPath()%>/categoryID=${category.id}"><button type="submit" class="btn btn-large btn btn-primary">${category.categoryName}</button></a>
            </p>
        </c:forEach>
      </center>