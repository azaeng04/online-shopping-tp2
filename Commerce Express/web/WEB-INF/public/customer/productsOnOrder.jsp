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
            <label>Content here!</label>
            <table border="1" class='table table-bordered table-hover'>
                <thead>
                    <tr>
                        <td colspan="4" style="text-align: right">Order ID</td>
                        <td>${orderID}</td>
                    </tr>
                    <tr>
                        
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <c:forEach items = "${products}" var = "product">
                    <tbody>
                        <tr>
                            <td>${product.productID}</td>
                            <td>${product.productName}</td>
                            <td>${product.productPrice}</td>                            
                            <c:forEach items = "${orderLines}" var = "orderLine">
                                <c:if test="${product.productID == orderLine.productID}">
                                    <td>${orderLine.quantity}</td>
                                </c:if>                                
                            </c:forEach>
                            <td>${product.productID}</td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>

        </div>
    </div>
    <jsp:include page="../browser/main/footer.jsp" />