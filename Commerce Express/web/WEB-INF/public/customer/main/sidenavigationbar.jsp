<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center>
    Select Category
    <c:forEach var="category" items="${categories}">
        <p>
            <a href="<%=request.getContextPath()%>/memberCategoryId=${category.id}"><button type="submit" class="btn btn-large btn btn-primary">${category.categoryName}</button></a>
        </p>
    </c:forEach>
</center>