/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.DatabaseService;

import com.commerce.express.app.factory.AccessDetailsFactory;
import com.commerce.express.app.factory.AddressFactory;
import com.commerce.express.app.factory.AdministratorFactory;
import com.commerce.express.app.factory.BrandFactory;
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
import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;
import com.commerce.express.domain.Roles;
import com.commerce.express.service.crud.AdministratorCrudService;
import com.commerce.express.service.crud.BrandCrudService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.CustomerCrudService;
import com.commerce.express.service.crud.FAQCrudService;
import com.commerce.express.service.crud.OrdersCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import com.commerce.express.service.crud.WishListCrudService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    private static ApplicationContext ctx;
    private static AdministratorCrudService administratorCrudService;
    private static CustomerCrudService customerCrudService;
    private static OrdersCrudService ordersCrudService;
    private static CategoryCrudService categoryCrudService;
    private static ProductCrudService productCrudService;
    private static BrandCrudService brandCrudService;
    private static FAQCrudService fAQCrudService;
    private static WishListCrudService wishListCrudService;
    static Integer numberMales = 1;
    static Integer numberFemales = 1;
    List<Integer> uniqueNumbers = new ArrayList<Integer>();
    Map<String, List<String>> categories = new TreeMap<String, List<String>>();
//    List<String> categories = new ArrayList<String>(
//            Arrays.asList("Ready made", "Breads", "Protein", "Fruit & Vegetables", "Long life"));
    List<String> brands = new ArrayList<String>(
            Arrays.asList("Blue Ribbon", "Fruit N Veg City", "Heinz", "Blaauwberg meats", "Gourmet meals"));
    List<String> readyMade = new ArrayList<String>(
            Arrays.asList("Samoosas", "Quiche", "Pasta", "Salad", "Kebabs", "Polony", "Dips", "Mini Hamburgers", "Ham", "Grated Cheese"));
    List<String> breads = new ArrayList<String>(
            Arrays.asList("Bread1", "Bread2", "Bread3", "Bread4", "Bread5", "Bread6", "Bread7", "Bread8", "Bread9", "Bread10"));
    List<String> protein = new ArrayList<String>(
            Arrays.asList("Protein1", "Protein2", "Protein3", "Protein4", "Protein5", "Protein6", "Protein7", "Protein8", "Protein9", "Protein10"));
    List<String> fruitNVeg = new ArrayList<String>(
            Arrays.asList("FuitNVeg1", "FuitNVeg2", "FuitNVeg3", "FuitNVeg4", "FuitNVeg5", "FuitNVeg6", "FuitNVeg7", "FuitNVeg8", "FuitNVeg9", "FuitNVeg10"));
    List<String> longLife = new ArrayList<String>(
            Arrays.asList("LongLife1", "LongLife2", "LongLife3", "LongLife4", "LongLife5", "LongLife6", "LongLife7", "LongLife8", "LongLife9", "LongLife10"));
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
        categories.put("Ready made", readyMade);
        categories.put("Breads", breads);
        categories.put("Protein", protein);
        categories.put("Fruit & Vegetables", fruitNVeg);
        categories.put("Long life", longLife);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");

        administratorCrudService = (AdministratorCrudService) ctx.getBean("AdministratorCrudService");
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
        ordersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        brandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        wishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        productCrudService = (ProductCrudService) ctx.getBean("ProductCrudService");
        fAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
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
        
        for (int i = 0; i < 50; i++) {
            uniqueNumbers.clear();
            createMaleCustomer();
        }

        for (int i = 0; i < 50; i++) {
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

        AccessDetails user = AccessDetailsFactory.getAccessDetails(username, password, false, roles);

        Integer year = generateRandomNumber(1969, 1991, random);
        Integer month = generateRandomNumber(1, 12, random);
        Integer day = generateRandomNumber(1, 25, random);

        Customer customer = new CustomerFactory.Builder(userNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(year, month, day, 0, 0).toDate())
                .setFirstName(name)
                .setGender(gender)
                .setLastName(surname)
                .setMiddleName(middleName)
                .buildCustomer();

        List<Product> products = productCrudService.findAll();
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
                .setDateCreated(date)
                .setDateModified(date)
                .setOrderLines(ordersList)
                .setStatus("Pending Delivery")
                .buildOrder();               
        
        List<Orders> orders = new ArrayList<Orders>();
        orders.add(order);
        
        customer.setOrders(orders);
        
        customerCrudService.persist(customer);

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

        AccessDetails user = AccessDetailsFactory.getAccessDetails(username, password, false, roles);

        Integer year = generateRandomNumber(1969, 1991, random);
        Integer month = generateRandomNumber(1, 12, random);
        Integer day = generateRandomNumber(1, 25, random);

        Customer customer = new CustomerFactory.Builder(userNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(year, month, day, 0, 0).toDate())
                .setFirstName(name)
                .setGender(gender)
                .setLastName(surname)
                .setMiddleName(middleName)
                .buildCustomer();

        List<Product> products = productCrudService.findAll();
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
                .setDateCreated(date)
                .setDateModified(date)
                .setOrderLines(ordersList)
                .setStatus("Pending Delivery")
                .buildOrder();               
        
        List<Orders> orders = new ArrayList<Orders>();
        orders.add(order);
        
        customer.setOrders(orders);
        
        customerCrudService.persist(customer);

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
        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(1989, 5, 5, 0, 0).toDate())
                .setFirstName("Shannon")
                .setGender("Female")
                .setLastName("Weir")
                .setMiddleName("")
                .buildAdministrator();

        administratorCrudService.persist(administrator);
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
        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(1989, 5, 5, 0, 0).toDate())
                .setFirstName("Nashrethen")
                .setGender("Male")
                .setLastName("Naidoo")
                .setMiddleName("")
                .buildAdministrator();

        administratorCrudService.persist(administrator);
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

        Administrator administrator = new AdministratorFactory.Builder(adminNumber, user)
                .setAddresses(addresses)
                .setContact(contact)
                .setDateOfBirth(new DateTime(1989, 5, 5, 0, 0).toDate())
                .setFirstName("Azariah")
                .setGender("Male")
                .setLastName("Engelbrecht")
                .setMiddleName("Michal")
                .buildAdministrator();

        administratorCrudService.persist(administrator);
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
        int brandCount = 0;
        Double randomPriceValue;

        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {
            String categoryName = entry.getKey();
            List<String> productName = entry.getValue();

            ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 10000);

            List<Product> productList = new ArrayList<Product>();
            uniqueNumbers.clear();
            Integer uniqueNum;
            for (int i = 0; i < productName.size(); i++) {
                randomPriceValue = generateRandomNumber(30, 100, new Random()).doubleValue();
                uniqueNum = generateUniqueRandomNumber(10000, 99999, new Random());
                Product product = new ProductFactory.Builder(uniqueNum.toString())
                        .setDescription("On Special")
                        .setImageURL("www.google.com")
                        .setProductName(productName.get(i))
                        .setProductPrice(randomPriceValue)
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
            categoryCrudService.persist(category);

            uniqueNumbers.clear();
            uniqueNum = generateUniqueRandomNumber(10000, 99999, new Random());
            Brand brand = new BrandFactory.Builder(uniqueNum.toString())
                    .setBrandName(brands.get(brandCount))
                    .setDescription("On Special")
                    .setLogoURL("imageURL")
                    .setProducts(productList)
                    .buildBrand();

            brandCrudService.persist(brand);
            brandCount += 1;
        }
    }
}