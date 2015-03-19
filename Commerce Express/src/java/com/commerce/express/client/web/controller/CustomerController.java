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
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/memberCategoryId={id}", method = RequestMethod.GET)
    public String categorySelected(@PathVariable("id") Long id, Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressServices.getProductService().getProducts(id);
        Category category = commerceExpressCRUD.getCategoryCrudService().findById(id);
        model.addAttribute("categoryName", category.getCategoryName());
        model.addAttribute("products", products);
        model.addAttribute("title", "Products in Category");
        model.addAttribute("categoryName", category.getCategoryName());
        return "customer/categorySelected";
    }

    @RequestMapping(value = "/addCustomerToSession", method = RequestMethod.GET)
    public String addCustomerToSession() {

        return "customer/addCustomerToSession";
    }
    
    @RequestMapping(value = "/memberSession", method = RequestMethod.POST)
    public String session() {

        return "customer/addToSession";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.GET)
    public String memberIndex(Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
        model.addAttribute("categoryName", "All Categories");
        model.addAttribute("products", products);
        model.addAttribute("title", "Customer Home");
        model.addAttribute("active", "/");
        return "customer/index";
    }

    @RequestMapping(value = "/memberAboutUs", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "About Us");
        model.addAttribute("active", "aboutus");
        return "customer/aboutus";
    }

    @RequestMapping(value = "/memberContactUs", method = RequestMethod.GET)
    public String contactUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Contact Us");
        model.addAttribute("active", "contactus");
        return "customer/contactus";
    }

    @RequestMapping(value = "/memberHelp", method = RequestMethod.GET)
    public String help(Model model) {
        categoryModel(model);
        
        model.addAttribute("title", "Help");
        model.addAttribute("active", "help");
        return "customer/help";
    }

    @RequestMapping(value = "/memberOrders", method = RequestMethod.GET)
    public String orders(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Orders");
        model.addAttribute("active", "orders");
        return "customer/orders";
    }

    @RequestMapping(value = "/memberWishlist", method = RequestMethod.GET)
    public String wishlist(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Wishlist");
        model.addAttribute("active", "wishlist");
        return "customer/wishlist";
    }

    @RequestMapping(value = "/memberBasket", method = RequestMethod.GET)
    public String basket(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Basket");
        return "customer/basket";
    }

    @RequestMapping(value = "/memberOrderID={id}", method = RequestMethod.GET)
    public String productsOnOrder(@PathVariable("id") String orderID, HttpSession session, Model model) {
        categoryModel(model);
        session.setAttribute("orderID", orderID);
        model.addAttribute("title", "Products on Order");
        return "customer/productsOnOrder";
    }

    private void categoryModel(Model model) {
        List<Category> categories = commerceExpressCRUD.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }
}
