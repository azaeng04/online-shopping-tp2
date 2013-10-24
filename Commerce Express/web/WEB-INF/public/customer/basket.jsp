
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.commerce.express.domain.Product"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
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
                CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
                try {
                    Map<String, String> cart = (Map<String, String>) session.getAttribute("cart");
                    String table = commerceExpressServices.getCartService().displayCart(cart);
                    out.println(table);
                } catch (NullPointerException ex) {
                    out.println("<label>No items in cart</label>");
                }
            %>                
        </div>
    </div>

    <jsp:include page="../browser/main/footer.jsp" />