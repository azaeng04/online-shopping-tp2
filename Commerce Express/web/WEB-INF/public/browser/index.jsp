<%-- 
    Document   : index
    Created on : 06 Sep 2013, 10:19:44 PM
    Author     : Owner
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
                <meta name="viewport" content="width=device-width">
		<title>Home</title>
		<link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
		<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
        <link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="jquery.dropdown.css" />
        <script type="text/javascript" src="jquery.dropdown.js"></script>
   </head>
   <body>
	
      <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
	  <div class="positiningTopNavigation">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="">Commerce Express</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="<%=request.getContextPath()%>/">Home</a></li>
                    <li><a href="<%=request.getContextPath()%>/aboutus">About Us</a></li>
                    <li><a href="<%=request.getContextPath()%>/contactus">Contact Us</a></li>
                    <li><a href="<%=request.getContextPath()%>/help">Help</a></li>
	            <li><a href="<%=request.getContextPath()%>/login">Login</a></li>
                    <li><a href="<%=request.getContextPath()%>/signup">Sign Up</a></li>
          </div>
        </div>
      </div>

	<div class= "sidenavigation">
            <jsp:include page="sidenavigationbar.jsp" /> 
	</div>
	
	<div class= "content">
	
	<div class="container">
            <p> 
            <table>
                <tr><td>
                <div class="categoryFont">Categories: &nbsp
                <select id = "myList">
                    <option value = "beverages">Beverages</option>
                    <option value = "breadbakery">Bread/Bakery</option>
                    <option value = "cannedGoods">Canned Good</option>
                    <option value = "dairy">Dairy</option>
                    <option value = "dryGoods">Dry Goods</option>
                    <option value = "frozenfoods">Frozen Foods</option>
                    <option value = "meat">Meat</option>
                    <option value = "produce">Produce</option>
                    <option value = "cleaners">Cleaners</option>
                    <option value = "papergoods">Paper Goods</option>
                    <option value = "personalcare">Personal Care</option>
                    <option value = "babyitems">Baby Items</option>
                    <option value = "frozenfoods">Frozen Foods</option>
                    <option value = "snacks">Snacks</option>
                    <option value = "Spices">Spices</option>
                </select>
                &nbsp &nbsp <input type="text" name="searchItemName" placeholder="Search Item...">&nbsp &nbsp 
                <button type="submit" class="btn">Search</button>
                </div>
                    </td>
                </tr>
             </table>
            </p>
	    <br>
	    <!-- Main hero unit for a primary marketing message or call to action -->
             <div id="myCarousel" class="carousel slide">
	    <!-- Carousel items -->
                <div class="carousel-inner">
			<div class="active item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
			<div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
		</div>
	  <!-- Carousel nav -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
          </div>

      <!-- Example row of columns -->
     <div class="row">
        <c:forEach items = "${products}" var = "product">
        <div class="span4 carshow">
<!--			<h2>Product 1</h2>
			<h3>Price : R30:00</h3>-->
			<img src="${product.imageURL}" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
              
              
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="productName" value="${product.productName}" /></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="description" placeholder="Price" value="${product.description}"/></li>
               
            </ul>
          </div>
        </div></p>
         
        </div>
        </c:forEach>        
     </div>
        
         
      <div class="row">
        <c:forEach items = "${products}" var = "product">
        <div class="span4 carshow">
<!--			<h2>Product 1</h2>
			<h3>Price : R30:00</h3>-->
			<img src="${product.imageURL}" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
              
              
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="productName" value="${product.productName}" /></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="description" placeholder="Price" value="${product.description}"/></li>
               
            </ul>
          </div>
        </div></p>
                
        </div>
        </c:forEach> 
      </div>
         
<!--        <div class="span4  carshow">
			<img src="resources/images/product.jpg" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="ProductName" placeholder="Product Name"/></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price" placeholder="Price"/></li>
            </ul>
          </div>
        </div></p>
        </div>
        <div class="span4  carshow">
			<img src="resources/images/product.jpg" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="ProductName" placeholder="Product Name"/></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price" placeholder="Price"/></li>
            </ul>
          </div>
        </div></p>
        </div>
      </div>
 
      <div class="row">
        <div class="span4  carshow">
			<img src="resources/images/product.jpg" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="ProductName" placeholder="Product Name"/></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price" placeholder="Price"/></li>
            </ul>
          </div>
        </div></p>
        </div>
        <div class="span4  carshow">
			<img src="resources/images/product.jpg" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="ProductName" placeholder="Product Name"/></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price" placeholder="Price"/></li>
            </ul>
          </div>
        </div></p>
        </div>
        <div class="span4  carshow">
			<img src="resources/images/product.jpg" class="img-rounded" />
          	<p> <div class="btn-group-vertical">
          <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-info" data-toggle="dropdown">
            More Info
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li>Product Name:<input type="text" name="ProductName" placeholder="Product Name"/></li>
                <li>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price" placeholder="Price"/></li>
                
            </ul>
          </div>
        </div></p>
        </div>-->
       
      </div>
      </div>
        <jsp:include page="footer.jsp" /> 
     </div>
     </div>
	
      <script src="resources/bootstrap/js/jquery.js"></script>
      <script src="resources/bootstrap/js/bootstrap.js"></script>
   </body>
 </html>