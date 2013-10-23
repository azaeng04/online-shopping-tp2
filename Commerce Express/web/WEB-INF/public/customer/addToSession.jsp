<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.commerce.express.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%
    String qty;
    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
    Map<String, String> cart = new TreeMap<String, String>();
    for (Product product : products) {
        qty = request.getParameter("qty" + product.getId());
        try {
            if (Integer.parseInt(qty) > 0) {
                cart.put(product.getId().toString(), qty);
                session.setAttribute("cart", cart);
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("qty" + product.getId(), "0");
        }
    }
    response.sendRedirect("basket");
%>