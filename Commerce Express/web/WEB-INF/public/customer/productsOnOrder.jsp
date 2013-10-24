<%@page import="com.commerce.express.domain.Orders"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
<%@page import="com.commerce.express.domain.OrderLine"%>
<%@page import="com.commerce.express.domain.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                String orderID = session.getAttribute("orderID").toString();
                String table = commerceExpressServices.getOrderService().displayProductsOnOrder(orderID);
                out.println(table);
            %>  
        </div>
    </div>
    <jsp:include page="../browser/main/footer.jsp" />