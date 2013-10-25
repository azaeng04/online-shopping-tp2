<jsp:include page="main/header.jsp"/>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>
    <f:form id="form" method="POST" action="createCustomer">
        <div class= "content">
            <div class="container">
                <h1>${title}</h1>
                <h5>(*) fields are required fields</h5>
                <div class="row">
                    <div class="span3 carshow">
                        <h2>Access Details</h2>
                        <hr> <table>
                            <tr>
                                <td>* Username:</td>
                                <td><input type="text" name="username" min="5" max="15" required="true" class ="span2" placeholder="Username"/></td>
                            </tr>
                            <tr>
                                <td>* Password:</td>
                                <td><input type="password" name="password" min="8" max="15" required="true" class ="span2" placeholder="Password"/></td>
                            </tr>
                        </table>
                    </div>
                    <div class="span3 carshow">
                        <h2>User Details</h2>
                        <hr>
                        <table>
                            <tr>
                                <td>* First Name:</td>
                                <td><input id ="firstName" type="text" name="firstName" min="2" max="15" required="true" class ="span2" placeholder="First Name"/></td>
                            </tr>
                            <tr>
                                <td>* Last Name:</td>
                                <td><input id="lastName" type="text" name="lastName" min="2" max="15" required="true" class ="span2" placeholder="Last Name"/></td>
                            </tr>
                            <tr>
                                <td>Middle Name:</td>
                                <td><input type="text" name="middleName" min="2" max="15" class="span2" placeholder="Middle Name"/></td>
                            </tr>
                            <tr>
                                <td>* DOB:</td>
                                <td><input type="date" name="dateOfBirth" required="true" class ="span2"/></td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td>
                                    <input type="radio" name="gender" value="Male" checked="true"/>Male
                                    <input type="radio" name="gender" value="Female"/>Female
                                </td>
                            </tr>
                        </table>

                    </div>

                    <div class="span3  carshow">
                        <h2>Address</h2>
                        <hr>
                        <table>
                            <tr>
                                <td>* Postal Address:</td>
                                <td><input type="text" name="postalAddress" required="true" class ="span2" placeholder="Postal Address"/></td>
                            </tr>
                            <tr>
                                <td>* Physical Address:</td>
                                <td><input type="text" name="physicalAddress" required="true" class ="span2" placeholder="Physical Address"/></td>
                            </tr>
                            <tr>
                                <td>* Postal Code:</td>
                                <td><input type="number" name="postalCode" min="1000" max="9999" value="1000" required="true" class ="span2" placeholder="Postal Code"/></td>
                            </tr>
                        </table>
                    </div>

                    <div class="span3 carshow">
                        <h2>Contact Details</h2>
                        <hr> 
                        <table>
                            <tr>
                                <td>* E-mail:</td>
                                <td><input type="email" name="email" required="true" class ="span2" placeholder="E-mail Address"/></td>
                            </tr>
                            <tr>
                                <td>* Cell Number:</td>
                                <td><input type="tel" name="cellnumber" required="true" class ="span2" placeholder="Cell Number"/></td>
                            </tr>
                            <tr>
                                <td>* Home Number:</td>
                                <td><input type="tel" name="homenumber" required="true" class ="span2" placeholder="Home Number"/></td>
                            </tr>
                            <tr>
                                <td>* Office Number:</td>
                                <td><input type="tel" name="officenumber" required="true" class ="span2" placeholder="Home Number"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
                <input type="submit" name="sign up" value="Sign Up" class ="btn btn-primary btn-large"/>
            
        </f:form>
        <jsp:include page="main/footer.jsp" />
