<!DOCTYPE html>
<html>
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Help</title>
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
                    <li><a href="<%=request.getContextPath()%>/">Home</a></li>
                    <li><a href="<%=request.getContextPath()%>/aboutus">About Us</a></li>
                    <li><a href="<%=request.getContextPath()%>/contactus">Contact Us</a></li>
                    <li class="active"><a href="<%=request.getContextPath()%>/help">Help</a></li>
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
                <h1>Help Page</h1>
                
                <br>
                <br>
                <br>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                
                <jsp:include page="footer.jsp" />
            </div>
	</div>
            
	<script src="resources/bootstrap/js/jquery.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
   </body>
 </html>