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
	  <div class="positiningTopNavigation">
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
	            <li class="dropdown">
                        <a href="http://getbootstrap.com/2.3.2/examples/hero.jsp#" class="dropdown-toggle" data-toggle="dropdown">Basket<b class="caret"></b></a>
                            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;width: 700px; height:400px;">
					<form action="[YOUR ACTION]" method="post" accept-charset="UTF-8">
						<table border="1" >
							<tr>
								<td class="span2">Product</td>
								<td class="span2">Quantity</td>
								<td class="span2">Edit</td>
								<td class="span2">Remove</td>
							</tr>
							<tr>
								<td>Product</td>
								<td>Quantity</td>
								<td>Edit</td>
								<td>Remove</td>
							</tr>
							<tr>
								<td>Product</td>
								<td>Quantity</td>
								<td>Edit</td>
								<td>Remove</td>
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
            </ul>
			
            <form class="navbar-form pull-right">
              <input class="span2" type="text" placeholder="Username">
              <input class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">Sign in</button>
			  <button type="submit" class="btn">Register</button>
            </form>
			
          </div>
        </div>
      </div>
   