<%-- 
    Document   : index
    Created on : Oct 9, 2013, 10:00:32 PM
    Author     : Shannon
--%>

<%-- 
    Document   : index
    Created on : 06 Sep 2013, 10:19:44 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<!--	  <div class="positiningTopNavigation">-->
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="">Commerce Express</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active">Home</li>
          </div>
        </div>
      </div>

	
	<div class= "content">
	
	
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
      <h1>Hi Administrator</h1><br>
      Please note that this application has been deployed as a desktop server and will no longer be available as a web service.<br>
      Please make sure you have and use the latest software.<br>
      If you have any other problems,please contact your vendor for details and enquiries at 
      097 126 8129
      </div>
        <jsp:include page="footer.jsp" /> 
     </div>
     </div>
	
      <script src="resources/bootstrap/js/jquery.js"></script>
      <script src="resources/bootstrap/js/bootstrap.js"></script>
   </body>
 </html>
