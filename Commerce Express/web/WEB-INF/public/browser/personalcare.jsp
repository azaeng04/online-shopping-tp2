<!DOCTYPE html>
<html>
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Personal Care</title>
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
   </head>
   <body>
	
	<div class="navigationbar">
	  <jsp:include page="topnavigationbar.jsp" />
	</div>
	
	<div class= "sidenavigation">
		<jsp:include page="sidenavigationbar.jsp" />
	</div>
	
	<div class= "content">
            <div class="container">
                <h1>Personal Care Page</h1>
                
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
        <div class="span4 carshow">
<!--			<h2>Product 1</h2>
			<h3>Price : R30:00</h3>-->
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
        </div>
       
      </div>
                <jsp:include page="footer.jsp" />
            </div>
	</div>
	
	<script src="resources/bootstrap/js/jquery.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
   </body>
 </html>