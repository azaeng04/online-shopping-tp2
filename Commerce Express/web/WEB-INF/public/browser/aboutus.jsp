<%@ page import="java.util.*,java.util.*" %>
<jsp:include page="main/header.jsp"/>
   <body>       
    <jsp:include page="main/topnavigationbar.jsp"/>
	
	<div class= "sidenavigation">
            <jsp:include page="main/sidenavigationbar.jsp" />
	</div>
	<div class= "content">
            <div class="container">
                <h1>${title} Page</h1>
                <form method = "post" action = "session">
			<font size = 6>Enter your name<input type = "text" name = "name"></font><br><br>
			<font size = 6>Enter your password<input type="password" name = "pwd" ></font><br><br>
			<input type = "submit" name = "submit" value = "submit" >
		</form>
                <%   
                    out.println("<label>This is your name: "+session.getAttribute("list")+"</label>"); %>                
            </div>
	</div>
        
<jsp:include page="main/footer.jsp" />