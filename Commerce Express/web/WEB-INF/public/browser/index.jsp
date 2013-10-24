<%-- 
    Document   : index
    Created on : 06 Sep 2013, 10:19:44 PM
    Author     : Owner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="main/header.jsp"/>
<body>

    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" /> 
    </div>

    <div class= "content">
        <div class="container">

            <jsp:include page="categorySearch.jsp" />
            <br>
            <!-- Main hero unit for a primary marketing message or call to action -->
            <jsp:include page="carousel.jsp" />
            <div class="row">
                <table id="products">
                    <c:forEach items = "${products}" var = "product">
                        <div class="span4 carshow">
                            <c:choose>
                                <c:when test="${product.productStatus.inStock == 0}">
                                    <h3>${product.id}. ${product.productName}</h3>
                                    <h4>Price : R${product.productPrice}</h4>
                                    <h5>In Stock: ${product.productStatus.inStock}</h5>
                                    <img src="<c:url value='resources/images/soldOut.png' />"  class="img-rounded" />
                                </c:when>
                                <c:otherwise>
                                    <h3>${product.id}. ${product.productName}</h3>
                                    <h4>Price : R${product.productPrice}</h4>
                                    <h5>In Stock: ${product.productStatus.inStock}</h5>
                                    <img src="${product.imageURL}" class="img-rounded" />
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>    
</div>
</div>
<jsp:include page="main/footer.jsp" />
