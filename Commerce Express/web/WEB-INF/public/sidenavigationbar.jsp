<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">

<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="jquery.dropdown.css" />
<script type="text/javascript" src="jquery.dropdown.js"></script>

<center>
    Groceries
    <c:forEach var="category" items="${categories}">
        <p>
            <a href="<%=request.getContextPath()%>/categoryID=${category.id}"><button type="submit" class="btn btn-large button">${category.categoryName}</button></a>
        </p>
    </c:forEach>
    <!--<p>
        <a href="<%=request.getContextPath()%>/bakery"><button type="submit" class="btn btn-large">Bread/Bakery</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/cannedgoods"><button type="submit" class="btn btn-large">Canned Goods</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/dairy"><button type="submit" class="btn btn-large">Dairy</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/drygoods"><button type="submit" class="btn btn-large">Dry Goods</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/bakinggoods"><button type="submit" class="btn btn-large">Baking Goods</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/frozenfoods"><button type="submit" class="btn btn-large">Frozen Foods</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/meat"><button type="submit" class="btn btn-large">Meat</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/produce"><button type="submit" class="btn btn-large">Produce</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/snacks"><button type="submit" class="btn btn-large">Snacks</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/spices"><button type="submit" class="btn btn-large">Spices</button></a>
    </p>
    Pamper Goods
    <p>
        <a href="<%=request.getContextPath()%>/babyitems"><button type="submit" class="btn btn-large">Baby Items</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/personalcare"><button type="submit" class="btn btn-large">Personal Care</button></a>
    </p>
    Home Care
    <p>
        <a href="<%=request.getContextPath()%>/cleaners"><button type="submit" class="btn btn-large">Cleaners</button></a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/papergoods"><button type="submit" class="btn btn-large">Paper Goods</button></a>
    </p> -->
</center>
