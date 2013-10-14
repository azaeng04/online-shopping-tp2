/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CategoryFacade;
import com.commerce.express.app.facade.CustomerFacade;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Product;
import com.commerce.express.service.ProductService;
import com.commerce.express.service.crud.OrderLineCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Shannon
 */
@Controller
public class CustomerController {

    @Autowired
    private ProductService productService;
    private static CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();
    private static CustomerFacade customerFacade = CustomerFacade.getCustomerFacadeInstance();
    
    @RequestMapping(value = "/memberhome", method = RequestMethod.GET)
    public String memberIndex(Model model) {
        categoryModel(model);
        List<Product> products = categoryFacade.getProductCrudService().findAll();
        model.addAttribute("products", products);
        model.addAttribute("title", "Customer Home");
        model.addAttribute("active", "/");
        return "customer/index";
    }

    @RequestMapping(value = "/memberaboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "About Us");
        model.addAttribute("active", "aboutus");
        return "customer/aboutus";
    }

    @RequestMapping(value = "/membercontactus", method = RequestMethod.GET)
    public String contactUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Contact Us");
        model.addAttribute("active", "contactus");
        return "customer/contactus";
    }

    @RequestMapping(value = "/memberhelp", method = RequestMethod.GET)
    public String help(Model model) {        
        categoryModel(model);
        model.addAttribute("title", "Help");
        model.addAttribute("active", "help");
        return "customer/help";
    }    
    
    @RequestMapping(value = "/memberorders", method = RequestMethod.GET)
    public String orders(Model model) {        
        categoryModel(model);
        model.addAttribute("title", "Orders");
        model.addAttribute("active", "orders");
        return "customer/orders";
    }
    
    @RequestMapping(value = "/memberwishlist", method = RequestMethod.GET)
    public String wishlist(Model model) {        
        categoryModel(model);
        model.addAttribute("title", "Wishlist");
        model.addAttribute("active", "wishlist");
        return "customer/wishlist";
    }
    
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(Model model) {        
        categoryModel(model);
        model.addAttribute("title", "Basket");
        return "customer/basket";
    }
    
    private void categoryModel(Model model) {
        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }
    
//    @RequestMapping(value="/addToCart")
//    public String addToCart(Model model,@ModelAttribute("OrderLineModel") OrderLineModel orderLine,@RequestParam("productID") String productID) {
////        
////        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
////        List<Product> productsTest = categoryFacade.getProductCrudService().findAll();
////        model.addAttribute("productsRow", productsTest);
////        model.addAttribute("categories",categories);
////        
////       
////        Product p = productService.getProductByProductID(productID);
////        String quantity=orderLine.getQuantity();
////        
////        OrderLine o = new OrderLine();
////        o.setOrderLineID("");
////        o.setProduct(p);
////        o.setQuantity(12);
////        o.setId(Long.MIN_VALUE);
////        
////        orderLines.add(o);
//////        model.addAttribute("orderLine",o);
////        model.addAttribute("product",p);
////        model.addAttribute("orderLines",orderLines);
//////        
//        return "customer/basket";
//    }
}
