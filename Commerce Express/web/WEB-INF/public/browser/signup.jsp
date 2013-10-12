<!DOCTYPE html>
<html>
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Register</title>
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
                    <li class="active"><a href="<%=request.getContextPath()%>/signup">Sign Up</a></li>
          </div>
        </div>
      </div>

	<div class= "sidenavigation">
		<jsp:include page="sidenavigationbar.jsp" />
	</div>
	
	<div class= "content">
            <div class="container">
                <h1>Sign up Page</h1>
              
        <div class="row">
        <div class="span3 carshow">
            <h2>Access Details</h2>
            <hr> <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" class ="span2"/></td>
                    </tr>
                </table>
            
           
        </div>
        <div class="span3 carshow">
              <h2>User Details</h2>
              <hr>
		 <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstname" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" class ="span2"/></td>
                    </tr>
                     <tr>
                        <td>Middle Name:</td>
                        <td><input type="text" name="middleName" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>DOB:</td>
                        <td><input type="text" name="dob" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td><input type="text" name="gender" class ="span2"/></td>
                    </tr>
                    
                </table>

        </div>
        <div class="span3  carshow">
	      <h2>Address</h2>
              <hr>
		 <table>
                    <tr>
                        <td>Postal Address:</td>
                        <td><input type="text" name="postalAddress" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>Physical Address:</td>
                        <td><input type="text" name="physicalAddress" class ="span2"/></td>
                    </tr>
                     <tr>
                        <td>Postal Code:</td>
                        <td><input type="text" name="postalCode" class ="span2"/></td>
                    </tr>
                  
                    
                </table>
         </div>
          <div class="span3 carshow">
            <h2>Contact Details</h2>
            <hr> 
            <table>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="text" name="email" class ="span2"/></td>
                    </tr>
                    <tr>
                        <td>Cell Number:</td>
                        <td><input type="text" name="cellnumber" class ="span2"/></td>
                    </tr>
                     <tr>
                        <td>Home Number:</td>
                        <td><input type="text" name="homenumber" class ="span2"/></td>
                    </tr>
                    
                </table>
            <br>
                    <br>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><input type="submit" name="sign up" value="Sign Up>" class ="span2"/>
           
        </div>
           
                <br>
                <br>
                <br>
              
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                
                <jsp:include page="footer.jsp" />
            </div>
	</div>
	
	<script src="resources/bootstrap/js/jquery.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
   </body>
 </html>