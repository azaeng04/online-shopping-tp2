<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <a class="brand" href="<%=request.getContextPath()%>/memberhome">Commerce Express</a>
        <div class="nav-collapse collapse navbar-responsive-collapse">
            <ul class="nav">
                <li class="${active=='/' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberhome">Home</a></li>
                <li class="${active=='orders' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberorders">Orders</a></li>
                <li class="${active=='wishlist' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberwishlist">Wishlist</a></li>
                <li class="${active=='aboutus' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/memberaboutus">About Us</a></li>
                <li class="${active=='contactus' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/membercontactus">Contact Us</a></li>
                <li class="${active=='help' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/memberhelp">Help</a></li>
            </ul>
            <ul class="nav pull-right">
                <li>
                <%
//                    Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                    if(principle instanceof UserDetails){
//                        String username = ((UserDetails)principle).getUsername();
//                    } else {
//                        String username = principle.toString();
//                    }
                %></li>
                <li><a href="<%=request.getContextPath()%>/basket"><img src="resources/images/shopping-basket-icon.png" /></a></li>
                <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>                
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /navbar-inner -->
</div><!-- /navbar -->
