<jsp:include page="main/header.jsp"/>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>
        <f:form id="form" method="POST" modelAttribute="CustomerModel" action="createCustomer">
    <div class= "content">
        <div class="container">
            <h1>${title} Page</h1>
 
                <div class="row">
                    <div class="span3 carshow">
                        <h2>Access Details</h2>
                        <hr> <table>
                            <tr>
                                <td>Username:</td>
                                <td><input type="text" name="username" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" name="password" class ="span2"/></td>
                            </tr>
                        </table>
                    </div>
                    <div class="span3 carshow">
                        <h2>User Details</h2>
                        <hr>
                        <table>
                            <tr>
                                <td>First Name:</td>
                                <td><input id ="firstName" type="text" name="firstName" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td><input id="lastName" type="text" name="lastName" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Middle Name:</td>
                                <td><input type="text" name="middleName" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>DOB:</td>
                                <td><input type="text" name="dsteOfBirth" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td><input type="text" name="gender" class ="span2"/></td>
                            </tr>
                        </table>
                    </div>

                    <div class="span3  carshow">
                        <h2>Address</h2>
                        <hr>
                        <table>
                            <tr>
                                <td>Postal Address:</td>
                                <td><input type="text" name="postalAddress" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Physical Address:</td>
                                <td><input type="text" name="physicalAddress" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Postal Code:</td>
                                <td><input type="text" name="postalCode" class ="span2"/></td>
                            </tr>


                        </table>
                    </div>

                    <div class="span3 carshow">
                        <h2>Contact Details</h2>
                        <hr> 
                        <table>
                            <tr>
                                <td>E-mail:</td>
                                <td><input type="text" name="email" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Cell Number:</td>
                                <td><input type="text" name="cellnumber" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Home Number:</td>
                                <td><input type="text" name="homenumber" class ="span2"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <input type="submit" name="sign up" value="Sign Up" class ="btn btn-primary btn-large"/>
    </f:form>
            <jsp:include page="main/footer.jsp" />
