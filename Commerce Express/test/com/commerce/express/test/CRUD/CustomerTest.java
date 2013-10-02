/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.AccessDetailsFactory;
import com.commerce.express.app.factory.AddressFactory;
import com.commerce.express.app.factory.ContactFactory;
import com.commerce.express.app.factory.CustomerFactory;
import com.commerce.express.app.factory.RolesFactory;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.Roles;
import com.commerce.express.domain.AccessDetails;
import com.commerce.express.service.crud.CustomerCrudService;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cna canal walk
 */
public class CustomerTest {

    private static ApplicationContext ctx;
    private static CustomerCrudService customerCrudService;
    private static Long customerID;

    public CustomerTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        List<Customer> customers = customerCrudService.findAll();

        customerCrudService.removeMultipleEntities(customers);
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void createCustomer() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress("637 Parkers Avenue", "PO Box", "7831");
        addresses.add(address);

        Contact contact = ContactFactory.getContact("mikejoans@gmail.com", "0728374615", "0217057362", "0218392837");

        List<Roles> roles = new ArrayList<Roles>();
        Roles role1 = RolesFactory.getRoles("ROLE_CUSTOMER", "View products", "mikeJoans1234");
        Roles role2 = RolesFactory.getRoles("ROLE_CUSTOMER", "Write products", "mikeJoans1234");
        roles.add(role1);
        roles.add(role2);

        AccessDetails user = AccessDetailsFactory.getAccessDetails("mikeJoans1234", "mikeJoans", false, roles);

        Customer customer = new CustomerFactory.Builder("82118", user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(1988, 4, 4, 0, 0).toDate())
                .setFirstName("Mike")
                .setGender("Male")
                .setLastName("Joans")
                .setMiddleName("Daniel")
                .buildCustomer();

        customerCrudService.persist(customer);

        customerID = customer.getId();
    }

    @Test(dependsOnMethods = "createCustomer")
    public void readCustomer() {
        Customer customer = customerCrudService.findById(customerID);

        assertNotNull(customer);
    }

    @Test(dependsOnMethods = "createCustomer")
    public void readCustomers() {
        List<Customer> customers = customerCrudService.findAll();

        assertTrue(customers.size() > 0);
    }

    @Test(dependsOnMethods = "createCustomer")
    public void updateCustomer() {
        Customer customer = customerCrudService.findById(customerID);

        assertNotNull(customer);

        customer.setFirstName("Jason");

        customerCrudService.merge(customer);

        Customer customer1 = customerCrudService.findById(customerID);

        assertEquals(customer1.getFirstName(), "Jason");
    }

    @Test(dependsOnMethods = "readCustomer")
    public void deleteCustomer() {
        Customer customer = customerCrudService.findById(customerID);

        customerCrudService.remove(customer);

        Customer customer1 = customerCrudService.findById(customerID);

        assertNull(customer1);
    }
}