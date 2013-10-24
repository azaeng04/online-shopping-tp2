<%@page import="com.commerce.express.domain.Customer"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%
    session.setMaxInactiveInterval(0);
    Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    if (principle instanceof UserDetails) {
        String username = ((UserDetails) principle).getUsername();
        Customer customer = commerceExpressServices.getCustomerService().getCustomerByUsername(username);
        session.setAttribute("customer", customer);
    } else {
        String username = principle.toString();
        Customer customer = commerceExpressServices.getCustomerService().getCustomerByUsername(username);
        session.setAttribute("customer", customer);
    }
    response.sendRedirect("memberHome");
%>