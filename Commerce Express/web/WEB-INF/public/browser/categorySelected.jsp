<%-- 
    Document   : index
    Created on : 06 Sep 2013, 10:19:44 PM
    Author     : Owner
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="main/header.jsp"/>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" /> 
    </div>

    <div class= "content">
        <div class="container">
            <p> 
            <table>
                <tr>
                    <td>
                        <div class="categoryFont">Categories: &nbsp
                            <select id = "myList">
                                <c:forEach var="category" items="${categories}">
                                    <option value = "categoryID=${category.id}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                            &nbsp &nbsp <input type="text" name="searchItemName" placeholder="Search Item...">&nbsp &nbsp 
                            <button type="submit" class="btn">Search</button>
                        </div>
                    </td>
                </tr>
            </table>
            </p>
            <br>
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


            <div class="row">
                <c:forEach items = "${products}" var = "product">
                    <div class="span4 carshow">
                        <h3>${product.productName}</h3>
                        <h4>Price : ${product.productPrice}</h4>
                        <img src="${product.imageURL}" class="img-rounded" />
                        <br/>
                    </div>
                </c:forEach>  
            </div>
        </div>
    </div> 
<jsp:include page="main/footer.jsp" />