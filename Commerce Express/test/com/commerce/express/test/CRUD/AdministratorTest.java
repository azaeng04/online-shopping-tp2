/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.AccessDetailsFactory;
import com.commerce.express.app.factory.AddressFactory;
import com.commerce.express.app.factory.AdministratorFactory;
import com.commerce.express.app.factory.ContactFactory;
import com.commerce.express.app.factory.RolesFactory;
import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Administrator;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Roles;
import com.commerce.express.service.crud.AdministratorCrudService;
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
public class AdministratorTest {

    private static ApplicationContext ctx;
    private AdministratorCrudService AdministratorCrudService;
    private static Long administratorID;

    public AdministratorTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void createAdministrator() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress("333 Albert Avenue", "PO Box", "7223");
        addresses.add(address);

        Contact contact = ContactFactory.getContact("johndoe@gmail.com", "0725643456", "0215463456", "0215647569");

        List<Roles> roles = new ArrayList<Roles>();
        Roles role1 = RolesFactory.getRoles("Administrator", "View products", "johnDoe1234");
        Roles role2 = RolesFactory.getRoles("Administrator", "Write products", "johnDoe1234");
        roles.add(role1);
        roles.add(role2);

        AccessDetails user = AccessDetailsFactory.getAccessDetails("johnDoe1234", "johnDoe", false, roles);

        Administrator administrator = new AdministratorFactory.Builder("82119", user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(1989, 5, 5, 0, 0).toDate())
                .setFirstName("Susan")
                .setGender("Female")
                .setLastName("Andrews")
                .setMiddleName("Mary")
                .buildAdministrator();

        AdministratorCrudService.persist(administrator);

        administratorID = administrator.getId();
    }

    @Test(dependsOnMethods = "createAdministrator")
    public void readAdministrator() {
        Administrator administrator = AdministratorCrudService.findById(administratorID);

        assertNotNull(administrator);
    }

    @Test(dependsOnMethods = "readAdministrator")
    public void readAdministrators() {
        List<Administrator> administrator = AdministratorCrudService.findAll();

        assertTrue(administrator.size() > 0);
    }

    @Test(dependsOnMethods = "readAdministrators")
    public void updateAdministrator() {
        Administrator administrator = AdministratorCrudService.findById(administratorID);
        assertNotNull(administrator);
        administrator.setFirstName("Jack");

        AdministratorCrudService.merge(administrator);
        Administrator administrator1 = AdministratorCrudService.findById(administratorID);

        assertEquals(administrator1.getFirstName(), "Jack");
    }

    @Test(dependsOnMethods = "updateAdministrator")
    public void deleteAdministrator() {
        Administrator administrator = AdministratorCrudService.findById(administratorID);
        AdministratorCrudService.remove(administrator);

        Administrator administrator1 = AdministratorCrudService.findById(administratorID);

        assertNull(administrator1);
    }
}