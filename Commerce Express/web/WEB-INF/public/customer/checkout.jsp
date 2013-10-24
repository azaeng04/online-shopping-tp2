<%@page import="java.util.TreeMap"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
<%@page import="com.commerce.express.domain.Customer"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> cart = (Map<String, String>) session.getAttribute("cart");
    Customer customer = (Customer) session.getAttribute("customer");
    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    commerceExpressServices.getOrderService().checkout(cart, customer);
    session.setAttribute("cart", null);
    response.sendRedirect("memberOrders");
%>