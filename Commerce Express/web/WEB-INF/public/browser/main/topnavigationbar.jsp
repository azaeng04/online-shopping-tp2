<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <a class="brand" href="<%=request.getContextPath()%>/">Commerce Express</a>
        <div class="nav-collapse collapse navbar-responsive-collapse">
            <ul class="nav">
                <li class="${active=='/' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/">Home</a></li>
                <li class="${active=='aboutus' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/aboutus">About Us</a></li>
                <li class="${active=='contactus' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/contactus">Contact Us</a></li>
                <li class="${active=='help' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/help">Help</a></li>

            </ul>
            <ul class="nav pull-right">
                <li class="${active=='login' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/login">Login</a></li>
                <li class="${active=='signup' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/signup">Sign Up</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /navbar-inner -->
</div><!-- /navbar -->