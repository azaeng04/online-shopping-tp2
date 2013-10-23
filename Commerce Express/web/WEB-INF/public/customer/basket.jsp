
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.commerce.express.domain.Product"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%@page import="java.util.Map"%>
<jsp:include page="../browser/main/header.jsp"/>
<body>       
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>

    <div class= "content">
        <div class="container">
            <h1>${title}</h1>
            <%
                try {
                    Map<String, String> cart = (Map<String, String>) session.getAttribute("cart");
                    if (!cart.isEmpty()) {
                        DecimalFormat decimalFormat = new DecimalFormat("###########.00");
                        CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
                        Double grandTotal = 0.0;
                        out.println("<form method='POST' action='checkout'>");
                        out.println("<table class='table table-bordered table-hover'>");
                        out.println("<th>Product ID</th>");
                        out.println("<th>Product Name</th>");
                        out.println("<th>Product Price</th>");
                        out.println("<th>Quantity</th>");
                        out.println("<th>Subtotal</th>");
                        for (Map.Entry<String, String> entry : cart.entrySet()) {
                            String productID = entry.getKey();
                            String quantity = entry.getValue();
                            Product product = commerceExpressCRUD.getProductCrudService().findById(Long.parseLong(productID));
                            Double subtotal = new Double(product.getProductPrice()) * new Integer(quantity);
                            out.println("<tr>");
                            out.println("<td>" + productID + "</td>");
                            out.println("<td>" + product.getProductName() + "</td>");
                            out.println("<td>R" + product.getProductPrice() + "</td>");
                            out.println("<td><input type='number' name='qty" + product.getId() + "' value='" + quantity + "' /></td>");
                            out.println("<td>R" + decimalFormat.format(subtotal) + "</td>");
                            out.println("</tr>");
                            grandTotal += subtotal;
                        }
                        out.println("<tr>");
                        out.println("<td colspan='4' style='text-align: right'>Grand Total </td>");
                        out.println("<td>R" + decimalFormat.format(grandTotal) + "</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("<input type='submit' class='btn btn-primary btn-large' value='Checkout'/>");
                        out.println("</form>");
                    }

                } catch (NullPointerException ex) {
                    out.println("<label>No items in cart</label>");
                }
            %>                
        </div>
    </div>

    <jsp:include page="../browser/main/footer.jsp" />