<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="main/header.jsp"/>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>

    <div class= "content">
        <div class="container">
            <h1>${title}</h1>
            <form method="POST" action="j_spring_security_check">
                <div>
                    <c:if test="${not empty error}">
                        <div class="alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <strong>Error: </strong> 
                            Your login attempt was not successful, try again.<br /> Caused by: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                        </div>
                    </c:if>
                </div>

                <div class="control-group">
                    <label class="control-label" for='j_username'>Username:</label>
                    <div class="controls">
                        <input type="text" id="j_username" name='j_username' placeholder="Enter username">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for='j_password'>Password:</label>
                    <div class="controls">
                        <input type="password" id="j_password" name='j_password' placeholder="Enter password">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox">
                            <input type="checkbox" type="_spring_security_remember_me" name='_spring_security_remember_me'> Remember me
                        </label>
                        <button type="submit" class="btn">Log in</button>
                    </div>
                </div>
            </form>       
        </div>        
    </div>                  
</div>
</div>
<jsp:include page="main/footer.jsp" />