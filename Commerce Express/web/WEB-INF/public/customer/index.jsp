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
                    <li class ="active"><a href="<%=request.getContextPath()%>/memberhome">Home</a></li>
                    <li><a href="<%=request.getContextPath()%>/memberaboutus">About Us</a></li>
                    <li><a href="<%=request.getContextPath()%>/membercontactus">Contact Us</a></li>
                    <li><a href="<%=request.getContextPath()%>/memberhelp">Help</a></li>
	            <li class="dropdown">
                        <a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#" class="dropdown-toggle" data-toggle="dropdown">Basket<b class="caret"></b></a>
                            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;width: 700px; height:400px;">
					<form action="[YOUR ACTION]" method="post" accept-charset="UTF-8">
						<table border="0" >
                                                    
							<tr>
                                                     
                                                                <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/></td>
                                                                <td class="span2"><input type="text" name="Quantity" placeholder="Quantity"/></td>
                                                                <td><input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></td>
								<td class="span2"><input type="submit" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
							<tr>
								
                                                                <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/></td>
                                                                <td class="span2"><input type="text" name="Quantity" placeholder="Quantity"/></td>
                                                                <td><input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></td>
								<td class="span2"><input type="submit" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
							<tr>
								
                                                                <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/></td>
                                                                <td class="span2"><input type="text" name="Quantity" placeholder="Quantity"/></td>
                                                                <td><input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></td>
								<td class="span2"><input type="submit" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
                                                        
						</table>
						
						<!--<input id="user_username" style="margin-bottom: 15px;" type="text" name="user[username]" size="30" />
						<input id="user_password" style="margin-bottom: 15px;" type="password" name="user[password]" size="30" />
						<input id="user_remember_me" style="float: left; margin-right: 10px;" type="checkbox" name="user[remember_me]" value="1" />
						<label class="string optional" for="user_remember_me"> Remember me</label>
						<input class="btn btn-primary" style="clear: left; width: 100%; height: 32px; font-size: 13px;" type="submit" name="commit" value="Sign In" />-->
						
					</form>
				</div>
              </li>
                <li class="dropdown">
                        <a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#" class="dropdown-toggle" data-toggle="dropdown">Wish List<b class="caret"></b></a>
                            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;width: 500px; height:400px;">
					<form action="[YOUR ACTION]" method="post" accept-charset="UTF-8">
						<table border="0" >
                                                    
							<tr>
                                                                <td class="span2">Product</td>
                                                                <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/>
								<td class="span2"><input type="button" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
							<tr>
								<td class="span2">Product</td>
                                                                <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/>
								<td class="span2"><input type="button" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
							<tr>
                                                            <td class="span2">Product</td>
                                                            <td class="span2"><input type="text" name="ProductName" placeholder="Product Name"/>
                                                            <td class="span2"><input type="button" name="remove" value="Remove" class="span0 btn-danger"></td>
							</tr>
                                                        
						</table>
						
						<!--<input id="user_username" style="margin-bottom: 15px;" type="text" name="user[username]" size="30" />
						<input id="user_password" style="margin-bottom: 15px;" type="password" name="user[password]" size="30" />
						<input id="user_remember_me" style="float: left; margin-right: 10px;" type="checkbox" name="user[remember_me]" value="1" />
						<label class="string optional" for="user_remember_me"> Remember me</label>
						<input class="btn btn-primary" style="clear: left; width: 100%; height: 32px; font-size: 13px;" type="submit" name="commit" value="Sign In" />-->
						
					</form>
				</div>
              </li>
              
<!--              <li class="dropdown">
                <a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#" class="dropdown-toggle" data-toggle="dropdown">Wish List<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#">Action</a></li>
                  <li><a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#">Another action</a></li>
                  <li><a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#">Something else here</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">Nav header</li>
                  <li><a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#">Separated link</a></li>
                  <li><a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#">One more separated link</a></li>
                </ul>
                
              </li>
            </ul>-->
			
<!--            <form class="navbar-form pull-right">
              <input class="span2" type="text" placeholder="Username">
              <input class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">Sign in</button>
			  <button type="submit" class="btn">Register</button>
            </form>-->
			
          </div>
        </div>
      </div>

	<div class= "sidenavigation">
            <jsp:include page="sidenavigationbar.jsp" /> 
	</div>
	
	<div class= "content">
	
	<div class="container">
            <p>
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
                </select>&nbsp &nbsp <input type="text" name="searchItemName" placeholder="Search Item...">&nbsp &nbsp 
                <button type="submit" class="btn">Search</button>
                </div>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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
                <li>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Quantity" placeholder="Quantity" class="span1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToQauntity" value="+" class="span0 btn-primary"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="addToCart" value="Add to Cart" class="span0 btn-primary"></li>
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