/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Shannon
 */
@Controller
public class CustomerController {

    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    
    @RequestMapping(value = "/member/categoryID={id}", method = RequestMethod.GET)
    public String categorySelected(@PathVariable("id") Long id, Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressServices.getProductService().getProducts(id);
        model.addAttribute("products", products);
        model.addAttribute("title", "Products in Category");

        return "customer/categorySelected";
    }
    
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public String session(Model model) {
        categoryModel(model);
        
        return "customer/addToSession";
    }
    
    @RequestMapping(value = "/memberhome", method = RequestMethod.GET)
    public String memberIndex(Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
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
        List<Category> categories = commerceExpressCRUD.getCategoryCrudService().findAll();
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
