<%@page import="com.commerce.express.domain.Customer"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
<%@page import="com.commerce.express.domain.Orders"%>
<%@page import="java.util.List"%>
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
                    Customer customer = (Customer) session.getAttribute("customer");
                    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
                    List<Orders> orders = commerceExpressServices.getOrderService().getOrders(customer.getUserID());
                    session.setAttribute("orders", orders);
                    String table = commerceExpressServices.getOrderService().orderTable(orders);
                    out.println(table);
                } catch (NullPointerException ex) {
                    Customer customer = (Customer) session.getAttribute("customer");
                    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
                    try {
                        List<Orders> customersOrders = commerceExpressServices.getOrderService().getOrders(customer.getUserID());
                        session.setAttribute("orders", customersOrders);
                        String table = commerceExpressServices.getOrderService().orderTable(customersOrders);
                        out.println(table);
                    } catch (NullPointerException e) {
                        out.println("<label>No orders made</label>");
                    }
                }
            %>              
        </div>
    </div>

    <jsp:include page="../browser/main/footer.jsp" />