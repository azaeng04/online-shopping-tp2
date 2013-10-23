<%-- 
    Document   : index
    Created on : 06 Sep 2013, 10:19:44 PM
    Author     : Owner
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../browser/main/header.jsp"/>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>
    
    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" /> 
    </div>

    <div class= "content">
        <div class="container">
            <jsp:include page="categorySearch.jsp" />
            <!-- Main hero unit for a primary marketing message or call to action -->
            <jsp:include page="carousel.jsp" />

            <!-- Example row of columns -->
            <form method="POST" action="session">
                <div class="row">
                    <div class="row">
                        <c:forEach items = "${products}" var = "product">
                            <div class="span4 carshow">
                                <h3>${product.id}. ${product.productName}</h3>
                                <h4>Price : R${product.productPrice}</h4>
                                <img src="${product.imageURL}" class="img-rounded" />

                                <div class="btn-group-vertical">
                                    <div class="btn-group">
                                        <input type="hidden" name="prd${product.id}" value="''${product.id}"/>
                                        <button type="submit" name="product" class="btn btn-default btn-info">
                                            Add to Cart                                        
                                        </button>
                                        
                                        <input id="${product.id}" name="qty${product.id}" style="width:75px;" min="0" max="99" value="0" type="number"/>

                                        <input type="hidden" name="wish${product.id}" value="''${product.id}"/>
                                        <button type="button" class="btn btn-default btn-info">
                                            Add to Wishlist                                        
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div> 
                </div>
            </form>
        </div>
    </div>
<jsp:include page="../browser/main/footer.jsp" />
