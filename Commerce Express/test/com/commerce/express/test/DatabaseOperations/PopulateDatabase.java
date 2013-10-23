/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.DatabaseOperations;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.factory.AccessDetailsFactory;
import com.commerce.express.app.factory.AddressFactory;
import com.commerce.express.app.factory.AdministratorFactory;
import com.commerce.express.app.factory.CategoryFactory;
import com.commerce.express.app.factory.ContactFactory;
import com.commerce.express.app.factory.CustomerFactory;
import com.commerce.express.app.factory.OrderLineFactory;
import com.commerce.express.app.factory.OrdersFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.app.factory.RatingFactory;
import com.commerce.express.app.factory.RolesFactory;
import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Administrator;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;
import com.commerce.express.domain.Roles;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.joda.time.DateTime;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author OM95446
 */
public class PopulateDatabase {

    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    static Integer numberMales = 1;
    static Integer numberFemales = 1;
    List<Integer> uniqueNumbers = new ArrayList<Integer>();
    Map<String, List<String>> categories = new TreeMap<String, List<String>>();
    
    List<String> beverages = new ArrayList<String>(
            Arrays.asList("Beverage1", "Beverage2", "Beverage3", "Beverage4", "Beverage5", "Beverage6", "Beverage7", "Beverage8", "Beverage9", "Beverage10"));
    List<String> breadBakery = new ArrayList<String>(
            Arrays.asList("Bread1", "Bread2", "Bread3", "Bread4", "Bread5", "Bread6", "Bread7", "Bread8", "Bread9", "Bread10"));
    List<String> cannedGoods = new ArrayList<String>(
            Arrays.asList("cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods", "cannedGoods"));
    List<String> dairy = new ArrayList<String>(
            Arrays.asList("dairy", "dairy", "dairy", "dairy", "dairy", "dairy", "dairy", "dairy", "dairy", "dairy"));
    List<String> dryGoods = new ArrayList<String>(
            Arrays.asList("dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods", "dryGoods"));
    List<String> bakingGoods = new ArrayList<String>(
            Arrays.asList("bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods", "bakingGoods"));
    List<String> frozenFoods = new ArrayList<String>(
            Arrays.asList("FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods", "FrozenFoods"));
    List<String> meat = new ArrayList<String>(
            Arrays.asList("meat", "meat", "meat", "meat", "meat", "meat", "meat", "meat", "meat", "meat"));
    List<String> produce = new ArrayList<String>(
            Arrays.asList("Produce1", "produce1", "produce1", "produce1", "produce1", "produce1", "produce1", "produce1","produce1", "produce1"));
    List<String> snacks = new ArrayList<String>(
            Arrays.asList("snacks", "snacks", "snacks", "snacks", "snacks", "snacks", "snacks", "snacks", "snacks", "snacks"));
    
    List<String> boyNames = new ArrayList<String>(
            Arrays.asList("Ruwaal", "Devon", "Jade", "Jacob", "Ely", "Ethan", "Jody", "Jeff", "Evan", "Graham"));
    List<String> girlNames = new ArrayList<String>(
            Arrays.asList("Leah", "Jody", "Sheena", "Lola", "Eva", "Emma", "Jose", "Lisa", "Monique", "Sonya"));
    List<String> middleNames = new ArrayList<String>(
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
    List<String> surnames = new ArrayList<String>(
            Arrays.asList("Rossouw", "Engelbrecht", "McKay", "Wendle", "Josias", "Eden", "Louw", "Le Roux", "Isaacs", "Lee"));
    List<String> streetNames = new ArrayList<String>(
            Arrays.asList("Livingston Avenue", "Claremont Road", "Seven Sleepers Street", "Italian Road", "Protea Avenue", "Mamosa Avenue", "Azalea Avenue", "Adderley Street", "Rail Road", "Locnest Avenue"));
    List<String> postalTypes = new ArrayList<String>(
            Arrays.asList("PO Box", "Private Bag"));
    List<String> suburbs = new ArrayList<String>(
            Arrays.asList("West Coast", "Helderberg", "Cape Flats", "South Peninsula", "Atlanti Seaboard", "City Bowl", "Southern Suburb", "Northern Suburb"));

    public PopulateDatabase() {
        categories.put("Beverages", beverages);
        categories.put("Bread/Bakery", breadBakery);
        categories.put("Canned Goods", cannedGoods);
        categories.put("Dairy", dairy);
        categories.put("Dry Goods", dryGoods);
        categories.put("Baking Goods", bakingGoods);
        categories.put("Frozen Foods", frozenFoods);
        categories.put("Meat", meat);
        categories.put("Produce", produce);
        categories.put("Snacks", snacks);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
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
    public void testFunction() {
        createCategories();
        
        for (int i = 0; i < 15; i++) {
            uniqueNumbers.clear();
            createMaleCustomer();
        }

        for (int i = 0; i < 15; i++) {
            uniqueNumbers.clear();
            createFemaleCustomer();
        }

        createAdmin1();
        createAdmin2();
        createAdmin3();
        
        System.out.println("Database POPULATED successfully");
    }

    private Integer generateRandomNumber(Integer start, Integer end, Random randomize) {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        Long range = (long) end - (long) start + 1;
        Long fraction = (long) (range * randomize.nextDouble());
        Integer randomNumber = (int) (fraction + start);
        return randomNumber;
    }

    private Integer generateUniqueRandomNumber(Integer start, Integer end, Random randomize) {
        Integer randomNumber = generateRandomNumber(start, end, randomize);
        if (uniqueNumbers.size() == ((end - start) + 1)) {
            throw new IllegalArgumentException("No more unique numbers can be generated in specified range");
        }

        if (uniqueNumbers.contains(randomNumber)) {
            randomNumber = generateRandomNumber(start, end, randomize);
        } else {
            uniqueNumbers.add(randomNumber);
        }
        return randomNumber;
    }

    private void createMaleCustomer() {
        Random random = new Random();
        String name = boyNames.get(generateRandomNumber(0, boyNames.size() - 1, random));
        String middleName = middleNames.get(generateRandomNumber(0, middleNames.size() - 1, random));
        String surname = surnames.get(generateRandomNumber(0, surnames.size() - 1, random));
        String username = (name.substring(0, 1).toLowerCase() + surname + numberMales.toString()).replace(' ', '.');
        String password = username;
        String userNumber = generateUniqueRandomNumber(10000, 99999, random).toString();
        String gender = "Male";

        String roleName = "ROLE_CUSTOMER";
        String postalCode = generateRandomNumber(1000, 9999, random).toString();
        String postalType = postalTypes.get(generateRandomNumber(0, postalTypes.size() - 1, random));
        String streetNumber = generateRandomNumber(100, 1000, random).toString();
        String streetName = streetNames.get(generateRandomNumber(0, streetNames.size() - 1, random));
        String physicalAddress = streetNumber + " " + streetName;

        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress(postalType, physicalAddress, postalCode);
        addresses.add(address);

        Integer randomCellNum1 = generateRandomNumber(1000000, 9999999, random);
        Integer randomCellNum2 = generateRandomNumber(1000000, 9999999, random);
        Integer randomCellNum3 = generateRandomNumber(1000000, 9999999, random);

        Contact contact = ContactFactory.getContact(username + "@cexpress.com", "072" + randomCellNum1, "021" + randomCellNum2, "021" + randomCellNum3);

        List<Roles> roles = new ArrayList<Roles>();
        Roles role1 = RolesFactory.getRoles(roleName, "View products", username);
        Roles role2 = RolesFactory.getRoles(roleName, "Write products", username);
        roles.add(role1);
        roles.add(role2);

        AccessDetails user = AccessDetailsFactory.getAccessDetails(username, password, true, roles);

        Integer year = generateRandomNumber(1969, 1991, random);
        Integer month = generateRandomNumber(1, 12, random);
        Integer day = generateRandomNumber(1, 25, random);
        Date dob = new DateTime(year, month, day, 0, 0).toDate();
        Customer customer = new CustomerFactory.Builder(userNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new SimpleDateFormat("EEEE dd MMM YYYY").format(dob))
                .setFirstName(name)
                .setGender(gender)
                .setLastName(surname)
                .setMiddleName(middleName)
                .buildCustomer();

        List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
        List<OrderLine> ordersList = new ArrayList<OrderLine>();
        
        Integer randomProduct;
        
        uniqueNumbers.clear();
        Integer randomUniqueNum = generateUniqueRandomNumber(10000, 99999, random);        
        Integer randomQuanitity;
        
        for (int i = 0; i < 5; i++) {
            randomProduct = generateRandomNumber(0, categories.size(), random);
            randomUniqueNum = generateUniqueRandomNumber(10000, 99999, random);        
            randomQuanitity = generateRandomNumber(1, 5, random);
            
            OrderLine orderLine = OrderLineFactory.getOrderLine(randomUniqueNum.toString(), randomQuanitity, products.get(randomProduct));
            
            ordersList.add(orderLine);
        }
        
        Date date = new DateTime().toDate();
        Orders order = new OrdersFactory.Builder(randomUniqueNum.toString())
                .setDateCreated(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setDateModified(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setOrderLines(ordersList)
                .setStatus("Pending Delivery")
                .buildOrder();               
        
        List<Orders> orders = new ArrayList<Orders>();
        orders.add(order);
        
        customer.setOrders(orders);
        
        commerceExpressCRUD.getCustomerCrudService().persist(customer);

        numberMales++;
    }

    private void createFemaleCustomer() {
        Random random = new Random();
        String name = girlNames.get(generateRandomNumber(0, girlNames.size() - 1, random));
        String middleName = middleNames.get(generateRandomNumber(0, middleNames.size() - 1, random));
        String surname = surnames.get(generateRandomNumber(0, surnames.size() - 1, random));
        String username = (name.substring(0, 1).toLowerCase() + surname + numberFemales.toString()).replace(' ', '.');
        String password = username;
        String userNumber = generateUniqueRandomNumber(10000, 99999, random).toString();
        String gender = "Female";

        String roleName = "ROLE_CUSTOMER";
        String postalCode = generateRandomNumber(1000, 9999, random).toString();
        String postalType = postalTypes.get(generateRandomNumber(0, postalTypes.size() - 1, random));
        String streetNumber = generateRandomNumber(100, 1000, random).toString();
        String streetName = streetNames.get(generateRandomNumber(0, streetNames.size() - 1, random));
        String physicalAddress = streetNumber + " " + streetName;

        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress(postalType, physicalAddress, postalCode);
        addresses.add(address);

        Integer randomCellNum1 = generateUniqueRandomNumber(1000000, 9999999, random);
        Integer randomCellNum2 = generateRandomNumber(1000000, 9999999, random);
        Integer randomCellNum3 = generateRandomNumber(1000000, 9999999, random);

        Contact contact = ContactFactory.getContact(username + "@cexpress.com", "072" + randomCellNum1, "021" + randomCellNum2, "021" + randomCellNum3);

        List<Roles> roles = new ArrayList<Roles>();
        Roles role1 = RolesFactory.getRoles(roleName, "View products", username);
        Roles role2 = RolesFactory.getRoles(roleName, "Purchase products", username);
        roles.add(role1);
        roles.add(role2);

        AccessDetails user = AccessDetailsFactory.getAccessDetails(username, password, true, roles);

        Integer year = generateRandomNumber(1969, 1991, random);
        Integer month = generateRandomNumber(1, 12, random);
        Integer day = generateRandomNumber(1, 25, random);

        Date dob = new DateTime(year, month, day, 0, 0).toDate();
        Customer customer = new CustomerFactory.Builder(userNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new SimpleDateFormat("EEEE dd MMM YYYY").format(dob))
                .setFirstName(name)
                .setGender(gender)
                .setLastName(surname)
                .setMiddleName(middleName)
                .buildCustomer();

        List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
        List<OrderLine> ordersList = new ArrayList<OrderLine>();
        
        Integer randomProduct;
        
        uniqueNumbers.clear();
        Integer randomUniqueNum = generateUniqueRandomNumber(10000, 99999, random);        
        Integer randomQuanitity;
        
        for (int i = 0; i < 5; i++) {
            randomProduct = generateRandomNumber(0, categories.size(), random);
            randomUniqueNum = generateUniqueRandomNumber(10000, 99999, random);        
            randomQuanitity = generateRandomNumber(1, 5, random);
            
            OrderLine orderLine = OrderLineFactory.getOrderLine(randomUniqueNum.toString(), randomQuanitity, products.get(randomProduct));
            
            ordersList.add(orderLine);
        }
        
        Date date = new DateTime().toDate();
        Orders order = new OrdersFactory.Builder(randomUniqueNum.toString())
                .setDateCreated(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setDateModified(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setOrderLines(ordersList)
                .setStatus("Pending Delivery")
                .buildOrder();               
        
        List<Orders> orders = new ArrayList<Orders>();
        orders.add(order);
        
        customer.setOrders(orders);
        
        commerceExpressCRUD.getCustomerCrudService().persist(customer);

        numberFemales++;
    }

    private void createAdmin1() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress("333 Albert Avenue", "PO Box", "7223");
        addresses.add(address);

        Contact contact = ContactFactory.getContact("sWeir@cexpress.com", "0725643456", "0215463456", "0215647569");

        List<Roles> roles = returnAdminRoles("sWeir");

        AccessDetails user = AccessDetailsFactory.getAccessDetails("sWeir", "sWeir", false, roles);

        uniqueNumbers.clear();
        String adminNumber = generateUniqueAdminNumber();
        Date dob = new DateTime(1989, 5, 5, 0, 0).toDate();
        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new SimpleDateFormat("EEEE dd MMM YYYY").format(dob))
                .setFirstName("Shannon")
                .setGender("Female")
                .setLastName("Weir")
                .setMiddleName("")
                .buildAdministrator();

        commerceExpressCRUD.getAdministratorCrudService().persist(administrator);
    }

    private void createAdmin2() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress("333 Albert Avenue", "PO Box", "7223");
        addresses.add(address);

        Contact contact = ContactFactory.getContact("nNaidoo@cexpress.com", "0725643456", "0215463456", "0215647569");

        List<Roles> roles = returnAdminRoles("nNaidoo");

        AccessDetails user = AccessDetailsFactory.getAccessDetails("nNaidoo", "nNaidoo", false, roles);

        uniqueNumbers.clear();
        String adminNumber = generateUniqueAdminNumber();
        Date dob = new DateTime(1989, 5, 5, 0, 0).toDate();
        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new SimpleDateFormat("EEEE dd MMM YYYY").format(dob))
                .setFirstName("Nashrethen")
                .setGender("Male")
                .setLastName("Naidoo")
                .setMiddleName("")
                .buildAdministrator();

        commerceExpressCRUD.getAdministratorCrudService().persist(administrator);
    }

    private void createAdmin3() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = AddressFactory.getAddress("333 Albert Avenue", "PO Box", "7223");
        addresses.add(address);

        Contact contact = ContactFactory.getContact("aEngelbrecht@cexpress.com", "0725643456", "0215463456", "0215647569");
        List<Roles> roles = returnAdminRoles("aEngelbrecht");

        AccessDetails user = AccessDetailsFactory.getAccessDetails("aEngelbrecht", "aEngelbrecht", false, roles);

        uniqueNumbers.clear();
        String adminNumber = generateUniqueAdminNumber();

        Date dob = new DateTime(1989, 5, 5, 0, 0).toDate();
        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new SimpleDateFormat("EEEE dd MMM YYYY").format(dob))
                .setFirstName("Azariah")
                .setGender("Male")
                .setLastName("Engelbrecht")
                .setMiddleName("Michal")
                .buildAdministrator();

        commerceExpressCRUD.getAdministratorCrudService().persist(administrator);
    }

    private List<Roles> returnAdminRoles(String userID) {
        List<Roles> roles = new ArrayList<Roles>();
        Roles role1 = RolesFactory.getRoles("ROLE_ADMIN", "View products", userID);
        Roles role2 = RolesFactory.getRoles("ROLE_ADMIN", "Write products", userID);
        roles.add(role1);
        roles.add(role2);
        return roles;
    }

    private String generateUniqueAdminNumber() {
        String adminNumber = generateUniqueRandomNumber(10000, 99999, new Random()).toString();
        return adminNumber;
    }

    private void createCategories() {
        Double randomPriceValue;

        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {
            String categoryName = entry.getKey();
            List<String> productName = entry.getValue();

            ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 10000);

            List<Product> productList = new ArrayList<Product>();
            uniqueNumbers.clear();
            Integer uniqueNum;
            DecimalFormat decimalFormat = new DecimalFormat("###########.00");
            for (int i = 0; i < productName.size(); i++) {
                randomPriceValue = generateRandomNumber(30, 100, new Random()).doubleValue();
                uniqueNum = generateUniqueRandomNumber(10000, 99999, new Random());
                Product product = new ProductFactory.Builder(uniqueNum.toString())
                        .setDescription("On Special")
                        .setImageURL("resources/images/product.jpg")
                        .setProductName(productName.get(i))
                        .setProductPrice(decimalFormat.format(randomPriceValue.doubleValue()))
                        .setProductStatus(productStatus)
                        .buildProduct();


                Rating rating = new RatingFactory.Builder(uniqueNum.toString())
                        .setProduct(product)
                        .setRatingNumber(0)
                        .setRatingQuantity(0)
                        .setRatingStatus("Not Rated")
                        .buildRating();

                product.setRating(rating);

                productList.add(product);
            }

            uniqueNumbers.clear();
            uniqueNum = generateUniqueRandomNumber(10000, 99999, new Random());
            Category category = CategoryFactory.getCategory(uniqueNum.toString(), categoryName, productList);
            commerceExpressCRUD.getCategoryCrudService().persist(category);

        }
    }
}