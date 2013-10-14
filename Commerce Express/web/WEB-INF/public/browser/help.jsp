<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="main/header.jsp"/>
   <body>
     <jsp:include page="main/topnavigationbar.jsp"/>
	
	<div class= "sidenavigation">
		<jsp:include page="main/sidenavigationbar.jsp" />
	</div>
	
	<div class= "content">
            <div class="container">
                <h1>${title} Page</h1>
                <label>Content here!</label>
                <f:form action="getData" modelAttribute="category">
                    <label>${category.id}</label>
                    <label>${category.categoryID}</label>
                    <label>${category.categoryName}</label>
                </f:form>
            </div>
	</div>
<jsp:include page="main/footer.jsp" />