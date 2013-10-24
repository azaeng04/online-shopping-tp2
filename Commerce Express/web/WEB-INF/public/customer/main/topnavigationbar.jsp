<%@page import="com.commerce.express.domain.Customer"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
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
                <li class="${active=='/' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberHome">Home</a></li>
                <li class="${active=='orders' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberOrders">Orders</a></li>
                <li class="${active=='wishlist' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberWishlist">Wishlist</a></li>
                <li class="${active=='aboutus' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/memberAboutUs">About Us</a></li>
                <li class="${active=='contactus' ? 'active' : ''}"><a href="<%=request.getContextPath()%>/memberContactUs">Contact Us</a></li>
                <li class="${active=='help' ? 'active' : ''}" ><a href="<%=request.getContextPath()%>/memberHelp">Help</a></li>
            </ul>
            <ul class="nav pull-right">
                <li>
                <%
                    Customer customer = (Customer) session.getAttribute("customer");
                    out.println("<a>Welcome! "+customer.getFirstName()+"</a>");
                %></li>
                <li><a href="<%=request.getContextPath()%>/memberBasket">View Basket -><img src="resources/images/shopping-basket-icon.png" /></a></li>
                <li><a href="<%=request.getContextPath()%>/memberLogout">Logout</a></li>                
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /navbar-inner -->
</div><!-- /navbar -->
