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
               <p style="font-family:arial;color:black;font-size:14px;">
                    The Web layer is also built around the shopping cart scenario but aimed at regular online shoppers and at random browsers.<br> These individuals use the service of the shopping cart to view specials, promotions and other daily preferences and needs.<br> Signed up customers are able to add to their cart, delete from their cart and update their cart if they change their mind.<br> They also allowed to populate orders and check it out.
                </p>
            </div>
	</div>
        
<jsp:include page="../browser/main/footer.jsp" />