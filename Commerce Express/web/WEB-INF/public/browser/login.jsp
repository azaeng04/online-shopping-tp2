<jsp:include page="main/header.jsp"/>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>

    <div class= "content">
        <div class="container">
            <h1>${title}</h1>
            <!-- Main hero unit for a primary marketing message or call to action -->
            <!--            <div id="myCarousel" class="carousel slide">
                         Carousel items 
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
                       Carousel nav 
                        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
                      </div>-->

            <!-- Example row of columns -->
        <!--    <form method="post" action="<%=request.getContextPath()%>/homepagedependentonrole"> -->
            <form method="POST" action="j_spring_security_check">
                <tr>
                    <td label path="userName">User Name:</td>
                <input type="text" class="input-block-level" placeholder="username" name="j_username"> 
                </tr>
                <tr>
                    <td label path="password">Password:</td>
                <input type="password" class="input-block-level" placeholder="password" name="j_password"> 
                </tr>
                <tr>
                    <td> <button type ="submit" class ="btn">Log In </button> </td>
                </tr>
                <!--       </form> -->
            </form>       
        </div>        
    </div>                  
</div>
</div>
<jsp:include page="main/footer.jsp" />