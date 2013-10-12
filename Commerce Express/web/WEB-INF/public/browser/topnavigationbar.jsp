<!DOCTYPE html>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
  
    
    <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
    <link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="jquery.dropdown.css" />
    
    <script type="text/javascript" src="jquery.dropdown.js"></script>
  
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
                    <li><a href="<%=request.getContextPath()%>/help">Help</a></li>
	            <li><a href="<%=request.getContextPath()%>/login">Login</a></li>
                    <li><a href="<%=request.getContextPath()%>/signup">Sign Up</a></li>
          </div>
        </div>
      </div>
   