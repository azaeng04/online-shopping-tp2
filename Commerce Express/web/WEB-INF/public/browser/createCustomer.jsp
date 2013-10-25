<%@page import="java.text.DateFormat"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressServices"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.Date"%>
<%@page import="com.commerce.express.app.factory.AccessDetailsFactory"%>
<%@page import="com.commerce.express.domain.AccessDetails"%>
<%@page import="com.commerce.express.app.factory.RolesFactory"%>
<%@page import="com.commerce.express.app.factory.RolesFactory"%>
<%@page import="com.commerce.express.domain.Roles"%>
<%@page import="com.commerce.express.app.factory.AddressFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.commerce.express.app.factory.ContactFactory"%>
<%@page import="com.commerce.express.domain.Contact"%>
<%@page import="com.commerce.express.domain.Address"%>
<%@page import="com.commerce.express.domain.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.commerce.express.app.factory.CustomerFactory"%>
<%@page import="com.commerce.express.domain.Customer"%>
<%@page import="com.commerce.express.app.facade.CommerceExpressCRUD"%>
<%
    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    List<Address> addresses = new ArrayList<Address>();
    String firstName = request.getParameter("firstName").toString();
    String lastName = request.getParameter("lastName").toString();
    String middleName = request.getParameter("middleName").toString();
    String dateOfBirth = request.getParameter("dateOfBirth").toString();
    String gender = request.getParameter("gender").toString();
    String username = request.getParameter("username").toString();
    String password = request.getParameter("password").toString();
    String physicalAddress = request.getParameter("physicalAddress").toString();
    String postalAddress = request.getParameter("postalAddress").toString();
    String postalCode = request.getParameter("postalCode").toString();
    String emailAddress = request.getParameter("email").toString();
    String cellPhoneNumber = request.getParameter("cellnumber").toString();
    String homeNumber = request.getParameter("homenumber").toString();
    String officeNumber = request.getParameter("officenumber").toString();


    Address address = AddressFactory.getAddress(postalAddress, physicalAddress, postalCode);
    addresses.add(address);

    Contact contact = ContactFactory.getContact(emailAddress, cellPhoneNumber, homeNumber, officeNumber);

    List<Roles> roles = new ArrayList<Roles>();
    Roles role1 = RolesFactory.getRoles("ROLE_CUSTOMER", "View products", username);
    Roles role2 = RolesFactory.getRoles("ROLE_CUSTOMER", "Write products", username);
    roles.add(role1);
    roles.add(role2);

    AccessDetails user = AccessDetailsFactory.getAccessDetails(username, password, true, roles);
    String uniqueID = commerceExpressServices.getCustomerService().getUniqueCustomerNumber().toString();
    
    Customer customer = new CustomerFactory.Builder(uniqueID, user)
            .setAddresses(addresses)
            .setContact(contact)
            .setDateOfBirth(dateOfBirth)
            .setFirstName(firstName)
            .setGender(gender)
            .setLastName(lastName)
            .setMiddleName(middleName)
            .buildCustomer();

    commerceExpressCRUD.getCustomerCrudService().persist(customer);
    response.sendRedirect("login");
%>
