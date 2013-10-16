<%@page import="com.commerce.express.app.facade.CategoryFacade"%>
<%@page import="java.util.Map"%>
<jsp:include page="../browser/main/header.jsp"/>
<body>       
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>

    <div class= "content">
        <div class="container">
            <h1>${title} Page</h1>
            <%
                Map<String, String> cart = (Map<String, String>) session.getAttribute("cart");
                try {
                    if (!cart.isEmpty()) {
                        CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();
                        out.println("<table class='table table-bordered table-hover'>");
                        out.println("<th>Product ID</th>");
                        out.println("<th>Product Name</th>");
                        out.println("<th>Quantity</th>");
                        for (Map.Entry<String, String> entry : cart.entrySet()) {
                            String productID = entry.getKey();
                            String productName = categoryFacade.getProductCrudService().findById(Long.parseLong(productID)).getProductName();
                            String quantity = entry.getValue();
                            out.println("<tr>");
                            out.println("<td>" + productID + "</td>");
                            out.println("<td>" + productName + "</td>");
                            out.println("<td><input type='number' name='qty" + productID + "' value='" + quantity + "' /></td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                    }
                } catch (NullPointerException ex) {
                    out.println("<label>No items in cart</label>");
                }
            %>                
        </div>
    </div>

    <jsp:include page="../browser/main/footer.jsp" />