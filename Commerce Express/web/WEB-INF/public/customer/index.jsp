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
            <!-- Main hero unit for a primary marketing message or call to action -->
            <div id="myCarousel" class="carousel slide">
                <!-- Carousel items -->
                <div class="carousel-inner">
                    <div class="active item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                    <div class="item"><img src="resources/images/product.jpg" alt="Car Carousel" /></div>
                </div>
                <!-- Carousel nav -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>

            <!-- Example row of columns -->
            <form method="POST" action="session">
                <div class="row">
                    <div class="row">
                        <c:forEach items = "${products}" var = "product">
                            <div class="span4 carshow">
                                <h3>${product.productName}</h3>
                                <h4>Price : R${product.productPrice}</h4>
                                <img src="${product.imageURL}" class="img-rounded" />

                                <div class="btn-group-vertical">
                                    <div class="btn-group">
                                        <input type="hidden" name="prd${product.id}" value="${product.id}"/>
                                        <button type="submit" name="product" class="btn btn-default btn-info">
                                            Add to Cart                                        
                                        </button>
                                        
                                        <input id="${product.id}" name="qty${product.id}" style="width:75px;" min="0" max="99" value="0" type="number"/>

                                        <input type="hidden" name="wish${product.id}" value="${product.id}"/>
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