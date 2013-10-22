<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form>
    <h1>${categoryName}</h1>
    <div class="categoryFont">Search by:
        <select id = "myList" onchange="goToPage('myList');">
            <option value ="<%=request.getContextPath()%>/" >All Categories</option>
            <c:forEach var="category" items="${categories}">
                <option value = "<%=request.getContextPath()%>/categoryID=${category.id}">${category.categoryName}</option>
            </c:forEach>
        </select>
        <input type="text" name="searchItemName" placeholder="Search Item...">
        <!--<button type="submit" class="btn">Search</button>-->
    </div>
</form>