<jsp:include page="main/header.jsp"/>
<body>
    <jsp:include page="main/topnavigationbar.jsp"/>

    <div class= "sidenavigation">
        <jsp:include page="main/sidenavigationbar.jsp" />
    </div>

    <div class= "content">
        <div class="container">
            <h1>${title}</h1>

            <div class="row">                
                <div class="span3 carshow">
                    <h2>User Details</h2>
                    <hr>
                    <table>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="firstname" max="15" class ="span2"/></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="lastName" max="15" class ="span2"/></td>
                        </tr>
                        <tr>
                            <td>Middle Name:</td>
                            <td><input type="text" name="middleName" max="15" class ="span2"/></td>
                        </tr>
                        <tr>
                            <td>DOB:</td>
                            <td><input id="dob" type="text" name="dob" class ="span2"/></td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <input type="radio" name="sex" value="Male">Male<br>
                            <input type="radio" name="sex" value="Female">Female
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
            </div>
        </div>
        <input type="submit" name="sign up" value="Sign Up" class ="btn btn-primary btn-large"/>

        <jsp:include page="main/footer.jsp" />
